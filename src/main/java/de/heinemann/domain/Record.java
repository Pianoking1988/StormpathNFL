package de.heinemann.domain;

public class Record {

	private int wins = 0;
	private int losses = 0;
	private int ties = 0;
	private int score = 0;
	private int scoreOpponents = 0;
	
	public Record() {}
	
	public Record(int wins, int losses, int ties, int score, int scoreOpponents) {
		this.wins = wins;
		this.losses = losses;
		this.ties = ties;
		this.score = score;
		this.scoreOpponents = scoreOpponents;
	}
	
	public Record add(Record record) {
		return new Record(
				wins + record.getWins(),
				losses + record.getLosses(),
				ties + record.getTies(),
				score + record.getScore(),
				scoreOpponents + record.getScoreOpponents());
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

	public int getScore() {
		return score;
	}

	public int getScoreOpponents() {
		return scoreOpponents;
	}	
	
}
