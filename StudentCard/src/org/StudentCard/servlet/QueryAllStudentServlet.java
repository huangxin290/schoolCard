package org.StudentCard.servlet;

import java.util.List;

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

@WebServlet("/QueryAllStudentServlet")
public class QueryAllStudentServlet extends HttpServlet implements BasicServlet{
	private static final long serialVersionUID = 1L;
	
    public QueryAllStudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		    request.setCharacterEncoding("utf-8");
			
			List<Person> persons=personService.queryAllStudent();
			
			request.setAttribute("persons",persons);
			request.getRequestDispatcher("index.jsp").forward(request, response);;

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
