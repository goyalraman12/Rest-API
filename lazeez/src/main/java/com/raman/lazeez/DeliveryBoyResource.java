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





@Path("deliveryboys")
public class DeliveryBoyResource
{
	DeliveryBoyRepository repo = new DeliveryBoyRepository();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<DeliveryBoy> getDeliveryBoys() 
	{
		System.out.println("getDeliveryBoys called ...");
		return repo.getDeliveryBoys();
	}
	
	@GET
	@Path("deliveryboy/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public DeliveryBoy getDeliveryBoy(@PathParam("id") int id)
	{
		return repo.getDeliveryBoy(id);
	}
	
	@POST
	@Path("deliveryboy")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public DeliveryBoy createDeliveryBoy(DeliveryBoy a1)
	{
		System.out.println(a1);
		repo.create(a1);
		
		return a1;
	}
	
	@PUT
	@Path("deliveryboy")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public DeliveryBoy updateDeliveryBoy(DeliveryBoy a1)
	{
		System.out.println(a1);
		if(repo.getDeliveryBoy(a1.getId()).getId()==0) 
		{
			repo.create(a1);
		}
		repo.update(a1);
		return a1;
	}
	
	@DELETE
	@Path("deliveryboy/{id}")
	 public DeliveryBoy deleteDeliveryBoy(@PathParam("id") int id)
	 {
		 DeliveryBoy a = repo.getDeliveryBoy(id);
		
		 if(a.getId()!=0)
			 repo.delete(id);
		 
		 return a;
	 }
	
}
