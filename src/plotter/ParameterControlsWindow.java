package plotter;

import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

public class ParameterControlsWindow extends JFrame {

	public ParameterControlsWindow(ParameterControlsView customView) {
		
		setTitle("ControlWindow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		add(customView);
		pack();
		setResizable(true);
	}

}