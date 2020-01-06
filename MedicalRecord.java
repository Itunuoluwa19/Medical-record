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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ITUNU
 */
public class MedicalRecord {
Connection conn = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;



    static final String DB_url = "jdbc:mysql://localhost:3306/rohi?zeroDateTimeBehavior=convertToNull";
    static final String username = "root";
    static final String password = "";
    private String nam, elec, temp, rep, bp, hr, rr  ;
    
    
    public void medicalrecord (String card_number, String pulse_rate, String blood_pressure, String report, String heart_rate, String temperature, String respiration_rate){
       String available=checkIfAccountExist(card_number);
       
        boolean ame=true;
        {
            //JOptionPane.showMessageDialog(null, "Account Exist");
        
        nam=card_number;
        elec=pulse_rate;
        bp=blood_pressure;
        rep=report;
        temp=temperature;
        hr=heart_rate;
        rr=respiration_rate;
        
       try{
           java.util.Date date = new java.util.Date();
        SimpleDateFormat Date = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat Time = new SimpleDateFormat("hh:mm:ss a");
        
        String DateCreated = Date.format(date);
        String TimeCreated=Time.format(date);
    
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_url, username, password);
        String sql = "INSERT INTO readings (card_number, blood_pressure, pulse_rate, respiration_rate, temperature,  heart_rate, report,dateEntered,timeEntered) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        statement=conn.prepareStatement(sql);
      
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, nam);
        statement.setString(2, elec);
        statement.setString(3, bp);
        statement.setString(4, rep);
        statement.setString(5, temp);
        statement.setString(6, hr);
        statement.setString(7, rr);
        statement.setString(8, DateCreated);
        statement.setString(9, TimeCreated);
        statement.executeUpdate();
       }
       catch(Exception ex){
           ex.printStackTrace();
       }
          }//end of else
    }
    

     public String checkIfAccountExist(String card_number ) {
        String report= "";
        boolean avail = false;
      
        try {
            Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_url, username, password);
                String sqlStatement = "select * from readings where card_number =?  && report= ?;";
                PreparedStatement k = conn.prepareStatement(sqlStatement);
                k.setString(1, card_number);
                k.setString(2, report);
                   while(avail==true){
    statement.setString(2, report);
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
  return report;
    }
    
   public  ArrayList<String> date=new ArrayList<>();
   public  ArrayList<String> time=new ArrayList<>();
   public  ArrayList<String> temperature=new ArrayList<>();
   public  ArrayList<String> pulse_rate=new ArrayList<>();
   public  ArrayList<String> heart_rate=new ArrayList<>(); 
    public      ArrayList<String> blood_pressure=new ArrayList<>();
    public  ArrayList<String> reports =new ArrayList<>();
    public  ArrayList<String> respiration_rate=new ArrayList<>();
          public  String pName, pDob, pSex, pPhone;
   /// public boolean getDetails(String ID,ArrayList<String> date,ArrayList<String> time,ArrayList<String> temperature ,ArrayList<String> pulse_rate,ArrayList<String> heart_rate,ArrayList<String> blood_pressure,ArrayList<String> reports ,ArrayList<String> respiration_rate, String [] values) {
      public boolean getDetails(String ID){  
        boolean d=false;
      
        
        String report= "";
        boolean avail = false;
      
        try {
 {
        date.clear();
        time.clear();
        pulse_rate.clear();
        blood_pressure.clear();
        temperature.clear();
        heart_rate.clear();
        respiration_rate.clear();
        reports.clear();
        }
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_url, username, password);
            String sqlStatement = "SELECT * FROM rohi.readings d JOIN details f on f.id=d.card_number where f.id=?";
            PreparedStatement k = conn.prepareStatement(sqlStatement);
            k.setString(1, ID);
            resultSet=k.executeQuery();
  int count=0;
        while(resultSet.next()){
            System.out.println("record exist for Id "+ID);
            d=true;
              System.out.println(resultSet.getString("timeEntered"));
              if(count==0){
              pName =resultSet.getString("surname")+" "+resultSet.getString("other_names");
               pDob=resultSet.getString("dob");
               pSex=resultSet.getString("sex");
               pPhone=resultSet.getString("phone_number");
              }
           date.add(resultSet.getString("dateEntered"));
           time.add(resultSet.getString("timeEntered"));
           pulse_rate.add(resultSet.getString("pulse_rate"));
           
           blood_pressure.add(resultSet.getString("blood_pressure"));
           respiration_rate.add(resultSet.getString("respiration_rate"));
           heart_rate.add(resultSet.getString("heart_rate"));
           temperature.add(resultSet.getString("temperature"));
           reports.add(resultSet.getString("report"));
        count++;
       
    }
    System.out.println("DAte size= "+date.size());
    
    }
        
    catch(ClassNotFoundException | SQLException ex){
        }
 return d;
 
    }
    
    
    public boolean checkID(String ID){
      boolean  avail=false;
               try {
            Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection(DB_url, username, password);
                String sqlStatement = "SELECT * FROM rohi.details where id = ?";
                PreparedStatement k = conn.prepareStatement(sqlStatement);
                k.setString(1, ID);
               
    resultSet=k.executeQuery();
    if(resultSet.next()==true){
        //ID exitavai
     avail=true;
        }
               }
               catch(Exception ex){
                   ex.printStackTrace();
               }
       
        return avail;
    }
    
    
}

