package org.wicket_kkato.learning.isd;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestManagementDAO implements Serializable{
	private static final long serialVersionUID = 1L;

	String driver = "org.postgresql.Driver";
	String url = "jdbc:postgresql:/5432/isdWicket";
	String dbUser = "postgres";
	String dbPassword = "postgres";

	public boolean confirmAccount(String accountId, String password) {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbUser, dbPassword);

			String sql = "select * from account_table where account_id = ? and password = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, accountId);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
