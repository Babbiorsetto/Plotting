package plotter;

import java.util.EventListener;

public interface ParameterChangeListener extends EventListener {
	
	public void ParameterChangeHappened(ParameterChangeEvent evt);

}
