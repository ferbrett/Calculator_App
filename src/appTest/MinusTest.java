package appTest;

import static org.junit.Assert.assertEquals;
import main.BinaryOperation;
import org.junit.Before;
import org.junit.Test;

public class MinusTest extends AbstractOperationTest {

	private BinaryOperation op;
	
	@Before
	public void setUp() throws Exception {
		op = new calcOps.Minus();
	}
	
	@Test
	public void testPerform() {
		assertEquals(-1.0, op.perform(1.0F, 2.0F), 0.01F);
	}
	
	@Test
	public void testGetName() {
		assertEquals(op.getName(), "-");
	}
}
