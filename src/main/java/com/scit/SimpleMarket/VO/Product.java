package com.scit.SimpleMarket.VO;

public class Product {
	private int productSeq;
	private String name;
	private int quantity;
	private int price;
	private String comments;
	private String indate;
	
	private String soldSeq;
	private String customerId;
	
	public Product() {
		
	}

	public Product(int productSeq, String name, int quantity, int price, String comments, String indate) {
		this.productSeq = productSeq;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.comments = comments;
		this.indate = indate;
	}

	public int getProductSeq() {
		return productSeq;
	}

	public void setProductSeq(int productSeq) {
		this.productSeq = productSeq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getIndate() {
		return indate;
	}

	public void setIndate(String indate) {
		this.indate = indate;
	}
	
	
	public String getSoldSeq() {
		return soldSeq;
	}

	public void setSoldSeq(String soldSeq) {
		this.soldSeq = soldSeq;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Product [productSeq=" + productSeq + ", name=" + name + ", quantity=" + quantity + ", price=" + price
				+ ", comments=" + comments + ", indate=" + indate + "]";
	}
	
	
	
}
