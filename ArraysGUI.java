
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ArraysGUI extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		Scene scene = new Scene(new ArraysPanel(), 600, 600);

		primaryStage.setTitle("Array GUI");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		    @Override
		    public void handle(WindowEvent t) {
		        Platform.exit();
		        System.exit(0);
		    }
		});

	}

	public static void main(String[] args) {

		launch(args);

	}

}