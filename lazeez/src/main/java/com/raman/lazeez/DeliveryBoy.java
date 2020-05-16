package com.raman.lazeez;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class DeliveryBoy 
{
	private int id;
	private String name,mobile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "DeliveryBoy [id=" + id + ", name=" + name + ", mobile=" + mobile + "]";
	}
	
	
}
