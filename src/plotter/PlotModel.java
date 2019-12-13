package plotter;

import java.util.Observable;

public class PlotModel extends Observable {
	
	/**
	 * x value to start plotting from
	 */
	private double startX = -10.0;
	/**
	 * x value to stop plotting at
	 */
	private double endX = 10.0;
	/**
	 * x value increase between plotting samples, lower values smooth the curve
	 */
	private double step = 0.1;
	/**
	 * how many units to leave between scale numbers
	 */
	private int graduationStep = 2;
	
	public double getStartX() {
		return startX;
	}
	public void setStartX(double startX) {
		setChanged();
		notifyObservers();
		this.startX = startX;
	}
	public double getEndX() {
		return endX;
	}
	public void setEndX(double endX) {
		setChanged();
		notifyObservers();
		this.endX = endX;
	}
	public double getStep() {
		return step;
	}
	public void setStep(double step) {
		setChanged();
		notifyObservers();
		this.step = step;
	}
	public int getGraduationStep() {
		return graduationStep;
	}
	public void setGraduationStep(int graduationStep) {
		setChanged();
		notifyObservers();
		this.graduationStep = graduationStep;
	}
	
}
