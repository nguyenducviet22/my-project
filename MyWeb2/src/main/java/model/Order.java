package model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@Column(name = "order_code")
	private String orderCode;
	private String receivedAddress;
	private String state;
	private String formOfPayment;
	private Double paidMoney;
	private Double unpaidMoney;
	private Date orderedDay;
	private Date deliveredDay;
	@ManyToOne
	@JoinColumn(name = "customer_FK")
	private Customer customer;

	public Order() {
	}

	public Order(String orderCode, Customer customer, String receivedAddress, String state, String formOfPayment,
			Double paidMoney, Double unpaidMoney, Date orderedDay, Date deliveredDay) {
		this.orderCode = orderCode;
		this.customer = customer;
		this.receivedAddress = receivedAddress;
		this.state = state;
		this.formOfPayment = formOfPayment;
		this.paidMoney = paidMoney;
		this.unpaidMoney = unpaidMoney;
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

	public Double getPaidMoney() {
		return paidMoney;
	}

	public void setPaidMoney(Double paidMoney) {
		this.paidMoney = paidMoney;
	}

	public Double getUnpaidMoney() {
		return unpaidMoney;
	}

	public void setUnpaidMoney(Double unpaidMoney) {
		this.unpaidMoney = unpaidMoney;
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

	@Override
	public String toString() {
		return "Order [orderCode=" + orderCode + ", receivedAddress=" + receivedAddress + ", state=" + state
				+ ", formOfPayment=" + formOfPayment + ", paidMoney=" + paidMoney + ", unpaidMoney=" + unpaidMoney
				+ ", orderedDay=" + orderedDay + ", deliveredDay=" + deliveredDay + ", customer=" + customer + "]";
	}

	
}
