package ui;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Affine;
import model.GameData;

import java.util.ArrayList;

public class Game {



    public void gameFill(Pane pane) {
        for (int ia = 0; ia < 5; ia++) {
            GameData.gameFieldGUI.add(new ArrayList<Circle>());
            for (int ib = 0; ib < 5; ib++) {
                GameData.gameFieldGUI.get(ia).add(new Circle(23 + (ia * 75), 65 + (ib * 65), 22, Color.GRAY));

                pane.getChildren().add(GameData.gameFieldGUI.get(ia).get(ib));
            }
        }

    }
}


