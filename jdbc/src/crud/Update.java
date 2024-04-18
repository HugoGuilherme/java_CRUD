package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DB;

public class Update {

	public void update(String[] args) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			conn = DB.getConnection();

			ps = conn.prepareStatement("UPDATE seller "
					+ "SET Name = ?, Email = ?, BirthDate = ?, BaseSalary = ?, DepartmentId = ? " + "WHERE Id = ?");
			
			ps.setString(1, "Hugo");
			ps.setString(2, "hugo@email.com");
			ps.setDate(3, new java.sql.Date(System.currentTimeMillis()));
			ps.setDouble(4, 5500.0);
			ps.setInt(5, 2);
			ps.setInt(6, 2);
			
			int rowsAffected = ps.executeUpdate();
			
			System.out.println("Done! Rows affected: " + rowsAffected);
		} catch (Exception e) {

			e.printStackTrace();
		} finally {

			DB.closeStatement(ps);
			DB.closeConnection();
		}
	}
}
