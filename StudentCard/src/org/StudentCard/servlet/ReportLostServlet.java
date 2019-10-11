package org.StudentCard.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.StudentCard.entity.Person;

@WebServlet("/ReportLostServlet")
public class ReportLostServlet extends HttpServlet implements BasicServlet{
	private static final long serialVersionUID = 1L;
       
    public ReportLostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Person person=(Person) request.getSession().getAttribute("person");
		
		person.setLost(true);
		
		boolean result = personService.updatePerson(person.getNo(), person);

		// 设置响应编码，要在out生成之前写
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");

		if (!result) { 
			request.setAttribute("error", "updateError");
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
