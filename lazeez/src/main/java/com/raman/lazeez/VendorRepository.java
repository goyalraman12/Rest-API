package com.raman.lazeez;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class VendorRepository
{
	Connection con = null;
	
	public VendorRepository()  
	{
		
		String url = "jdbc:mysql://localhost:3306/database1";
		String uname = "root";
		String pass = "Raman@7891";
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pass);
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
	}
	
	public List<Vendor> getVendors()
	{
		List<Vendor> vendors = new ArrayList<>();
		String query = "select * from foodvendors";
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) 
			{
				Vendor a = new Vendor();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setEmail(rs.getString(3));
				a.setMobile(rs.getString(4));
				a.setAddress(rs.getString(5));
				vendors.add(a);
			}
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		return vendors;
	}
	
	public Vendor getVendor(int id) 
	{
		String query = "select * from foodvendors where id ="+id;
		Vendor a = new Vendor();
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) 
			{
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setEmail(rs.getString(3));
				a.setMobile(rs.getString(4));
				a.setAddress(rs.getString(5));	
			}
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		return a;
	}
	
	public void create(Vendor a1)
	{
		String query = "insert into foodvendors values (?,?,?,?,?)";
		try 
		{
			String select = "select * from foodvendors";
			int count =0;
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(select);
			while(rs.next()) 
			{
				count=rs.getInt(1);
			}
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1, ++count);
			pst.setString(2, a1.getName());
			pst.setString(3, a1.getEmail());
			pst.setString(4,a1.getMobile());
			pst.setString(5,a1.getAddress());
			pst.executeUpdate();
	
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public void update(Vendor a1)
	{
		String query = "update foodvendors set name=?, email=?,mobile=?, address=? where id=?";
		try 
		{
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, a1.getName());
			st.setString(2,a1.getEmail());
			st.setString(3, a1.getMobile());
			st.setString(4,a1.getAddress());
			st.setInt(5,a1.getId());
			st.executeUpdate();
	
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public void delete(int id) {
		String query = "delete from foodvendors where id=?";
		try 
		{
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, id);
			st.executeUpdate();
	
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
			
	}
}
