package Ammon1.SpringMVC.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;  
  
@Entity  
@Table(name= "skirts")  
public class Skirts {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;  
	@Column(name = "price")
	private int price;
	@Column(name = "picture")
	private String picture;
	
	public int getId() {  
	    return id;  
	}  
	public void setId(int id) {  
	    this.id = id;  
	}  
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public Skirts(){
		System.out.println("Skirts started");
	};
	
	public Skirts(int price, String picture) {
		super();
		System.out.println("skirt initialize");
		this.price = price;
		this.picture = picture;
	}
	@Override
	public String toString() {
		return "Skirts [id=" + id + ", price=" + price + ", figure=" + picture + "]";
	}

	
}
