package edu.jsp.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.jsp.controller.Controller;
import edu.jsp.entity.Task;

@WebServlet(name="searchTask", urlPatterns = {"/searchTask"})
public class SearchTask extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Controller controller= new Controller();
		HttpSession session= req.getSession();
		
		Task task=controller.searchTask(Integer.parseInt(req.getParameter("id")));
			if (task!=null) {
				session.setAttribute("task", task);
				System.err.println(Integer.parseInt(req.getParameter("id")));
				resp.sendRedirect("tFounded.jsp");
				}else {
					resp.sendRedirect("taskNotFound.jsp");	
			}
	}
}
