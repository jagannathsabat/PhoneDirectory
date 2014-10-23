package pack.tulu.phone.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pack.tulu.phone.model.User;

@Controller
@RequestMapping("/")
public class PhoneController {
	
	private final Logger LOG = LoggerFactory.getLogger(PhoneController.class);
	
	@RequestMapping(method=RequestMethod.GET)
	public String phoneHome(Model model){		
		
		LOG.debug("Control Flow : PhoneController.phoneHome() Hit ");
		
		if(model.containsAttribute("loggedUser")){
			User loggedUser = (User) model.asMap().get("loggedUser");
			LOG.debug("user {} is logged..", loggedUser.getUserName());
			return "redirect:/contacts/UserHome";
		}
		
		return "HomePage";
		//return "redirect:static/HomePage.html";
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerPage(Model model){
		
		LOG.debug("Control Flow : PhoneController.registerPage() Hit ");
		model.addAttribute("loginDTO", new User());
		
		return "register";
	}
	
	/*@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registerProcess(@ModelAttribute("loginDTO")User user, Model model, BindingResult bindingResult){
		
		LOG.debug("Control Flow : PhoneController.registerProcess() Hit ");
		LOG.debug("User Registration Details : "+user);
		model.addAttribute("userData", user);
		return "login";
	}*/
	
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage(Model model, RedirectAttributes rAttributes){
		
		LOG.debug("Control Flow : PhoneController.loginPage() Hit ");
		model.addAttribute("loginDTO",new User());
		model.addAttribute("err_msg", rAttributes.getFlashAttributes().get("err_msg"));
		return "login";
	}
	
	
	/*@RequestMapping(value="/login",method=RequestMethod.POST)
	public String successPage(@ModelAttribute("loginDTO")User user, Model model){
		
		LOG.debug("Control Flow : PhoneController.successPage() Hit ");
		LOG.debug("User is : ",user);
		model.addAttribute("userDetails",user);
		
		return "success";
	}*/
	
	
	

}
