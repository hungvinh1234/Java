/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagement;
import java.sql.*;
import java.util.*;
/**
 *
 * @author duong
 */
public class LibraryManagement {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
//        JDBC j = new JDBC();
//        String sql = "Select * from books";
//        j.open();
//        Object[][] x = j.getObjectData(sql);
//        System.out.println(Arrays.deepToString(x));
//        
//        Object[] y = j.getArrayColName(sql);
//        System.out.println(Arrays.deepToString(y));
        
        Login loginScreen = new Login();
        loginScreen.setVisible(true);
    }
    
}
