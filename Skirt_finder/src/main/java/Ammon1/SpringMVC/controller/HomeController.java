package Ammon1.SpringMVC.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import Ammon1.SpringMVC.Dao.SkirtsDAO;
import Ammon1.SpringMVC.Entity.Skirts;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {
	
	@Autowired
	WebData theWeb; 
	@Autowired
	HiMModel theHiMModel; 
	@Autowired
	MariezelieModel theMariezelieModel;

	//@RequestMapping(value="/")
	//public ModelAndView test(HttpServletResponse response) throws IOException{
	//	return new ModelAndView("home");
	//}
	@RequestMapping(value="/",method=RequestMethod.GET )
	public String showForm(Model theModel) {
		
		// add student object to the model
		theModel.addAttribute("web", theWeb);
		initModelListSize(theModel);
		initModelListLength(theModel);
		initModelListShop(theModel);
		
		return "home";
	}
	@RequestMapping(value="/processForm")
	public ModelAndView processForm(@ModelAttribute("web") WebData theWeb) throws IOException {
		ArrayList<String> skirtList = new ArrayList<String>();
		
	//	System.out.println(theWeb.getShop());
		if(theWeb.getShop().equals("H i M")){
			skirtList = theHiMModel.Content(theWeb.getSize(),theWeb.getLength());
			}
		if(theWeb.getShop().equals("mariezelie")){
			skirtList = theMariezelieModel.Content(theWeb.getSize(),theWeb.getLength());
			}
		
		LinkedList<String> prices = new LinkedList<String>();
		LinkedList<String> links = new LinkedList<String>();
		int iend;
		for (String skirt : skirtList) {
			iend = skirt.indexOf("`");
		//	System.out.println(iend);
			links.add("<img width='222' height='333' src='"+ skirt.substring(0, iend)+"'/>");
			prices.add(skirt.substring(iend+1, skirt.length()));
	
		}
		
		ModelAndView map = new ModelAndView("confirmation");
		map.addObject("links",links);
		map.addObject("prices",prices);
		map.addObject("data",theWeb);
		
		return map;
	}
	@Autowired
	private SkirtsDAO SkirtsDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		// get customers from the dao
		List<Skirts> theSkirts = SkirtsDAO.getSkirts();
				
		// add the customers to the model
		theModel.addAttribute("skirts", theSkirts);
		
		return "list-customers";
	}
	
	 private void initModelListSize(Model theModel) {
		         List<String> theSize = new ArrayList<String>();
		         theSize.add("xs");		 
		         theSize.add("s"); 
		         theSize.add("m"); 
		         theSize.add("l");
		         theSize.add("xl");
		         theModel.addAttribute("size", theSize);
		     }
	 
	 private void initModelListLength(Model theModel) {
         List<String> theLength = new ArrayList<String>();
         theLength.add("mini");		 
         theLength.add("midi"); 
         theLength.add("maxi"); 
         theModel.addAttribute("length", theLength);
     }
	 private void initModelListShop(Model theModel) {
         List<String> theShop = new ArrayList<String>();
         theShop.add("H i M");		 
         theShop.add("mariezelie"); 
         theModel.addAttribute("shop", theShop);
     }
}
