package com.raman.lazeez;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;





@Path("vendors")
public class VendorResource
{
	VendorRepository repo = new VendorRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Vendor> getVendors() 
	{
		System.out.println("getVendors called ...");
		return repo.getVendors();
	}
	
	@GET
	@Path("vendor/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Vendor getVendor(@PathParam("id") int id)
	{
		return repo.getVendor(id);
	}
	
	@POST
	@Path("vendor")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Vendor createVendor(Vendor a1)
	{
		System.out.println(a1);
		repo.create(a1);
		
		return a1;
	}
	
	@PUT
	@Path("vendor")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Vendor updateVendor(Vendor a1)
	{
		System.out.println(a1);
		if(repo.getVendor(a1.getId()).getId()==0) 
		{
			repo.create(a1);
		}
		repo.update(a1);
		return a1;
	}
	
	@DELETE
	@Path("vendor/{id}")
	 public Vendor deleteVendor(@PathParam("id") int id)
	 {
		 Vendor a = repo.getVendor(id);
		
		 if(a.getId()!=0)
			 repo.delete(id);
		 
		 return a;
	 }
	
}
