package com.ateam.hostelmanagement.hosteldaoimpl;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ateam.hostelmanagement.hosteldao.HostlerDao;
import com.ateam.hostelmanagement.settings.Sqls;
import com.ateam.hostelmanagement.util.Api;


@Repository
public class HostlerDaoImpl implements HostlerDao {

	@Autowired
	private JdbcTemplate jdbcTemplet;

	@Autowired
	private SessionFactory sessionFactory;
 
	
	public void saveHostler(final Hostler hostler) {

		sessionFactory.getCurrentSession().save(hostler);

	}

	
	public List<Hostler> getallhostlers(int offset, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Hostler.class);
		criteria.add(Restrictions.eq("deleted", 0));
	    criteria.setFirstResult(offset);
		criteria.setMaxResults(pageSize);
		List<Hostler> hostlers = criteria.list();
			
//		  List<Hostler> hostlers = session.createQuery("from hostler h where h.deleted=0").list();
		return hostlers;
	}

	
	public void deleteHostler(long hostlerId) {
		// TODO Auto-generated method stu
		Session session = sessionFactory.getCurrentSession();
		Query qry = session
				.createQuery("update hostler h SET h.deleted=1 WHERE h.hostlerId=?");
		qry.setParameter(0, hostlerId);
		int res = qry.executeUpdate();
	}
//	@Override
//	public void editHostler(Hostler hostler) {
//		sessionFactory.getCurrentSession().update(hostler);
//	}
	public Hostler getHostler(long hostlerId) {

		return (Hostler)sessionFactory.getCurrentSession().get(Hostler.class, hostlerId);
//		return jdbcTemplet.queryForObject(Sqls.SELECT_HOSTLER,
//				new Object[] { hostlerId }, new BeanPropertyRowMapper<Hostler>(
//						Hostler.class));

	}
	public void saveHostel(final Hostel hostel) {

		sessionFactory.getCurrentSession().save(hostel);
   }
	public List<Hostel> getallhostels(int offset, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
	    List<Hostel> hostels = session.createQuery("from hostel h where h.deleted=0").list();
	     		return hostels;
	}

	
	public void deleteHostel(long hostelId) {
		Session session = sessionFactory.getCurrentSession();
        Query qry=session.createQuery("update hostel h SET h.deleted=1 WHERE h.hostelId=?");
        qry.setParameter(0,hostelId);
        int res = qry.executeUpdate();

	}

	
	public void editHostel(Hostel hostel) {

		sessionFactory.getCurrentSession().update(hostel);	
	}

	
	public Hostel getHostel(long hostelId) {

		return jdbcTemplet.queryForObject(Sqls.SELECT_HOSTEL,
				new Object[] { hostelId }, new BeanPropertyRowMapper<Hostel>(
						Hostel.class));
	}

	
	public void saveRoom(final Room room) {

		sessionFactory.getCurrentSession().save(room);
	}

	
	
	public void deleteRoom(long roomId) {

		Session session = sessionFactory.getCurrentSession();
        Query qry=session.createQuery("update room r SET r.deleted=1 WHERE r.roomId=?");
        qry.setParameter(0,roomId);
        int res = qry.executeUpdate();
	}
	public List<Room> getallrooms(int offset, int pageSize) {
		Session session = sessionFactory.getCurrentSession();
       List<Room> rooms =  jdbcTemplet.query(Sqls.SELECT_ROOMS, new Object[]{offset,pageSize},new BeanPropertyRowMapper<Room>(Room.class));//session.createQuery("select r.roomId, r.roomNumber, r.noOfBeds, r.hostelId,h.hostelName from com.ateam.hostelmanagement.hosteldaoimpl.Room r join com.ateam.hostelmanagement.hosteldaoimpl.Hostel h  where r.deleted=0").list();	     		
//		Criteria query = session.createCriteria(Hostel.class);
//	    query.createCriteria("room", "r");
//	    query.add(Restrictions.eq("r.hostelId", hostelId));
//		List<Room> rooms = (ArrayList<Room>)query.list();
//		DetachedCriteria ownerCriteria = DetachedCriteria.forClass(Room.class);
//	    ownerCriteria.setProjection(Property.forName("roomId"));
//	    ownerCriteria.add(Restrictions.eq("hostelId", "hostelId"));
//
//	    Criteria criteria = session.createCriteria(Hostel.class);
//	    criteria.add(Property.forName("roomId").in(ownerCriteria));
//	    List rooms = criteria.list();
		return rooms;
	}
	
	public void editRoom(Room room) {

		sessionFactory.getCurrentSession().update(room);

	}

	
	public Room getRoom(long roomId) {

		return jdbcTemplet.queryForObject(Sqls.SELECT_ROOM,
				new Object[] { roomId }, new BeanPropertyRowMapper<Room>(
						Room.class));
	}

	
	public void saveExpense(final Expense expense) {

		sessionFactory.getCurrentSession().save(expense);
	}

	
	public List<Expense> getallExpenses() {

		Session session = sessionFactory.getCurrentSession();
	    List<Expense> expense = session.createQuery("from expense e where e.deleted=0").list();
	    return  expense;
	}

	
	public void deleteExpense(long expenseId) {
		Session session = sessionFactory.getCurrentSession();
        Query qry=session.createQuery("update expense e SET e.deleted=1 WHERE e.expenseId=?");
        qry.setParameter(0,expenseId);
        int res = qry.executeUpdate();
	}

	
	public void editExpense(Expense expense) {

		sessionFactory.getCurrentSession().update(expense);
	}

	
	public Expense getExpense(long expenseId) {

		return jdbcTemplet.queryForObject(Sqls.SELECT_EXPENSE,
				new Object[] { expenseId }, new BeanPropertyRowMapper<Expense>(
						Expense.class));
	}

	
	public void saveAssign(final HostlerRoomMapping hostlerRoomMapping) {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		int update = jdbcTemplet.update(new PreparedStatementCreator() {

			
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {

				PreparedStatement ps = arg0.prepareStatement(
						Sqls.INSERT_ASSIGN, java.sql.Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, hostlerRoomMapping.getRoomId());
				ps.setLong(2, hostlerRoomMapping.getHostlerId());
				ps.setString(3, hostlerRoomMapping.getDateOfJoining());
				return ps;
			}
		}, keyHolder);

	}

	
	public List<HostlerRoomMapping> getallAssigns() {

		List<HostlerRoomMapping> hostlerRoomMapping = jdbcTemplet.query(
				Sqls.SELECT_ASSIGNS, new Object[] {},
				new BeanPropertyRowMapper<HostlerRoomMapping>(
						HostlerRoomMapping.class));
		return hostlerRoomMapping;
	}

	
	public void deleteAssign(long hostlerId) {

		jdbcTemplet.update(Sqls.DELETE_ASSIGN, new Object[] { hostlerId });
	}

	
	public void editAssign(HostlerRoomMapping hostlerRoomMapping) {

		jdbcTemplet.update(
				Sqls.UPDATE_ASSIGN,
				new Object[] { hostlerRoomMapping.getRoomId(),
						hostlerRoomMapping.getHostlerId(),
						hostlerRoomMapping.getDateOfJoining(),
						hostlerRoomMapping.getHostlerId() });
	}

	
	public HostlerRoomMapping getAssign(long id) {

		try {
			return jdbcTemplet.queryForObject(Sqls.SELECT_ASSIGN,
					new Object[] { id },
					new BeanPropertyRowMapper<HostlerRoomMapping>(
							HostlerRoomMapping.class));
		} catch (Exception e) {
			return null;
		}
	}

	
	public List<Room> getAvailableBeds() {

		List<Room> beds = jdbcTemplet.query(Sqls.SELECT_ROOM_BEDS_AVAILABLE,
				new Object[] {}, new BeanPropertyRowMapper<Room>(Room.class));
		return beds;
	}

	
	public List<HostlerRoomMapping> getHostlersRooms() {

		List<HostlerRoomMapping> hostlersRooms = jdbcTemplet.query(
				Sqls.SELECT_HOSTLER_ROOM, new Object[] {},
				new BeanPropertyRowMapper<HostlerRoomMapping>(
						HostlerRoomMapping.class));

		return hostlersRooms;
	}

	
	public List<Long> getPaidHostlerIds(String fromDate, String toDate) {
		List<Long> listOfPaidHostlerIds = jdbcTemplet.queryForList(
				Sqls.SELECT_PAID_HOSTLERID, new Object[] { fromDate, toDate },
				Long.class);
		return listOfPaidHostlerIds;
	}

	
	public List<Hostler> getUnPaidHostlerIds(String fromDate, String toDate) {
		List<Long> listOfPaidHostlerIds = getPaidHostlerIds(fromDate, toDate);
		String csvListOfPaidHostlerIds = Api.toCSV(listOfPaidHostlerIds);
		String sql = Sqls.SELECT_UNPAID_HOSTLERID;
		if (!Api.isEmptyString(csvListOfPaidHostlerIds)) {
			sql = sql.replace(":extraCondition", "AND hr.hostlerId NOT IN ("
					+ csvListOfPaidHostlerIds + ")");

		} else {
			sql = sql.replace(":extraCondition", "");
		}

		List<Hostler> unpaidHostlers = jdbcTemplet.query(sql, new Object[] {
				fromDate, fromDate, fromDate, fromDate, fromDate, toDate },
				new BeanPropertyRowMapper<Hostler>(Hostler.class));
		return unpaidHostlers;
	}

	
	public void savePayment(final Payments payments) {

		KeyHolder keyHolder = new GeneratedKeyHolder();
		int update = jdbcTemplet.update(new PreparedStatementCreator() {

			
			public PreparedStatement createPreparedStatement(Connection arg0)
					throws SQLException {
				PreparedStatement ps = arg0.prepareStatement(
						Sqls.INSERT_PAYMENT, java.sql.Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, payments.getPaymentId());
				ps.setString(2, payments.getActualAmount());
				ps.setString(3, payments.getPaidAmount());
				ps.setString(4, payments.getActualDate());
				ps.setString(5, payments.getPaidDate());
				ps.setLong(6, payments.getHostlerId());
				return ps;
			}
		}, keyHolder);

	}

	
	public List<Payments> getPaymentDetails() {

		List<Payments> payments = jdbcTemplet.query(Sqls.SELECT_PAYMENTS,
				new Object[] {}, new BeanPropertyRowMapper<Payments>(
						Payments.class));
		return payments;
	}

	
	public List<Hostler> getHostlerSearch(HostlerSearch hostlerSearch) {
		Session session = sessionFactory.getCurrentSession();
	       
	       Criteria crit = session.createCriteria(Hostler.class);
	       crit.add(Restrictions.eq("deleted",0));
	       if(!Api.isEmptyString(hostlerSearch.getName())){ 
	          crit.add(Restrictions.and(Restrictions.like("name","%"+hostlerSearch.getName()+"%")));
	       }
	       if(!Api.isEmptyString(hostlerSearch.getFirstName())){
	        crit.add(Restrictions.and(Restrictions.like("firstName","%"+hostlerSearch.getFirstName()+"%")));
	       }
	        if(!Api.isEmptyString(hostlerSearch.getLastName())){
	        
	            crit.add(Restrictions.and(Restrictions.like("lastName","%"+hostlerSearch.getLastName()+"%")));
	        }
	        if(!Api.isEmptyString(hostlerSearch.getMobileNumber())){
	        crit.add(Restrictions.and(Restrictions.like("mobileNumber","%"+hostlerSearch.getMobileNumber()+"%")));
	        }
	        List<Hostler> list = crit.list();
		return list;
	}

	
	public List<CurrentPayers> getCurrentHostlers() {

		List<CurrentPayers> currentHostlers = jdbcTemplet.query(
				Sqls.SELECT_CURRENT_HOSTLERS, new Object[] {},
				new BeanPropertyRowMapper<CurrentPayers>(CurrentPayers.class));
		return currentHostlers;
	}

	
	public List<Room> getRoomSearch(RoomSearch roomSearch) {
		List<Room> availableBeds = jdbcTemplet.query(Sqls.SEARCH_ROOMS,
				new Object[] { roomSearch.getAvailableBeds() },
				new BeanPropertyRowMapper<Room>(Room.class));
		return availableBeds;

	}

	
	public BigDecimal getSpent(String startDate, String endDate) {
		Session session = sessionFactory.getCurrentSession();

		String sql = Sqls.SELECT_SPENT;
		SQLQuery query = session.createSQLQuery(sql);
		
		query.setParameter(0,startDate);
      query.setParameter(1,endDate);
      return (BigDecimal) query.uniqueResult();
	}

	
	public BigDecimal getReceived(String startDate, String endDate) {
		return jdbcTemplet.queryForObject(Sqls.SELECT_RECIEVED, new Object[] {
				startDate, endDate }, BigDecimal.class);
	}

	
	public List<Payments> getPaymentHistory(long hostlerId) {
//
		List<Payments> paymentHistory = jdbcTemplet.query(
				Sqls.SELECT_PAYMENT_HISTORY, new Object[] { hostlerId },
				new BeanPropertyRowMapper<Payments>(Payments.class));
		
//		Session session = sessionFactory.getCurrentSession();
//		Query qry=session.createQuery(" from Payments p join hostler h where p.hostlerId=h.hostlerId and p.hostlerId=?");
//		qry.setParameter(0,hostlerId);
//		List<Payments> paymentHistory = qry.list();
		return paymentHistory;
	}

	
	public long getHostlersCount() {
		Session session=sessionFactory.getCurrentSession();
     Criteria criteria=session.createCriteria(Hostler.class);
     criteria.add(Restrictions.eq("deleted", 0));
     criteria.setProjection(Projections.rowCount());
     return (Long)criteria.uniqueResult();
//		return jdbcTemplet.queryForLong(Sqls.SELECT_HOSTLERS_COUNT,
//				new Object[] {});
	}

	
	public long getHostelsCount() {
		// TODO Auto-generated method stub
		return jdbcTemplet.queryForLong(Sqls.SELECT_HOSTELS_COUNT,
				new Object[] {});

	}

	
	public long getRoomsCount() {
		// TODO Auto-generated method stub
		return jdbcTemplet.queryForLong(Sqls.SELECT_ROOMS_COUNT,
				new Object[] {});
	}

	
	
	

	public List<Hostler> getallHostlers2() {
		// TODO Auto-generated method stub
		List<Hostler> hostlers2 = jdbcTemplet.query(Sqls.SELECT_HOSTLERS2,
				new Object[] {}, new BeanPropertyRowMapper<Hostler>(
						Hostler.class));

		
		return hostlers2;
	}


	public void editHostler(Hostler hostler) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(hostler);
	}
	
}
