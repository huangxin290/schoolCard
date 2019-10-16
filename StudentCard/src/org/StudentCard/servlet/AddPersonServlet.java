package org.StudentCard.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.StudentCard.entity.Person;
import org.StudentCard.service.IPersonService;
import org.StudentCard.service.impl.PersonServiceImpl;
import org.apache.jasper.tagplugins.jstl.core.Out;

@WebServlet("/AddPersonServlet")
public class AddPersonServlet extends HttpServlet implements BasicServlet{

	private static final long serialVersionUID = 1L;

	public AddPersonServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		Float balance = Float.parseFloat(request.getParameter("balance"));
		String identity = request.getParameter("identity");

		Person person  = new Person(no, name, pwd,balance,identity,false);
        System.out.println(person);
		
		boolean result = personService.addPerson(person);

		// 设置响应编码，要在out生成之前写
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");

		if (!result) {
			request.setAttribute("error", "addError");
			System.out.println("addError");
		}
		
		if("student".equals(((Person) request.getSession().getAttribute("person")).getIdentity())) {
			response.sendRedirect("student.jsp");
		}else if("administrator".equals(((Person) request.getSession().getAttribute("person")).getIdentity())){
			response.sendRedirect("administrator.jsp");
		}else {
			request.setAttribute("error", "loginError");
			response.sendRedirect("index.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
