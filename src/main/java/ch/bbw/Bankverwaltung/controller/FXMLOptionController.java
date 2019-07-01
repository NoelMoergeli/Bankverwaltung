package ch.bbw.Bankverwaltung.controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import ch.bbw.Bankverwaltung.User;
import ch.bbw.Bankverwaltung.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public class  FXMLOptionController  implements Initializable {

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
    private Label lbIhreOptionen;

    @FXML
    private Button btZahlungen;

    @FXML
    private Button btKontoauszug;

    @FXML
    private ImageView imgSchweiz;
    
    @FXML
    private Button btAusloggen;
    
	private ViewLoader viewLoader = new ViewLoader();
    private User user;
    
    @FXML
	void handleBtZahlungen(ActionEvent event) {
    	btZahlungen.getScene().getWindow().hide();
		viewLoader.loadBalance(user);
    }
    @FXML
	void handleBtKontoauszug(ActionEvent event) {
    	btKontoauszug.getScene().getWindow().hide();
		viewLoader.loadPayment(user);
    }
    @FXML
	void handleBtAusloggen(ActionEvent event) {
    	btAusloggen.getScene().getWindow().hide();
		viewLoader.loadMain(user);
    }
    
    @Override
  	public void initialize(URL url, ResourceBundle rb) {
  		// TODO
  	}
    
    public void initController(User user) {
    	this.user = user;
    }
    
}
