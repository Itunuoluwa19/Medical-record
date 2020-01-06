/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medicalrecord;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ITUNU
 */
public class records_sql {
   Connection conn = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    static final String DB_url = "jdbc:mysql://localhost:3306/rohi?zeroDateTimeBehavior=convertToNull";
    static final String username = "root";
    static final String password = "";
    
public String checkID(){
    String ID="";
    boolean avail=true;
    try{
      
    Class.forName("com.mysql.jdbc.Driver");
    conn=DriverManager.getConnection(DB_url, username, password);
    String sql="SELECT * FROM details  where id=?";
    statement=conn.prepareStatement(sql);
    while(avail==true){
     ID = generateID();
    statement.setString(1, ID);
    resultSet=statement.executeQuery();
    if(resultSet.next()==true){
        //ID exit
        avail=true;
    }
    else{
        //ID doesnot exist
        avail=false;
        break;
    }
    }
    }
    catch(Exception ex){
        ex.printStackTrace();
        }
  return ID;  
}
public String generateID(){
    String ID1="RS/";
    Random randNum=new Random();
    String ID2= String.valueOf(randNum.nextInt(9));
    Random randNum3=new Random();
    String ID3= String.valueOf(randNum3.nextInt(9));
    Random randNum4=new Random();
    String ID4= String.valueOf(randNum4.nextInt(9));
    Random randNum5= new Random ();
    String ID5=String.valueOf(randNum5.nextInt(9));
    Random randNum6=new Random ();
    String ID6= String.valueOf(randNum6.nextInt(9));
            
  String ID=ID1+ID2+ID3+ID4+ID5+ID6;
  return ID;
}
public void InsertRecord(String ID, String Surname, String OtherName, String Sex, String Address, String Occupation, String EthnicGroup,String Town, String DOB, String Nationality, String Email, String PhoneNumber, String Religion, String CivilState, String NextOfKin, String PhoneNextOfKin){
   
    try{
        
      
    Class.forName("com.mysql.jdbc.Driver");
    conn=DriverManager.getConnection(DB_url, username, password);
    String sql="insert into details (id, surname,other_names, sex, address, occupation, ethnic_group, town, dob, nationality, email, phone_number, religion, civil_state, next_of_kin, next_of_kin_number) value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    statement=conn.prepareStatement(sql);
    
    statement.setString(1, ID);
    statement.setString(2, Surname);
    statement.setString(3, OtherName);
    statement.setString(4, Sex);
    statement.setString(5, Address);
    statement.setString(6, Occupation);
    statement.setString(7, EthnicGroup);
    statement.setString(8, Town);
    statement.setString(9, DOB);
    statement.setString(10, Nationality);
    statement.setString(11, Email);
    statement.setString(12, PhoneNumber);
    statement.setString(13, Religion);
    statement.setString(14, CivilState);
    statement.setString(15, NextOfKin);
    statement.setString(16, PhoneNextOfKin);
    statement.executeUpdate();
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
 
}

public static int  userTemp;
public static int userPulse;
public static int userbp;
public static int userrr;
public static int userhr;

 public void getReadings(int Id){
   
    try{  
      
    Class.forName("com.mysql.jdbc.Driver");
    conn=DriverManager.getConnection(DB_url, username, password);
    String sql="SELECT * FROM readings;";
    statement=conn.prepareStatement(sql);
    resultSet=statement.executeQuery();
    ArrayList temp = new ArrayList();
    ArrayList pulse = new ArrayList();
    ArrayList bp = new ArrayList();
    ArrayList rr = new ArrayList();
    ArrayList hr = new ArrayList();
    while(resultSet.next()){
        temp.add(resultSet.getInt(2));
        pulse.add(resultSet.getInt(4));
        bp.add(resultSet.getInt(6));
        rr.add(resultSet.getInt(8));
        hr.add(resultSet.getInt(10));
        
    }
    userTemp=(Integer)temp.get(Id);
    userPulse=(Integer)pulse.get(Id); 
    userbp=(Integer)bp.get(Id);
    userrr=(Integer)rr.get(Id);
    userhr=(Integer)hr.get(Id);
    }
    catch(Exception ex){
        ex.printStackTrace();
    }
 
}

public boolean getAvail(String Id){
    boolean avail=true;
    try{
      
    Class.forName("com.mysql.jdbc.Driver");
    conn=DriverManager.getConnection(DB_url, username, password);
    String sql="SELECT * FROM details  where id=?";
    statement=conn.prepareStatement(sql);
    statement.setString(1, Id);
    resultSet=statement.executeQuery();
  
    if(resultSet.next()==true){
        //ID exit
        avail=true;
    }
    else{
        //ID doesnot exist
        avail=false;
        
    }
    
    }
    catch(Exception ex){
        ex.printStackTrace();
        }
  return avail;  
 
}


}
