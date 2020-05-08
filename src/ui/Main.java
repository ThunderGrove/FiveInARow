package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import persistence.DB;

public class Main extends Application{
    DB persistance = new DB();
    EventHandler eh = new EventHandler();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        primaryStage.setTitle("Five in a row");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        persistance.createTables();
        eh.gameCount();

    }

    public static void main(String[] args) {
        launch(args);
    }
}