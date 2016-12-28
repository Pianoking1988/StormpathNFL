package de.heinemann.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnyUserController {
    
    @RequestMapping("/anyUser")
    public String anyUser(HttpServletRequest request) {
    	return "anyUser";
    }
    
}