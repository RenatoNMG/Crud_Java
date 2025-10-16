	package application;
	
	
	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;
	
	public class Seller {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Connection conn = null;
		PreparedStatement st = null;
		
		
		
		public void create() {
			try {
				conn = DB.getConnection();
			
				st = conn.prepareStatement("INSERT INTO seller (Name, Email, BirthDate, BaseSalary, DepartmentId) " +
					    "VALUES (?, ?, ?, ?, ?)");
			
			st.setString(1, "Renato Navarro");
			st.setString(2, "renatonm9@gmailo.com");
			st.setDate(3, new java.sql.Date(sdf.parse("28/11/1996").getTime()));
			st.setDouble(4, 5000);
			st.setInt(5, 4);
			
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
