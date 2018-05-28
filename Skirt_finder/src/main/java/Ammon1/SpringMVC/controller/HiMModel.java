package Ammon1.SpringMVC.controller;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


@Component
public class HiMModel {
	
	public  ArrayList<String> Content(String size, String length) throws IOException{
		String adres = "http://www2.hm.com/pl_pl/ona/produkty/spodnice.html?";
		
		//case for Length
		if(length.equals("mini")){
			adres+="product-type=ladies_skirts_shortskirts&";System.out.println("Length schoosen " + length);
		}
		if(length.equals("mini")){
			adres+="product-type=ladies_skirts_midiskirts&";System.out.println("Length schoosen " + length);
		}
		if(length.equals("mini")){
			adres+="product-type=ladies_skirts_longskirts&";System.out.println("Length schoosen " + length);
		}
		
		
		//case for size
		if(size.equals("xs")){
			adres+="size=5_xs";System.out.println("size schoosen " + size);
		}
		if(size.equals("s")){
			adres+="size=9_s";System.out.println("size schoosen " + size);
		}
		if(size.equals("m")){
			adres+="size=13_m";System.out.println("size schoosen " + size);
		}
		if(size.equals("l")){
			adres+="size=17_l";System.out.println("size schoosen " + size);
		}
		if(size.equals("xl")){
			adres+="size=21_xl";System.out.println("size schoosen " + size);
		}
		
		
		adres+="&sort=stock&offset=0&page-size=240";
	//	System.out.println(adres);
		
		Document document = Jsoup.connect(adres).get();
		Elements pictures = document.getElementsByClass("product-item-image");
		Elements prices = document.select("div.ng-hide");
		
		
		//list of skirts
		 ArrayList<String> skirtList = new ArrayList<String>(0);
		
		int countter=0;
        for (Element picture : pictures) {
                countter++;
            	skirtList.add(picture.attr("src"));
      //      	System.out.println(countter + " Photo: " + title.attr("src"));
            
        }
        countter=0;
        //list of prices
        ArrayList<String> priceList = new ArrayList<String>(0);
        for(Element price:prices)
        	{
        	
        	countter++;
        	priceList.add(price.text());
   //     	System.out.println(countter + " Price: " + price.text());
        	
        	
        	}
        
 //       System.out.println("\n\nWielkosc list: spodnice "+skirtList.size() + " ceny " + priceList.size());
        
      ArrayList<String> sumList = new ArrayList<String>(0);
        for(int i=0;i<skirtList.size();i++)
        {
        	sumList.add(skirtList.get(i)+"`"+priceList.get(i));
        }
        
		return sumList;
		
	}

}
