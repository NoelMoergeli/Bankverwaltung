package ch.bbw.Bankverwaltung;

public class Movement {

	private String text;

	public Movement(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return  text;
	}
	
	
}
