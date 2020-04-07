package models;

public class ScoreManager {

	private int numberMoves; 
	private int numberSeries; 
	private int seriesPoints; 
	private int score; 
	
	public ScoreManager() {
		
		numberMoves = 0;
		numberSeries = 10;
		seriesPoints = 0;
		score = 0;
	}
	
	public void setScore(int score) { 

		this.score = score;
	}
	
	public void setEnchainmentPoints(int enchainmentPoints) { 
		this.seriesPoints = enchainmentPoints;
	}
	
	
	public void setNumberMoves(int numberMoves) {
		this.numberMoves = numberMoves;
	}
	
	public void setNumberSeries(int numberSeries) {
		this.numberSeries = numberSeries;
	}

	public int getScore() { 
		return score;
	}
	
	public int getPointBySeries() { 
		return seriesPoints;
	}
	
	public int getNumberMoves() { 
		return numberMoves;
	}
	
	public int getNumberSeries() {
		return numberSeries;
	}
}
