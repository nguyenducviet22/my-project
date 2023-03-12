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
	@Column(name = "detailed_order_code")
	private String detailedOrderCode;
	private Double quantity;
	private Double discountPrice;
	private Double sellingPrice;
	private Double basisPrice;
	private Double vat;
	private Double total;
	@OneToMany(mappedBy = "detailedOrder", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Product> product;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_FK")
	private Order order;

	public DetailedOrder() {
	}

	public DetailedOrder(String detailedOrderCode, Double quantity, Double discountPrice, Double sellingPrice,
			Double basisPrice, Double vat, Double total, List<Product> product, Order order) {
		this.detailedOrderCode = detailedOrderCode;
		this.quantity = quantity;
		this.discountPrice = discountPrice;
		this.sellingPrice = sellingPrice;
		this.basisPrice = basisPrice;
		this.vat = vat;
		this.total = total;
		this.product = product;
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

	public Double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Double getBasisPrice() {
		return basisPrice;
	}

	public void setBasisPrice(Double basisPrice) {
		this.basisPrice = basisPrice;
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

	@Override
	public String toString() {
		return "DetailedOrder [detailedOrderCode=" + detailedOrderCode + ", quantity=" + quantity + ", discountPrice="
				+ discountPrice + ", sellingPrice=" + sellingPrice + ", basisPrice=" + basisPrice + ", vat=" + vat
				+ ", total=" + total + ", product=" + product + ", order=" + order + "]";
	}
	
	
}
