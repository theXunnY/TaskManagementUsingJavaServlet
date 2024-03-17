package edu.jsp.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jsp.controller.Controller;

@WebServlet(name = "DeleteEmployee" , urlPatterns ={"/del"})

public class DeleteEmp extends HttpServlet{

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        // Get the employee ID from the request
	        int employeeId = Integer.parseInt(request.getParameter("id"));
	        
	        
	        // Call a method in your controller or service to delete the employee
	        Controller controller = new Controller(); // Assuming Controller is your controller class
	      
	        
//	      System.out.println(Integer.parseInt(request.getParameter("id")));
	        if (controller.removeEmployee(employeeId)!=null) {
	            // If deletion is successful, redirect the user to a success page or back to the employee list
	        	System.out.println("done");
	            response.sendRedirect("deleted.jsp");
	        } else {
	            // If deletion fails, you can redirect to an error page or handle it accordingly
	            response.sendRedirect("empError.jsp");
	            System.out.println("error");

	        }
	    }
}
