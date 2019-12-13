package plotter;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;

import function.CrazyFunction;
import function.FunctionFactory;
import function.PFunction;

public class Application {
	
	public static void main(String[] args) {
		EventQueue.invokeLater( () -> {
			JFrame c, p, v, g;
			Toolkit tk = Toolkit.getDefaultToolkit();
			Dimension screenSize = tk.getScreenSize();
			int screenHeight = screenSize.height;
			int screenWidth = screenSize.width;

			PFunction fun = FunctionFactory.getFunctionByType(FunctionType.CRAZY);
			FunctionModel functionModel = new FunctionModel(fun);
			PlotModel plotModel = new PlotModel();
			
		    ParameterControlsView pcv = new ParameterControlsView(functionModel);
		    ParameterControlsController pcc = new ParameterControlsController(pcv, functionModel);
		    ValuesView vv = new ValuesView(functionModel);
		    PlotView pv = new PlotView(functionModel, plotModel);
		    GraphOptionsView gov = new GraphOptionsView(plotModel, functionModel);
		    GraphOptionsController goc = new GraphOptionsController(gov, plotModel);
		    FunctionTypeController ftc = new FunctionTypeController(gov, functionModel);
		    
			c = new ParameterControlsWindow(pcv);
			c.setLocation(screenWidth * 4 / 6, (screenHeight / 2) - (c.getHeight()));
			c.setVisible(true);
			
			p = new PlotWindow(pv);
			p.setLocation( (screenWidth / 2) - p.getWidth() / 2, (screenHeight / 2) - p.getHeight() / 2);
			p.setVisible(true);
			
			v = new ValuesWindow(vv);
			v.setLocation(c.getLocation().x, c.getLocation().y - v.getHeight());
			v.setVisible(true);
			
			g = new GraphOptionsWindow(gov);
			g.setLocation(p.getLocation().x, p.getLocation().y + p.getHeight());
			g.setVisible(true);

		});
		// TODO aggiusta tutti i modelli in modo che non accettino di essere impostati a valori impossibili
		// TODO pensa se è il caso di rendere le funzioni singleton

	}

}
