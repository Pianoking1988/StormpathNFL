package de.heinemann.domain;

public enum Conference {

	AFC,
	NFC;
	
	public Conference getComplementaryConference() {
		return equals(AFC) ? NFC : AFC;
	}
	
}
