package com.ateam.hostelmanagement.hosteldaoimpl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity(name="room")
public class Room {
	@Id @GeneratedValue
	private long roomId;
	private  String roomNumber;
	private  String noOfBeds;
	private String hostelId;
	@Transient
	private String hostelName;
	@Transient
	private int availableBeds;
	private int deleted=0;
	
	
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public int getAvailableBeds() {
		return availableBeds;
	}
	public void setAvailableBeds(int availableBeds) {
		this.availableBeds = availableBeds;
	}
	public String getHostelName() {
		return hostelName;
	}
	public void setHostelName(String hostelName) {
		this.hostelName = hostelName;
	}
	public String getHostelId() {
		return hostelId;
	}
	public void setHostelId(String hostelId) {
		this.hostelId = hostelId;
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getNoOfBeds() {
		return noOfBeds;
	}
	public void setNoOfBeds(String noOfBeds) {
		this.noOfBeds = noOfBeds;
	}
	public void setRoomAssigned(boolean b) {
		// TODO Auto-generated method stub
		
	}
//	@ManyToOne
//    private Hostel hostel;
//	
	
}
