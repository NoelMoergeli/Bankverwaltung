package ch.bbw.Bankverwaltung;

import java.io.IOException;

import ch.bbw.Bankverwaltung.controller.FXMLBalanceController;
import ch.bbw.Bankverwaltung.controller.FXMLController;
import ch.bbw.Bankverwaltung.controller.FXMLOptionController;
import ch.bbw.Bankverwaltung.controller.FXMLPaymentController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ViewLoader {
	public void loadOptionDialog(User user) {

		// Create FXMLLoader
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene2.fxml"));

		// Create new Stage
		Stage stage = new Stage();

		// Try to load Scene
		try {
			stage.setScene(new Scene((Pane) loader.load()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// load controller
		FXMLOptionController controller = loader.<FXMLOptionController>getController();

		// Initialize Controller
		controller.initController(user);

		stage.show();

	}
	
	public void loadBalance(User user) {

		// Create FXMLLoader
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene3.fxml"));

		// Create new Stage
		Stage stage = new Stage();

		// Try to load Scene
		try {
			stage.setScene(new Scene((Pane) loader.load()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// load controller
		FXMLBalanceController controller = loader.<FXMLBalanceController>getController();

		// Initialize Controller
		controller.initController(user);

		stage.show();

	}
	
	public void loadPayment(User user) {

		// Create FXMLLoader
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene4.fxml"));

		// Create new Stage
		Stage stage = new Stage();

		// Try to load Scene
		try {
			stage.setScene(new Scene((Pane) loader.load()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// load controller
		FXMLPaymentController controller = loader.<FXMLPaymentController>getController();

		// Initialize Controller
		controller.initController(user);

		stage.show();

	}
	public void loadMain(User user) {

		// Create FXMLLoader
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene.fxml"));

		// Create new Stage
		Stage stage = new Stage();

		// Try to load Scene
		try {
			stage.setScene(new Scene((Pane) loader.load()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// load controller
		FXMLController controller = loader.<FXMLController>getController();

		// Initialize Controller
		controller.mainController(user);

		stage.show();

	}
}
