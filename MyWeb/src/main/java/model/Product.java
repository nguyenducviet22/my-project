package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	private String productCode;
	private String productName;
	private Integer productionYear;
	private Double sellingPrice;
	private Integer quantity;
	private String description;
	@ManyToOne
	@JoinColumn(name = "detailedOrderFK")
	private DetailedOrder detailedOrder;
	@ManyToOne
	@JoinColumn(name = "categoryFK")
	private Category category;
	@ManyToMany(mappedBy = "productList")
	private Set<Shop> ShopList = new HashSet<Shop>();

	public Product() {
	}

	public Product(String productCode, String productName, Integer productionYear, Double sellingPrice,
			Integer quantity, String description, Category category) {
		this.productCode = productCode;
		this.productName = productName;
		this.productionYear = productionYear;
		this.sellingPrice = sellingPrice;
		this.quantity = quantity;
		this.description = description;
		this.category = category;
	}
	
	public Product(String productCode, String productName, Integer productionYear, Double sellingPrice,
			Integer quantity, String description, DetailedOrder detailedOrder, Category category) {
		this.productCode = productCode;
		this.productName = productName;
		this.productionYear = productionYear;
		this.sellingPrice = sellingPrice;
		this.quantity = quantity;
		this.description = description;
		this.detailedOrder = detailedOrder;
		this.category = category;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(Integer productionYear) {
		this.productionYear = productionYear;
	}

	public Double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(Double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DetailedOrder getDetailedOrder() {
		return detailedOrder;
	}

	public void setDetailedOrder(DetailedOrder detailedOrder) {
		this.detailedOrder = detailedOrder;
	}

	public Set<Shop> getShopList() {
		return ShopList;
	}

	public void setShopList(Set<Shop> shopList) {
		ShopList = shopList;
	}

}
