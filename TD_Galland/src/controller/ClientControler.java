package controller;

import injects.LoggedIn;
import entities.Order;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;

import bean.MessageBean;
import ejb.CategoryService;
import ejb.ClientService;
import entities.Category;
import entities.Client;
import form.LoginForm;

@Named
@SessionScoped
public class ClientControler implements Serializable {
     @Inject
      private LoginForm loginForm;
     
     @EJB
     private ClientService clientService;
 	
     //private ClientManager clientManager ;
      @Inject
      private Logger log;
      @Inject
      private  MessageBean messageBean;
     
      private Client currentClient;
      @Produces @LoggedIn @Named
      public Client getCurrentClient() {
        return currentClient;
      }

    
      public String doLogin() {
          currentClient = clientService.login(loginForm.getLogin(), loginForm.getPassword());
          if (currentClient == null) {
        	  messageBean.addMessage("clientNotFound");
        	  
            return null;
          }
          return "welcome";
        }
      
      public boolean isLoggedIn(){
        return currentClient != null;
      }
      
      public String doLogout() {
        currentClient = null;
        return "welcome";
      }
     
      public boolean isLoggedOut(){
    	  return (isLoggedIn()==false);
      }
      
      public List getClientList(){
          System.out.println(">>>>Dans client get");
         
          return clientService.findWithNamedQuery("Client.findAll");
        }

      public List<Order> getCommandes(){
          System.out.println(">>>>Dans client get");
         
          return clientService.getCommandes(currentClient);
        }
     
    }