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

@WebServlet("/QueryStudentBySnoServlet")
public class QueryStudentBySnoServlet extends HttpServlet implements BasicServlet{
       
	private static final long serialVersionUID = 1L;
	
    public QueryStudentBySnoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        request.setCharacterEncoding("utf-8");
		int no=Integer.parseInt(request.getParameter("stuno"));
		
		Person student=personService.queryPersonByNo(no);
		
		
		//������Ӧ���룬Ҫ��out����֮ǰд
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		request.setAttribute("student", student);
		
		request.getRequestDispatcher("student.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
