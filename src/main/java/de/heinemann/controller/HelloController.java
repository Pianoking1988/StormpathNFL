package de.heinemann.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.servlet.account.AccountResolver;
import com.stormpath.sdk.servlet.application.ApplicationResolver;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String hello(HttpServletRequest request, Model model) {
        Application application = ApplicationResolver.INSTANCE.getApplication(request);
        
        return "home";
    }
    
    @RequestMapping("/restricted")
    public String restricted(HttpServletRequest request) {
    	Account account = AccountResolver.INSTANCE.getAccount(request);
        if (account == null) {
        	return "redirect:/login";
        }
        
        return "restricted";
    }
    
}