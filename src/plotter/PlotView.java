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

	private int pixelPerUnita;
	private FunctionModel functionModel;
	private PlotModel plotModel;
	
	public PlotView(FunctionModel functionModel, PlotModel plotModel) {
		this.functionModel = functionModel;
		functionModel.addObserver(this);
		this.plotModel = plotModel;
		plotModel.addObserver(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int pixelDisponibili = getWidth();
		pixelPerUnita = (int) (pixelDisponibili / (plotModel.getEndX()-plotModel.getStartX()));

		Graphics2D g2d = (Graphics2D) g;

		drawAxes(g2d);
		drawPlot(g2d);
	}

	private void drawPlot(Graphics2D g2d) {
		int currX, currY, prevX, prevY;
		prevX = toDrawSpaceX(plotModel.getStartX());
		prevY = toDrawSpaceY(functionModel.eval(plotModel.getStartX()));
		
		for (double d = plotModel.getStartX() + plotModel.getStep(); d < plotModel.getEndX(); d += plotModel.getStep()) {
			currX = toDrawSpaceX(d);
			currY = toDrawSpaceY(functionModel.eval(d));
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
		for (int i = (int) plotModel.getStartX(); i < plotModel.getEndX(); i += plotModel.getGraduationStep()) {
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
