package srcmain;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/srcmain/MainWindow.fxml"));
        Scene primaryScene = new Scene(root, 600, 708);
        primaryScene.getStylesheets().add(getClass().getResource("styling.css").toExternalForm());
        primaryStage.setTitle("Task Master");
        primaryStage.setScene(primaryScene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
