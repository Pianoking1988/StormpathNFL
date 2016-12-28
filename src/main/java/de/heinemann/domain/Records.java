package de.heinemann.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Contains the records for a single team based on all schedule matches. 
 */
public class Records {

	private Team team;
	private Matches scheduleMatches;
	
	private Map<RecordType, Matches> recordsMatches = new HashMap<>();
	
	public Records(Team team, Matches scheduleMatches) {
		this.team = team;
		this.scheduleMatches = scheduleMatches;
		buildRecords();
	}
	
	private void buildRecords() {
		buildRecordOverall();
		buildRecordDivision();
		buildRecordConference();
		buildRecordComplementaryConference();
	}

	private void buildRecordOverall() {
		Matches matches = scheduleMatches.getMatchesInvolving(team);
		addRecord(RecordType.OVERALL, matches);		
	}
	
	private void buildRecordDivision() {
		Matches matches = scheduleMatches.getMatchesAgainstDivisionFor(
				team, team.getConference(), team.getDivision());
		addRecord(RecordType.DIVISION, matches);				
	}	

	private void buildRecordConference() {
		Matches matches = scheduleMatches.getMatchesAgainstConferenceFor(
				team, team.getConference());
		addRecord(RecordType.CONFERENCE, matches);				
	}

	private void buildRecordComplementaryConference() {
		Matches matches = scheduleMatches.getMatchesAgainstConferenceFor(
				team, team.getConference().getComplementaryConference());
		addRecord(RecordType.COMPLEMENTARY_CONFERENCE, matches);				
	}

	private void addRecord(RecordType recordType, Matches matches) {
		recordsMatches.put(recordType, matches);
	}
		
	public Matches getRecordMatches(RecordType recordType) {
		return recordsMatches.get(recordType);
	}	
	
}
