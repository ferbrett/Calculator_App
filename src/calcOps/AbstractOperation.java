package calcOps;

import main.Operation;
import main.Operations;

public abstract class AbstractOperation implements Operation {

	AbstractOperation() {
		Operations.INSTANCE.register(this);
	}
}
