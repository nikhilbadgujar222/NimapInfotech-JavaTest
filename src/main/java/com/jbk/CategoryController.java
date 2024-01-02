package com.jbk;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CategoryController {

	
	@Autowired
	SessionFactory factory;
	
	
// 1) API for getting category data in tabular format....	
	@RequestMapping("getCategory")
	public ModelAndView getAllCategory(){
		
		ModelAndView tableview = new ModelAndView();
		
	
		tableview.setViewName("categorytable");
		
		
		Session session =factory.openSession();
		Query query = session.createQuery("from Category");
		List<Category> totalli =query.list();
		tableview.addObject("categoryList",totalli);
		
		
		return tableview;
	}
	
// 2)  API for adding new category to the category table.....
	
	@RequestMapping("addCategory")
	public String createNewCategory(@RequestBody Category ct) {
		
		Session session =factory.openSession();
		Transaction tt =session.beginTransaction();
		session.saveOrUpdate(ct);
		
		tt.commit();
		return "category added sucessfully";
	}
	
	// 8th api.. for Retriving the category by refering the id.....
	@RequestMapping("getCategoryData/{ids}")
	public List<Category> getDataByCategoryId(@PathVariable int ids) {
	    List<Category> categoryList = new ArrayList<>();    
	        Session session = factory.openSession();
	       

	        Category category = session.get(Category.class, ids);
	        categoryList.add(category);
	        System.out.println(categoryList);


	    return categoryList;
	}
	
	
	//9th API for updating the Category by using categoryid..
	
	@RequestMapping("updateCat/{cid}")
	public String updateData(@PathVariable int cid,@RequestBody Category cb) {
		
		Session session =factory.openSession();
		Query query = session.createQuery("select categoryId from Category");
		List<Integer> ids =query.list();
		
		
		if ( ids.contains(cid) ){
			
			
			Transaction tt =session.beginTransaction();
			//pb.setCategory(cb);
			session.saveOrUpdate(cb);
			tt.commit();
	       
	}
		return "Category Data get Updated Succesfully...";
	}

	
	 //10th API for deleting the category by refering categoryid
	
	
	@RequestMapping("deleteCategoryData/{id}")
	public String deleteDataById (@PathVariable int id) {
		
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Category category = session.get(Category.class, id);
        session.delete(category);
        
        transaction.commit();
        session.close();
		return "Category Data get deleted sucessfully";
	}
}
