package org.wang.jquery.ajax.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.wang.jquery.ajax.bean.Person;

public class PersonServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 296867863671636888L;

	/**
	 * Constructor of the object.
	 */
	public PersonServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("method").equals("query")) {
			this.query(request, response);
		} else if (request.getParameter("method").equals("deleteById")) {
			this.deletePersonById(request, response);
		} else if (request.getParameter("method").equals("deleteByIds")) {
			deletePersonByIds(request, response);
		} else if (request.getParameter("method").equals("add")) {
			add(request, response);
		}else {
			update(request, response);
		}

	}

	private void deletePersonById(HttpServletRequest request,
			HttpServletResponse response) {
		Long pid = Long.parseLong(request.getParameter("pid"));
		@SuppressWarnings("unchecked")
		List<Person> persons = (List<Person>) request.getServletContext()
				.getAttribute("persons");

		for (int i = 0; i < persons.size(); i++) {
			Person person = persons.get(i);
			if (person.getPid().longValue() == pid.longValue()) {
				persons.remove(person);
			}
		}

	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		Long pid = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Person person = new Person();
		person.setPid(pid);
		person.setName(name);
		person.setDescription(description);

		@SuppressWarnings("unchecked")
		List<Person> persons = (List<Person>) this.getServletContext()
				.getAttribute("persons");
		persons.add(person);

	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		Long pid = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		@SuppressWarnings("unchecked")
		List<Person> persons = (List<Person>) request.getServletContext()
				.getAttribute("persons");

		for (int i = 0; i < persons.size(); i++) {
			Person person = persons.get(i);
			if (person.getPid().longValue() == pid.longValue()) {
				person.setName(name);
				person.setDescription(description);
				break;
			}
		}
	}

	private void deletePersonByIds(HttpServletRequest request,
			HttpServletResponse response) {
		String ids[] = request.getParameter("ids").split(",");
		@SuppressWarnings("unchecked")
		List<Person> persons = (List<Person>) request.getServletContext()
				.getAttribute("persons");

		for (int i = 0; i < persons.size(); i++) {
			// Person person = persons.get(i);
			// String pid=""+person.getPid().longValue();
			for (int j = 0; j < ids.length; j++) {
				String pid = "" + persons.get(i).getPid().longValue();// pid必须实时更新，上面被注释的代码不可用
				if (pid.equals(ids[j])) {
					persons.remove(i);
				}
			}
		}

	}

	private void query(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		@SuppressWarnings("unchecked")
		List<Person> persons = (List<Person>) request.getServletContext()
				.getAttribute("persons");

		String jsonStr = JSONArray.fromObject(persons).toString();
		response.getWriter().println(jsonStr);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
