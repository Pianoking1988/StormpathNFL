package de.heinemann.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.heinemann.domain.Matches;
import de.heinemann.domain.Teams;
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
    	Teams teams = teamService.findAll();
        model.addAttribute("teams", teams);
    	logger.info("Found {} teams", teams.getTeams().size());
    	
    	Matches matches = matchService.findAll();
    	model.addAttribute("matches", matches);
    	logger.info("Found {} matches", matches.getMatches().size());
    	
        return "home";
    }
    
}