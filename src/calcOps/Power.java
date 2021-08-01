package calcOps;

import main.BinaryOperation;
import java.lang.Math;

public class Power extends AbstractOperation implements BinaryOperation {

	@Override
	public float perform(float arg1, float arg2) {
		return (float) Math.pow(arg1, arg2);
	}
	
	@Override
	public String getName() {
		return "^";
	}
}
