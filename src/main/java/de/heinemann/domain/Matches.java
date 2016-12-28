package de.heinemann.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Matches {

	private List<Match> matches = new ArrayList<>();
	
	public Matches(List<Match> matches) {
		addMatches(matches);
	}
	
	public void addMatches(List<Match> matches) {
		this.matches.addAll(matches);
	}
	
	public Matches getMatchesInvolving(Team team) {
		return new Matches(
				matches.stream().filter(
						match -> match.isInvolving(team)
				).collect(Collectors.toList()));
	}

	public Record getRecordFor(Team team) {
		return matches.stream()
				.map(match -> match.getRecordFor(team))
				.reduce(new Record(), Record::add);		
	}
	
	public Matches getMatchesAgainstConferenceFor(Team team, Conference conference) {
		return new Matches(
				matches.stream().filter(
						match -> match.isInvolving(team)
								&& match.getOpponentOf(team).getConference().equals(conference)
				).collect(Collectors.toList()));
	}

	public Matches getMatchesAgainstDivisionFor(Team team, Conference conference, Division division) {
		return new Matches(
				matches.stream().filter(
						match -> match.isInvolving(team)
								&& match.getOpponentOf(team).getConference().equals(conference)
								&& match.getOpponentOf(team).getDivision().equals(division)
				).collect(Collectors.toList()));
	}

	public Matches getMatchesInWeek(int week) {
		return new Matches(
				matches.stream().filter(
						match -> match.getWeek() == week
				).collect(Collectors.toList()));
	}
	
	public List<Match> getMatches() {
		return matches;
	}
	
}
