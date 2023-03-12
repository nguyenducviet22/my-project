package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detailed_order")
public class DetailedOrder {
	@Id
	private String detailedOrderCode;
	private Double quantity;
	private Double vat;
	private Double total;
	@OneToMany(mappedBy = "detailedOrder", cascade = CascadeType.ALL)
	private List<Product> product;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "orderFK")
	private Order order;

	public DetailedOrder() {
	}

	public DetailedOrder(String detailedOrderCode, Double quantity, Double vat, Double total, Order order) {
		this.detailedOrderCode = detailedOrderCode;
		this.quantity = quantity;
		this.vat = vat;
		this.total = total;
		this.order = order;
	}

	public String getDetailedOrderCode() {
		return detailedOrderCode;
	}

	public void setDetailedOrderCode(String detailedOrderCode) {
		this.detailedOrderCode = detailedOrderCode;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

	public Double getVat() {
		return vat;
	}

	public void setVat(Double vat) {
		this.vat = vat;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}
