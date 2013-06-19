package ejb;

import java.util.List;

import entities.Client;
import entities.Order;

public interface ClientService extends GenericCRUDService<Client>{
  public Client login(String login, String password);
  public List<Order> getCommandes(Client client);
  
}