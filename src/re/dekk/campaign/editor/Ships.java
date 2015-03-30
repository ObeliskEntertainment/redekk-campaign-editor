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
public class Ships {
    static public void start(Stage primaryStage) throws IOException {
        Pane root = new Pane();
        ObservableList<String> listofships=FXCollections.observableArrayList();
        ObservableList<String> currentparts=FXCollections.observableArrayList();
        ObservableList<String> parts=FXCollections.observableArrayList();
        
        Path path = FileSystems.getDefault().getPath("resource", "parts.redekk");
        BufferedReader reader= Files.newBufferedReader(path, StandardCharsets.UTF_8);
        String str=reader.readLine();
        while(!str.equals("|")){
            parts.add(str);
            str=reader.readLine();
        }
        reader.close();
        path = FileSystems.getDefault().getPath("resource", "ships.redekk");
        reader= Files.newBufferedReader(path, StandardCharsets.UTF_8);
        str=reader.readLine();
        while(!str.equals("|")){
            listofships.add(str);
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
                Logger.getLogger(Ships.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button ship = new Button();
        ship.setText("ships");
        ship.setLayoutY(30);
        ship.setLayoutX(0);
        ship.setOnAction((ActionEvent event) -> {
        });
        Button part = new Button();
        part.setText("parts");
        part.setLayoutY(60);
        part.setLayoutX(0);
        part.setOnAction((ActionEvent event) -> {
            try {
                Parts.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(Ships.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Ships.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button exit = new Button();
        exit.setText("exit");
        exit.setLayoutY(120);
        exit.setLayoutX(0);
        exit.setOnAction((ActionEvent event) -> {
            primaryStage.close();
        });
        
        Text typeinfo=new Text();
        typeinfo.setText("type");
        typeinfo.setLayoutX(100);
        typeinfo.setLayoutY(10);
        root.getChildren().add(typeinfo);
        
        TextField type=new TextField();
        type.setLayoutX(100);
        type.setLayoutY(20);
        root.getChildren().add(type);
        
        Text nameinfo=new Text();
        nameinfo.setText("name");
        nameinfo.setLayoutX(250);
        nameinfo.setLayoutY(10);
        root.getChildren().add(nameinfo);
        
        TextField name=new TextField();
        name.setLayoutX(250);
        name.setLayoutY(20);
        root.getChildren().add(name);
        
        Text shipxinfo=new Text();
        shipxinfo.setText("shipx");
        shipxinfo.setLayoutX(100);
        shipxinfo.setLayoutY(55);
        root.getChildren().add(shipxinfo);
        
        TextField shipx=new TextField();
        shipx.setLayoutX(100);
        shipx.setLayoutY(65);
        root.getChildren().add(shipx);
        
        Text shipyinfo=new Text();
        shipyinfo.setText("shipy");
        shipyinfo.setLayoutX(250);
        shipyinfo.setLayoutY(55);
        root.getChildren().add(shipyinfo);
        
        TextField shipy=new TextField();
        shipy.setLayoutX(250);
        shipy.setLayoutY(65);
        root.getChildren().add(shipy);
        
        Text massinfo=new Text();
        massinfo.setText("mass");
        massinfo.setLayoutX(100);
        massinfo.setLayoutY(100);
        root.getChildren().add(massinfo);
        
        TextField mass=new TextField();
        mass.setLayoutX(100);
        mass.setLayoutY(110);
        root.getChildren().add(mass);
        
        Text partnxinfo=new Text();
        partnxinfo.setText("partnx");
        partnxinfo.setLayoutX(250);
        partnxinfo.setLayoutY(100);
        root.getChildren().add(partnxinfo);
        
        TextField partnx=new TextField();
        partnx.setLayoutX(250);
        partnx.setLayoutY(110);
        root.getChildren().add(partnx);
        
        Text partnyinfo=new Text();
        partnyinfo.setText("partny");
        partnyinfo.setLayoutX(100);
        partnyinfo.setLayoutY(145);
        root.getChildren().add(partnyinfo);
        
        TextField partny=new TextField();
        partny.setLayoutX(100);
        partny.setLayoutY(155);
        root.getChildren().add(partny);
        
        File f=path.toFile();
        Button addship = new Button();
        addship.setText("addship");
        addship.setLayoutX(400);
        addship.setLayoutY(300);
        addship.setOnAction((ActionEvent event) -> {
            try {
                String statsparts="";
                while(!currentparts.isEmpty()){
                    statsparts+=currentparts.remove(0)+" ";
                }
                String stats=type.getText()+" "+name.getText()+" "+shipx.getText()+" "+
                        shipy.getText()+" "+mass.getText()+":"+statsparts;
                listofships.add(stats);
                ObservableList<String> thepartslist=listofships;
                FileWriter fw = new FileWriter(f.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                while(!thepartslist.isEmpty()){
                    bw.write(thepartslist.remove(0)+"\n");
                }
                bw.write("|");
                bw.close();
                Ships.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(Units.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        root.getChildren().add(addship);
        
        ComboBox chooseunit = new ComboBox(parts);
        chooseunit.setLayoutX(100);
        chooseunit.setLayoutY(200);
        chooseunit.setMaxWidth(145);
        root.getChildren().add(chooseunit);
        
        Button addpart = new Button();
        addpart.setText("addpart");
        addpart.setLayoutX(400);
        addpart.setLayoutY(260);
        addpart.setOnAction((ActionEvent event) -> {
            String[] stats=chooseunit.getValue().toString().split(" ");
            String currentunit=stats[0]+" "+partnx.getText()+" "+partny.getText();
            currentparts.add(currentunit);
        });
        root.getChildren().add(addpart);
        
        
        ListView partslist=new ListView();
        partslist.setItems(currentparts);
        partslist.setLayoutX(100);
        partslist.setLayoutY(235);
        partslist.setMaxHeight(200);
        root.getChildren().add(partslist);
        
        ListView shipslist=new ListView();
        shipslist.setItems(listofships);
        shipslist.setLayoutX(500);
        root.getChildren().add(shipslist);
        
        
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
