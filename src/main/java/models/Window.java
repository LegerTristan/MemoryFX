package models;

import javafx.application.Application;
import javafx.stage.Stage;

public abstract class Window extends Application{
	
	protected static Stage memoryWindow;

	@Override
	public void start(Stage primaryStage) throws Exception {
	
		memoryWindow = primaryStage;
		this.initMemory();
	}
	
	protected abstract void initMemory();

	public static Stage getWindow() {
		
		return memoryWindow;
	}

}
