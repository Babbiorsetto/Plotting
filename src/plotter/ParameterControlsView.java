package plotter;

import java.awt.FlowLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;

public class ParameterControlsView extends JPanel implements Observer {
	
	private FunctionModel model;
	
	private ParameterControl[] controls;
	
	public ParameterControlsView(FunctionModel model) {
		this.model = model;
		controls = new ParameterControl[model.getNParams()];
		for (int i = 0; i < model.getNParams(); i++) {
			controls[i] = new ParameterControl(i);
		}
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		for (ParameterControl control : controls) {
			add(control);
		}
		
		model.addObserver(this);
	}
	
	public void addParameterChangeListener(ParameterChangeListener listener) {
		listenerList.add(ParameterChangeListener.class, listener);
	}
	
	// un singolo controllo di parametro composto da nome, valore e slider
	private class ParameterControl extends JPanel {
		
		int id;
		JLabel pName = new JLabel();
		JLabel value = new JLabel();
		JSlider slider = new JSlider(SwingConstants.HORIZONTAL, -100, 100, 0);
		
		public ParameterControl(int id) {
			this.id = id;
			pName.setText(model.getParamName(id));
			value.setText("0.0");
			slider.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					Object[] listeners = ParameterControlsView.this.listenerList.getListenerList();
					for (int i = 0; i < listeners.length; i += 2) {
						if (listeners[i] == ParameterChangeListener.class) {
							((ParameterChangeListener) listeners[i+1]).ParameterChangeHappened(new ParameterChangeEvent(ParameterControlsView.this, id, slider.getValue() / 10.0));
						}
					}
					
				}
			});
			
			setLayout(new FlowLayout());
			add(pName);
			add(value);
			add(slider);
		}
		
		public void updateLabel() {
			value.setText(model.getParam(id) + "");
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		for (ParameterControl control : controls) {
			control.updateLabel();
		}
		
	}

}
