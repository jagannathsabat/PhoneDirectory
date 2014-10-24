package pack.tulu.phone.services;

import java.util.List;

import pack.tulu.phone.model.User;

public interface UserService<E> {
	
	E save(E entity);
	
	E getByUserName(String username);
	
	List<E> list();
	
	E update(E entity);
	
	E delete(E entity);

	User get(Integer userId);
	

}
