package de.heinemann.service;

import de.heinemann.domain.Team;
import de.heinemann.domain.Teams;

public interface TeamService {

	public Teams findAll();

	public Team find(long teamId);

}
