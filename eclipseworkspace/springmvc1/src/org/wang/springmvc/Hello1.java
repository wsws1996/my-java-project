package org.wang.springmvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

public class Hello1 implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message="helloword1";
		request.setAttribute("message", message);
		request.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(request, response);
	}

}
