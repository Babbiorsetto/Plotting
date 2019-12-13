package plotter;

import java.util.EventListener;

public interface GraphOptionsChangeListener extends EventListener {
	
	public void GraphOptionsChangeHappened(GraphOptionsChangeEvent evt);

}
