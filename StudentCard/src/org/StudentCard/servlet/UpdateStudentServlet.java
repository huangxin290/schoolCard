package org.StudentCard.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.StudentCard.entity.Person;
import org.StudentCard.service.IPersonService;
import org.StudentCard.service.impl.PersonServiceImpl;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    IPersonService service=new PersonServiceImpl();
    
    public UpdateStudentServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	System.out.println("11");
	request.setCharacterEncoding("utf-8");
	
	int no=Integer.parseInt(request.getParameter("stuno"));
	String name=request.getParameter("stuname");
	int age=Integer.parseInt(request.getParameter("stuage"));
	String pwd=request.getParameter("stupwd");
	
//	Person student=new Person(no, name, age, pwd);
	
//	boolean result=service.updatePerson(no,student);
	
	//设置响应编码，要在out生成之前写
	response.setContentType("text/html;charset=utf-8");
	response.setCharacterEncoding("utf-8");

	if("student".equals(((Person) request.getSession().getAttribute("person")).getIdentity())) {
		response.sendRedirect("student.jsp");
	}else if("administrator".equals(((Person) request.getSession().getAttribute("person")).getIdentity())){
		response.sendRedirect("administrator.jsp");
	}else {
		request.setAttribute("error", "loginError");
		response.sendRedirect("index.jsp");
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
