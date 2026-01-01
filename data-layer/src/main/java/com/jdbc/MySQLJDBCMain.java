package com.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

/**
 * Demonstrates MySQL database connectivity using JDBC (Java Database Connectivity).
 * 
 * <p>JDBC provides a standard API for connecting Java applications to relational databases.
 * This class demonstrates core JDBC concepts including:</p>
 * 
 * <h3>JDBC Architecture:</h3>
 * <ol>
 *   <li><b>DriverManager</b> - Manages database drivers and creates connections</li>
 *   <li><b>Connection</b> - Represents a connection to the database</li>
 *   <li><b>Statement/PreparedStatement</b> - Executes SQL queries</li>
 *   <li><b>ResultSet</b> - Holds query results</li>
 * </ol>
 * 
 * <h3>Key Features Demonstrated:</h3>
 * <ul>
 *   <li><b>PreparedStatement</b> - Parameterized queries (prevents SQL injection)</li>
 *   <li><b>Statement Caching</b> - Reusing prepared statements for performance</li>
 *   <li><b>CRUD Operations</b> - Select, Insert, Update, and Truncate</li>
 *   <li><b>Resource Management</b> - Proper closing of connections and statements</li>
 * </ul>
 * 
 * <h3>Best Practices Shown:</h3>
 * <ul>
 *   <li>Use PreparedStatement over Statement for parameterized queries</li>
 *   <li>Close resources in finally block (or use try-with-resources)</li>
 *   <li>Cache PreparedStatements when executing same query multiple times</li>
 *   <li>Handle SQLException appropriately</li>
 * </ul>
 * 
 * @author Srinath.Rayabarapu
 * @see java.sql.DriverManager
 * @see java.sql.PreparedStatement
 * @see java.sql.ResultSet
 */
public class MySQLJDBCMain {
	
	private static final Logger LOG = LoggerFactory.getLogger(MySQLJDBCMain.class);

	/**
	 * Main method demonstrating JDBC database operations.
	 * 
	 * <p>Connects to MySQL database and performs select operations.
	 * Update the connection parameters (username, password, dbUrl) 
	 * to match your environment.</p>
	 *
	 * @param args command-line arguments (not used)
	 */
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
	
	/**
	 * Closes all cached PreparedStatements.
	 *
	 * @param cachedStatements the cached statements container to close
	 */
	private static void close(CachedStatements cachedStatements) {
		try {
			cachedStatements.getSt.close();
			//cachedStatements.insertSt.close();
			//cachedStatements.updateSt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Truncates tables using cached statements.
	 * 
	 * <p>Note: TRUNCATE is a DDL statement that removes all rows and resets auto-increment.
	 * Unlike DELETE, it cannot be rolled back in most databases.</p>
	 *
	 * @param con the database connection
	 * @param cachedStatements the cached statements container
	 */
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

	/**
	 * Demonstrates UPDATE operation using PreparedStatement.
	 * 
	 * <p>PreparedStatement allows setting parameter values by index (1-based).
	 * This prevents SQL injection and improves performance for repeated executions.</p>
	 *
	 * @param con the database connection
	 * @param cachedStatements the cached statements container
	 */
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

	/**
	 * Demonstrates INSERT operation using PreparedStatement.
	 * 
	 * <p>Uses executeUpdate() for INSERT/UPDATE/DELETE statements
	 * which returns the number of affected rows.</p>
	 *
	 * @param con the database connection
	 * @param cachedStatements the cached statements container
	 */
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

	/**
	 * Demonstrates SELECT operation and ResultSet processing.
	 * 
	 * <p>Uses executeQuery() for SELECT statements which returns a ResultSet.
	 * ResultSet is iterated using next() and column values are retrieved
	 * by index (1-based) or column name.</p>
	 *
	 * @param con the database connection
	 * @param cachedStatements the cached statements container
	 */
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
	
	/**
	 * Closes a PreparedStatement safely.
	 *
	 * @param getSt the PreparedStatement to close
	 */
	private static void close(PreparedStatement getSt) {
		try {
			getSt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		getSt = null;
	}

	/**
	 * Closes a ResultSet safely.
	 *
	 * @param executeQuery the ResultSet to close
	 */
	private static void closeRS(ResultSet executeQuery) {
		try {
			executeQuery.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		executeQuery = null;
	}

	/**
	 * Container class for caching PreparedStatements.
	 * 
	 * <p>Caching PreparedStatements improves performance when the same
	 * SQL statement is executed multiple times, as the database can
	 * reuse the execution plan.</p>
	 */
	private static class CachedStatements {
		/** PreparedStatement for UPDATE operations. */
		public PreparedStatement updateSt;
		
		/** PreparedStatement for INSERT operations. */
		public PreparedStatement insertSt;
		
		/** PreparedStatement for SELECT operations. */
		public PreparedStatement getSt;
		
		/** PreparedStatement for TRUNCATE table operations. */
		public PreparedStatement truncateSt;
		
		/** Additional PreparedStatement for TRUNCATE operations. */
		public PreparedStatement truncateSt1;
	}
}