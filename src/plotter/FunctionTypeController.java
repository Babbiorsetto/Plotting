package plotter;

import function.FunctionFactory;

public class FunctionTypeController implements FunctionTypeChangeListener {

	private GraphOptionsView view;
	private FunctionModel functionModel;
	
	public FunctionTypeController(GraphOptionsView view, FunctionModel functionModel) {
		this.view = view;
		view.addFunctionTypeChangeListener(this);
		this.functionModel = functionModel;
	}

	@Override
	public void functionTypeChangeHappened(FunctionTypeChangeEvent evt) {
		functionModel.setFunction(FunctionFactory.getFunctionByType(evt.getFunction()));
	}

}
