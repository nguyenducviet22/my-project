package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
	@Id
	private String orderCode;
	private String receivedAddress;
	private String state;
	private String formOfPayment;
	private Date orderedDay;
	private Date deliveredDay;
	@ManyToOne
	@JoinColumn(name = "customerFK")
	private Customer customer;

	public Order() {
	}

	public Order(String orderCode, Customer customer, String receivedAddress, String state, String formOfPayment,
			Date orderedDay, Date deliveredDay) {
		this.orderCode = orderCode;
		this.customer = customer;
		this.receivedAddress = receivedAddress;
		this.state = state;
		this.formOfPayment = formOfPayment;
		this.orderedDay = orderedDay;
		this.deliveredDay = deliveredDay;
	}

	public String getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(String orderCode) {
		this.orderCode = orderCode;
	}

	public String getReceivedAddress() {
		return receivedAddress;
	}

	public void setReceivedAddress(String receivedAddress) {
		this.receivedAddress = receivedAddress;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getFormOfPayment() {
		return formOfPayment;
	}

	public void setFormOfPayment(String formOfPayment) {
		this.formOfPayment = formOfPayment;
	}

	public Date getOrderedDay() {
		return orderedDay;
	}

	public void setOrderedDay(Date orderedDay) {
		this.orderedDay = orderedDay;
	}

	public Date getDeliveredDay() {
		return deliveredDay;
	}

	public void setDeliveredDay(Date deliveredDay) {
		this.deliveredDay = deliveredDay;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
