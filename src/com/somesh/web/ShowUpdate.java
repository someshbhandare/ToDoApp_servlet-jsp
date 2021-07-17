package com.somesh.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.somesh.web.dao.TaskDAO;
import com.somesh.web.model.Task;

@SuppressWarnings("serial")
public class ShowUpdate extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		int id = Integer.parseInt(req.getParameter("id"));
		
		TaskDAO t = new TaskDAO();
		Task task = t.getTask(id);
		
		req.setAttribute("task", task);
		RequestDispatcher rd = req.getRequestDispatcher("update_task.jsp");
		rd.forward(req, res);
				
	}
}
