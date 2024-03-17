package edu.jsp.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.jsp.controller.Controller;
import edu.jsp.entity.Employee;

@WebServlet(name="AssignTaskToEmployee",  urlPatterns = {"/assigntasktoemp"})
public class AssignTaskToEmp extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int tid = Integer.parseInt(req.getParameter("tid"));
		int eid = Integer.parseInt(req.getParameter("eid"));
		System.out.println(tid+ " "+ eid);
		
		HttpSession session= req.getSession();
		
		
		Controller controller= new Controller();
		
		if(controller.assignTasks(tid, eid)!=null) {
			Employee employee= controller.searchEmployee(eid);
			session.setAttribute("employee", employee);
			System.out.print("assigned");
			resp.sendRedirect("assignTasks.jsp");
		}else {
			System.out.print("NOTTTTTT assigned");
			
		}
	}
}
