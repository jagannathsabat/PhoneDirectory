package pack.tulu.phone.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.tulu.phone.dao.UserDAO;
import pack.tulu.phone.model.User;

@Repository
public class UserDaoImpl implements UserDAO<User> {
	
	private final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	@Override
	public User save(User entity) {
		LOG.debug("Control Flow : UserDaoImpl.save() Hit ");
		
		Object generatedId=getCurrentSession().save(entity);
		entity.setUserId((Integer)generatedId);
		return entity;
	}

	@Transactional
	@Override
	public User get(User entity) {
		LOG.debug("Control Flow : UserDaoImpl.get() Hit "+entity);
		
		Criteria criteria = getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("mobileNumber", entity.getMobileNumber())).add(Restrictions.eq("userPassword", entity.getUserPassword()));
		User userFound = (User) criteria.uniqueResult();
		LOG.debug("Control Flow : UserDaoImpl.get() USER FOUND "+userFound);
		return userFound;
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

	@Override
	public User get(Integer userId) {
		return (User) getCurrentSession().get(User.class, userId);
	}

	@Override
	public User getByUserName(String username) {
		String hqlQuery = "select distinct from User where userName = ?";
		Query query = getCurrentSession().createQuery(hqlQuery);
		query.setString(1, username);
		return (User) query.uniqueResult();
	}

}
