package function;

import plotter.FunctionType;

public class FunctionFactory {
	
	public static PFunction getFunctionByType(FunctionType type) {
		PFunction function = null;
		
		switch (type) {
		case ABSOLUTE:
			function = new AbsoluteFunction();
			break;
		case CRAZY:
			function = new CrazyFunction();
			break;
		case LOGARITHMIC:
			function = new LogarithmicFunction();
			break;
		case QUADRATIC:
			function = new QuadraticFunction();
			break;
		default:
			throw new UnsupportedOperationException("Tipo di funzione non supportato");		
		}
		
		return function;
	}
	
	public static FunctionType getFunctionTypeByInstance(PFunction function) {
		FunctionType type;
		
		if (function instanceof AbsoluteFunction) {
			type = FunctionType.ABSOLUTE;
		} else if (function instanceof CrazyFunction){
			type = FunctionType.CRAZY;
		} else if (function instanceof LogarithmicFunction){
			type = FunctionType.LOGARITHMIC;
		} else if (function instanceof QuadraticFunction){
			type = FunctionType.QUADRATIC;
		} else {
			throw new UnsupportedOperationException("");
		}
		return type;
	}

}
