package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;

import javax.inject.Inject;
import javax.inject.Named;

import bean.MessageBean;
import ejb.CategoryService;
import entities.Category;

@Named
@SessionScoped
public class CategoryControler implements Serializable{  
   @EJB
   private CategoryService categoryService;
 
    public List getCategoryList(){
        System.out.println(">>>>Dans category get");
       
        return categoryService.findWithNamedQuery("Category.findAll");
      }

}
