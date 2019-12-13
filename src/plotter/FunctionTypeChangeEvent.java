package plotter;

import java.util.EventObject;

public class FunctionTypeChangeEvent extends EventObject {

	private FunctionType function;
	
	public FunctionTypeChangeEvent(Object source, FunctionType function) {
		super(source);
		this.function = function;
	}
	
	public FunctionType getFunction() {
		return function;
	}

}
