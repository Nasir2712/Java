package application;
	
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	
	/**
	 * <b>Main Start function</b><br>
	 * By calling this function the main execute function is executed
	 * @param primaryStage the first stage of the function
	 */
	public void start(Stage primaryStage) 
	{
		MainBusinessLogicLayer mainBLL = new MainBusinessLogicLayer();
		mainBLL.execute();                                                        // The main function
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
