/* fait dans le projet create bookstore
 * package main;


import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Author;
import entities.Book;
import entities.Category;
import entities.Client;

public class CreateBookStore {

  public static void main(String[] args) throws Exception {

    Map<String, String> properties = new HashMap<String, String>();
    properties.put("eclipselink.ddl-generation", "drop-and-create-tables");
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("JEE6-JDBC", properties);
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
 
    Date now = new Date();

    Category category1 = new Category();
    category1.setTitle("Informatique");
    em.persist(category1);

    Category category2 = new Category();
    category2.setTitle("Littérature");
    em.persist(category2);

    Author author1 = new Author();
    author1.setFirstName("Michel");
    author1.setLastName("Martin");
    em.persist(author1);

    Author author2 = new Author();
    author2.setFirstName("Christian");
    author2.setLastName("Bauer");
    em.persist(author2);

    Author author3 = new Author();
    author3.setFirstName("J-K");
    author3.setLastName("Rowling");
    em.persist(author3);

    
    Book book = new Book();
    book.setTitle("HTML 5 et CSS 3");
    book.setCategory(category1);
    book.setPrice(new java.math.BigDecimal("10.50"));
    book.setDate(now);
    book.addAuthor(author1);
    File f = new File("WebContent/resources/images/html.jpg");
    byte[] photo = new byte[(int)(f.length())];
    FileInputStream fi = new FileInputStream(f);
    fi.read(photo);
    book.setPhoto(photo);
    em.persist(book);

    book = new Book();
    book.setTitle("Hibernate in action");
    book.setCategory(category1);
    book.setPrice(new java.math.BigDecimal("30.50"));
    book.setDate(now);
    book.addAuthor(author1);
    book.addAuthor(author2);
    f = new File("WebContent/resources/images/hibernate.jpg");
    photo = new byte[(int)(f.length())];
    fi = new FileInputStream(f);
    fi.read(photo);
    book.setPhoto(photo);
    em.persist(book);
     
    book = new Book();
    book.setTitle("Harry Potter");
    book.setCategory(category2);
    book.setPrice(new java.math.BigDecimal("20.50"));
    book.setDate(now);
    book.addAuthor(author3);
    f = new File("WebContent/resources/images/harry.jpg");
    photo = new byte[(int)(f.length())];
    fi = new FileInputStream(f);
    fi.read(photo);
    book.setPhoto(photo);
    em.persist(book);

    Client user = new Client();
    user.setLogin("galland");
    user.setPassword("dauphine");
    em.persist(user);
    em.getTransaction().commit();
    em.getTransaction().begin();
    List l = em.createQuery("select c from Client c").getResultList();
    System.out.println(l);
    em.getTransaction().commit();
    em.close();
 
  }

}
 */