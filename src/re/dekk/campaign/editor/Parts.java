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
public class Parts {
    static public void start(Stage primaryStage) throws IOException {
        Pane root = new Pane();
        ObservableList<String> listofparts=FXCollections.observableArrayList();
        ObservableList<String> currentunits=FXCollections.observableArrayList();
        ObservableList<String> units=FXCollections.observableArrayList();
        
        Path path = FileSystems.getDefault().getPath("resource", "units.redekk");
        BufferedReader reader= Files.newBufferedReader(path, StandardCharsets.UTF_8);
        String str=reader.readLine();
        while(!str.equals("|")){
            units.add(str);
            str=reader.readLine();
        }
        reader.close();
        path = FileSystems.getDefault().getPath("resource", "parts.redekk");
        reader= Files.newBufferedReader(path, StandardCharsets.UTF_8);
        str=reader.readLine();
        while(!str.equals("|")){
            listofparts.add(str);
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
                Logger.getLogger(Parts.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Button part = new Button();
        part.setText("parts");
        part.setLayoutY(60);
        part.setLayoutX(0);
        part.setOnAction((ActionEvent event) -> {
        });
        Button unit = new Button();
        unit.setText("units");
        unit.setLayoutY(90);
        unit.setLayoutX(0);
        unit.setOnAction((ActionEvent event) -> {
            try {
                Units.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(Parts.class.getName()).log(Level.SEVERE, null, ex);
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
        
        Text powertoenterinfo=new Text();
        powertoenterinfo.setText("powertoenter");
        powertoenterinfo.setLayoutX(100);
        powertoenterinfo.setLayoutY(55);
        root.getChildren().add(powertoenterinfo);
        
        TextField powertoenter=new TextField();
        powertoenter.setLayoutX(100);
        powertoenter.setLayoutY(65);
        root.getChildren().add(powertoenter);
        
        Text sizexinfo=new Text();
        sizexinfo.setText("sizex");
        sizexinfo.setLayoutX(250);
        sizexinfo.setLayoutY(55);
        root.getChildren().add(sizexinfo);
        
        TextField sizex=new TextField();
        sizex.setLayoutX(250);
        sizex.setLayoutY(65);
        root.getChildren().add(sizex);
        
        Text sizeyinfo=new Text();
        sizeyinfo.setText("sizey");
        sizeyinfo.setLayoutX(100);
        sizeyinfo.setLayoutY(100);
        root.getChildren().add(sizeyinfo);
        
        TextField sizey=new TextField();
        sizey.setLayoutX(100);
        sizey.setLayoutY(110);
        root.getChildren().add(sizey);
        
        Text specialinfo=new Text();
        specialinfo.setText("special");
        specialinfo.setLayoutX(250);
        specialinfo.setLayoutY(100);
        root.getChildren().add(specialinfo);
        
        TextField special=new TextField();
        special.setLayoutX(250);
        special.setLayoutY(110);
        root.getChildren().add(special);
        
        Text specialamountinfo=new Text();
        specialamountinfo.setText("specialamount");
        specialamountinfo.setLayoutX(100);
        specialamountinfo.setLayoutY(145);
        root.getChildren().add(specialamountinfo);
        
        TextField specialamount=new TextField();
        specialamount.setLayoutX(100);
        specialamount.setLayoutY(155);
        root.getChildren().add(specialamount);
        
        Text turninfo=new Text();
        turninfo.setText("turn?");
        turninfo.setLayoutX(250);
        turninfo.setLayoutY(145);
        root.getChildren().add(turninfo);
        
        TextField turn=new TextField();
        turn.setLayoutX(250);
        turn.setLayoutY(155);
        root.getChildren().add(turn);
        
        File f=path.toFile();
        Button addpart = new Button();
        addpart.setText("addpart");
        addpart.setLayoutX(400);
        addpart.setLayoutY(300);
        addpart.setOnAction((ActionEvent event) -> {
            try {
                String statsunits="";
                while(!currentunits.isEmpty()){
                    statsunits+=currentunits.remove(0)+" ";
                }
                String stats=type.getText()+" "+name.getText()+" "+powertoenter.getText()+" "+sizex.getText()+" "+
                        sizey.getText()+" "+special.getText()+" "+specialamount.getText()+" "+turn.getText()+
                        ":"+statsunits;
                listofparts.add(stats);
                ObservableList<String> thepartslist=listofparts;
                FileWriter fw = new FileWriter(f.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                while(!thepartslist.isEmpty()){
                    bw.write(thepartslist.remove(0)+"\n");
                }
                bw.write("|");
                bw.close();
                Parts.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(Units.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        root.getChildren().add(addpart);
        
        ComboBox chooseunit = new ComboBox(units);
        chooseunit.setLayoutX(100);
        chooseunit.setLayoutY(200);
        chooseunit.setMaxWidth(145);
        root.getChildren().add(chooseunit);
        
        Text currentunitcountinfo=new Text();
        currentunitcountinfo.setText("unitcount");
        currentunitcountinfo.setLayoutX(250);
        currentunitcountinfo.setLayoutY(190);
        root.getChildren().add(currentunitcountinfo);
        
        TextField currentunitcount=new TextField();
        currentunitcount.setLayoutX(250);
        currentunitcount.setLayoutY(200);
        root.getChildren().add(currentunitcount);
        
        Button addunit = new Button();
        addunit.setText("addunit");
        addunit.setLayoutX(400);
        addunit.setLayoutY(260);
        addunit.setOnAction((ActionEvent event) -> {
            String[] stats=chooseunit.getValue().toString().split(" ");
            String currentunit=stats[0]+" "+currentunitcount.getText();
            currentunits.add(currentunit);
        });
        root.getChildren().add(addunit);
        
        
        ListView unitslist=new ListView();
        unitslist.setItems(currentunits);
        unitslist.setLayoutX(100);
        unitslist.setLayoutY(235);
        unitslist.setMaxHeight(200);
        root.getChildren().add(unitslist);
        
        ListView partslist=new ListView();
        partslist.setItems(listofparts);
        partslist.setLayoutX(500);
        root.getChildren().add(partslist);
        
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
