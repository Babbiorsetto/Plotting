package function;

public class AbsoluteFunction implements PFunction {

	private double param;
	private String name = "a";
	
	AbsoluteFunction() {
		
	}
	
	@Override
	public int getNParams() {
		return 1;
	}

	@Override
	public void setParam(int i, double val) {
		param = val;
	}

	@Override
	public double getParam(int i) {
		return param;
	}

	@Override
	public String getParamName(int i) {
		return name;
	}

	@Override
	public double eval(double x) {
		return param * Math.abs(x);
	}

}
