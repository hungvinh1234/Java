/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.io.Serializable;

/**
 *
 * @author duong
 */
public class Student implements Serializable{
//    private static final long serialVersionUID = -5074537539778732011;
    private static final long serialVersionUID = -507453753;
    
    private String firstName;
    
    private String lastName;
    
    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
}
