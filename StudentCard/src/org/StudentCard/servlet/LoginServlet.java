package org.StudentCard.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.StudentCard.entity.Person;
import org.apache.catalina.Session;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet implements BasicServlet{
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		int no = Integer.parseInt(request.getParameter("no"));
		String pwd = request.getParameter("pwd");
		
		Person person = personService.login(no, pwd);

		// 设置响应编码，要在out生成之前写
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");

		if (person==null) {
			request.setAttribute("error", "loginError");
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("登录成功！");
			request.setAttribute("person", person);
			request.getSession().setAttribute("person", person);
			

			if("student".equals(((Person) request.getSession().getAttribute("person")).getIdentity())) {
				response.sendRedirect("student.jsp");
			}else if("administrator".equals(((Person) request.getSession().getAttribute("person")).getIdentity())){
				response.sendRedirect("administrator.jsp");
			}else {
				request.setAttribute("error", "loginError");
				response.sendRedirect("index.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
