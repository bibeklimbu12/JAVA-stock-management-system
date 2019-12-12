/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conveniencestore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.table.DefaultTableModel;


public class Conn {
 static String constring = "jdbc:mysql://localhost:3306/db_k1458417";
 static String username = "root";
 static String password = "";
 
 
  public static boolean Insert(String sql){
      Connection con = null;
      Statement s = null;
     try
     {
        con = DriverManager.getConnection(constring, username, password);
        //prepare stmnset
        s = con.prepareStatement(sql);
        s.execute(sql);
        return true;
     }
     catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
         return false;
     }finally{
          try{
              if(s!=null)s.close();
              if(con!=null)con.close();
          }catch(Exception e){
             JOptionPane.showMessageDialog(null, e); 
          }
      } 
  }    

  public static boolean Update(String sql){
     Connection con = null;
     Statement s = null;
      try
     {
        con = DriverManager.getConnection(constring, username, password);
        //prepare stmnset
        s = con.prepareStatement(sql);
        s.execute(sql);
        return true;
     }
     catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
         return false;
     }finally{
          try{
              if(s!=null)s.close();
              if(con!=null)con.close();
          }catch(Exception e){
             JOptionPane.showMessageDialog(null, e); 
          }
      }
  }   
  
  public static DefaultTableModel PopulateTable(String sql){
     Connection con = null;
     Statement s = null;
     try{
        con = DriverManager.getConnection(constring, username, password); 
        s = con.prepareStatement(sql);       
        ResultSet rs = s.executeQuery(sql);
        ResultSetMetaData metadata = rs.getMetaData();
        
        Vector<String> ColumNames = new Vector<String>();
        int ColumnCount = metadata.getColumnCount();
        
        for(int column=1; column<=ColumnCount; column++){
            ColumNames.add(metadata.getColumnName(column));
        }
        //names of columns
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        
        while(rs.next()){
           Vector<Object> vector = new Vector<Object>(); 
           
           for(int columindex=1; columindex<=ColumnCount; columindex++){
               vector.add(rs.getObject(columindex));
           }
           data.add(vector);
        }
        
        return new DefaultTableModel(data, ColumNames);
     }catch(Exception e){
         new JOptionPane().showMessageDialog(null, e);
         return null;
     }finally{
          try{
              if(s!=null)s.close();
              if(con!=null)con.close();
          }catch(Exception e){
             JOptionPane.showMessageDialog(null, e); 
          }
      }
   }
 
 public static DefaultComboBoxModel Fetch(String sql,String columName){
     DefaultComboBoxModel dcm = new DefaultComboBoxModel();
     Connection con = null;
     Statement s = null;
     try{
        con = DriverManager.getConnection(constring, username, password); 
        s = con.prepareStatement(sql);
        
        ResultSet rs = s.executeQuery(sql);
        dcm.addElement("Select...");
        //loop
        while(rs.next()){
            
            String name = rs.getString(columName);
            dcm.addElement(name);
             //new JOptionPane().showMessageDialog(null, name);
        }
        return dcm;
     }catch(Exception e){
         e.printStackTrace();
         return null;
     }finally{
          try{
              if(s!=null)s.close();
              if(con!=null)con.close();
          }catch(Exception e){
             JOptionPane.showMessageDialog(null, e); 
          }
      }
   } 
  

 public static String fetchItem(String sql,String columName){
     Connection con = null;
     Statement s = null;
     try{
         con = DriverManager.getConnection(constring, username, password); 
         s = con.prepareStatement(sql);
        
        ResultSet rs = s.executeQuery(sql);
        String name=null;
        //loop
        while(rs.next()){
            
           name = rs.getString(columName);
            
             //new JOptionPane().showMessageDialog(null, name);
        }
        return name;
     }catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
         return null;
     }finally{
          try{
              if(s!=null)s.close();
              if(con!=null)con.close();
          }catch(Exception e){
             JOptionPane.showMessageDialog(null, e); 
          }
      }
 }
 
  public static int counter(String sql){
     Connection con = null;
     Statement s = null;
     try{
         con = DriverManager.getConnection(constring, username, password); 
         s = con.prepareStatement(sql);
        
        ResultSet rs = s.executeQuery(sql);
        String name=null;
        //loop
        int count=0;
        while(rs.next()){
            
           count++;
            
             //new JOptionPane().showMessageDialog(null, name);
        }
        return count;
     }catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
         return 0;
     }finally{
          try{
              if(s!=null)s.close();
              if(con!=null)con.close();
          }catch(Exception e){
             JOptionPane.showMessageDialog(null, e); 
          }
      }
 }
  
}
