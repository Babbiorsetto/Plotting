package plotter;

import java.util.EventObject;

public class ParameterChangeEvent extends EventObject {
	
	private int id;
	private double value;
	
	public ParameterChangeEvent(Object source, int id, double newValue) {
		super(source);
		this.id = id;
		this.value = newValue;
	}

	public int getId() {
		return id;
	}

	public double getValue() {
		return value;
	}

}
