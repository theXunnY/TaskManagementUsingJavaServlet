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

@WebServlet(name = "update" , urlPatterns = {"/updateemp"})
public class UpdateEmp extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	
		Controller controller= new Controller();
		int id=0;
		id=Integer.parseInt(req.getParameter("id"));
		if (id>0) {
			
		String name= req.getParameter("name");
		int age= Integer.parseInt(req.getParameter("age"));
		double salary= Double.parseDouble(req.getParameter("salary"));
		LocalDate doj= LocalDate.parse(req.getParameter("doj"));
		
		Employee employee=controller.searchEmployee(id);
		
		if (employee!=null) {
		employee.setAge(age);
		employee.setDoJ(doj);
		employee.setName(name);
		employee.setSalary(salary);
		controller.updateEmployee(employee);
		System.out.println("updated");
		resp.sendRedirect("allEmp.jsp");
	}else {
		System.err.println("error");
	}
		
		}else {
			System.out.println("empty");
		}
		
	}
}
