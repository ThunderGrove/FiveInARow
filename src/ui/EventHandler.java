package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class EventHandler {

    @FXML
    private GridPane startMenu, gamePane, loadPane;

    @FXML
    public void startGame(ActionEvent event){
        startMenu.setVisible(false);
        gamePane.setVisible(true);
        //TODO Udvikling af code der generates spille fladen gøres evt fra en anden package
    }

    @FXML
    public void loadGame(ActionEvent event){
        startMenu.setVisible(false);
        gamePane.setVisible(false);
        loadPane.setVisible(true);
        //TODO udvikling af code så programmet kan læse fra databasen, evt gøres i en Model Class?
    }

    @FXML
    public void saveGame(ActionEvent event){
        //TODO udvikle kode der kan gemme til databasen, gøres evt fra en anden package
    }

}
