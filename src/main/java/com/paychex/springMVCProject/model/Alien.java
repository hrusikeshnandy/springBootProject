package com.paychex.springMVCProject.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
	@Id
	private int aid;
	private String aname;
	public int getAid() {
		return aid;
	}
	public Alien() {}
	
	public Alien(int aid, String aname) {
		super();
		this.aid = aid;
		this.aname = aname;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	@Override
	public String toString() {
		return "id:"+this.getAid() +" name: "+ this.getAname();
	}
	
}
