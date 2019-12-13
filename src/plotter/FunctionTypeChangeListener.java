package plotter;

import java.util.EventListener;

public interface FunctionTypeChangeListener extends EventListener {
	
	public void functionTypeChangeHappened(FunctionTypeChangeEvent evt);
}
