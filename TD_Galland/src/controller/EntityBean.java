package controller;

import ejb.GenericCRUDService;

public abstract class EntityBean {
	private GenericCRUDService service;
	private Long entityId;
	private Class clazz;
	private Object entity;
	
	public GenericCRUDService getService() {
		return service;
	}
	
	public void setService(GenericCRUDService service) {
		this.service = service;
	}
	
	public Class getClazz() {
		return clazz;
	}
	
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	
	public Long getEntityId() {
		return entityId;
	}
	
	public void setEntityId(Long entityId) {
		this.entityId = entityId;
		entity = service.find(entityId);
	}
	
	public Object getEntity() {
		return entity;
	}
	
	public void setEntity(Object entity) {
		this.entity = entity;
	}
	

}
