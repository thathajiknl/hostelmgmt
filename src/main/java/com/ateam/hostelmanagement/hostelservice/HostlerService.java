package com.ateam.hostelmanagement.hostelservice;

import java.math.BigDecimal;
import java.util.List;

import com.ateam.hostelmanagement.hosteldaoimpl.Expense;
import com.ateam.hostelmanagement.hosteldaoimpl.Hostel;
import com.ateam.hostelmanagement.hosteldaoimpl.Hostler;
import com.ateam.hostelmanagement.hosteldaoimpl.HostlerRoomMapping;
import com.ateam.hostelmanagement.hosteldaoimpl.HostlerSearch;
import com.ateam.hostelmanagement.hosteldaoimpl.Payments;
import com.ateam.hostelmanagement.hosteldaoimpl.Room;
import com.ateam.hostelmanagement.hosteldaoimpl.RoomSearch;

public interface HostlerService {
	
	public void saveHostler(Hostler hostler);
	public List<Hostler>getallhostlers(int page);
	public void deleteHostler(long hostlerId);
    public void editHostler(Hostler hostler);
	public Hostler getHostler(long hostlerId);
	public long getHostlersCount();
	public List<Hostler>getallHostlers2();

	public List<Hostler> getHostlerSearch(HostlerSearch hostlerSearch);
	public List<Hostler> getCurrentHostlers();
	
	public void saveHostel(Hostel hostel);
    public List<Hostel>getallhostels(int page);
    public void deleteHostel(long hostelId);
    public void editHostel(Hostel hostel);
    public Hostel getHostel(long hostelId);
    public long getHostelsCount();
    
    public void saveRoom(Room room);
    //public List<Room>getallrooms();
    public void deleteRoom(long roomId);
    public void editRoom(Room room);
    public Room getRoom(long roomId);
    public List<Room> getRoomSearch(RoomSearch roomSearch);
	//Hostler getHostler(Long hostlerId);
    public long getRoomsCount();
    public List<Room>getallrooms(int page);
	

	
	public void saveExpense(Expense expense);
    public List<Expense> getallExpenses();
    public void deleteExpense(long expenseId);
    public void editExpense(Expense expense);
    public Expense getExpense(long expenseId);
    
    public void saveAssign(HostlerRoomMapping hostlerRoomMapping);
    public List<HostlerRoomMapping> getallAssigns();
    public void deleteAssign(long hostlerId);
    public void editAssign(HostlerRoomMapping hostlerRoomMapping);
    public HostlerRoomMapping getAssign(long id);
    
    public List<Room> getAvailableBeds();
    public List<HostlerRoomMapping> getHostlersRooms();
    
    public List<Long> getPaidHostlerIds(String fromDate,String toDate);
    public List<Hostler> getUnPaidHostlerIds(String fromDate,String toDate);
    
    public void savePayment(Payments payments);
    public List<Payments> getPaymentDetails();
    public List<Payments> getPaymentHistory(long hostlerId);
    
    public BigDecimal getSpent(String startDate,String endDate);
    public BigDecimal getReceived(String startDate,String endDate);
//	public List<Hostel> getallhostels();
	
	

}
