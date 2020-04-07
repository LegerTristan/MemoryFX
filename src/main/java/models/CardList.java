package models;

import java.util.HashSet;
import java.util.Set;

import view.Game;
import javafx.scene.shape.Rectangle;

public class CardList {
	
	private Set<Rectangle> cards;
	
	public CardList(int numberOfCards, Game game) {
		
		cards = new HashSet<Rectangle>();
		
		this.createCards(numberOfCards, game);
	}

	private void createCards(int number, Game game) {
		
		for(int count = 0; count < number; count++) {
			
			cards.add(new Card(game));
			
		}
	}
	
}
