package com.raman.lazeez;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class DeliveryBoyRepository
{
	Connection con = null;
	
	public DeliveryBoyRepository()  
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
	
	public List<DeliveryBoy> getDeliveryBoys()
	{
		List<DeliveryBoy> deliveryBoys = new ArrayList<>();
		String query = "select * from deliveryboy";
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) 
			{
				DeliveryBoy a = new DeliveryBoy();
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setMobile(rs.getString(3));
				deliveryBoys.add(a);
			}
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		return deliveryBoys;
	}
	
	public DeliveryBoy getDeliveryBoy(int id) 
	{
		String query = "select * from foodvendors where id ="+id;
		DeliveryBoy a = new DeliveryBoy();
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) 
			{
				
				a.setId(rs.getInt(1));
				a.setName(rs.getString(2));
				a.setMobile(rs.getString(3));	
			}
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		return a;
	}
	
	public void create(DeliveryBoy a1)
	{
		String query = "insert into deliveryboy values (?,?,?)";
		try 
		{
			String select = "select * from deliveryboy";
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
			pst.setString(3,a1.getMobile());
			pst.executeUpdate();
	
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public void update(DeliveryBoy a1)
	{
		String query = "update deliveryboys set name=?,mobile=? where id=?";
		try 
		{
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, a1.getName());
			st.setString(2, a1.getMobile());
			st.setInt(3,a1.getId());
			st.executeUpdate();
	
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
	}
	
	public void delete(int id) {
		String query = "delete from deliveryboy where id=?";
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
