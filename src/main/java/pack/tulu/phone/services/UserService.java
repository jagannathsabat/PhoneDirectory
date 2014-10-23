package pack.tulu.phone.services;

import java.util.List;

public interface UserService<E> {
	
	E save(E entity);
	
	E get(E entity);
	List<E> list();
	
	E update(E entity);
	
	E delete(E entity);
	

}
