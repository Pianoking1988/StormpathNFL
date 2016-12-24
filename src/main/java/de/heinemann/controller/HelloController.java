package de.heinemann.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stormpath.sdk.servlet.account.AccountResolver;

import de.heinemann.service.HelloService;

@Controller
public class HelloController {

	@Autowired
	public HelloService helloService;
	
    @RequestMapping("/")
    public String home(HttpServletRequest req, Model model) {
        model.addAttribute("status", req.getParameter("status"));
        return "home";
    }

    @RequestMapping("/restricted")
    @PreAuthorize("hasPermission('reload', 'nfl')")
    public String restricted(HttpServletRequest req, Model model) {
        String msg = helloService.sayHello(
            AccountResolver.INSTANCE.getAccount(req)
        );
        model.addAttribute("msg", msg);
        return "restricted";
    }    
    
    @RequestMapping("/anyUser")
    public String anyUser(HttpServletRequest request) {
    	return "anyUser";
    }
    
}