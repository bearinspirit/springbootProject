package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {

	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public String chat() {
		return "/chat/chat";
	}
	
	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public String adminLogin() {
		return "/adminLogin/adminLogin";
	}
	
    @GetMapping("/")
    public String home1() {
        return "/home/home";
    }

    @GetMapping("/home")
    public String home() {
        return "/home/home";
    }
    
    @GetMapping("/login")
    public String login() {
    	return "/login/login";
    }
    
    @GetMapping("/admin")
    public String admin() {
        return "/adminLogin/admin";
    }

    @GetMapping("/inbox")
    public String inbox() {
        return "/adminMail/inbox";
    }
    
    @GetMapping("/sentMail")
    public String sentMail() {
        return "/adminMail/sentMail";
    }

    @GetMapping("/403")
    public String error403() {
        return "/error/403";
    }


}
