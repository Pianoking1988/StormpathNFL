package de.heinemann.service;

import de.heinemann.domain.Matches;
import de.heinemann.domain.Team;

public interface MatchService {

	public Matches findAll();

	public Matches getMatchesInvolving(Team team);

}
