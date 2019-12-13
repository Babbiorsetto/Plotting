package plotter;

public class GraphOptionsController implements GraphOptionsChangeListener {

	private GraphOptionsView graphOptionsView;
	private PlotModel plotModel;
	
	public GraphOptionsController(GraphOptionsView graphOptionsView, PlotModel plotModel) {
		this.graphOptionsView = graphOptionsView;
		graphOptionsView.addGraphOptionsChangeListener(this);
		this.plotModel = plotModel;
	}

	@Override
	public void GraphOptionsChangeHappened(GraphOptionsChangeEvent evt) {
		plotModel.setStartX(evt.getStartX());
		plotModel.setEndX(evt.getEndX());
		plotModel.setStep(evt.getStep());
		plotModel.setGraduationStep(evt.getGraduationStep());
	}
	
}
