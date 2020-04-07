package view;

import controler.GameInteraction;
import controler.PlayGameEventHandler;
import models.Constant;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class EndGame {
	
private StackPane endScreen;
	
	private GridPane grid;

	private Scene scEndScreen;
	
	private Button btnRetry;
	
	private Label lbEnd; 
	private Label lbScore;
	private Label lbPairs;
	private Label lbNumberPairs;
	private Label lbMoves;
	private Label lbNumberMove;
	private Label lbSeries;
	private Label lbNumberSeries;

	private GameInteraction interaction;
	
	public EndGame(GameInteraction interaction) {
		
		this.interaction = interaction;
		
	}
	public Scene displayEndScreen() {
		
		this.displayResult();
		this.positionning();
		
		endScreen.getChildren().addAll(lbEnd, lbScore, grid, btnRetry);
		
		return scEndScreen;
	}

	private void displayResult() {

		endScreen = new StackPane();
		
		grid = new GridPane();
		
		scEndScreen = new Scene(endScreen, Constant.WIDTH, Constant.HEIGHT);
		
		btnRetry = new Button("Rejouer");
		btnRetry.setOnMouseClicked(new PlayGameEventHandler(btnRetry));
		
		lbEnd = new Label("Partie Terminée !!");
		lbEnd.setFont(new Font(32));
		
		lbScore = new Label("Score : " + interaction.returnScore());
		lbScore.setFont(new Font(32));
		
		lbPairs = new Label("Nombre de paires :");
		lbPairs.setFont(new Font(26)); 
		
		lbNumberPairs = new Label("+ " + (Game.getNumberPairs() * 100));
		lbNumberPairs.setFont(new Font(26));
		
		lbMoves = new Label("Nombres de coups  :");
		lbMoves.setFont(new Font(26));
		
		lbNumberMove = new Label("- " + ((interaction.returnNumberMoves() + 1) * 20));
		lbNumberMove.setFont(new Font(26));
		
		lbSeries = new Label("Points gagnés par enchaînement :");
		lbSeries.setFont(new Font(26));
		
		lbNumberSeries = new Label("+ " +  (interaction.returnPointBySeries()));
		lbNumberSeries.setFont(new Font(26));
}

	private void positionning() {
		
		lbEnd.setPadding(new Insets(30.0, 60.0, 30.0, 60.0));
	
		lbScore.setTranslateY(100);
		lbScore.setPadding(new Insets(30.0, 60.0, 30.0, 60.0));
		
		btnRetry.setTranslateY(180);
		btnRetry.setPadding(new Insets(30.0, 60.0, 30.0, 60.0));
		
		grid.add(lbPairs, 0, 0);
		grid.add(lbNumberPairs, 1, 0);
		grid.add(lbMoves, 0, 1);
		grid.add(lbNumberMove, 1, 1);
		grid.add(lbSeries, 0, 2);
		grid.add(lbNumberSeries, 1, 2);
		
		grid.setHgap(10);
		grid.setVgap(10);
		
		grid.setTranslateY(200);
		grid.setTranslateX(350);
		
		StackPane.setAlignment(lbEnd, Pos.TOP_CENTER);
		
	}

}
