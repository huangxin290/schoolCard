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

@WebServlet("/QueryAllPersonServlet")
public class QueryAllPersonServlet extends HttpServlet implements BasicServlet{
	private static final long serialVersionUID = 1L;
	
    public QueryAllPersonServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		    request.setCharacterEncoding("utf-8");
			
			List<Person> persons=personService.queryAllStudent();
			
			request.setAttribute("persons",persons);
			
			if(persons!=null) {
				request.getRequestDispatcher("lookAllPerson.jsp").forward(request, response);
			}else {
				response.sendRedirect("index.jsp");
			}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
