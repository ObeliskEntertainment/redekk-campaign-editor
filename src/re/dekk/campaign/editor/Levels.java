/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package re.dekk.campaign.editor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author rasamog
 */
public class Levels {
    static public void start(Stage primaryStage) throws IOException {
        Pane root = new Pane();
        ObservableList<String> listoflevels=FXCollections.observableArrayList();
        ObservableList<String> currentships=FXCollections.observableArrayList();
        ObservableList<String> ships=FXCollections.observableArrayList();
        Path path = FileSystems.getDefault().getPath("resource", "ships.redekk");
        BufferedReader reader= Files.newBufferedReader(path, StandardCharsets.UTF_8);
        String str=reader.readLine();
        while(!str.equals("|")){
            ships.add(str);
            str=reader.readLine();
        }
        reader.close();
        path = FileSystems.getDefault().getPath("resource", "levels.redekk");
        reader= Files.newBufferedReader(path, StandardCharsets.UTF_8);
        str=reader.readLine();
        while(!str.equals("|")){
            listoflevels.add(str);
            str=reader.readLine();
        }
        reader.close();
        
        Button level = new Button();
        level.setText("levels");
        level.setLayoutY(0);
        level.setLayoutX(0);
        level.setOnAction((ActionEvent event) -> {
            try {
                Levels.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(Parts.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button ship = new Button();
        ship.setText("ships");
        ship.setLayoutY(30);
        ship.setLayoutX(0);
        ship.setOnAction((ActionEvent event) -> {
            try {
                Ships.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(Levels.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button part = new Button();
        part.setText("parts");
        part.setLayoutY(60);
        part.setLayoutX(0);
        part.setOnAction((ActionEvent event) -> {
            try {
                Parts.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(Levels.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button unit = new Button();
        unit.setText("units");
        unit.setLayoutY(90);
        unit.setLayoutX(0);
        unit.setOnAction((ActionEvent event) -> {
            try {
                Units.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(Levels.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button exit = new Button();
        exit.setText("exit");
        exit.setLayoutY(120);
        exit.setLayoutX(0);
        exit.setOnAction((ActionEvent event) -> {
            primaryStage.close();
        });
        
        Text numberinfo=new Text();
        numberinfo.setText("number");
        numberinfo.setLayoutX(100);
        numberinfo.setLayoutY(10);
        root.getChildren().add(numberinfo);
        
        TextField number=new TextField();
        number.setLayoutX(100);
        number.setLayoutY(20);
        root.getChildren().add(number);
        
        Text sizexinfo=new Text();
        sizexinfo.setText("sizex");
        sizexinfo.setLayoutX(250);
        sizexinfo.setLayoutY(10);
        root.getChildren().add(sizexinfo);
        
        TextField sizex=new TextField();
        sizex.setLayoutX(250);
        sizex.setLayoutY(20);
        root.getChildren().add(sizex);
        
        Text sizeyinfo=new Text();
        sizeyinfo.setText("sizey");
        sizeyinfo.setLayoutX(100);
        sizeyinfo.setLayoutY(55);
        root.getChildren().add(sizeyinfo);
        
        Text shipnxinfo=new Text();
        shipnxinfo.setText("shipnx");
        shipnxinfo.setLayoutX(100);
        shipnxinfo.setLayoutY(100);
        root.getChildren().add(shipnxinfo);
        
        TextField shipnx=new TextField();
        shipnx.setLayoutX(100);
        shipnx.setLayoutY(110);
        root.getChildren().add(shipnx);
        
        Text shipnyinfo=new Text();
        shipnyinfo.setText("partny");
        shipnyinfo.setLayoutX(250);
        shipnyinfo.setLayoutY(100);
        root.getChildren().add(shipnyinfo);
        
        TextField shipny=new TextField();
        shipny.setLayoutX(250);
        shipny.setLayoutY(110);
        root.getChildren().add(shipny);
        
        TextField sizey=new TextField();
        sizey.setLayoutX(100);
        sizey.setLayoutY(65);
        root.getChildren().add(sizey);
        
        File f=path.toFile();
        Button addship = new Button();
        addship.setText("addlevel");
        addship.setLayoutX(400);
        addship.setLayoutY(300);
        addship.setOnAction((ActionEvent event) -> {
            try {
                String statsships="";
                while(!currentships.isEmpty()){
                    statsships+=currentships.remove(0)+" ";
                }
                String stats=number.getText()+" "+sizex.getText()+" "+sizey.getText()+
                        ":"+statsships;
                listoflevels.add(stats);
                ObservableList<String> thepartslist=listoflevels;
                FileWriter fw = new FileWriter(f.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                while(!thepartslist.isEmpty()){
                    bw.write(thepartslist.remove(0)+"\n");
                }
                bw.write("|");
                bw.close();
                Levels.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(Units.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        root.getChildren().add(addship);
        
        ComboBox chooseunit = new ComboBox(ships);
        chooseunit.setLayoutX(100);
        chooseunit.setLayoutY(200);
        chooseunit.setMaxWidth(145);
        root.getChildren().add(chooseunit);
        
        Button addpart = new Button();
        addpart.setText("addship");
        addpart.setLayoutX(400);
        addpart.setLayoutY(260);
        addpart.setOnAction((ActionEvent event) -> {
            String[] stats=chooseunit.getValue().toString().split(" ");
            String currentunit=stats[0]+" "+shipnx.getText()+" "+shipny.getText();
            currentships.add(currentunit);
        });
        root.getChildren().add(addpart);
        
        
        ListView partslist=new ListView();
        partslist.setItems(currentships);
        partslist.setLayoutX(100);
        partslist.setLayoutY(235);
        partslist.setMaxHeight(200);
        root.getChildren().add(partslist);
        
        ListView levelslist=new ListView();
        levelslist.setItems(listoflevels);
        levelslist.setLayoutX(500);
        root.getChildren().add(levelslist);
        
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
}
