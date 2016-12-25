package de.heinemann.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stormpath.sdk.servlet.account.AccountResolver;

import de.heinemann.domain.Matches;
import de.heinemann.domain.Team;
import de.heinemann.service.HelloService;
import de.heinemann.service.MatchService;
import de.heinemann.service.TeamService;

@Controller
public class HomeController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private MatchService matchService;
		
    @RequestMapping("/")
    public String home(HttpServletRequest request, Model model) {
    	List<Team> teams = teamService.findAll();
        model.addAttribute("teams", teams);
    	logger.info("Found {} teams", teams.size());
    	
    	Matches matches = matchService.findAll();
    	model.addAttribute("matches", matches);
    	logger.info("Found {} matches", matches.getMatches().size());
    	
        return "home";
    }

    @Autowired
    public HelloService helloService;
    
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