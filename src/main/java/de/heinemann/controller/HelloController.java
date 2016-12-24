package de.heinemann.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.servlet.account.AccountResolver;
import com.stormpath.sdk.servlet.application.ApplicationResolver;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello(HttpServletRequest request) {
        Application application = ApplicationResolver.INSTANCE.getApplication(request);
        
        return "Hello, " + application.getName();
    }
    
    @RequestMapping("/restricted")
    public String restricted(HttpServletRequest request) {
    	Account account = AccountResolver.INSTANCE.getAccount(request);
        if (account == null) {
        	return "Access is not granted";
        } else {
        	return "Hello, your name is " + account.getFullName();
        }
    }
    
}