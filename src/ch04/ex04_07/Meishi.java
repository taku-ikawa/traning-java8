package ch04.ex04_07;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Meishi {

	private String name;
	private StringProperty nameP;
	public final StringProperty nameProperty() {
		if(nameP == null) {
			nameP =  new SimpleStringProperty(name);
		}
		return nameP;
	}
	public final void setName(String newValue) {
		if(nameP != null) {
			nameP.set(newValue);
		}else {
			name = newValue;
		}
	}
	public final String getName() {
		if(nameP != null) {
			return nameP.get();
		}else {
			return name;
		}
	}

	private String shozoku;
	private StringProperty shozokuP = null;
	public final StringProperty shozokuProperty() {
		if(shozokuP == null) {
			shozokuP =  new SimpleStringProperty("");
		}
		return shozokuP;
	}
	public final void setShozoku(String newValue) {
		if(shozokuP != null) {
			shozokuP.set(newValue);
		}else {
			shozoku = newValue;
		}
	}
	public final String getShozoku() {
		if(shozokuP != null) {
			return shozokuP.get();
		}else {
			return shozoku;
		}
	}

	private String tel;
	private StringProperty telP = null;
	public final StringProperty telProperty() {
		if(telP == null) {
			telP =  new SimpleStringProperty("");
		}
		return telP;
	}
	public final void setTel(String newValue) {
		if(telP != null) {
			telP.set(newValue);
		}else {
			tel = newValue;
		}
	}
	public final String getTel() {
		if(telP != null) {
			return telP.get();
		}else {
			return tel;
		}
	}


}
