import csc3a.ui.myPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		myPane pane = new myPane();
		BorderPane BPane = pane.Gridpane();
		Scene scene = new Scene(BPane);
		primaryStage.setTitle("Bus System");
		primaryStage.setHeight(700);
		primaryStage.setWidth(1000);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
}
