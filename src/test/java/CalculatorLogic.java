

public class CalculatorLogic {
	private Calculator calculator;

	public CalculatorLogic(Calculator calculator) {
		this.calculator = calculator;
	}

	public double getResult() {
		switch (calculator.getOpr()) {
		case "+" :
			return calculator.getNo1() + calculator.getNo2();
		case "-" :
			return calculator.getNo1() - calculator.getNo2();
		case "*" :
			return calculator.getNo1() * calculator.getNo2();
		case "/" :
			return calculator.getNo1() / calculator.getNo2();
		case "%" :
			return calculator.getNo1() / 100;
		case "^" :
			return Math.pow(calculator.getNo1() , calculator.getNo2());
		case "t" :
			return Math.pow(calculator.getNo1() , 2);
		case "sqr" :
			return Math.sqrt(calculator.getNo1());
		}
		return 0;
	}
}
