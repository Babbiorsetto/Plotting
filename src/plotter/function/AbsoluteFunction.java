package plotter.function;

public class AbsoluteFunction extends FunctionModel {

	private double param;
	private String name = "a";
	
	@Override
	public int getNParams() {
		return 1;
	}

	@Override
	public void setParam(int i, double val) {
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
		return name;
	}

	@Override
	public double eval(double x) {
		// TODO
		return param * Math.abs(x);
	}

}
