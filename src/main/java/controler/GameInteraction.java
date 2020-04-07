package controler;

import models.ScoreManager;

public class GameInteraction {

private ScoreManager manager;
	
	public GameInteraction() {
		
		this.manager = new ScoreManager();
	}

	public int returnScore() {
		
		return manager.getScore();
	}

	public int returnNumberMoves() {

		return manager.getNumberMoves();
	}

	public int returnPointBySeries() {

		return manager.getPointBySeries();
	}

	public int returnNumberSeries() {
		
		return manager.getNumberSeries();
	}
	
	public void incrementNumberMoves() {


		manager.setNumberMoves(manager.getNumberMoves() + 1);
		
	}

	public void calculateFinalScore(int score, int nbrMoves) {

		manager.setScore(manager.getScore() - (20 * nbrMoves) - 20);
		
	}

	public void increaseScore() {

		double multiplicateur = (double) manager.getNumberSeries() / 10;
		manager.setEnchainmentPoints(manager.getPointBySeries() + (int)(100 * multiplicateur) - 100 );
		manager.setScore(manager.getScore() + (int)(100 * multiplicateur));	
		
	}

	public void increasenumberSeries(int value) {

		manager.setNumberSeries(manager.getNumberSeries() + value);
	}

	public void editNumberSeries(int value) {
		
		manager.setNumberSeries(value);
	}
	
}
