package edu.jsp.view;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jsp.controller.Controller;
import edu.jsp.entity.Employee;

@WebServlet(name = "saveEmp", urlPatterns = {"/saveEmp"})
public class SaveEmp extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		int age=0;
		if (req.getParameter("age")!=null) {
			age=Integer.parseInt(req.getParameter("age"));
			
		}else {
			resp.getWriter().write("<html><body><h3>age is empty</h3></body></html>");
		}
		
		LocalDate Doj=LocalDate.now();
		if (req.getParameter("doj")!=null) {
			Doj=LocalDate.parse(req.getParameter("doj")) ;
			
		}else {
			resp.getWriter().write("<html><body><h3>date of joining is empty</h3></body></html>");
		}
		
		double salary=0.0;
		if (req.getParameter("salary")!=null) {
			salary=Double.parseDouble(req.getParameter("salary")) ;
			
		}else {
			resp.getWriter().write("<html><body><h3>salary is empty</h3></body></html>");
		}
		
		
		if((req.getParameter("salary")!=null && req.getParameter("age")!=null) && (req.getParameter("doj")!=null) ) {
		Controller controller=new Controller();
		
		Employee employee=new Employee();
		employee.setName(name);
		employee.setAge(age);
		employee.setDoJ(Doj);
		employee.setSalary(salary);

		controller.saveEmployee(employee);
		resp.sendRedirect("eSaved.html");
		}
		
		
	}

}
