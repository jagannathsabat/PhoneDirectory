package pack.tulu.phone.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pack.tulu.phone.model.Contact;
import pack.tulu.phone.model.User;
import pack.tulu.phone.services.ContactServices;

@Controller
//@SessionAttributes("loggedUser")
public class ContactController {
	
	private final Logger LOG = LoggerFactory.getLogger(ContactController.class);
	
	@Autowired
	private ContactServices<Contact> contactService;
	
	//SHOW CONTACT UserHome Get handler
	@RequestMapping(value="/contacts/UserHome",method=RequestMethod.GET)
	public String showContactUserHome(@ModelAttribute("loggedUser")User user, Model model, RedirectAttributes rAttributes){
				
		LOG.debug("Control Flow : ContactController.showContactUserHome() Hit ");
		if(user==null){
			rAttributes.addFlashAttribute("err_msg", "please login to access..");
			return "redirect:/login";
		}
		System.out.println("LOGGED IN USER IS : "+user.toString());		
		return "contacts/UserHome";
	}
		
	
	//SHOW CONTACT Get handler
	@RequestMapping(value="/showContactView",method=RequestMethod.GET)
	public String showContactView(@ModelAttribute("loggedUser")User user,Model model, RedirectAttributes redirectAttributes){
			
		LOG.debug("Control Flow : ContactController.showContactView() Hit ");
		//redirectAttributes.addAttribute("loggedUser", user);
		System.out.println("LOGGED IN USER IS : "+user.toString());		
		return "contacts/ShowContacts";
		}
	
	//ADD CONTACT Get handler
	@RequestMapping(value="/addContactView",method=RequestMethod.GET)
	public String addContactView(Model model){
		
		LOG.debug("Control Flow : ContactController.addContactView() Hit ");
		model.addAttribute("contactDTO", new Contact());
		return "contacts/AddContact";
	}
	
	/*//ADD CONTACT post handler
	@RequestMapping(value="/addContact",method=RequestMethod.GET)
	public String addContactProcess(Model model){
			
		LOG.debug("Control Flow : ContactController.addContactProcess() Hit ");
		return "redirect:/AddContact";
	}*/
	
	//Modify CONTACT
	@RequestMapping(value="/modifyContactView",method=RequestMethod.GET)
	public String modifyContactView(Model model){
			
		LOG.debug("Control Flow : ContactController.modifyContactProcess() Hit ");
		return "contacts/ModifyContact";
	}	
	//Delete CONTACT
	@RequestMapping(value="/deleteContactView",method=RequestMethod.GET)
	public String deleteContactView(Model model){
			
		LOG.debug("Control Flow : ContactController.deleteContactProcess() Hit ");
		return "contacts/DeleteContact";
	}
	
	//ADD CONTACT
	@RequestMapping(value="/addContactView",method=RequestMethod.POST)
	public String addContact(@ModelAttribute("loggedUser")User user, @ModelAttribute("contactDTO")Contact contact,Model model, BindingResult bindingResult){
		
		LOG.debug("Control Flow : PhoneController.addContact() Hit ");
		LOG.debug("User Registration Details : "+contact);
		
		//set user before saving contact so that user field will not be null in contact table
		contact.setUser(user);
		
		Contact savedContact = contactService.save(contact);
		System.out.println(contact.toString()); 
		
		model.addAttribute("savedContact", savedContact);
		return "contacts/UserHome";
	}
	
	//Retrieving Contact List
	@ModelAttribute("listOfContacts")
	public List<Contact> listContacts(){
		LOG.debug("Control Flow : ContactController.listContacts() Hit ");
		List<Contact> contactList = contactService.list();
		System.out.println(contactList);
		return contactList;
	}
	
	

}