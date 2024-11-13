package com.example.demo.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.pojo.Laptop;

@Repository
public class MyRepo {
	
	
	//INSERTION PURPOSE
	public String insert(Laptop laptop) throws ClassNotFoundException, SQLException{
		
		
	     String url="jdbc:mysql://localhost:3306/ems";
	    
	       Class.forName("com.mysql.cj.jdbc.Driver");   
	    
	         Connection con=DriverManager.getConnection(url,"root","Vasu@2002");
	  
	        Statement st=con.createStatement();
	  
	     String query="insert into laptop values(?,?,?)";
	    
	     PreparedStatement pst=con.prepareStatement(query)  ;
	    
	    
	    pst.setInt(1,laptop.getId());
	    pst.setString(2,laptop.getBrand() );
	    pst.setString(3, laptop.getPrice());
	   
	    pst.executeUpdate();
	   
		return "inserted sucessfully";
	
	}

	
	//GET ALL THE DATA [SELECT ]
	public List<Laptop> getDatav2() throws ClassNotFoundException, SQLException{
		
		   List<Laptop> lap=new ArrayList<>();
		
		     String url="jdbc:mysql://localhost:3306/ems";
		    
		       Class.forName("com.mysql.cj.jdbc.Driver");   
		    
		   Connection con=DriverManager.getConnection(url,"root","Vasu@2002");
		  
		 Statement st=con.createStatement();
		 
		
		  ResultSet rs=st.executeQuery("select*from laptop");  
		  while(rs.next()) {
			  
			 Laptop laptop=new Laptop();
	
			  laptop.setId(rs.getInt(1));
			  laptop.setBrand(rs.getString(2));
			  laptop.setPrice(rs.getString(3));
			
			lap.add(laptop);	
			
		}
		
		 return lap;
		
	}
	
	
	
	//DELTE THE DATA
	public String delete(int id) throws ClassNotFoundException, SQLException{
		
		
		  String url="jdbc:mysql://localhost:3306/ems"; 
		   Class.forName("com.mysql.cj.jdbc.Driver");   
		    Connection con=DriverManager.getConnection(url,"root","Vasu@2002");
		  Statement st=con.createStatement();
		  
		  
		    String query="delete from laptop where id = ?";
		    PreparedStatement pst=con.prepareStatement(query)  ;
		    pst.setInt(1,id);
		 
		    pst.executeUpdate();
	
			return "Deleted sucessfully";
		
		}
	

	//UPDATING THE DATA :
	public String update(Laptop laptop) throws ClassNotFoundException, SQLException {

	    String url = "jdbc:mysql://localhost:3306/ems";

	    Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con = DriverManager.getConnection(url, "root", "Vasu@2002");

	    // Modified query to update both brand and price
	    String query = "UPDATE laptop SET brand = ?, price = ? WHERE id = ?";

	    PreparedStatement pst = con.prepareStatement(query);
	    
	    // Set the values for brand, price, and id from the Laptop object
	    pst.setString(1, laptop.getBrand());
	    pst.setString(2, laptop.getPrice());
	    pst.setInt(3, laptop.getId());

	    pst.executeUpdate();

	    return "UPDATED successfully";
	}

	
	
	
	
	
	
	  //Search By Brand:
	
    public List<Laptop> searchByBrand(String brand) throws ClassNotFoundException, SQLException {
    	
        List<Laptop> laptops = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/ems";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, "root", "Vasu@2002");

        String query = "SELECT * FROM laptop WHERE brand LIKE ?";
        PreparedStatement pst = con.prepareStatement(query);
//        pst.setString(1, "%" + brand + "%"); // Use LIKE for partial matching
        pst.setString(1,  brand );

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
        	
            Laptop laptop = new Laptop();
            
            laptop.setId(rs.getInt("id"));
            laptop.setBrand(rs.getString("brand"));
            laptop.setPrice(rs.getString("price"));
            
            laptops.add(laptop);
        }

        // Close resources
        rs.close();
        pst.close();
        con.close();

        return laptops;
    }
	
	
    
    //SearchByPrice
	
    public List<Laptop> searchByPrice(String price )throws ClassNotFoundException, SQLException {
    	
        List<Laptop> laptops = new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/ems";
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        Connection con = DriverManager.getConnection(url, "root", "Vasu@2002");

        String query = "SELECT * FROM laptop WHERE price <= ?";
        
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, price); // Use LIKE for partial matching

        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
        	
            Laptop laptop = new Laptop();
            
            laptop.setId(rs.getInt("id"));
            laptop.setBrand(rs.getString("brand"));
            laptop.setPrice(rs.getString("price"));
            
            laptops.add(laptop);
        }

        // Close resources
        rs.close();
        pst.close();
        con.close();

        return laptops;
    }
	
	
	
	
	
    

	
	

}
