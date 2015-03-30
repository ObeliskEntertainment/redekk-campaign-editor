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
public class Units {
    static public void start(Stage primaryStage) throws IOException {
        Pane root = new Pane();
        ObservableList<String> listofunits=FXCollections.observableArrayList();
        
        Button level = new Button();
        level.setText("levels");
        level.setLayoutY(0);
        level.setLayoutX(0);
        level.setOnAction((ActionEvent event) -> {
            try {
                Levels.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(Units.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        root.getChildren().add(level);
        
        Button ship = new Button();
        ship.setText("ships");
        ship.setLayoutY(30);
        ship.setLayoutX(0);
        ship.setOnAction((ActionEvent event) -> {
            try {
                Ships.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(Units.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        root.getChildren().add(ship);
        
        Button part = new Button();
        part.setText("parts");
        part.setLayoutY(60);
        part.setLayoutX(0);
        part.setOnAction((ActionEvent event) -> {
            try {
                Parts.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(Units.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        root.getChildren().add(part);
        
        Button unit = new Button();
        unit.setText("units");
        unit.setLayoutY(90);
        unit.setLayoutX(0);
        unit.setOnAction((ActionEvent event) -> {
        });
        root.getChildren().add(unit);
        
        Button exit = new Button();
        exit.setText("exit");
        exit.setLayoutY(120);
        exit.setLayoutX(0);
        exit.setOnAction((ActionEvent event) -> {
            primaryStage.close();
        });
        root.getChildren().add(exit);
        
        
        Path path = FileSystems.getDefault().getPath("resource", "units.redekk");
        BufferedReader reader= Files.newBufferedReader(path, StandardCharsets.UTF_8);
        String str=reader.readLine();
        while(!str.equals("|")){
            listofunits.add(str);
            str=reader.readLine();
        }
        reader.close();
        
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
        
        Text hpinfo=new Text();
        hpinfo.setText("hp");
        hpinfo.setLayoutX(100);
        hpinfo.setLayoutY(55);
        root.getChildren().add(hpinfo);
        
        TextField hp=new TextField();
        hp.setLayoutX(100);
        hp.setLayoutY(65);
        root.getChildren().add(hp);
        
        Text staminainfo=new Text();
        staminainfo.setText("stamina");
        staminainfo.setLayoutX(250);
        staminainfo.setLayoutY(55);
        root.getChildren().add(staminainfo);
        
        TextField stamina=new TextField();
        stamina.setLayoutX(250);
        stamina.setLayoutY(65);
        root.getChildren().add(stamina);
        
        Text sizeinfo=new Text();
        sizeinfo.setText("size");
        sizeinfo.setLayoutX(100);
        sizeinfo.setLayoutY(100);
        root.getChildren().add(sizeinfo);
        
        TextField size=new TextField();
        size.setLayoutX(100);
        size.setLayoutY(110);
        root.getChildren().add(size);
        
        Text armortypeinfo=new Text();
        armortypeinfo.setText("armortype");
        armortypeinfo.setLayoutX(250);
        armortypeinfo.setLayoutY(100);
        root.getChildren().add(armortypeinfo);
        
        String[] items={"basic","medium","heavy","solid","magic","biological"};
        ObservableList<String> armors=FXCollections.observableArrayList(items);
        ComboBox armortype=new ComboBox(armors);
        armortype.setLayoutX(250);
        armortype.setLayoutY(110);
        armortype.setMaxWidth(200);
        root.getChildren().add(armortype);
        
        Text armorinfo=new Text();
        armorinfo.setText("armor");
        armorinfo.setLayoutX(100);
        armorinfo.setLayoutY(145);
        root.getChildren().add(armorinfo);
        
        TextField armor=new TextField();
        armor.setLayoutX(100);
        armor.setLayoutY(155);
        root.getChildren().add(armor);
        
        Text resistanceinfo=new Text();
        resistanceinfo.setText("resistance");
        resistanceinfo.setLayoutX(250);
        resistanceinfo.setLayoutY(145);
        root.getChildren().add(resistanceinfo);
        
        TextField resistance=new TextField();
        resistance.setLayoutX(250);
        resistance.setLayoutY(155);
        root.getChildren().add(resistance);
        
        Text rangeddmginfo=new Text();
        rangeddmginfo.setText("rangeddmg");
        rangeddmginfo.setLayoutX(100);
        rangeddmginfo.setLayoutY(190);
        root.getChildren().add(rangeddmginfo);
        
        TextField rangeddmg=new TextField();
        rangeddmg.setLayoutX(100);
        rangeddmg.setLayoutY(200);
        root.getChildren().add(rangeddmg);
        
        Text rangedtypeinfo=new Text();
        rangedtypeinfo.setText("rangedtype");
        rangedtypeinfo.setLayoutX(250);
        rangedtypeinfo.setLayoutY(190);
        root.getChildren().add(rangedtypeinfo);
        
        String[] tools={"magic","kinetic","laser","plasma"};
        ObservableList<String> tooltypes=FXCollections.observableArrayList(tools);
        ComboBox rangedtype=new ComboBox(tooltypes);
        rangedtype.setLayoutX(250);
        rangedtype.setLayoutY(200);
        root.getChildren().add(rangedtype);
        
        Text rangeinfo=new Text();
        rangeinfo.setText("range");
        rangeinfo.setLayoutX(100);
        rangeinfo.setLayoutY(235);
        root.getChildren().add(rangeinfo);
        
        TextField range=new TextField();
        range.setLayoutX(100);
        range.setLayoutY(245);
        root.getChildren().add(range);
        
        Text meleedmginfo=new Text();
        meleedmginfo.setText("meleedmg");
        meleedmginfo.setLayoutX(250);
        meleedmginfo.setLayoutY(235);
        root.getChildren().add(meleedmginfo);
        
        TextField meleedmg=new TextField();
        meleedmg.setLayoutX(250);
        meleedmg.setLayoutY(245);
        root.getChildren().add(meleedmg);
        
        Text meleetypeinfo=new Text();
        meleetypeinfo.setText("meleetype");
        meleetypeinfo.setLayoutX(100);
        meleetypeinfo.setLayoutY(280);
        root.getChildren().add(meleetypeinfo);
        
        ComboBox meleetype=new ComboBox(tooltypes);
        meleetype.setLayoutX(100);
        meleetype.setLayoutY(290);
        root.getChildren().add(meleetype);
        
        File f=path.toFile();
        Button addunit = new Button();
        addunit.setText("add");
        addunit.setLayoutX(250);
        addunit.setLayoutY(290);
        addunit.setOnAction((ActionEvent event) -> {
            try {
                String stats=type.getText()+" "+name.getText()+" "+hp.getText()+" "+stamina.getText()
                        +" "+size.getText()+" "+armortype.getValue().toString()+" "+armor.getText()+" "+resistance.getText()
                        +" "+rangeddmg.getText()+" "+rangedtype.getValue().toString()+" "+range.getText()
                        +" "+meleedmg.getText()+" "+meleetype.getValue().toString();
                listofunits.add(stats);
                ObservableList<String> theunitslist=listofunits;
                FileWriter fw = new FileWriter(f.getAbsoluteFile());
                BufferedWriter bw = new BufferedWriter(fw);
                while(!theunitslist.isEmpty()){
                    bw.write(theunitslist.remove(0)+"\n");
                }
                bw.write("|");
                bw.close();
                Units.start(primaryStage);
            } catch (IOException ex) {
                Logger.getLogger(Units.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        root.getChildren().add(addunit);
        
        
        
        ListView unitslist=new ListView();
        unitslist.setItems(listofunits);
        unitslist.setLayoutX(500);
        root.getChildren().add(unitslist);
        
        Scene scene = new Scene(root, 800, 500);
        
        primaryStage.setTitle("campaign editor");
        primaryStage.setScene(scene);
        primaryStage.show();
     }
}
