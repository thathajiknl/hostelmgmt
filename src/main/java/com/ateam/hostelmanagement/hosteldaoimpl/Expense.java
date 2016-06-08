                                                                                           package com.ateam.hostelmanagement.hosteldaoimpl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
@Entity(name="expense")
public class Expense {

	@Id @GeneratedValue
	private long expenseId;
	@NotEmpty(message = "Expence should not be blank.") 
	private String expense;
	@NotEmpty(message = "amount should not be blank.")
	private String amount;
	private String date;
	private int deleted=0;
	public int getDeleted() {
		return deleted;
	}
	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(long expenseId) {
		this.expenseId = expenseId;
	}
	public String getExpense() {
		return expense;
	}
	public void setExpense(String expense) {
		this.expense = expense;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
