package edu.jsp.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jsp.controller.Controller;
@WebServlet(name = "removeTask" , urlPatterns = {"/tdelete"})
public class RemoveTask extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			int id= 0;
			id=Integer.parseInt(req.getParameter("id"));
			if (id>0) {
				Controller controller= new Controller();
				if(controller.removeTask(id)!=null) {
					resp.sendRedirect("tdeleted.jsp");
				}else {
					resp.sendRedirect("taskError.jsp");
				}
			}
			
		}
}
