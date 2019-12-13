package plotter;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

public enum FunctionType {

	ABSOLUTE("Absolute"),
	CRAZY("Crazy"),
	LOGARITHMIC("Logarithmic"),
	QUADRATIC("Quadratic");
	
	private String name;
	
	private FunctionType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
