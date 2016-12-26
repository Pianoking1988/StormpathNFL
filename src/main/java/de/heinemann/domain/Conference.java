package de.heinemann.domain;

public enum Conference {

	AFC,
	NFC;
	
	public Conference getOtherConference() {
		return equals(AFC) ? NFC : AFC;
	}
	
}
