package edu.jsp.view;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jsp.controller.Controller;
import edu.jsp.entity.Task;

@WebServlet(name = "addtask", urlPatterns = {"/addtask"})
public class AddTask extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name= req.getParameter("name");
		LocalDate start=LocalDate.parse(req.getParameter("start"));
		LocalDate end=LocalDate.parse(req.getParameter("end"));
		
		Task task= new Task();
		task.settName(name);
		task.setStartDate(start);
		task.setEndDate(end);
		
		Controller controller= new Controller();
		if(controller.saveTask(task)!=null) {
			resp.sendRedirect("tSaved.jsp");
		}else {
//			resp.sendRedirect("allTask.jsp");
		}
	
	}
}
