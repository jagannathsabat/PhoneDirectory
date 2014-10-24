package pack.tulu.phone.dao;

import java.util.List;

import pack.tulu.phone.model.User;


public interface UserDAO<E> {
	
	E save(E entity);
	
	E get(E entity);
	List<E> list();
	
	E update(E entity);
	
	E delete(E entity);

	User get(Integer userId);

	User getByUserName(String username);
	

}
