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
		
		String name="";
		int age=0;
		LocalDate Doj=LocalDate.now();
		double salary=0.0;
		
		try {
			name=req.getParameter("name");
			age=Integer.parseInt(req.getParameter("age"));
			Doj=LocalDate.parse(req.getParameter("doj")) ;
			salary=Double.parseDouble(req.getParameter("salary")) ;
			
			Controller controller=new Controller();
			
			Employee employee=new Employee();
			employee.setName(name);
			employee.setAge(age);
			employee.setDoJ(Doj);
			employee.setSalary(salary);
			
			if(controller.saveEmployee(employee)!=null) {
				resp.sendRedirect("eSaved.html");
			}
			
		}catch(Exception e){
			resp.sendRedirect("fieldCannotBeEmptyEmp.html");
		}
		
		
		
		
		
		
	}

}
