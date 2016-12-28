package de.heinemann.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stormpath.sdk.account.Account;
import com.stormpath.sdk.servlet.account.AccountResolver;

@Controller
public class RestrictedController {

    @RequestMapping("/restricted")
    @PreAuthorize("hasPermission('reload', 'nfl')")
    public String restricted(HttpServletRequest request, Model model) {
    	Account account = AccountResolver.INSTANCE.getAccount(request); 
        String msg = "Hello, " + account.getGivenName()
        		+ ". You have the required permissions to access this restricted resource.";
        model.addAttribute("msg", msg);
        return "restricted";
    }    
        
}