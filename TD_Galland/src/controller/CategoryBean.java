package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ejb.CategoryService;
import entities.Category;

@Named
@SessionScoped
public class CategoryBean extends EntityBean implements Serializable{
	  
	@EJB
	CategoryService categoryService;
	
	public Category getCategory(){
		return (Category)this.getEntity();
	}

	@PostConstruct
	public void init(){
		this.setService(categoryService);
		this.setClazz(Category.class);
		
		
	}

}
