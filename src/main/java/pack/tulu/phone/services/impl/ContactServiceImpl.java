package pack.tulu.phone.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pack.tulu.phone.dao.ContactDAO;
import pack.tulu.phone.model.Contact;
import pack.tulu.phone.services.ContactServices;

@Service
public class ContactServiceImpl implements ContactServices<Contact> {
	
	private Logger LOG = LoggerFactory.getLogger(ContactServiceImpl.class);
	
	@Autowired
	private ContactDAO<Contact> contactDAO;

	@Transactional
	@Override
	public Contact save(Contact entity) {
		
		LOG.debug("Control Flow : ContactServiceImpl.save() Hit ");
		return contactDAO.save(entity);
	}

	@Override
	public Contact get(Contact entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Contact> list() {
		LOG.debug("Control Flow : ContactServiceImpl.list() Hit ");
		return contactDAO.list();
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
