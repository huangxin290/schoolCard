package org.StudentCard.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.StudentCard.dao.IPersonDao;
import org.StudentCard.entity.Person;
import org.StudentCard.service.IPersonService;
import org.StudentCard.service.impl.PersonServiceImpl;

@WebServlet("/QueryStudentsByPage")
public class QueryStudentsByPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public QueryStudentsByPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	IPersonService studentService=new PersonServiceImpl();
	int count=studentService.getTotalCount();//学生数据有多少条
	
	int currentPage=2;
	int pageSize=3;
//	List<Person> students=studentService.queryStudentsByPage(currentPage, pageSize);
//	System.out.println(students);
    System.out.println(count);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
