	package application;
	
	
	import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
	
	public class Seller {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		
		
		public void create(String name, String email, String date, double BaseSalary, int DepartmentId) {
			try {
				conn = DB.getConnection();
			
				st = conn.prepareStatement("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) " +
					    "VALUES (?, ?, ?, ?, ?)");
			
			st.setString(1, name);
			st.setString(2, email);
			st.setDate(3, new java.sql.Date(sdf.parse(date).getTime()));
			st.setDouble(4, BaseSalary);
			st.setInt(5, DepartmentId);
			
			int rowsAffecteds = st.executeUpdate();
			System.out.println("Rows Affecteds "+ rowsAffecteds);
		
		}
		catch(SQLException erro) {
			erro.printStackTrace();
			
		}catch(ParseException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
			
		
			
		}
		
		
	
	
	}
