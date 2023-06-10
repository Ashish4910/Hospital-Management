package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Specialist;

public class SpecialistDao extends HttpServlet {

	private Connection conn;

	public SpecialistDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	
	
	
	

	public boolean addSpecialist(String spec) throws SQLException {

		boolean f = false;
		try {
			String sql = "insert into specialist(spec_name) values(?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, spec);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;

			}
		} catch (Exception e) {
			e.printStackTrace();

		}

		return f;

	}

	public List<Specialist> getAllSpecialist() { 

		List<Specialist> list = new ArrayList<Specialist>();
		Specialist s = null;
		
		try {
			
			String sql = "select * from  specialist";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				s = new Specialist();
				s.setId(rs.getInt(1));
				s.setSpecialistName(rs.getString(2));
				list.add(s);
		}
		
			

		}
		catch(Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
