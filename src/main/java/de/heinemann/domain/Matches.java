package de.heinemann.domain;

import java.util.ArrayList;
import java.util.List;

public class Matches {

	private List<Match> matches = new ArrayList<>();
	
	public Matches(List<Match> matches) {
		addMatches(matches);
	}
	
	public void addMatches(List<Match> matches) {
		this.matches.addAll(matches);
	}
	
	public List<Match> getMatches() {
		return matches;
	}
	
}
