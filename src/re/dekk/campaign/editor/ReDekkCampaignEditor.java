/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package re.dekk.campaign.editor;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author rasamog
 */
public class ReDekkCampaignEditor extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button level = new Button();
        level.setText("levels");
        level.setOnAction((ActionEvent event) -> {
            try {
                Levels.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(ReDekkCampaignEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button ship = new Button();
        ship.setText("ships");
        ship.setOnAction((ActionEvent event) -> {
            try {
                Ships.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(ReDekkCampaignEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button part = new Button();
        part.setText("parts");
        part.setOnAction((ActionEvent event) -> {
            try {
                Parts.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(ReDekkCampaignEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button unit = new Button();
        unit.setText("units");
        unit.setOnAction((ActionEvent event) -> {
            try {
                Units.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(ReDekkCampaignEditor.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button exit = new Button();
        exit.setText("exit");
        exit.setOnAction((ActionEvent event) -> {
            primaryStage.close();
        });
        
        level.setLayoutY(0);
        level.setLayoutX(0);
        ship.setLayoutY(30);
        ship.setLayoutX(0);
        part.setLayoutY(60);
        part.setLayoutX(0);
        unit.setLayoutY(90);
        unit.setLayoutX(0);
        exit.setLayoutY(120);
        exit.setLayoutX(0);
        
        Pane root = new Pane();
        root.getChildren().add(level);
        root.getChildren().add(ship);
        root.getChildren().add(part);
        root.getChildren().add(unit);
        root.getChildren().add(exit);
        
        Scene scene = new Scene(root, 800, 500);
        
        primaryStage.setTitle("campaign editor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
