package com.jdbc;

import java.sql.*;

/**
 * class to test Oracle JDBC related capabilities.
 *
 * @author Srinath.Rayabarapu
 */
public class OracleJDBCMain {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public OracleJDBCMain() {

        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "user1", "oracle");
            DatabaseMetaData dbmd = con.getMetaData();
            System.out.println("DatabaseProductName     :  " + dbmd.getDatabaseProductName());
            System.out.println("DatabaseProductVersion  :" + dbmd.getDatabaseProductVersion());
            System.out.println("getStringFunctions            : " + dbmd.getStringFunctions());
            System.out.println("DriverMajorVersion          : " + dbmd.getDriverMajorVersion());
            System.out.println("DriverMinorVersion          :" + dbmd.getDriverMinorVersion());
            System.out.println("DriverName		    : " + dbmd.getDriverName());
            System.out.println("SQLKeywords 		     : " + dbmd.getSQLKeywords());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        int age[] = {20, 30, 40};
        OracleJDBCMain ex = new OracleJDBCMain();
        for (int i = 0; i < age.length; i++) {
            ex.display(age[i]);
        }
    }

    public void display(int age) {
        try {
            ps = con.prepareStatement("select *from ex_empdata where age = ?");
            ps.setInt(1, age);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int colcount = rsmd.getColumnCount();

            while (rs.next()) {
                for (int i = 1; i <= colcount; i++) {
                    System.out.print(rsmd.getColumnName(i) + ":"
                            + rs.getString(i) + "\t");
                }
                System.out.println("");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}