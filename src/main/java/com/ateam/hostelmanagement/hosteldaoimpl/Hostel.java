package com.ateam.hostelmanagement.hosteldaoimpl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="hostel")
public class Hostel {
	@Id @GeneratedValue
	private long hostelId;
	private  String hostelName;
	private  String hostelAddress;
	private int deleted=0;
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public long getHostelId() {
		return hostelId;
	}
	public void setHostelId(long hostelId) {
		this.hostelId = hostelId;
	}
	public String getHostelName() {
		return hostelName;
	}
	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}
	public String getHostelAddress() {
		return hostelAddress;
	}
	public void setHostelAddress(String hostelAddress) {
		this.hostelAddress = hostelAddress;
	}
	public void setRoomAssigned(boolean b) {
		// TODO Auto-generated method stub
		
	}

//    @OneToMany(targetEntity = Room.class, cascade = CascadeType.ALL, mappedBy = "hostel")
//    @Cascade(value = org.hibernate.annotations.CascadeType.ALL)
//    private Collection<Room> rooms = new ArrayList<Room>();
//	
//	
	
	

}
