package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
	@Column(name = "product_code")
	private String productCode;
	private String productName;
	private Integer productionYear;
	private Double importPrice;
	private Double sellingPrice;
	private Double basisPrice;
	private Integer quantity;
	private String description;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "shop_FK")
	private Shop shop;
	@ManyToOne
	@JoinColumn(name = "detailed_order_FK")
	private DetailedOrder detailedOrder;
	@ManyToMany(mappedBy = "productList")
	private Set<Shop> ShopList = new HashSet<Shop>();

	public Product() {
	}

	public Product(String productCode, String productName, Shop shop, Integer productionYear, Double importPrice,
			Double sellingPrice, Double basisPrice, Integer quantity, String description) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.shop = shop;
		this.productionYear = productionYear;
		this.importPrice = importPrice;
		this.sellingPrice = sellingPrice;
		this.basisPrice = basisPrice;
		this.quantity = quantity;
		this.description = description;
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

	public Double getImportPrice() {
		return importPrice;
	}

	public void setImportPrice(Double importPrice) {
		this.importPrice = importPrice;
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

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
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

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", productionYear="
				+ productionYear + ", importPrice=" + importPrice + ", sellingPrice=" + sellingPrice + ", basisPrice="
				+ basisPrice + ", quantity=" + quantity + ", description=" + description + ", shop=" + shop
				+ ", detailedOrder=" + detailedOrder + ", ShopList=" + ShopList + "]";
	}

	
}
