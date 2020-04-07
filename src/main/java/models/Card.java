package models;

import javafx.scene.shape.Rectangle;
import view.Game;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class Card extends Rectangle {

	public Card(Game game) {
		
		this.setWidth(Constant.CARD_WIDTH);
		this.setHeight(Constant.CARD_HEIGHT);
		this.setFill(Color.WHITE);
		this.setArcHeight(Constant.CARD_ROUND);
		this.setArcWidth(Constant.CARD_ROUND);
		this.setStroke(Color.BLACK);
		this.setStrokeWidth(Constant.CARD_CORNER_WIDTH);
		addEventHandlers(game);
		
	}

	private void addEventHandlers(Game game) {
		this.setOnMouseEntered(new Card.Highlighted(game));
		this.setOnMouseExited(new Card.EndHighlighted(game));
		this.addEventFilter(MouseEvent.MOUSE_CLICKED, new Game.ReturnCarte(game));
	}
	
	public class Highlighted implements EventHandler<MouseEvent>{
		
		private Game game;
		
		public Highlighted(Game game) {
			
			this.game = game;
			
		}
		
		@Override
		public void handle(MouseEvent event) {
			
			for(Rectangle card : this.game.getCardList()) {
				
				if(event.getSource() == card) {
					card.setStroke(Color.CYAN);
				}
			}	
		}
	}

	public class EndHighlighted implements EventHandler<MouseEvent>{
	
		private Game game;
		
		public EndHighlighted(Game game) {
			
			this.game = game;
			
		}
		
		@Override
		public void handle(MouseEvent event) {
			
			for(Rectangle card : this.game.getCardList()) {
				
				if(event.getSource() == card) {
					card.setStroke(Color.BLACK);
				}
			}	
		}
	}
	
	public boolean isHighlighted() {
		
		return (this.getStroke() == Color.CYAN) ? true : false;
	}
}
