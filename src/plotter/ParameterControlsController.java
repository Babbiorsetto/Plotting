package plotter;

public class ParameterControlsController implements ParameterChangeListener {

	private ParameterControlsView view;
	private FunctionModel model;
	
	public ParameterControlsController(ParameterControlsView view, FunctionModel model) {
		this.view = view;
		this.model = model;
		view.addParameterChangeListener(this);
	}
	
	@Override
	public void ParameterChangeHappened(ParameterChangeEvent evt) {
		model.setParam(evt.getId(), evt.getValue());
	}

}
