package function;

public interface PFunction {
	
	/**
	 * @return the number of parameters of this function
	 */
	int getNParams();
	
	/**
	 * Sets the value of the i-th parameter to val. Enumeration starts at 0.
	 * @param i a number 0 <= i < NParams
	 * @param val
	 */
	void setParam(int i, double val);
	
	/**
	 * @param i
	 * @return the current value of the i-th parameter.
	 */
	double getParam(int i);
	
	/**
	 * @param i
	 * @return the name of the i-th parameter
	 */
	String getParamName(int i);
	
	// Returns 
	/**
	 * @param x
	 * @return the value of this function for argument x.
	 */
	double eval(double x);
}
