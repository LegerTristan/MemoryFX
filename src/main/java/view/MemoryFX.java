package view;

import controler.PlayGameEventHandler;
import models.Constant;
import models.Window;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MemoryFX extends Window{

	private VBox menu;
	private VBox vbInteractionMenu;
	private HBox hbInfoMenu;
	
	private Button btnPlay;
	private Button btnQuit;
	
	private Label lbTitle;
	private Label lbVersion;
	private Label lbMAJ;

	public static void main(String[] args) {
		
		launch(args);

	}

	@Override
	public void initMemory() {
		
		menu = new VBox();
		
		Scene scMenu = new Scene(menu, Constant.WIDTH, Constant.HEIGHT);
		
		this.initElements();
		this.positionning();
		
		memoryWindow.setScene(scMenu);
		memoryWindow.setTitle("MemoryFx");
		memoryWindow.show();
		
		btnQuit.setOnMouseClicked(new EventHandler<MouseEvent>() { // Utilisation d'une "convenience method"

			public void handle(MouseEvent event) {	// Classe anonyme /!\ Cas unique car le bouton Quitter n'a qu'une fonction qui lui est propre.
				
				Platform.exit();
				
			}
			
		});
		
		btnPlay.addEventFilter(MouseEvent.MOUSE_CLICKED, new PlayGameEventHandler(this.btnPlay));
		
	}

	private void initElements() {
		
		vbInteractionMenu = new VBox();
		hbInfoMenu = new HBox();

		btnPlay = new Button("Jouer");	
		btnQuit = new Button("Quitter");
		
		lbTitle = new Label("Memory");
		lbVersion = new Label("Version 0.3.2");
		lbMAJ = new Label("Mis à  jour le 21/07/2019"); // Début projet le 14/06/2019
														// Temps passé sur le projet : 24h00
		lbTitle.setFont(new Font("Arial", 32.0));
		
	}
	
	private void positionning() {
		
		btnPlay.setPadding(new Insets(30.0, 60.0, 30.0, 60.0));	
		btnQuit.setPadding(new Insets(30.0, 55.0, 30.0, 55.0));
		
		menu.setPrefSize(700, 520);	
		menu.setAlignment(Pos.CENTER);
		menu.setSpacing(50.0); 
		
		vbInteractionMenu.setMaxSize(700, 520);
		vbInteractionMenu.setPrefSize(700, 450); 
		vbInteractionMenu.setSpacing(20.0); 
		vbInteractionMenu.setAlignment(Pos.CENTER);
		
		hbInfoMenu.setMaxSize(700, 150);
		hbInfoMenu.setPrefSize(700, 90);
		hbInfoMenu.setAlignment(Pos.BASELINE_CENTER);
		hbInfoMenu.setSpacing(500);
		
		lbTitle.setMaxSize(700, 200);
		lbTitle.setPrefSize(700, 150);
		lbTitle.setAlignment(Pos.CENTER);
		
		lbVersion.setMinSize(180, 50);
		lbVersion.setAlignment(Pos.BOTTOM_LEFT);
		
		lbMAJ.setMinSize(250, 50);
		lbMAJ.setAlignment(Pos.BOTTOM_RIGHT);
		
		
		vbInteractionMenu.getChildren().addAll(btnPlay, btnQuit);
		hbInfoMenu.getChildren().addAll(lbVersion, lbMAJ);
		menu.getChildren().addAll(lbTitle, vbInteractionMenu, hbInfoMenu);
		
	}
}
