package de.heinemann.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.heinemann.domain.Teams;
import de.heinemann.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService {

	@Autowired
	private TeamRepository teamRepository;
	
	public Teams findAll() {
		return new Teams(teamRepository.findAll());
	}
	
}
