package de.heinemann.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teams {

	private List<Team> teams = new ArrayList<>();

	public Teams(List<Team> teams) {
		addTeams(teams);
	}

	public void addTeams(List<Team> teams) {
		this.teams.addAll(teams);
	}

	public List<Team> getTeams() {
		return teams;
	}

	public Teams getTeamsIn(Conference conference) {
		return new Teams(
				teams.stream().filter(
						team -> team.isInConference(conference)
				).collect(Collectors.toList()));
	}

	public Teams getTeamsIn(Conference conference, Division division) {
		return new Teams(
				teams.stream().filter(
						team -> team.isInConference(conference) && team.isInDivision(division)
				).collect(Collectors.toList()));
	}

}
