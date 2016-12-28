package de.heinemann.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import de.heinemann.domain.Matches;
import de.heinemann.service.MatchService;

@Controller
public class ScheduleController {

	@Autowired
	private MatchService matchService;
		
    @RequestMapping("/schedule")
    public String home(HttpServletRequest request, Model model) {
    	Matches matches = matchService.findAll();
    	model.addAttribute("matches", matches);
    	
        return "schedule";
    }
    
}