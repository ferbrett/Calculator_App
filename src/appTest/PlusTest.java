package appTest;

import static org.junit.Assert.*;
import main.BinaryOperation;
import org.junit.Before;
import org.junit.Test;

public class PlusTest extends AbstractOperationTest {

	private BinaryOperation op;
	
	@Before
	public void setUp() throws Exception {
		op = new calcOps.Plus();
	}
	
	@Test
	public void testPerform() {
		assertEquals(3.0, op.perform(1.0f, 2.0F), 0.01F);
	}
	
	@Test
	public void testGetName() {
		assertEquals(op.getName(), "+");
	}
}
