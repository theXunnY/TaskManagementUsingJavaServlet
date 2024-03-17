package edu.jsp.view;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="assignTask" , urlPatterns = {"/assignTask"})
public class AssignTask extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int tid=0;
		tid= Integer.parseInt(req.getParameter("id"));
		
		if (tid>0) {
			resp.sendRedirect("assignEmp.jsp?tid="+tid);
		}else {
			resp.sendRedirect("index.html");
		}
		
		
	}
}
