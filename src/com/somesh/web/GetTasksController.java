package com.somesh.web;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.somesh.web.dao.TaskDAO;
import com.somesh.web.model.Task;

@SuppressWarnings("serial")
public class GetTasksController extends HttpServlet
{
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		try{
			TaskDAO td = new TaskDAO();
			ArrayList<Task> tasks = td.getTasks();
			
			req.setAttribute("tasks", tasks);
			RequestDispatcher rd = req.getRequestDispatcher("tasks.jsp");
			rd.forward(req, res);
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
