package plotter.function;

public interface PFunction {
	
	// Returns the number of parameters
	int getNParams();
	
	// Sets the value of the i-th parameter to val. Enumeration starts at 0.
	void setParam(int i, double val);
	
	// Returns the current value of the i-th parameter
	double getParam(int i);
	
	// Returns the name of the i-th parameter
	String getParamName(int i);
	
	// Returns the value of this function on the argument x
	double eval(double x);
}
