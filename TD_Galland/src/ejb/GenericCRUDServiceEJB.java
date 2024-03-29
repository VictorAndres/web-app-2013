package ejb;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GenericCRUDServiceEJB<T> implements GenericCRUDService<T>{
  @PersistenceContext(unitName="bookstore")
  EntityManager em;
  private Class<T> entityClass;
  
  public GenericCRUDServiceEJB() {
    Class clazz = getClass().getSuperclass();
    Type genericType = this.getClass().getGenericSuperclass();  // par exemple ClientServiceEJB
    Type[] params = ((ParameterizedType)genericType).getActualTypeArguments();
    entityClass = (Class)params[0]; //par exemple Client
  }

  public void create(T t) {
    em.persist(t);
  }

  public T find(Object id) {
    return (T) em.find(entityClass, id);
  }

  public T update(T t) {
    return (T)em.merge(t);
   }

  public void delete( Object id) {
    Object ref = em.getReference(entityClass, id);
    em.remove(ref);
 }
  
  public List findAll(){
    return  em.createQuery("select t from " + entityClass.getName() + "t").getResultList();
  }

  public List findWithNamedQuery(String namedQueryName) {
    return this.em.createNamedQuery(namedQueryName).getResultList();
  }

  public List findWithNamedQuery(String namedQueryName, Map<String,Object> parameters) {
    Query query = em.createNamedQuery(namedQueryName);
    for(Entry<String, Object> entry : parameters.entrySet())
      query.setParameter(entry.getKey(), entry.getValue());
     return query.getResultList(); 
  }
}