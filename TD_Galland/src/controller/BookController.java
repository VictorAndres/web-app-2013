package controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ejb.BookService;
import ejb.CategoryService;
import entities.Book;
import entities.Category;
import form.LoginForm;

@Named
@SessionScoped
public class BookController implements Serializable{  
  /* @EJB
   private BookService bookService;
   @EJB
   private CategoryService categoryService;
   @Inject
   private Category category;
 
    public List<Book> getBookList(){
       System.out.println(">>>>Dans book get");
      //doit récupérer le nom du titre de la categorie
       Category category2 = new Category();
      category2 = (Category)categoryService.findWithNamedQuery("Category.findLikeOnTitle").set(0, category.getTitle());
       return (List<Book>)bookService.findWithNamedQuery("Book.findByCategory").set(0, category);
      }
*/
}