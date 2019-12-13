package plotter;

import java.util.EventObject;

public class GraphOptionsChangeEvent extends EventObject {
	
	double startX = -10.0;
	double endX = 10.0;
	double step = 0.1;
	int graduationStep = 2;
	
	public GraphOptionsChangeEvent(Object source) {
		super(source);
	}

	public double getStartX() {
		return startX;
	}

	public void setStartX(double startX) {
		this.startX = startX;
	}

	public double getEndX() {
		return endX;
	}

	public void setEndX(double endX) {
		this.endX = endX;
	}

	public double getStep() {
		return step;
	}

	public void setStep(double step) {
		this.step = step;
	}

	public int getGraduationStep() {
		return graduationStep;
	}

	public void setGraduationStep(int graduationStep) {
		this.graduationStep = graduationStep;
	}
}
