package pack.tulu.phone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import pack.tulu.phone.model.User;
import pack.tulu.phone.services.UserService;

@SessionAttributes("loggedUser")
@Controller
public class UserController {
	
	private final Logger LOG = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService<User> userService;
	
	
	//REGISTERING USER
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerProcess(@ModelAttribute("loginDTO")User user, Model model, BindingResult bindingResult){
		
		LOG.debug("Control Flow : PhoneController.registerProcess() Hit ");
		LOG.debug("User Registration Details : "+user);
		
		User userData=userService.save(user);
		
		
		model.addAttribute("userData", userData);
		return "redirect:/login";
	}
	
	//RETRIEVING LOGIN DETAILS
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginProcess(@ModelAttribute("loginDTO")User user, Model model){
		
		LOG.debug("Control Flow : PhoneController.successPage() Hit ");
		LOG.debug("User is : ",user);
//		model.addAttribute("userDetails",user);
		
		User userFound = userService.get(user);
		LOG.debug("UserFound is : ",userFound);
		System.out.println(userFound);
		
		/*model.addAttribute("userDetails",userFound);
		
		if(userFound==null){
			return "login";
		}*/
		
		if(userFound!=null){
			//add userDetails in session to check in next handler methods..
			model.addAttribute("loggedUser", userFound);
			model.addAttribute("message", "Hi Jagannath");
			return "redirect:contacts/UserHome";
		}
			
		return "login";
	}
	
	

}
