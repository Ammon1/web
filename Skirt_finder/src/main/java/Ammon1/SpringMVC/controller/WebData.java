package Ammon1.SpringMVC.controller;

import org.springframework.stereotype.Component;

@Component
public class WebData {

	private String adres;
	private String length;
	private String size;
	private String shop;
	
	public String getShop() {
		return shop;
	}


	public void setShop(String shop) {
		this.shop = shop;
	}


	public String getLength() {
		return length;
	}


	public void setLength(String length) {
		this.length = length;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public WebData(){
		System.out.println("Initialization");
		
	};
	
	
	public String getAdres() {

		return adres;
	}
	public void setAdres(String adres) {
	
		this.adres = adres;
	}


	//@Override
	//public String toString() {
	//	return "WebData [adres=" + adres + ", length=" + length + ", size=" + size + ", shop=" + shop + "]";
	//}


	

}

