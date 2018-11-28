/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagement;

import java.time.LocalDateTime;


/**
 *
 * @author duong
 */
public class Constant {
    public static int type_admin    = 1;
    public static int type_employee = 2;
    public static int type_user     = 3;
    
    public static int type_create   = 1;
    public static int type_update   = 2;
    
    public static String getCurrentDate(){
        LocalDateTime now = LocalDateTime.now();
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        return String.format("%d-%02d-%02d", year,month,day);
    }
    
    public static String getCurrentDatetime(){
        LocalDateTime now = LocalDateTime.now();
        String currentDate = Constant.getCurrentDate();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        return currentDate + " " + String.format("%02d:%02d:%02d",hour,minute,second);
    }
}
