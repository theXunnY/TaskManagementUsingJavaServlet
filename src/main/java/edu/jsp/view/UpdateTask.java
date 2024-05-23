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

@WebServlet(name = "updatetask" , urlPatterns = {"/updatetask"} )
public class UpdateTask extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name="";
		LocalDate start=LocalDate.now();
		LocalDate end=LocalDate.now();
		int id=0;
		try {
			name=req.getParameter("name");
			start=LocalDate.parse(req.getParameter("start"));
			end=LocalDate.parse(req.getParameter("end"));
			Controller controller= new Controller();
			id=Integer.parseInt(req.getParameter("id"));
			
			if (id>0) {
				Task task=controller.searchTask(id);				
			
			
			if (task!=null) {
				task.settName(name);
				task.setStartDate(start);
				task.setEndDate(end);
				controller.updateTask(task);
				resp.sendRedirect("allTask.jsp");
				
				}
			}
		} catch (Exception e) {
			resp.sendRedirect("emptyField.html");

		}
	}
}
