package plotter;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class PlotWindow extends JFrame {
	
	private PlotWindow() {
		setTitle("PlotWindow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));	
	}
	
	public PlotWindow(FunctionModel model) {
		this();
		PlotView view = new PlotView(model);
		add(view);
		pack();
	}
	
	public PlotWindow(PlotView customView) {
		this();
		add(customView);
		pack();
	}

}
