package com.somesh.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.somesh.web.dao.TaskDAO;



@SuppressWarnings("serial")
public class AddTaskController extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		String task = req.getParameter("task");
		if(!task.trim().isEmpty())
		{
			TaskDAO t = new TaskDAO();
			t.addTask(task);
		}
		
//		RequestDispatcher rd = req.getRequestDispatcher("get_tasks");
//		rd.forward(req, res);
		res.sendRedirect("get_tasks");
	}
	
}
