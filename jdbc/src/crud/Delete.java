package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DB;

public class Delete {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();

			st = conn.prepareStatement("DELETE FROM seller WHERE Id = ?");
			st.setInt(1, 14);

			int rowsAffected = st.executeUpdate();

			System.out.println("Done! Rows affected: " + rowsAffected);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
