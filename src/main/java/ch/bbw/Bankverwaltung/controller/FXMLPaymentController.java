package ch.bbw.Bankverwaltung.controller;

import java.net.URL;
import java.util.ResourceBundle;

import ch.bbw.Bankverwaltung.Movement;
import ch.bbw.Bankverwaltung.User;
import ch.bbw.Bankverwaltung.ViewLoader;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public class FXMLPaymentController  implements Initializable{

    @FXML
    private Label label;

    @FXML
    private Label lbTitel;

    @FXML
    private ImageView imgBild;

    @FXML
    private Line LTopLine;

    @FXML
    private Label lbCopyright;

    @FXML
    private Label lbFehler;

    @FXML
    private Label lbKontoauszug;

    @FXML
    private ListView<Movement> lvAuszuge;

    @FXML
    private Label lbKontobewegung;

    @FXML
    private Button btEintragLöschen;

    @FXML
    private Button btVerlaufLöschen;

    @FXML
    private ImageView imgMatterhorn;
    
    @FXML
    private Button btAusloggen;
    
	@FXML
	private Button btZuruck;
    
	private ViewLoader viewLoader = new ViewLoader();
	private Movement movement;
	ObservableList<Movement> movements = FXCollections.observableArrayList();
    private User user;
    
    @FXML 
	void handleBtAusloggen(ActionEvent event) {
    	btAusloggen.getScene().getWindow().hide();
		viewLoader.loadMain(user);
    }
    
    @FXML
	void handleBtZuruck(ActionEvent event) {
		btZuruck.getScene().getWindow().hide();
		viewLoader.loadOptionDialog(user);
	}
    
    @FXML
   	void handleBtDeleteSingle(ActionEvent event) {
    	movement = lvAuszuge.getSelectionModel().getSelectedItem();
    	user.removeMovement(movement);
       }
    
    @FXML 
   	void handleBtDeleteAll(ActionEvent event) {
       	user.removeAll();
       }

    @Override
	public void initialize(URL url, ResourceBundle rb) {    	

	}
    public void initController(User user) {
    	this.user = user;
    	
    	movements = (ObservableList<Movement>) user.getAuszuge();
    	lvAuszuge.setItems(movements);
    }
}
