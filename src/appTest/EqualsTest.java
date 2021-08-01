package appTest;

import static org.junit.Assert.assertEquals;
import main.Operation;
import org.junit.Before;
import org.junit.Test;

public class EqualsTest extends AbstractOperationTest {

	private Operation op;
	
	@Before
	public void setUp() throws Exception {
		op = new calcOps.Equals();
	}
	
	@Test
	public void testGetName() {
		assertEquals(op.getName(), "=");
	}
}
