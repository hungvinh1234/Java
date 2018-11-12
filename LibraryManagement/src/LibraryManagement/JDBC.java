/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagement;

import java.sql.*;
/**
 *
 * @author duong
 */
public class JDBC {
    static final String DB_URL      = "jdbc:mysql://localhost:3306/Library_manager";
    static final String DB_DRV      = "com.mysql.jdbc.Driver";
    static final String DB_USER     = "root";
    static final String DB_PASSWD   = "123";
    
    private static Connection conn   = null;
    private static Statement stmt    = null;
    private static ResultSet rs      = null;

    public static void main(String[] args) throws SQLException
    {
        try{
            Driver driver = new org.gjt.mm.mysql.Driver();// nap driver 
            DriverManager.registerDriver(driver);// dang ky driver 
            
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD);
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM books");
            System.out.println(1);
            int columnsNumber = 2;
            while(rs.next()){
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + " ");
                }
                System.out.println("");
            }
        } catch (SQLException e){
            throw e;
        }
    }
    
    public void JDBC(){
        open();
    }
    
    public void open(){
        try {
            Driver driver = new org.gjt.mm.mysql.Driver();// nap driver 
            DriverManager.registerDriver(driver);// dang ky driver 
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWD); // ket noi db
        } catch (SQLException ex) {
            getSqlError(ex);
        }
    }
    
    public void close() {// dong ket noi co so du lieu 
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            getSqlError(ex);
        }
    }
    
    public void getSqlError(SQLException ex) {
        System.out.println(" Error Message:" + ex.getMessage());
        System.out.println(" SQL State:" + ex.getSQLState());
        System.out.println(" Error Code:" + ex.getErrorCode());
    }
    
    public void printResult(String sql){
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while(rs.next()){
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1) System.out.print(",  ");
                    String columnValue = rs.getString(i);
                    System.out.print(rsmd.getColumnName(i) + ": " + columnValue);
                }
                System.out.println("");
            }
        } catch (SQLException ex) {
            getSqlError(ex);
        }
    }
    
    public Object[][] getObjectData(String sql){
        Object[][] data = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            //get the row number
            rs.last();
            int num_row = rs.getRow();
            if(num_row == 0){
                return data;
            }
            
            //get the col number
            ResultSetMetaData rsmd = rs.getMetaData();
            int num_col = rsmd.getColumnCount();
            
            data = new String[num_row][num_col];
            int index = 0; // count array
            rs.first(); // return pointer to first
            do{
                String[] row_data = new String[num_col];
                for (int i = 1; i <= num_col; i++) {
                    String columnValue = rs.getString(i);
                    row_data[i-1] = columnValue;
                }
                data[index++] = row_data;
            } while(rs.next());
        } catch (SQLException ex) {
            getSqlError(ex);
        }
        return data;
    }
    
    public String[] getArrayColName(String sql){
        String[] data = null;
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            
            //get the col number
            ResultSetMetaData rsmd = rs.getMetaData();
            int num_col = rsmd.getColumnCount();
            
            data = new String[num_col];
            int index = 0; // count array
            rs.first(); // return pointer to first
            for (int i = 1; i <= num_col; i++) {
                data[i-1] = rsmd.getColumnName(i);
            }
        } catch (SQLException ex) {
            getSqlError(ex);
        }
        return data;
    }
}
