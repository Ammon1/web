package Ammon1.SpringMVC.controller;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


@Component
public class MariezelieModel {
	
	public  ArrayList<String> Content(String size, String length) throws IOException{
		String adres = "https://mariezelie.com/kategoria/spodnice-2";
		
		
		//case for size
		if(size.equals("xs")){
			adres+="?properties[Rozmiar]=34";System.out.println("size schoosen " + size);
		}
		if(size.equals("s")){
			adres+="?properties[Rozmiar]=36";System.out.println("size schoosen " + size);
		}
		if(size.equals("m")){
			adres+="?properties[Rozmiar]=38";System.out.println("size schoosen " + size);
		}
		if(size.equals("l")){
			adres+="?properties[Rozmiar]=40";System.out.println("size schoosen " + size);
		}
		if(size.equals("xl")){
			adres+="?properties[Rozmiar]=42";System.out.println("size schoosen " + size);
		}
		
		System.out.println(adres);
		
		Document document = Jsoup.connect(adres).get();
		Elements pictures = document.select("img[src^=https://cdn.shoplo.com/1560/products/]");
		Elements prices = document.getElementsByClass("product-price");
		
		
		//list of skirts
		 ArrayList<String> skirtList = new ArrayList<String>(0);
		
		int countter=0;
        for (Element picture : pictures) {
                countter++;
            	skirtList.add(picture.attr("src"));
      //     	System.out.println(countter + " Photo: " + picture.attr("src"));
            
        }
        countter=0;
        //list of prices
        ArrayList<String> priceList = new ArrayList<String>(0);
        for(Element price:prices)
        	{
        	
        	countter++;
        	priceList.add(price.text().replaceAll("z³", "PLN "));
      //  	System.out.println(countter + " Price: " + price.text());
        	
        	
        	}
        
       // System.out.println("\n\nWielkosc list: spodnice "+skirtList.size() + " ceny " + priceList.size());
        
      ArrayList<String> sumList = new ArrayList<String>(0);
        for(int i=0;i<skirtList.size();i++)
        {
        	sumList.add(skirtList.get(i)+"`"+priceList.get(i));
        }
        
		return sumList;
		
	}

}
