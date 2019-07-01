package ch.bbw.Bankverwaltung.controller;

import java.io.IOException;
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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public class FXMLController implements Initializable {

	@FXML
	private Label label;

	@FXML
	private Label lbTitel;

	@FXML
	private ImageView imgBild;

	@FXML
	private Line LTopLine;

	@FXML
	private Label lbAnmelden;

	@FXML
	private TextField tfBenutzernameA;

	@FXML
	private Label lbBenutzernameA;

	@FXML
	private Label lbPasswortA;

	@FXML
	private TextField tfPasswortA;

	@FXML
	private TextField tfPasswortR;

	@FXML
	private Label lbPasswortR;

	@FXML
	private Label lbBenutzernameR;

	@FXML
	private TextField tfBenutzernameR;

	@FXML
	private Label lbRegistrieren;

	@FXML
	private Button btAnmelden;

	@FXML
	private Button btRegistrieren;

	@FXML
	private Label lbCopyright;

	@FXML
	private Label lbFehler;

	private ViewLoader viewLoader = new ViewLoader();
	private User newUser;
	private User user;
	private ObservableList<Movement> auszuge = FXCollections.observableArrayList();

	@FXML
	void handleBtAnmelden(ActionEvent event) throws IOException {
		lbFehler.setText("");

		if (null == user) {
			System.out.println("null");
			lbFehler.setText("Benutzer existiert nicht. Registrieren sie sich.");
		} else if (user.getUsername().equals(tfBenutzernameA.getText())
				&& user.getPassword().equals(tfPasswortA.getText())) {
			newUser = user;

			btAnmelden.getScene().getWindow().hide();
			viewLoader.loadOptionDialog(newUser);

		} else {
			lbFehler.setText("Benutzername oder Passwort stimmt nicht überein");

		}

	}

	@FXML
	void handleBtRegistrieren(ActionEvent event) {
		lbFehler.setText("");
		
		System.out.println("Benutzername: " + tfBenutzernameR.getText() + " Passwort: " + tfPasswortR.getText());

		if (tfBenutzernameR.getText().isEmpty() || tfPasswortR.getText().isEmpty()) {
			lbFehler.setText("Geben Sie bitte einen Namen und ein Passwort an.");
		} else {
			newUser = new User(tfBenutzernameR.getText(), tfPasswortR.getText(), 0.0, auszuge);

			btRegistrieren.getScene().getWindow().hide();
			viewLoader.loadOptionDialog(newUser);
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	public void mainController(User user) {
		this.user = user;

	}
}
