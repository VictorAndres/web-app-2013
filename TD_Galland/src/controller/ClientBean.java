package controller;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ejb.ClientService;
import entities.Client;

@Named
@SessionScoped
public class ClientBean extends EntityBean implements Serializable{
	  
	@EJB
	ClientService clientService;
	
	public Client getClient(){
		System.out.println("Dans le getClient du clientBean");
		return (Client)this.getEntity();
	}

	@PostConstruct
	public void init(){
		System.out.println("Dans le init du clientBean");
		this.setService(clientService);
		this.setClazz(Client.class);
		
		
	}

}
