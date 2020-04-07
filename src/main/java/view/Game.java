package view;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import controler.GameInteraction;
import models.Card;
import models.Constant;
import models.Window;
import javafx.animation.PauseTransition;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Game {

private GameInteraction interaction;
	
	private boolean foundPairAtLeastMove;
	
	private int numberPairsFound;
	private static int numberOfPairs;

	private Label lbMoves;
	
	private Set<Rectangle> visibleCard;
	private Set<Rectangle> cardList;

	private Rectangle card1;
	private Rectangle card2;
	private Rectangle card3;
	private Rectangle card4;
	private Rectangle card5;
	private Rectangle card6;
	private Rectangle card7;
	private Rectangle card8;
	private Rectangle card9;
	private Rectangle card10;
	private Rectangle card11;
	private Rectangle card12;

	public Game() {

		this.interaction = new GameInteraction();
	}
	
	public Set<Rectangle> getCardList() {
		return cardList;
	}

	public static int getNumberPairs() {
		return numberOfPairs;
	}
	
	/*
	 * Lancement du jeu et création de l'interface
	 */

	public BorderPane launching(GridPane gameGrid, BorderPane hud){
		
		numberPairsFound = 0;
		
		foundPairAtLeastMove = false;
		
		lbMoves = new Label("Nombre de coup(s) : " + interaction.returnNumberMoves());
		
		this.setVisibleCard(new HashSet<Rectangle>());
		this.setCardList(new HashSet<Rectangle>());
		
		card1 = new Card(this);

		card2 = new Card(this);
		
		card3 = new Card(this);
		
		card4 = new Card(this);

		card5 = new Card(this);

		card6 = new Card(this);

		card7 = new Card(this);

		card8 = new Card(this);
		
		card9 = new Card(this);

		card10 = new Card(this);

		card11 = new Card(this);

		card12 = new Card(this);
		
		this.editCardList();

		 hud.setMaxSize(Constant.WIDTH, Constant.HEIGHT);
		 hud.setPrefSize(Constant.WIDTH, Constant.HEIGHT);
		 
		 lbMoves.setMaxSize(180, Constant.HEIGHT);
		 lbMoves.setPrefSize(180, Constant.HEIGHT);
		 
		 gameGrid.setVgap(20.0);
		 gameGrid.setHgap(20.0);
			
		 this.determineNumberPairsMax();
			
		 this.positionningCards(gameGrid);
		
		 hud.setCenter(gameGrid);
		 gameGrid.setAlignment(Pos.CENTER);
		 gameGrid.setPadding(new Insets(0.0, 140.0, 0, 0));
		 
		 hud.setLeft(lbMoves);
		 lbMoves.setAlignment(Pos.BOTTOM_CENTER);
		 lbMoves.setPadding(new Insets(0.0, 0.0, 30.0, 20.0));
		 
		 return hud;	
	}
	
	/*
	 * Les cartes sont posées sur la grille de 3x4
	 */

	private void positionningCards(GridPane gameGrid) {

		Object[] cards = cardList.toArray();
		int k = 0;
		Random random = new Random();
		
		for(int i = 0; i < Constant.NUMBER_OF_LINES_MAX; i++) {
			
			for(int j = 0; j < Constant.NUMBER_OF_COLUMNS_MAX; j++) {
				
				do {
					
					k = random.nextInt(Constant.CARD_NUMBER);
					if(!(gameGrid.getChildren().contains((Rectangle) cards[k]))) {
						
						gameGrid.add((Rectangle) cards[k], j, i);
						k = -1;
					}
					
				}while(k >= 0 && k < Constant.CARD_NUMBER);
				
			}
		}
		 
		
	}

	private void determineNumberPairsMax() {
		numberOfPairs = cardList.size() / 2;	
	}

	private void setCardList(HashSet<Rectangle> list) {
		
		this.cardList = list;
	}

	private void editCardList() {
		
		cardList.add(card1);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);
		cardList.add(card6);
		cardList.add(card7);
		cardList.add(card8);
		cardList.add(card9);
		cardList.add(card10);
		cardList.add(card11);
		cardList.add(card12);
		
	}

	public Set<Rectangle> getVisibleCard() {
		return visibleCard;
	}



	public void setVisibleCard(Set<Rectangle> visibleCard) {
		this.visibleCard = visibleCard;
	}
	
	/*
	 * Gestion des cartes retournées
	 */

	public static class ReturnCarte implements EventHandler<MouseEvent>{
		
		private Game game;
		
		public ReturnCarte(Game game) {
			
			this.game = game;
			
		}

		public void handle(MouseEvent event) {

			if(event.getSource() == game.card1) {
				
				game.card1.setFill(Color.RED);	
				game.visibleCard.add(game.card1);
				game.cacherLesCartes();
			}
			
			if(event.getSource() == game.card2) {
				
				game.card2.setFill(Color.BLUE);
				game.visibleCard.add(game.card2);
				game.cacherLesCartes();
			}

			if(event.getSource() == game.card3) {
	
				game.card3.setFill(Color.YELLOW);
				game.visibleCard.add(game.card3);
				game.cacherLesCartes();
			}
			
			if(event.getSource() == game.card4) {
				
				game.card4.setFill(Color.GREEN);
				game.visibleCard.add(game.card4);
				game.cacherLesCartes();
			}
			
			if(event.getSource() == game.card5) {
				
				game.card5.setFill(Color.YELLOW);
				game.visibleCard.add(game.card5);
				game.cacherLesCartes();
			}
			
			if(event.getSource() == game.card6) {
				
				game.card6.setFill(Color.GREEN);
				game.visibleCard.add(game.card6);
				game.cacherLesCartes();
			}
			
			if(event.getSource() == game.card7) {
				
				game.card7.setFill(Color.RED);
				game.visibleCard.add(game.card7);
				game.cacherLesCartes();
			}
			
			if(event.getSource() == game.card8) {
				
				game.card8.setFill(Color.BLUE);
				game.visibleCard.add(game.card8);
				game.cacherLesCartes();
			}
			
			if(event.getSource() == game.card9) {
				
				game.card9.setFill(Color.PURPLE);	
				game.visibleCard.add(game.card9);
				game.cacherLesCartes();
			}
			
			if(event.getSource() == game.card10) {
				
				game.card10.setFill(Color.PURPLE);
				game.visibleCard.add(game.card10);
				game.cacherLesCartes();
			}
			
			if(event.getSource() == game.card11) {
				
				game.card11.setFill(Color.ORANGE);	
				game.visibleCard.add(game.card11);
				game.cacherLesCartes();
			}
			
			if(event.getSource() == game.card12) {
				
				game.card12.setFill(Color.ORANGE);
				game.visibleCard.add(game.card12);
				game.cacherLesCartes();
			}

		}
	}
	
	/*
	 * Bloque les interactions et vérifie l'indentité des deux cartes retournées
	 * 	Identique : Elles sont retirées de la liste des cartes restantes et le joueur augmente son score
	 * 				de plus, sa série de paire trouvée augmente de 10 (points bonus lros des scores).
	 * 	Pas identique : Elles sont retournées face cachée, et la série du joueur est réinitialisé à 0.
	 * (Nécessite un refactoring)
	 */

	public void cacherLesCartes() {
		
		if(2 == this.visibleCard.size()) { 
			
			this.interdireInteraction();
			
			Object[] cartes = this.visibleCard.toArray();
			
			Rectangle carte1 = (Rectangle) cartes[0];
			Rectangle carte2 = (Rectangle) cartes[1];
			
			if(Game.verifierIdentique(carte1, carte2)) {
				
				if(cardList.contains(carte1) && cardList.contains(carte2)) {
					cardList.remove(carte1);
					cardList.remove(carte2);
					numberPairsFound++;
					
					if(foundPairAtLeastMove) {
						interaction.increasenumberSeries(2);
					}
					foundPairAtLeastMove = true;
					interaction.increaseScore();
				}
				this.visibleCard.clear();
				this.activerInteraction();
			}
			else {
				final PauseTransition pause = new PauseTransition(Duration.millis(1000));
				
				pause.setOnFinished(event2 -> {
					for( Rectangle carte_select : visibleCard) {
						carte_select.setFill(Color.WHITE);
					}
					this.visibleCard.clear();
					foundPairAtLeastMove = false;
					interaction.editNumberSeries(10);
					this.activerInteraction();
				});
				
				pause.play();
			}
			if(this.beDone()) {
				interaction.calculateFinalScore(interaction.returnScore(), interaction.returnNumberMoves());
				
				EndGame fin = new EndGame(interaction);
				Window.getWindow().setScene(fin.displayEndScreen());
				
				
			}
			interaction.incrementNumberMoves();
			labelRefresh();
		}		
	}  

	private void labelRefresh() {
		lbMoves.setText("Nombre de coup(s) : " + interaction.returnNumberMoves());
		
	}

	/*
	 * Vérifie si le jeu est finie.
	 */
	
	private boolean beDone() {
		
		return numberPairsFound == numberOfPairs ? true : false;
	}

	private static boolean verifierIdentique(Rectangle carte1, Rectangle carte2) {
			
		return carte1.getFill().equals(carte2.getFill()) ? true : false ;	
	}

	private void activerInteraction() {
		
		for( Rectangle carte : cardList) {
			carte.setDisable(false);
		}
		
	}

	public void interdireInteraction() {
		
		for( Rectangle carte : cardList) {
			carte.setDisable(true);
		}
	}
}
