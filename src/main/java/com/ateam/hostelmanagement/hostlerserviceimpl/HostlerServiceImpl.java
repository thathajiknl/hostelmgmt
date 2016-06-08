package com.ateam.hostelmanagement.hostlerserviceimpl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ateam.hostelmanagement.hosteldao.HostlerDao;
import com.ateam.hostelmanagement.hosteldaoimpl.Expense;
import com.ateam.hostelmanagement.hosteldaoimpl.Hostel;
import com.ateam.hostelmanagement.hosteldaoimpl.Hostler;
import com.ateam.hostelmanagement.hosteldaoimpl.HostlerRoomMapping;
import com.ateam.hostelmanagement.hosteldaoimpl.HostlerSearch;
import com.ateam.hostelmanagement.hosteldaoimpl.Payments;
import com.ateam.hostelmanagement.hosteldaoimpl.Room;
import com.ateam.hostelmanagement.hosteldaoimpl.RoomSearch;
import com.ateam.hostelmanagement.hostelservice.HostlerService;
import com.ateam.hostelmanagement.settings.Constants;
import com.ateam.hostelmanagement.util.Api;
@Service

public class HostlerServiceImpl implements HostlerService{

	@Autowired
	HostlerDao hostlerDao;
	@Autowired
	Constants constants;
	
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveHostler(Hostler hostler) {
		System.out.println(hostler.getName());
		hostlerDao.saveHostler(hostler);
		
	}
	
	@Transactional
	public List<Hostler> getallhostlers(int page) {
		int offSet=(page-1)*constants.pageSize;
		
		return hostlerDao.getallhostlers(offSet,constants.pageSize);
	}
	
	@Transactional
	public void deleteHostler(long hostlerId) {

		
		hostlerDao.deleteHostler(hostlerId);
		
	}
	@Transactional
	public void editHostler(Hostler hostler) {
		
		hostlerDao.editHostler(hostler);
		
	}
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public Hostler getHostler(long hostlerId) {
		
		return hostlerDao.getHostler(hostlerId);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveHostel(Hostel hostel) {
		
		hostlerDao.saveHostel(hostel);
	}
	@Transactional
	public List<Hostel> getallhostels(int page) {
		int offSet=(page-1)*constants.pageSize;
		
		return hostlerDao.getallhostels(offSet,constants.pageSize);
	}

	@Transactional
	public void deleteHostel(long hostelId) {
		
		hostlerDao.deleteHostel(hostelId);
		
	}
	@Transactional
	public void editHostel(Hostel hostel) {
		
		hostlerDao.editHostel(hostel);
		
	}
	
	public Hostel getHostel(long hostelId) {
		
		return hostlerDao.getHostel(hostelId);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveRoom(Room room) {
		
		hostlerDao.saveRoom(room);
		
	}
	@Transactional
	public List<Room> getallrooms(int page) {
		
int offSet=(page-1)*constants.pageSize;
		
		return hostlerDao.getallrooms(offSet,constants.pageSize);
	}
	@Transactional
	public void deleteRoom(long roomId) {
		
		hostlerDao.deleteRoom(roomId);
		
	}
	@Transactional
	public void editRoom(Room room) {
		
		hostlerDao.editRoom(room);
	}
	
	public Room getRoom(long roomId) {
		
		return hostlerDao.getRoom(roomId);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public void saveExpense(Expense expense) {
		
	hostlerDao.saveExpense(expense);	
	}
	@Transactional
	public List<Expense> getallExpenses() {
		
		return hostlerDao.getallExpenses();
	}
	@Transactional
	public void deleteExpense(long expenseId) {
		
		hostlerDao.deleteExpense(expenseId);
	}
	@Transactional
	public void editExpense(Expense expense) {
		
		hostlerDao.editExpense(expense);
	}
	@Transactional
	public Expense getExpense(long expenseId) {
		
		return hostlerDao.getExpense(expenseId);
	}
	
	public void saveAssign(HostlerRoomMapping hostlerRoomMapping) {
		
		hostlerDao.saveAssign(hostlerRoomMapping);
	}
	
	public List<HostlerRoomMapping> getallAssigns() {
		
		return hostlerDao.getallAssigns();
	}
	
	public void deleteAssign(long hostlerId) {
		
		hostlerDao.deleteAssign(hostlerId);
	}
	
	public void editAssign(HostlerRoomMapping hostlerRoomMapping) {
		
	hostlerDao.editAssign(hostlerRoomMapping);	
	}
	
	public HostlerRoomMapping getAssign(long id) {
		
		return hostlerDao.getAssign(id);
	}
	
	public List<Room> getAvailableBeds() {
		
		return hostlerDao.getAvailableBeds();
	}
	
	public List<HostlerRoomMapping> getHostlersRooms() {
		
		return hostlerDao.getHostlersRooms();
	}
	
	public List<Long> getPaidHostlerIds(String fromDate, String toDate) {
		
		return hostlerDao.getPaidHostlerIds(fromDate, toDate);
	}
	
	public List<Hostler> getUnPaidHostlerIds(String fromDate, String toDate) {
		
		return hostlerDao.getUnPaidHostlerIds(fromDate, toDate);
	}
	
	public void savePayment(Payments payments) {
		
		hostlerDao.savePayment(payments);
		
	}
	
	public List<Payments> getPaymentDetails() {
		
		return hostlerDao.getPaymentDetails();
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Hostler> getHostlerSearch(HostlerSearch hostlerSearch) {
		
		return hostlerDao.getHostlerSearch(hostlerSearch);
	}
	
	public List<Hostler> getCurrentHostlers() {

		int day=-Api.getGivenFieldFromDateAndTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd"), Api.DateType.DAY);
		Date fromDate=DateUtils.addDays(new Date(), day);
		Date todate=new Date();
		String fromDateInSting=DateFormatUtils.format(fromDate, "yyyy-MM-dd");
		String toDateInstring=DateFormatUtils.format(todate, "yyyy-MM-dd");
		
		
		
		
		
		
		return hostlerDao.getUnPaidHostlerIds(fromDateInSting, toDateInstring);
	}
	
	public List<Room> getRoomSearch(RoomSearch roomSearch) {
		
		return hostlerDao.getRoomSearch(roomSearch);
	}

	
	public BigDecimal getSpent(String startDate, String endDate) {
		
		return hostlerDao.getSpent(startDate, endDate);
	}
	
	public BigDecimal getReceived(String startDate, String endDate) {
		
		return hostlerDao.getReceived(startDate, endDate);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public List<Payments> getPaymentHistory(long hostlerId) {
		
		return hostlerDao.getPaymentHistory(hostlerId);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public long getHostlersCount() {
		return hostlerDao.getHostlersCount();
	}
	
	
	public long getHostelsCount() {
		
		return hostlerDao.getHostelsCount();
	}
	
	public long getRoomsCount() {
		
		return hostlerDao.getRoomsCount();
	}
	
	
	public List<Hostler> getallHostlers2() {
		
		return hostlerDao.getallHostlers2();
	}


}
