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
				.reduce(new Record(0, 0, 0), Record::add);		
	}
	
	public List<Match> getMatches() {
		return matches;
	}
	
}
