/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagement.Helpers;

import LibraryManagement.Constant;
import LibraryManagement.JDBC;
import java.sql.PreparedStatement;

/**
 *
 * @author duong
 */
public class Users {
    public static int id;
    public static String username;
    public static String password;
    public static String email;
    public static String name;
    public static String school;
    public static String phone;
    public static String dob;
    public static int type;
    public static String created_date;
    
    public Users(String un, String pw, String em, String n, String sch, String p, String bd, int t){
        em       = em.equals("") ? null : em;
        sch      = sch.equals("") ? null : sch;
        p        = p.equals("") ? null : p;
        username = un;
        password = pw;
        email    = em;
        name     = n;
        school   = sch;
        phone    = p;
        dob      = bd;
        type     = t;
    }
    
    public Users(){}
    
    // Save a user to database
    public boolean save(){
        try {
            if( username.equals("") ||
                password.equals("") ||
                name.equals("") ||
                dob.equals("") ){
                System.out.println("Empty required field!");
                return false;
            }
            JDBC db = new JDBC();
            PreparedStatement stm = db.conn.prepareStatement("INSERT INTO users (username, password, email, name, school, phone, dob, type) VALUES (?,?,?,?,?,?,?,?)");
            stm.setString(1, username);
            stm.setString(2, password);
            stm.setString(3, email);
            stm.setString(4, name);
            stm.setString(5, school);
            stm.setString(6, phone);
            stm.setString(7, dob);
            stm.setInt(8, type);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    // Check login infomation
    public boolean checkLogin(String un, String pw){
        try {
            JDBC db = new JDBC();
            String sql = "SELECT * FROM users";
            db.stmt = db.conn.createStatement();
            db.rs = db.stmt.executeQuery(sql);
            while (db.rs.next())
            {
                String usernameInput = db.rs.getString("username");
                String passwordInput = db.rs.getString("password");
                //Date dateCreated = db.rs.getDate("date_created");
                if(un.equals(usernameInput) && pw.equals(passwordInput)) return true;
            }
            db.stmt.close();
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean checkExists(String un){
        try {
            JDBC db = new JDBC();
            String sql = "SELECT * FROM users";
            db.stmt = db.conn.createStatement();
            db.rs = db.stmt.executeQuery(sql);
            while (db.rs.next())
            {
                String usernameInput = db.rs.getString("username");
                if(un.equals(usernameInput)) return true;
            }
            db.stmt.close();
            return false;
        } catch (Exception e) {
            System.out.println("Error checkExists");
            return false;
        }
    }
}
