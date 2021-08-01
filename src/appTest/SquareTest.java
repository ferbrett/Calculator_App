package appTest;

import static org.junit.Assert.assertEquals;
import main.UnaryOperation;
import org.junit.Before;
import org.junit.Test;

public class SquareTest extends AbstractOperationTest {

	private UnaryOperation op;
	
	@Before
	public void setUp() throws Exception {
		op = new calcOps.Square();
	}
	
	@Test
	public void testPerform() {
		assertEquals(4.0, op.perform(2.0F), 0.01F);
	}
	
	@Test
	public void testGetName() {
		assertEquals(op.getName(), "^2");
	}
}
