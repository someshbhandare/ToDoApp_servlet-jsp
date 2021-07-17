package com.somesh.web;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.somesh.web.dao.TaskDAO;

@SuppressWarnings("serial")
public class UpdateTask extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		int id = Integer.parseInt(req.getParameter("id"));
		String new_task = req.getParameter("new_task");
		boolean completed = Boolean.valueOf(req.getParameter("completed"));
		
		TaskDAO t = new TaskDAO();
		Boolean rs = t.updateTask(id, new_task, completed);
		
		if(rs)
		{
			res.sendRedirect("get_tasks");
		}
	}
}
