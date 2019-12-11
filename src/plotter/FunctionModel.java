package plotter;

import java.util.Observable;

import function.PFunction;

public class FunctionModel extends Observable {
	
	PFunction function;
	
	public FunctionModel(PFunction function) {
		this.function = function;
	}

	public void setParam(int id, double value) {
		function.setParam(id, value);
		setChanged();
		notifyObservers();
	}

	public int getNParams() {
		return function.getNParams();
	}

	public double eval(double xValue) {
		return function.eval(xValue);
	}

	public String getParamName(int id) {
		return function.getParamName(id);
	}

	public double getParam(int id) {
		return function.getParam(id);
	}
	
	public void setFunction(PFunction function) {
		this.function = function;
	}
	
	
}
