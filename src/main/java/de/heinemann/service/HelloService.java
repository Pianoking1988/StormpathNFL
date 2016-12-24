package de.heinemann.service;

import org.springframework.stereotype.Service;

import com.stormpath.sdk.account.Account;

@Service
public class HelloService {
    
    public String sayHello(Account account) {
        return "Hello, " + account.getGivenName() +
            ". You have the required permissions to access this restricted resource.";
    }
    
}