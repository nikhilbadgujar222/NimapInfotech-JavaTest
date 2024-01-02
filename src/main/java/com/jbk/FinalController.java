package com.jbk;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FinalController {
 
	
	@Autowired
	SessionFactory factory;

 // 1) API to open frontend page for insert the data...related to product and category table...
	
		@RequestMapping("start")
		public ModelAndView start () {
			ModelAndView ms= new ModelAndView();
			ms.setViewName("product");
			return ms;
		}
 //2) API to save data in the database tables.....	
	@RequestMapping("click")
	public String start (@ModelAttribute Product pb,@ModelAttribute Category cb) {
		System.out.println("Browser Json Data category:"+pb);
		System.out.println("Browser Json Data category:"+cb);
		
	//	==================================Final Code to store data i the database..
		
		

		pb.setCategory(cb);
		
		List<Product> productList =new ArrayList();
	
	    productList.add(pb);

		
     	cb.setProducts(productList);
		Session session =factory.openSession();
		Transaction tt =session.beginTransaction();
		
		session.save(cb);
		
		tt.commit();
		
		
		return "okno problem";
	}
	

	

 //3)  API FOR showing Product Data IN TABULAR FORMAT......	
	@RequestMapping("getProducts")
	public ModelAndView getAllProducts(){
		
		ModelAndView tableview = new ModelAndView();
		
	
		tableview.setViewName("table");
		
		
		Session session =factory.openSession();
		Query query = session.createQuery("from Product");
		List<Product> totalli =query.list();
		tableview.addObject("productlist",totalli);
		
		
		return tableview;
	}
	
  //4)  API FOR showing Category Data IN TABULAR FORMAT......	
//	@RequestMapping("getCategory")
//	public ModelAndView getAllCategory(){
//		
//		ModelAndView tableview = new ModelAndView();
//		
//	
//		tableview.setViewName("categorytable");
//		
//		
//		Session session =factory.openSession();
//		Query query = session.createQuery("from Category");
//		List<Category> totalli =query.list();
//		tableview.addObject("categoryList",totalli);
//		
//		
//		return tableview;
//	}
	
	//5)  API for Updating Data of Product Table By using Product Id
	@RequestMapping("update/{id}")
	public String updateData(@PathVariable int id,@RequestBody Product pb) {
		
		Session session =factory.openSession();
		Query query = session.createQuery("select productId from Product");
		List<Integer> ids =query.list();
		
		
		if ( ids.contains(id) ){
			
			
			Transaction tt =session.beginTransaction();
			//pb.setCategory(cb);
			session.saveOrUpdate(pb);
			tt.commit();
	       
	}
		return "Data get Updated Succesfully...";
	}
	
	//6)  API for Getting products from Product Table by using productid
	
	@RequestMapping("getData/{id}")
	public List<Product> getDataById(@PathVariable int id) {
	    List<Product> productList = new ArrayList<>();

	    try {
	        Session session = factory.openSession();
	        Transaction transaction = session.beginTransaction();

	        Product product = session.get(Product.class, id);

	        transaction.commit();
	        session.close();

	        if (product != null) {
	            productList.add(product);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        
	    }

	    return productList;
	}

	
	// 7) Deleting the record from the product table by refering the product id.....
	@RequestMapping("deleteData/{id}")
	public String deleteDataById (@PathVariable int id) {
		
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Product product = session.get(Product.class, id);
        session.delete(product);
        
        transaction.commit();
        session.close();
		return "Data get deleted sucessfully";
	}

	


}

