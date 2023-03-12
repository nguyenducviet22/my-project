package model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "shop")
public class Shop {
	@Id
	private String shopCode;
	private String shopName;
	private String address;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "shopProduct", 
	joinColumns = { @JoinColumn(name = "shopFK") }, 
	inverseJoinColumns = {@JoinColumn(name = "productFK")})
	private Set<Product> productList = new HashSet<Product>();

	public Shop() {
	}

	public Shop(String shopCode, String shopName, String address) {
		this.shopCode = shopCode;
		this.shopName = shopName;
		this.address = address;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(shopCode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Shop other = (Shop) obj;
		return Objects.equals(shopCode, other.shopCode);
	}

	@Override
	public String toString() {
		return "Shop [shopCode=" + shopCode + ", shopName=" + shopName + ", address=" + address + ", productList="
				+ productList + "]";
	}

	
}
