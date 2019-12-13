package plotter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import function.FunctionFactory;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.awt.Dimension;

public class GraphOptionsView extends JPanel implements Observer {
	
	private final int ROWS = 5;
	private final int COLUMNS = 2;
	private final int DEFAULT_MINIMUM = -30;
	private final int DEFAULT_MAXIMUM = 30;
	private final int DEFAULT_MAJOR_TICK_SPACING = 5;
	private final int DEFAULT_MINOR_TICK_SPACING = 1;
	private final int DEFAULT_STEP_MINIMUM = 1;
	private final int DEFAULT_STEP_MAXIMUM = 10;
	private final int DEFAULT_GRADUATION_STEP_MINIMUM = 1;
	private final int DEFAULT_GRADUATION_STEP_MAXIMUM = 10;
	
	private JLabel tipoFunzioneLabel;
	private JComboBox<FunctionType> tipoFunzioneComboBox;
	private JLabel ascissaInizialeLabel;
	private JSlider ascissaInizialeSlider;
	private JLabel ascissaFinaleLabel;
	private JSlider ascissaFinaleSlider;
	private JLabel stepLabel;
	private JSlider stepSlider;
	private JLabel graduationStepLabel;
	private JSlider graduationStepSlider;
	
	PlotModel plotModel;
	FunctionModel functionModel;
	
	public GraphOptionsView(PlotModel plotModel, FunctionModel functionModel) {
		this.plotModel = plotModel;
		plotModel.addObserver(this);
		this.functionModel = functionModel;
		functionModel.addObserver(this);
		uiSetup();
	}

	private final void uiSetup() {
		setLayout(new GridLayout(ROWS, COLUMNS));
		
		tipoFunzioneLabel = new JLabel("Tipo di funzione");
		
		tipoFunzioneComboBox = new JComboBox<FunctionType>();
		tipoFunzioneComboBox.setModel(new DefaultComboBoxModel<FunctionType>(FunctionType.values()));
		tipoFunzioneComboBox.setSelectedItem(FunctionFactory.getFunctionTypeByInstance(functionModel.getFunction()));
		tipoFunzioneComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Object[] listeners = listenerList.getListenerList();
				for (int i = 0; i < listeners.length; i += 2) {
					if (listeners[i] == FunctionTypeChangeListener.class) {
						((FunctionTypeChangeListener) listeners[i+1]).functionTypeChangeHappened(new FunctionTypeChangeEvent(GraphOptionsView.this, (FunctionType)tipoFunzioneComboBox.getSelectedItem()));
					}
				}
			}
		});
		
		ascissaInizialeLabel = new JLabel("Ascissa iniziale");
		
		ascissaInizialeSlider = new JSlider();
		ascissaInizialeSlider.setPaintLabels(true);
		ascissaInizialeSlider.setMinorTickSpacing(DEFAULT_MINOR_TICK_SPACING);
		ascissaInizialeSlider.setMajorTickSpacing(DEFAULT_MAJOR_TICK_SPACING);
		ascissaInizialeSlider.setPaintTicks(true);
		ascissaInizialeSlider.setMinimum(DEFAULT_MINIMUM);
		ascissaInizialeSlider.setMaximum(DEFAULT_MAXIMUM);
		ascissaInizialeSlider.setValue((int)plotModel.getStartX());;
		ascissaInizialeSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				signalGraphOptionsChange();
			}
		});
		
		ascissaFinaleLabel = new JLabel("Ascissa finale");
		
		ascissaFinaleSlider = new JSlider();
		ascissaFinaleSlider.setPaintLabels(true);
		ascissaFinaleSlider.setMinorTickSpacing(DEFAULT_MINOR_TICK_SPACING);
		ascissaFinaleSlider.setMajorTickSpacing(DEFAULT_MAJOR_TICK_SPACING);
		ascissaFinaleSlider.setPaintTicks(true);
		ascissaFinaleSlider.setMinimum(DEFAULT_MINIMUM);
		ascissaFinaleSlider.setMaximum(DEFAULT_MAXIMUM);
		ascissaFinaleSlider.setValue((int)plotModel.getEndX());
		ascissaFinaleSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				signalGraphOptionsChange();
			}
		});
		
		stepLabel = new JLabel("Step");
		
		stepSlider = new JSlider();
		stepSlider.setMinimum(DEFAULT_STEP_MINIMUM);
		stepSlider.setMaximum(DEFAULT_STEP_MAXIMUM);
		stepSlider.setValue((int)plotModel.getStep());
		stepSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				signalGraphOptionsChange();
			}
		});
		
		graduationStepLabel = new JLabel("Graduation step");
		
		graduationStepSlider = new JSlider();
		graduationStepSlider.setPaintLabels(true);
		graduationStepSlider.setMajorTickSpacing(1);
		graduationStepSlider.setPaintTicks(true);
		graduationStepSlider.setMinimum(DEFAULT_GRADUATION_STEP_MINIMUM);
		graduationStepSlider.setMaximum(DEFAULT_GRADUATION_STEP_MAXIMUM);
		graduationStepSlider.setValue(plotModel.getGraduationStep());
		graduationStepSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				signalGraphOptionsChange();
			}
		});
		
		add(tipoFunzioneLabel);
		add(tipoFunzioneComboBox);
		add(ascissaInizialeLabel);
		add(ascissaInizialeSlider);
		add(ascissaFinaleLabel);		
		add(ascissaFinaleSlider);
		add(stepLabel);
		add(stepSlider);
		add(graduationStepLabel);
		add(graduationStepSlider);
	}
	
	protected void setEventInfo(GraphOptionsChangeEvent event) {
		event.setStartX(ascissaInizialeSlider.getValue());
		event.setEndX(ascissaFinaleSlider.getValue());
		event.setStep(stepSlider.getValue() * 0.1);
		event.setGraduationStep(graduationStepSlider.getValue());
	}

	public void addGraphOptionsChangeListener(GraphOptionsChangeListener listener) {
		listenerList.add(GraphOptionsChangeListener.class, listener);
	}
	
	public void addFunctionTypeChangeListener(FunctionTypeChangeListener listener) {
		listenerList.add(FunctionTypeChangeListener.class, listener);
	}

	@Override
	public Dimension getPreferredSize() {
		return new Dimension(700, 300);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		
	}

	private void signalGraphOptionsChange() {
		Object[] listeners = listenerList.getListenerList();
		GraphOptionsChangeEvent event = new GraphOptionsChangeEvent(this);
		setEventInfo(event);
		for (int i = 0; i < listeners.length; i += 2) {
			if (listeners[i] == GraphOptionsChangeListener.class) {
				((GraphOptionsChangeListener) listeners[i+1]).GraphOptionsChangeHappened(event);
			}
		}
	}

}
