package com.kh.chap01_inherit.before.model.vo;

public class Desktop {
	private String brand; // 브랜드
	private String pCode; // 상품 번호
	private String pName; // 상품명
	private int price; // 가격
	
	private boolean allInOne; // 일체 여부
	
	public Desktop(){}
	public Desktop(String brand, String pCode, String pName, int price, boolean allIn) {
		super();
		this.brand = brand;
		this.pCode = pCode;
		this.pName = pName;
		this.price = price;
		this.allInOne = allIn;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isAllInOne() {
		return allInOne;
	}
	public void setAllInOne(boolean allInOne) {
		this.allInOne = allInOne;
	}
	
	public String information(){
		return "brand : " + brand + ", pCode : " + pCode +
				", pName : " + pName + ", price : " + price + 
				", allInOne : " + allInOne;
	}
	
}
