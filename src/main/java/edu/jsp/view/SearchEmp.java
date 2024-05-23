package edu.jsp.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.jsp.controller.Controller;
import edu.jsp.entity.Employee;


@WebServlet(name ="search" , urlPatterns = {"/searchEmp"})
public class SearchEmp extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Controller controller =new Controller();
		
		HttpSession session = req.getSession();
	try {
		int id=Integer.parseInt(req.getParameter("id"));
		
		if (controller.searchEmployee(id)!=null) {			
			Employee employee=controller.searchEmployee(id);
			
			session.setAttribute("employee", employee);
			System.out.println(employee.getAge());
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getSalary());
			resp.sendRedirect("foundedEmp.jsp");
		}
		else {
//			resp.getWriter().write("<html><body><h3>employee not found</h3></body></html>");
			resp.sendRedirect("empNotFound.html");
		}}catch(Exception e) {
			resp.sendRedirect("emptyField.html");
		}
		
	}
	
	
}
