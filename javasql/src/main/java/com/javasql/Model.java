package com.javasql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Model {
    private final static String db_name = "python_db";
    private final static String url = "jdbc:mysql://localhost:3306/" + db_name ;
    private final static String username = "root";
    private final static String password = "";
    private static Connection callConnection(){
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database");
            return con;
        }
        catch(SQLException e) {
            System.out.println("An error ocurred while connecting to the database");
            e.printStackTrace();
            return null;
        }
    }
    public void getAllDoctors(){
        try {
            String sql = "SELECT * FROM Doctor";
            Connection con = callConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Doctor Id: "+rs.getInt("doctor_id"));
                System.out.println("Doctor Name: "+rs.getString("doctor_name"));
                System.out.println("Hospital Id: "+rs.getInt("hospital_id"));
            }
        }
        catch(SQLException e){
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
    }
    public void getDoctor(int id){
        try {
            String sql = "SELECT * FROM Doctor WHERE doctor_id=?";
            Connection con = callConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                System.out.println("Doctor Id: "+rs.getInt("doctor_id"));
                System.out.println("Doctor Name: "+rs.getString("doctor_name"));
                System.out.println("Hospital Id: "+rs.getInt("hospital_id"));
            }
        }
        catch(SQLException e) {
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
    }
    public void addHospital(int hospital_id, String hospital_name, int bed_count){
        try {
            String sql = "INSERT INTO Hospital (hospital_id,hospital_name,bed_count) VALUES (?,?,?);";
            Connection con = callConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, hospital_id);
            ps.setString(2,hospital_name);
            ps.setInt(3,bed_count);
            ps.execute();
            System.out.println("Hospital added!");
        }
        catch(SQLException e){
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
    }
    public void updateHospital(int hospital_id, String hospital_name){
        try {
            String sql = "UPDATE Hospital SET hospital_name=? where hospital_id=?;";
            Connection con = callConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, hospital_name);
            ps.setInt(2,hospital_id);
            ps.executeUpdate();
            System.out.println("Hospital updated!");
        }
        catch(SQLException e){
            System.out.println("An error ocurred");
            e.printStackTrace();
        }
    }

}