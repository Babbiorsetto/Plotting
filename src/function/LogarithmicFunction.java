package function;

public class LogarithmicFunction implements PFunction {

	private static final int N_PARAMS = 1;
	private double param;
	private String paramName;
	
	LogarithmicFunction() {
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
