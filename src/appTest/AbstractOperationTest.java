package appTest;

import main.Operations;
import org.junit.After;

public abstract class AbstractOperationTest {

	@After
	public void tearDown() throws Exception {
		Operations.INSTANCE.reset();
	}
}
