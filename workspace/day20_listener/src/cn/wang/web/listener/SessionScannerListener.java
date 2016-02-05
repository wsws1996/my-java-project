package cn.wang.web.listener;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionScannerListener implements HttpSessionListener,
		ServletContextListener {
	private List<HttpSession> list = Collections
			.synchronizedList(new LinkedList<HttpSession>());
	private Object lock;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		synchronized (lock) {
			list.add(session);
		}
		System.out.println("session被创建了");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session被摧毁了");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Timer timer = new Timer();
		timer.schedule(new MyTask(list, lock), 0, 1000);
	}

}

class MyTask extends TimerTask {

	private List<HttpSession> list;
	private Object lock;

	public MyTask(List<HttpSession> list, Object lock) {
		super();
		this.list = list;
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			ListIterator<HttpSession> iterator = list.listIterator();
			while (iterator.hasNext()) {
				HttpSession session = (HttpSession) iterator.next();
				if (System.currentTimeMillis() - session.getLastAccessedTime() > 1000 * 30) {
					session.invalidate();
					iterator.remove();
				}
			}
		}
	}
}
