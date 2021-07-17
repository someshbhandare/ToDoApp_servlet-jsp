package com.somesh.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.somesh.web.model.Task;

public class TaskDAO 
{
	private final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
	private final String DB_USER = "root";
	private final String DB_PASS = "";
	private Connection con;
	
	public TaskDAO()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	
	public Boolean addTask(String task)
	{
		try{
			PreparedStatement st = con.prepareStatement("INSERT INTO task(taskname) VALUES (?)");
			st.setString(1, task);
			st.executeUpdate();
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public ArrayList<Task> getTasks()
	{
		ArrayList<Task> tasks = new ArrayList<>();
		try
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM task");
			
			while(rs.next())
			{
				Task t = new Task();
				t.setId(rs.getInt("taskid"));
				t.setTask(rs.getString("taskname"));
				t.setCompleted(rs.getBoolean("completed"));
				tasks.add(t);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return tasks;
	}
	
	public Task getTask(int id)
	{
		try
		{
			PreparedStatement st = con.prepareStatement("SELECT * FROM task WHERE taskid=?");
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			rs.next();
			Task t = new Task();
			t.setId(rs.getInt("taskid"));
			t.setTask(rs.getString("taskname"));
			t.setCompleted(rs.getBoolean("completed"));
			return t;
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return null;
	}
	
	public Boolean deleteTask(int id)
	{
		try
		{
			PreparedStatement st = con.prepareStatement("DELETE FROM task WHERE taskid=?");
			st.setInt(1, id);
			st.executeUpdate();
		}
		catch(SQLException se)
		{
			System.out.println(se);
			return false;
		}
		return true;
	}
	
	public Boolean updateTask(int id, String new_task, boolean completed)
	{
		try
		{
			PreparedStatement st = con.prepareStatement("UPDATE task SET taskname=?, completed=? WHERE taskid=?");
			st.setString(1, new_task);
			st.setBoolean(2, completed);
			st.setInt(3, id);
			st.executeUpdate();
		}
		catch(SQLException se)
		{
			System.out.println(se);
			return false;
		}
		return true;
	}
	
}
