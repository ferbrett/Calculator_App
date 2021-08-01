package main;

public class Calculator {

private appInterface.TextProvider textProvider;
	
	private String cmd;
	
	private boolean clearText;
	
	private float value;
	
	public static String NAME = "Simple Calculator";
	
	public Calculator(appInterface.TextProvider textProvider) {
		this.textProvider = textProvider;
		setupDefaultOperations();
	}
	
	private void setupDefaultOperations() {
		new calcOps.Equals();
		new calcOps.Minus();
		new calcOps.Plus();
		new calcOps.Square();
		new calcOps.Divide();
	}
	
	private String getTextOrZero() {
		String currentInput = textProvider.getDisplayText();
		if ((currentInput == null) || (currentInput.isEmpty()) ) {
			currentInput = "0";
		}
		return currentInput;
	}
	
	private void calculate(String cmdName) {
		float curValue;
		float newValue = 0;
		
		curValue = Float.parseFloat(getTextOrZero());
		
		Operation currentOp = Operations.INSTANCE.getOperation(cmdName);
		if ((currentOp instanceof main.BinaryOperation) && (cmd == null)) {
			cmd = cmdName;
			setClearText(true);
		} else {
			Operation savedOp = Operations.INSTANCE.getOperation(cmd);
			if (savedOp instanceof main.BinaryOperation) {
				main.BinaryOperation bop = (main.BinaryOperation) savedOp;
				newValue = bop.perform(value, curValue);
			} else if (currentOp instanceof main.UnaryOperation) {
				main.UnaryOperation uop = (main.UnaryOperation) currentOp;
				newValue = uop.perform(curValue);
			}
			
			textProvider.setDisplayText("" + newValue);
			setClearText(true);
			if (currentOp instanceof calcOps.Equals) {
				cmd = null;
			} else if (currentOp instanceof main.BinaryOperation) {
				cmd = cmdName;
			} else {
				cmd = null;
			}
		}
	}
	
	private boolean isCommand(String name) {
		return (Operations.INSTANCE.getOperation(name) != null);
	}
	
	public void handleButtonClick(String str) {
		if (isCommand(str)) {
			calculate(str);
		} else {
			char digit = (str.toCharArray())[0];
			if (Character.isDigit(digit) || digit == '.') {
				value = Float.parseFloat(getTextOrZero());
				textProvider.setDisplayText("");
				setClearText(false);
			}
			
			textProvider.setDisplayText(textProvider.getDisplayText() + digit);
		}
	}
	
	public void setClearText(boolean clearText) {
		this.clearText = clearText;
	}
}
