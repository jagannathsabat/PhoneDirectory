package pack.tulu.phone.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pack.tulu.phone.dao.ContactDAO;
import pack.tulu.phone.model.Contact;

@Repository
public class ContactDaoImpl implements ContactDAO<Contact> {
	
	private final Logger LOG = LoggerFactory.getLogger(ContactDaoImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session getCurrentSession(){
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	@Override
	public Contact save(Contact entity) {
		
		LOG.debug("Control Flow : ContactDaoImpl.save() Hit ");
		
		Object generatedId = getCurrentSession().save(entity);
		entity.setContactId((Integer)generatedId);
		return entity;
	}

	@Override
	public Contact get(Contact entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Contact> list() {
		
		LOG.debug("Control Flow : ContactDaoImpl.list() Hit ");
		String hqlStr = "from pack.tulu.phone.model.Contact";
		Query query =  getCurrentSession().createQuery(hqlStr);
		return query.list();
	}

	@Override
	public Contact update(Contact entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact delete(Contact entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
