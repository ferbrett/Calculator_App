package appTest;

import static org.junit.Assert.assertEquals;

import main.Calculator;
import main.Operations;
import appInterface.TextProvider;

import org.junit.After;
import org.junit.Test;

public class CalculatorTest {

	@After
	public void tearDown() throws Exception {
		Operations.INSTANCE.reset();
	}
	
	@Test
	public void testPlus() {
		TestTextProvider textProvider = new TestTextProvider();
		Calculator calculator = new Calculator(textProvider);
		
		calculator.handleButtonClick("1");
		calculator.handleButtonClick("+");
		calculator.handleButtonClick("2");
		calculator.handleButtonClick("=");
		
		assertEquals("3.0", textProvider.getDisplayText());
	}
	
	@Test
	public void testTwoTimesPlus() {
		TestTextProvider textProvider = new TestTextProvider();
		Calculator calculator = new Calculator(textProvider);
		
		calculator.handleButtonClick("1");
		calculator.handleButtonClick("+");
		calculator.handleButtonClick("2");
		calculator.handleButtonClick("+");
		calculator.handleButtonClick("3");
		calculator.handleButtonClick("=");
		
		assertEquals("6.0", textProvider.getDisplayText());
	}
	
	@Test
	public void testPlusWithFraction() {
		TestTextProvider textProvider = new TestTextProvider();
		Calculator calculator = new Calculator(textProvider);
		
		calculator.handleButtonClick("1");
		calculator.handleButtonClick("+");
		calculator.handleButtonClick("2");
		calculator.handleButtonClick(".");
		calculator.handleButtonClick("1");
		calculator.handleButtonClick("=");
		
		assertEquals("3.1", textProvider.getDisplayText());
	}
	
	@Test
	public void testSquare() {
		TestTextProvider textProvider = new TestTextProvider();
		Calculator calculator = new Calculator(textProvider);
		
		calculator.handleButtonClick("2");
		calculator.handleButtonClick("^2");
		
		assertEquals("4.0", textProvider.getDisplayText());
	}
	
	private static final class TestTextProvider implements TextProvider {
		
		private String text = "0";
		
		public void setDisplayText(String text) {
			this.text = text;
		}
		
		@Override
		public String getDisplayText() {
			return text;
		}
	}
}
