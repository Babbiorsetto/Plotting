package plotter;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import plotter.function.FunctionModel;

public class ValuesView extends JPanel implements Observer {

	private static final double DEFAULT_START_X = -3.0;
	private static final double DEFAULT_END_X = 3.0;
	private static final double DEFAULT_STEP = 0.5;
	private FunctionModel model;
	private List<ValueRow> rows = new LinkedList<>();
	
	public ValuesView(FunctionModel model) {
		this(model, DEFAULT_START_X, DEFAULT_END_X, DEFAULT_STEP);
	}
	
	public ValuesView(FunctionModel model, double startX, double endX, double step) {
		this.model = model;
		model.addObserver(this);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new Intestazione());
		
		for (double d = startX; d < endX; d += step) {
			ValueRow v = new ValueRow(d);
			rows.add(v);
			add(v);
		}
		
	}
	
	private class ValueRow extends JPanel {
		
		private double xValue;
		private JLabel yValue = new JLabel();
		
		public ValueRow(double xValue) {
			this.xValue = xValue;
			this.yValue.setText(model.eval(xValue) + "");
			
			setLayout(new GridLayout());
			add(new JLabel(xValue + ""));
			add(yValue);
		}
		
		public void updateLabel() {
			yValue.setText(model.eval(xValue) + "");
		}

		@Override
		public Dimension getPreferredSize() {
			Dimension prev = super.getPreferredSize();
			return new Dimension(250, prev.height);
		}
				
		
	}
	
	private class Intestazione extends JPanel {
		
		public Intestazione() {
			setLayout(new GridLayout());
			add(new JLabel("x"));
			add(new JLabel("y"));
		}
	}
	
	@Override
	public void update(Observable o, Object arg) {
		for (ValueRow row : rows) {
			row.updateLabel();
		}
		
	}

}
