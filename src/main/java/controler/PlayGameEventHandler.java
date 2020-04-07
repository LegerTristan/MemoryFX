package controler;

import models.Constant;
import view.Game;
import view.MemoryFX;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class PlayGameEventHandler implements EventHandler<MouseEvent> {

	private GridPane gameInterface = new GridPane();
	private BorderPane hud = new BorderPane();

	private Game game = new Game();

	private Button btnPlay;

	public PlayGameEventHandler(Button btn) {

		this.btnPlay = btn;

	}

	public void handle(MouseEvent event) {

		if (event.getSource() == this.btnPlay) {

			Scene scJeu = new Scene(hud, Constant.WIDTH, Constant.HEIGHT);

			hud = game.launching(gameInterface, hud);

			MemoryFX.getWindow().setScene(scJeu);
		}
	}
}
