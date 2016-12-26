package de.heinemann.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.heinemann.domain.Matches;
import de.heinemann.domain.Team;
import de.heinemann.repository.MatchRepository;

@Service
public class MatchServiceImpl implements MatchService {

	@Autowired
	private MatchRepository matchRepository;

	@Override
	public Matches findAll() {
		return new Matches(matchRepository.findAllByOrderByIdAsc());
	}	
	
	public Matches getMatchesInvolving(Team team) {
		return findAll().getMatchesInvolving(team);		
	}
	
}
