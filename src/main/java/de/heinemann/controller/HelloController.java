package de.heinemann.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stormpath.sdk.application.Application;
import com.stormpath.sdk.servlet.application.ApplicationResolver;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String hello(HttpServletRequest req) {
        Application app = ApplicationResolver.INSTANCE.getApplication(req);
        
        return "Hello, " + app.getName();
    }
    
}