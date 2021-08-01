package calcOps;

import main.UnaryOperation;

public class Square extends AbstractOperation implements UnaryOperation {

	@Override
	public float perform(float arg1) {
		return arg1 * arg1;
	}
	
	@Override
	public String getName() {
		return "^2";
	}
}
