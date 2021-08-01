package calcOps;

import main.BinaryOperation;

public class Multiply extends AbstractOperation implements BinaryOperation {

	@Override
	public float perform(float arg1, float arg2) {
		return arg1 * arg2;
	}
	
	@Override
	public String getName() {
		return "*";
	}
}
