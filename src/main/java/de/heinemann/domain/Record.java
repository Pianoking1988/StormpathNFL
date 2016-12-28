package de.heinemann.domain;

public class Record {

	private int wins = 0;
	private int losses = 0;
	private int ties = 0;
	
	public Record(int wins, int losses, int ties) {
		this.wins = wins;
		this.losses = losses;
		this.ties = ties;
	}
	
	public Record add(Record record) {
		return new Record(wins + record.getWins(), losses + record.getLosses(), ties + record.getTies());
	}
	
	public double getWinPercentage() {
		if (getTotal() == 0) {
			return 0.0;
		}
		return (wins + 0.5d * ties) * 100 / getTotal();
	}
	
	public int getTotal() {
		return wins + losses + ties;
	}
	
	public int getWins() {
		return wins;
	}
	
	public int getLosses() {
		return losses;
	}
	
	public int getTies() {
		return ties;
	}	
	
}
