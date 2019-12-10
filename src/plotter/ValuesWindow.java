package plotter;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;

import plotter.function.FunctionModel;

public class ValuesWindow extends JFrame {
	
	private ValuesWindow() {
		setTitle("ValuesWindow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
	}
	
	public ValuesWindow(FunctionModel model) {
		this();
		ValuesView view = new ValuesView(model);
		add(view, BorderLayout.CENTER);
		pack();
	}
	
	public ValuesWindow(ValuesView customView) {
		this();
		add(customView, BorderLayout.CENTER);
		pack();
	}

}
