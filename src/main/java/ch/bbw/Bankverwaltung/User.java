package ch.bbw.Bankverwaltung;

import java.util.List;

import javafx.collections.ObservableList;

public class User {

	private String username;
	private String password;
	private Double balance;
	private List<Movement> auszuge;
	
	public User(String username, String password, Double balance, ObservableList<Movement> auszuge) {
		super();
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.auszuge = auszuge;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public List<Movement> getAuszuge() {
		return auszuge;
	}
	public void addMovement(Movement movement) {
		this.auszuge.add(movement);
	}
	public void removeMovement(Movement movement) {
		this.auszuge.remove(movement);
	}
	public void removeAll() {
		this.auszuge.removeAll(auszuge);
	}
}
