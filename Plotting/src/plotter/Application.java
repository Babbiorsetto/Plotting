package plotter;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Application {
	
	public static void main(String[] args) {
		EventQueue.invokeLater( () -> {
			// FunctionModel model = new QuadraticFunction();
			// FunctionModel model = new LogarithmicFunction();
			// FunctionModel model = new AbsoluteFunction();
			FunctionModel model = new CrazyFunction();
			
			JFrame c, p, v;
			Toolkit tk = Toolkit.getDefaultToolkit();
		    Dimension screenSize = tk.getScreenSize();
		    int screenHeight = screenSize.height;
		    int screenWidth = screenSize.width;
			
			c = new ControlsWindow(model);
			c.setLocation(screenWidth * 4 / 6, (screenHeight / 2) - (c.getHeight()));
			c.setVisible(true);
			
			p = new PlotWindow(model);
			p.setLocation( (screenWidth / 2) - p.getWidth() / 2, (screenHeight / 2) - p.getHeight() / 2);
			p.setVisible(true);
			// new PlotWindow(new PlotView(model, -50, 60, 5, 10)).setVisible(true);;
			
			v = new ValuesWindow(model);
			v.setLocation(c.getLocation().x, c.getLocation().y - v.getHeight());
			v.setVisible(true);
			// new ValuesWindow(new ValuesView(model, -50, 60, 5)).setVisible(true);

		});

	}

}
