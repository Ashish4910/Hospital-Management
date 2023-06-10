package com.admin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.db.DBConnect;
import com.entity.Doctor;

@WebServlet("/addDoctor")
public class AddDoctor extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String fullName= req.getParameter("fullname");
			String dob= req.getParameter("dob");
			String qualification= req.getParameter("qualification");
			String specialist= req.getParameter("spec");
			String email= req.getParameter("email");
			String mobNo= req.getParameter("mobno");
			String password= req.getParameter("password");
			
			/*
			 * Doctor d = new Doctor(fullName,dob,qualification,spec,email,mobNo,password);
			 */
			 Doctor d=new Doctor( fullName, dob,  qualification,  specialist,  email,  mobNo,
					 password);
			DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
			
			HttpSession session = req.getSession();
			boolean f =dao2.registerDoctor(d);
			
			if(f) {
				session.setAttribute("succMsg", "Docter Added Successfully");
				resp.sendRedirect("admin/doctor.jsp");
				
						
			}
			else {
				session.setAttribute("errorMsg","Something went Wrong");
				resp.sendRedirect("admin/doctor.jsp");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}

	

}
