package com.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * class to test MySQL JDBC related capabilities.
 * 
 * @author Srinath.Rayabarapu
 */
public class MySQLJDBCMain {
	
	private static final Logger LOG = LoggerFactory.getLogger(MySQLJDBCMain.class);

	public static void main(String args[]) {

		String username = "srinath";
		String password = "password";
		String dbUrl = "jdbc:mysql://bg-tradex-dev:3306/world";
		Connection con = null;

		try {

			//Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, username, password);
			
			CachedStatements cachedStatements = new CachedStatements();
			cachedStatements.getSt = con.prepareStatement("select * from city");
			//cachedStatements.insertSt = con.prepareStatement("insert into vehicle(vehicleId, vehicleName) values (?, ?)");
			//cachedStatements.updateSt = con.prepareStatement("update vehicle set vehicleName=? where vehicleId=?");
			//cachedStatements.truncateSt = con.prepareStatement("truncate table vehicle");
			//cachedStatements.truncateSt1 = con.prepareStatement("truncate table user_details");
			
			doSelectOperation(con, cachedStatements);
			
			//doInsertOperation(con, cachedStatements);
			
			//doSelectOperation(con, cachedStatements);
			
			//doUpdateOperation(con, cachedStatements);
			
			//doSelectOperation(con, cachedStatements);
			
			close(cachedStatements);
			
			//doTruncateTable(con, cachedStatements);
			
			LOG.debug("done --");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null)
					con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private static void close(CachedStatements cachedStatements) {
		try {
			cachedStatements.getSt.close();
			//cachedStatements.insertSt.close();
			//cachedStatements.updateSt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void doTruncateTable(Connection con, CachedStatements cachedStatements) {
		try {
			
			PreparedStatement getSt = cachedStatements.truncateSt1;
			boolean execute = getSt.execute();
			System.out.println(execute);
			
			close(getSt);
			
			PreparedStatement getSt1 = cachedStatements.truncateSt;
			boolean execute1 = getSt1.execute();
			System.out.println(execute1);
			
			close(getSt1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void doUpdateOperation(Connection con, CachedStatements cachedStatements) {
		
		try {
			PreparedStatement getSt = cachedStatements.updateSt;
			
			getSt.setString(1, "New-Swift");
			getSt.setInt(2, 2);
			getSt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void doInsertOperation(Connection con, CachedStatements cachedStatements) {
		
		try {
			PreparedStatement getSt = cachedStatements.insertSt;
			
			getSt.setInt(1, 2);
			getSt.setString(2, "Swift");
			getSt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void doSelectOperation(Connection con, CachedStatements cachedStatements) {
		
		try {
			PreparedStatement getSt = cachedStatements.getSt;			
			ResultSet executeQuery = getSt.executeQuery();
			
			while(executeQuery.next()) {
				int cityId = executeQuery.getInt(1);
				String cityName = executeQuery.getString(2);
				System.out.println("City Id : " + cityId + ", City Name : " + cityName);
			}
			
			closeRS(executeQuery);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void close(PreparedStatement getSt) {
		try {
			getSt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getSt = null;
	}

	private static void closeRS(ResultSet executeQuery) {
		try {
			executeQuery.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		executeQuery = null;
	}

	private static class CachedStatements
	{
		public PreparedStatement updateSt;
		public PreparedStatement insertSt;
		public PreparedStatement getSt;
		public PreparedStatement truncateSt;
		public PreparedStatement truncateSt1;
	}
}