package controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ejb.BookService;

@Named
@SessionScoped
public class OrderController  implements Serializable {
	@EJB
	private BookService bookService;
	
	private addBook()
	

}
