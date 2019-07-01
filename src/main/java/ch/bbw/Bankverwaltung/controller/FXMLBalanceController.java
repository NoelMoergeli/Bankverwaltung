package ch.bbw.Bankverwaltung.controller;

import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

import ch.bbw.Bankverwaltung.Movement;
import ch.bbw.Bankverwaltung.User;
import ch.bbw.Bankverwaltung.ViewLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public class FXMLBalanceController implements Initializable {

	@FXML
	private Label label;

	@FXML
	private Label lbTitel;

	@FXML
	private ImageView imgBild;

	@FXML
	private Line LTopLine;

	@FXML
	private Label lbIhrGuthaben;

	@FXML
	private Label lbCopyright;

	@FXML
	private Label lbFehler;

	@FXML
	private Label lbGuthabenZahl;

	@FXML
	private Label lbText1;

	@FXML
	private TextField tfBetrag;

	@FXML
	private Label lbText2;

	@FXML
	private Label lbText3;

	@FXML
	private Button btEinzahlen;

	@FXML
	private Label lbText4;

	@FXML
	private Button btAuszahlen;

	@FXML
	private Button btZuruck;

	@FXML
	private Label lbText5;

	@FXML
	private Label lbIhrGuthaben1;

	@FXML
	private Line LTopLine1;

	@FXML
	private Button btAusloggen;

	private User user;
	private ViewLoader viewLoader = new ViewLoader();
	private Double newBalance;
	private Double textBalance;
	private Double userBalance;
	private Movement movement;

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
	void handleBtAuszahlen(ActionEvent event) {
		lbFehler.setText("");

		if (tfBetrag.getText().isEmpty()) {
			lbFehler.setText("Geben Sie bitte einen Betrag an.");
		} else {
			if (isNumeric(tfBetrag.getText())) {
				userBalance = user.getBalance();
				textBalance = Double.parseDouble(tfBetrag.getText());
				newBalance = userBalance - textBalance;
				if (newBalance < 0.0) {
					lbFehler.setText("Ihr guthaben ist zu klein (" + userBalance + " Fr.)");
				} else {
					user.setBalance(newBalance);
					lbGuthabenZahl.setText(user.getBalance().toString());
					movement = new Movement("");
					movement.setText("Es wurden " + textBalance + " Fr. abgehoben.");
					user.addMovement(movement);

				}
			}else {
				lbFehler.setText("Geben Sie bitte einen numerischen Betrag an.");
			}
		}
	}

	@FXML
	void handleBtEinzahlen(ActionEvent event) {
		lbFehler.setText("");

		if (tfBetrag.getText().isEmpty()) {
			lbFehler.setText("Geben Sie bitte einen Betrag an.");
		} else {
			if (isNumeric(tfBetrag.getText())) {

				userBalance = user.getBalance();
				textBalance = Double.parseDouble(tfBetrag.getText());
				newBalance = userBalance + textBalance;

				user.setBalance(newBalance);
				lbGuthabenZahl.setText(user.getBalance().toString());
				movement = new Movement("");
				movement.setText("Es wurden " + textBalance + " Fr. eingezahlt.");
				user.addMovement(movement);
			} else {
				lbFehler.setText("Geben Sie bitte einen numerischen Betrag an.");
			}

		}
		
	}

	public static boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {

	}

	public void initController(User user) {
		this.user = user;
		lbGuthabenZahl.setText(user.getBalance().toString());
	}

}
