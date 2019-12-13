package plotter;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class GraphOptionsWindow extends JFrame {
	
	private GraphOptionsWindow() {
		setTitle("GraphOptionsWindow");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
	}
	
	public GraphOptionsWindow(GraphOptionsView customView) {
		this();
		add(customView, BorderLayout.CENTER);
		pack();
	}
}
