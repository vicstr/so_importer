package com.vincipline.util.service;

import java.sql.*;


public class MySQLService {
    private Connection conn = null;
    private ResultSet rs = null;
    private Statement stmt = null;

    protected Connection getConn() {
        try {
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=minty&password=greatsqldb");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/world?useSSL=false","root","12345");


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (Exception ex) {
            // handle the error
        }
        return conn;
    }

    public ResultSet query(String query) {
        try {
            stmt = getConn().createStatement();
//            rs = stmt.executeQuery("SELECT foo FROM bar");

            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...

            if (stmt.execute(query)) {
                rs = stmt.getResultSet();
            }

            return rs;
        } catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        finally {
            return rs;

            //if (rs != null) {
            //    try {
            //        rs.close();
            //    } catch (SQLException sqlEx) { } // ignore
            //    rs = null;
            //}
            //
            //if (stmt != null) {
            //    try {
            //        stmt.close();
            //    } catch (SQLException sqlEx) { } // ignore
            //    stmt = null;
            //}
        }
    }
}