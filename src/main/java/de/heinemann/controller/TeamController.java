package de.heinemann.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import de.heinemann.domain.Matches;
import de.heinemann.domain.Team;
import de.heinemann.service.MatchService;
import de.heinemann.service.TeamService;

@Controller
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private MatchService matchService;
		
    @RequestMapping("/teams/{teamId}")
    public String home(HttpServletRequest request, @PathVariable int teamId, Model model) {
    	Team team = teamService.find(teamId);
    	Matches teamMatches = matchService.getMatchesInvolving(team);
    	
    	model.addAttribute("team", team);
    	model.addAttribute("matches", teamMatches);
    	
        return "team";
    }
   
}