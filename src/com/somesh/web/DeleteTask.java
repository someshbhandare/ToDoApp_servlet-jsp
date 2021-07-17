package com.somesh.web;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.somesh.web.dao.TaskDAO;

@SuppressWarnings("serial")
public class DeleteTask extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException{
		int id = Integer.parseInt(req.getParameter("id"));
		
		TaskDAO t = new TaskDAO();
		Boolean rs = t.deleteTask(id);
		
		if(rs)
		{
			res.sendRedirect("get_tasks");
		}
	}

}
