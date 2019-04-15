package com.vincipline.util;

//import com.vincipline.util.service.MySQLService;
//import java.sql.ResultSet;

import com.vincipline.util.service.HibernateService;


public class Main {
    public static void main(String[] args) {

        HibernateService hibernateService = new HibernateService();
        hibernateService.run();

        //MySQLService mysqlService = new MySQLService();
        //ResultSet    rs           = mysqlService.query("SELECT * FROM city limit 5;");
        //
        //try {
        //    while (rs.next()) {
        //        String id = rs.getString("ID");
        //        String name = rs.getString("Name");
        //        String countryCode = rs.getString("CountryCode");
        //        String district = rs.getString("District");
        //        String population = rs.getString("Population");
        //        System.out.println(String.format(
        //                "ID: [%s], Name: [%s], CountryCode: [%s], District: [%s], Population: [%s],",
        //                id, name, countryCode, district, population
        //        ));
        //    }
        //} catch (Exception e) {
        //
        //}

        System.out.println("Bye!");
    }

//    public void run()
//    {
//        System.out.println("Hello World!");
//        connectMysql();
//    }
//
//    public void connectMysql() {
//        try {
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world","root","12345");
//            Class.forName("com.mysql.jdbc.Driver");
//
//            //here sonoo is database name, root is username and password
//            Statement stmt = con.createStatement();
//
//            ResultSet rs = stmt.executeQuery("select * from city limit 5;");
//
//            while(rs.next()) {
//                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
//            }
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            //
//        }
//    }
}
