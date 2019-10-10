package org.StudentCard.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.StudentCard.entity.Person;
import org.StudentCard.entity.Record;

@WebServlet("/QueryRecordByNo")
public class QueryRecordByNo extends HttpServlet implements BasicServlet{
	private static final long serialVersionUID = 1L;
       
    public QueryRecordByNo() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Person person=(Person) request.getSession().getAttribute("person");
		List<Record> records=new ArrayList<>();
		
		if(person==null) {
			response.sendRedirect("index.jsp");
		}
		records=recordService.queryRecordByNo(person.getNo());
		
		request.setAttribute("records",records);
		
		// 设置响应编码，要在out生成之前写
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");

		if("student".equals(person.getIdentity())) {
			request.getRequestDispatcher("lookMyCost.jsp").forward(request, response);;
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
