package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	@Id
	private int id;
	private String name;
	private String image;
	private Double price;
	private int amount;
	private String title;
	private String description;
	@ManyToOne
	@JoinColumn(name = "cateId")
	private Category category;
	@ManyToOne
	@JoinColumn(name = "accId")
	private Account account;

	public Product() {
	}

	public Product(int id, String name, String image, Double price, int amount, String title, String description) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.amount = amount;
		this.title = title;
		this.description = description;
	}

	public Product(int id, String name, String image, Double price, int amount, String title, String description,
			Account account, Category category) {
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
		this.amount = amount;
		this.title = title;
		this.description = description;
		this.account = account;
		this.category = category;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image + ", price=" + price + ", amount=" + amount
				+ ", title=" + title + ", description=" + description + ", category=" + category + ", account="
				+ account + "]";
	}

}
