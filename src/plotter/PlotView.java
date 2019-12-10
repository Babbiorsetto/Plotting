package plotter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class PlotView extends JPanel implements Observer {

	private static final int WIDTH = 400, HEIGHT = 300;
	
	// x value to start plotting from
	private double startX = -10.0;
	// x value to stop plotting at
	private double endX = 10.0;
	// x value increase between plotting samples, lower values smooth the curve
	private double step = 0.1;
	// how many units to leave between scale numbers
	private int graduationStep = 2;
	
	private int pixelPerUnita;
	private FunctionModel model;
	
	public PlotView(FunctionModel model) {
		this.model = model;
		model.addObserver(this);
	}
	
	public PlotView(FunctionModel model, double startX, double endX, double step, int graduationStep) {
		this(model);
		this.startX = startX;
		this.endX = endX;
		this.step = step;
		this.graduationStep = graduationStep;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		int pixelDisponibili = getWidth();
		pixelPerUnita = (int) (pixelDisponibili / (endX-startX));

		drawAxes(g2d);
		
		// draw plot
		int currX, currY, prevX, prevY;
		prevX = toDrawSpaceX(startX);
		prevY = toDrawSpaceY(model.eval(startX));
		
		for (double d = startX + step; d < endX; d += step) {
			currX = toDrawSpaceX(d);
			currY = toDrawSpaceY(model.eval(d));
			g2d.drawLine(prevX, prevY, currX, currY);
			prevX = currX;
			prevY = currY;
			
		}
	}

	private void drawAxes(Graphics2D g2d) {
		g2d.setStroke(new BasicStroke());
		g2d.setColor(Color.CYAN);
		int h = getHeight(), w = getWidth();
		int halfH = h / 2;
		int halfW = w / 2;
		// x axis
		g2d.drawLine(0, halfH, w, halfH);
		// y axis
		g2d.drawLine(halfW, 0, halfW, h);
		g2d.setColor(Color.BLACK);
		// scale numbers
		int yOffset = 12;
		int xOffset = 2;
		for (int i = (int) startX; i < endX; i += graduationStep) {
			g2d.drawString(i + "", i * pixelPerUnita + halfW, halfH + yOffset);
			g2d.drawString(i + "", halfW + xOffset, -i * pixelPerUnita + halfH);
		}
		
	}
	
	private int toDrawSpaceX(double valueSpaceX) {		
		return (int) ( (valueSpaceX  * pixelPerUnita) + (getWidth() / 2) );
	}

	private int toDrawSpaceY(double valueSpaceY) {
		return (int) ( (valueSpaceY * -1 * pixelPerUnita) + (getHeight() / 2) );
	}

	@Override
	public void update(Observable o, Object arg) {
		repaint();
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(WIDTH, HEIGHT);
	}

}
