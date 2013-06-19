package ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;

import entities.Book;
import entities.Client;
@Stateless
@Local(BookService.class)
public class BookServiceEJB extends GenericCRUDServiceEJB<Book> implements BookService{
	/*public List<Book> getBooksByCategory(String category) {
	    List<Book> books = new ArrayList();
	    try {
	      books = (Book) em.createQuery("select c from Client c where c.login=:login and c.password=:password")
	          .setParameter("login", login).setParameter("password", password).getSingleResult();
	    } catch (NoResultException e) {
	    }
	    return client;
	  }*/
}
