package plotter;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class ParameterControlsWindow extends JFrame {

	public ParameterControlsWindow(FunctionModel model) {
		
		setTitle("ControlWindow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		ParameterControlsView pcv = new ParameterControlsView(model);
		ParameterControlsController pcc = new ParameterControlsController(pcv, model);
		add(pcv);
		
		pack();
		setResizable(false);
	}

}