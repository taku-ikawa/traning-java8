package ch04.ex04_02;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Greeting {

	private String text;
	private StringProperty textP = null;
	public final StringProperty textProperty() {
		if(textP == null) {
			textP =  new SimpleStringProperty("");
		}
		System.out.println("プロパティ生成");
		return textP;
	}
	public final void setText(String newValue) {
		if(textP != null) {
			textP.set(newValue);
		}else {
			text = newValue;
		}

	}
	public final String getText() {
		if(textP != null) {
			return textP.get();
		}else {
			return text;
		}

	}

}
