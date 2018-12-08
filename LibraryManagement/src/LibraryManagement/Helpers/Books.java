/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagement.Helpers;

import LibraryManagement.JDBC;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;

/**
 *
 * @author duong
 */
public class Books {
    public static int id;
    public static String name;
    public static String author;
    public static String type;
    public static String publisher;
    public static String description;
    public static String total;
    public static String latest_import;
    
    public Books(String new_name, String new_author, String new_type, String new_publisher, String new_des){
        name        = new_name;
        author      = new_author;
        type        = new_type;
        publisher   = new_publisher;
        description = new_des;
    }
    
    public Books(){}
    
    // Save a user to database
    public boolean save(){
        try {
            if( name.equals("") ||
                author.equals("") ||
                publisher.equals("") ||
                type.equals("") ){
                System.out.println("Empty required field!");
                return false;
            }
            LocalDateTime now = LocalDateTime.now();
            int year = now.getYear();
            int month = now.getMonthValue();
            int day = now.getDayOfMonth();
            latest_import = year + "-" + String.format("%02d", month) + "-" + String.format("%02d", day);
            JDBC db = new JDBC();
            PreparedStatement stm = db.conn.prepareStatement("INSERT INTO books (name, author, type, publisher, description, latest_import) VALUES (?,?,?,?,?,?)");
            stm.setString(1, name);
            stm.setString(2, author);
            stm.setString(3, type);
            stm.setString(4, publisher);
            stm.setString(5, description);
            stm.setString(6, latest_import);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    // Update a user to database
    public boolean update(){
        try {
            JDBC db = new JDBC();
            PreparedStatement stm = db.conn.prepareStatement("INSERT INTO books (name, author, type, publisher, description, latest_import) VALUES (?,?,?,?,?,?)");
            stm.setString(1, name);
            stm.setString(2, author);
            stm.setString(3, type);
            stm.setString(4, publisher);
            stm.setString(5, description);
            stm.setString(6, latest_import);
            stm.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
