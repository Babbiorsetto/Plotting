package plotter;

public class LogarithmicFunction extends FunctionModel {

	private static final int N_PARAMS = 1;
	private double param;
	private String paramName;
	
	public LogarithmicFunction() {
		paramName = "a";
	}
	
	@Override
	public int getNParams() {
		return N_PARAMS;
	}

	@Override
	public void setParam(int i, double val) {
		if (i != 0 ) {
			throw new IllegalArgumentException();
		}
		param = val;
		setChanged();
		notifyObservers();
	}

	@Override
	public double getParam(int i) {
		return param;
	}

	@Override
	public String getParamName(int i) {
		return paramName;
	}

	@Override
	public double eval(double x) {
		return param * Math.log(x);
	}

}
