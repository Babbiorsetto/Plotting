package function;

public class CrazyFunction implements PFunction {

	private static final int N_PARAMS = 2;
	private double[] param = new double[N_PARAMS];
	private String[] paramNames = new String[N_PARAMS];
	
	public CrazyFunction() {
		paramNames[0] = "a";
		paramNames[1] = "b";
	}
	
	@Override
	public int getNParams() {
		return N_PARAMS;
	}

	@Override
	public void setParam(int i, double val) {
		param[i] = val;
	}

	@Override
	public double getParam(int i) {
		return param[i];
	}

	@Override
	public String getParamName(int i) {
		return paramNames[i];
	}

	@Override
	public double eval(double x) {
		return param[0] * Math.sin(x) + param[1] * x;
	}

}
