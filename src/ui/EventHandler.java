package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Affine;
import model.GameData;
import persistence.DB;

public class EventHandler {

    Game gameUI = new Game();
    GameData gameModel = new GameData();
    DB persistance = new DB();

    @FXML
    private GridPane startMenu, gamePane, loadPane;
    @FXML
    private Pane gameField;
    private Affine affine;

    @FXML
    public void startGame(ActionEvent event){
        startMenu.setVisible(false);
        gamePane.setVisible(true);
        gameUI.gameFill(gameField);
        this.affine = new Affine();
        this.affine.appendScale(400/5f,400/5f);
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
        persistance.saveGame(gameModel);
        System.out.println("der burde ligge noget i db'en nu");
        //TODO udvikle kode der kan gemme til databasen, gøres evt fra en anden package
    }

    @FXML
    void loadGameBack2Main(ActionEvent event){
        loadPane.setVisible(false);
        startMenu.setVisible(true);
    }
    @FXML
    void loadGameBack2Game(ActionEvent event){
        loadPane.setVisible(false);
        gamePane.setVisible(true);
    }
    @FXML
    public void handlePlay(MouseEvent event){
        int y = (int) event.getY();
        int x = (int) event.getX();
        int a = 0, b = 0;
        for (int i = 70; i < x ; i+=75) {
            a++;
        }
        for (int i = 90; i < y ; i+=65) {
            b++;
        }
        System.out.println(x + " , "+ y);
            if (gameModel.getTurn()){
                if (gameModel.getGameCell(a,b) == 0){
                GameData.gameFieldGUI.get(a).get(b).setFill(Color.CRIMSON);
                gameModel.nextTurn();
                gameModel.setGameCell(a,b,1);}
            }
            else{
                if (gameModel.getGameCell(a,b)==0){
                GameData.gameFieldGUI.get(a).get(b).setFill(Color.BLUE);
                gameModel.nextTurn();
                gameModel.setGameCell(a,b,2);}
            }
        System.out.println(gameModel.getGameFieldAsText());
    }
    public void handleLoadDB(){
        gameModel = persistance.getSavedGame(1);
        System.out.println(gameModel.getGameFieldAsText());
        startMenu.setVisible(false);
        gamePane.setVisible(true);
        gameUI.gameFill(gameField);
        for (int ia = 0; ia < 5; ia++) {
            for (int ib = 0; ib < 5; ib++) {
                switch (gameModel.getGameCell(ia,ib)){
                    case 0:
                        GameData.gameFieldGUI.get(ia).get(ib).setFill(Color.GRAY);
                        break;
                    case 1:
                        GameData.gameFieldGUI.get(ia).get(ib).setFill(Color.CRIMSON);
                        break;
                    case 2:
                        GameData.gameFieldGUI.get(ia).get(ib).setFill(Color.BLUE);
                        break;
                }
            }

        }

    }

}
