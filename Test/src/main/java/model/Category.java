package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {
	@Id
	private int cid;
	private String cname;
	@OneToMany(mappedBy = "category")
	List<Product> product;

	public Category() {
	}

	public Category(int cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}

	public Category(int cid, String cname, List<Product> product) {
		this.cid = cid;
		this.cname = cname;
		this.product = product;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}

}
