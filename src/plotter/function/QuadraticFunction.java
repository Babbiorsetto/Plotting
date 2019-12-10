package plotter.function;

import java.util.Arrays;
import java.util.Observable;

public class QuadraticFunction extends FunctionModel {
	
	private static final String PARAMETER_NAME_NULL_MESSAGE = "I nomi delle variabili non possono essere null";
	private static final int N_PARAMS = 3;
	private double[] param = new double[N_PARAMS];
	private String[] paramNames = new String[N_PARAMS];

	public QuadraticFunction() {
		paramNames[0] = "a";
		paramNames[1] = "b";
		paramNames[2] = "c";
	}
	
	public QuadraticFunction(double[] params, String[] names) {
		this.param = Arrays.copyOf(params, N_PARAMS);
		
		for (int i = 0; i < names.length; i++) {
			String s = names[i];
			if (s != null) {
				paramNames[i] = s;
			} else {
				throw new IllegalArgumentException(PARAMETER_NAME_NULL_MESSAGE);
			}
		}
	}
	
	@Override
	public int getNParams() {
		return N_PARAMS;
	}

	@Override
	public void setParam(int i, double val) {
		if (i < N_PARAMS) {
			param[i] = val;
			setChanged();
			notifyObservers();
		} else {
			throw new IllegalArgumentException();
			//TODO justify exception
		}
	}

	@Override
	public double getParam(int i) {
		if (i < N_PARAMS) {
			return param[i];			
		} else {
			throw new IllegalArgumentException();
			//TODO justify exception
		}
	}

	@Override
	public String getParamName(int i) {
		if (i < N_PARAMS) {
			return paramNames[i];
		} else {
			throw new IllegalArgumentException();
			//TODO justify exception
		}
	}

	@Override
	public double eval(double x) {
		return param[0] * Math.pow(x, 2) + param[1] * x + param[2];
	}

}
