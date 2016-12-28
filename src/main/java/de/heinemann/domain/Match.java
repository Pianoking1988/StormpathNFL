package de.heinemann.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "match")
public class Match {

	private long id;
	private int season;
	private int week;
	private boolean finished;
	private Team homeTeam;
	private Team roadTeam;
	private int homeScore;
	private int roadScore;
	private boolean overtime;

	public boolean isInvolving(Team team) {
		return homeTeam.equals(team) || roadTeam.equals(team);
	}

	public Record getRecordFor(Team team) {
		if (!isInvolving(team) || !isFinished()) {
			return new Record();
		}
		if (isTie()) {
			return new Record(0, 0, 1, homeScore, roadScore);
		}
		return getWinnerTeam().equals(team) 
				? new Record(1, 0, 0, getWinnerScore(), getLoserScore())
				: new Record(0, 1, 0, getLoserScore(), getWinnerScore());
	}
	
	@Transient
	public Team getWinnerTeam() {
		if (isTie() || !isFinished()) {
			return null;
		}
		return homeScore > roadScore ? homeTeam : roadTeam;
	}

	@Transient
	public Team getLoserTeam() {
		if (isTie() || !isFinished()) {
			return null;
		}
		return homeScore < roadScore ? homeTeam : roadTeam;
	}

	@Transient
	public int getWinnerScore() {
		Team winnerTeam = getWinnerTeam();
		if (winnerTeam == null) {
			return homeScore;
		}
		return winnerTeam.equals(homeTeam) ? homeScore : roadScore;
	}

	@Transient
	public int getLoserScore() {
		Team loserTeam = getLoserTeam();
		if (loserTeam == null) {
			return homeScore;
		}
		return loserTeam.equals(homeTeam) ? homeScore : roadScore;
	}
	
	@Transient
	public boolean isTie() {
		return homeScore == roadScore;
	}
	
	public Team getOpponentOf(Team team) {
		if (!isInvolving(team)) {
			return null;
		}
		return homeTeam.equals(team) ? roadTeam : homeTeam;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	@ManyToOne
	@JoinColumn(name = "hometeam")
	public Team getHomeTeam() {
		return homeTeam;
	}

	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}

	@ManyToOne
	@JoinColumn(name = "roadteam")
	public Team getRoadTeam() {
		return roadTeam;
	}

	public void setRoadTeam(Team roadTeam) {
		this.roadTeam = roadTeam;
	}

	@Column(name = "homescore")
	public int getHomeScore() {
		return homeScore;
	}

	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}

	@Column(name = "roadscore")
	public int getRoadScore() {
		return roadScore;
	}

	public void setRoadScore(int roadScore) {
		this.roadScore = roadScore;
	}

	public boolean isOvertime() {
		return overtime;
	}

	public void setOvertime(boolean overtime) {
		this.overtime = overtime;
	}
	
}