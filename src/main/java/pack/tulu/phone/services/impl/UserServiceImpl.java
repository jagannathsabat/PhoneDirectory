package pack.tulu.phone.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pack.tulu.phone.dao.UserDAO;
import pack.tulu.phone.model.User;
import pack.tulu.phone.services.UserService;

@Service
public class UserServiceImpl implements UserService<User> {
	
	private Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDAO<User> userDAO;

	@Transactional
	@Override
	public User save(User entity) {
		
		LOG.debug("Control Flow : UserServiceImpl.save() Hit ");
		
		return userDAO.save(entity);
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User delete(User entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public User get(Integer userId) {
		return userDAO.get(userId);
	}

	@Override
	public User getByUserName(String username) {
		return userDAO.getByUserName(username);
	}

}
