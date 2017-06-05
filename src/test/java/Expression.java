import java.util.ArrayList;
import java.util.List;

public class Expression {
	private String exp;
	private StackOperation stackOperation;

	public Expression() {
	}

	public Expression(String exp) {
		this.exp = "(" + exp.toLowerCase().replace("sqrt", "t").replace("sqr", "s") + ")";
	}

	public void setExp(String exp) {
		this.exp = "(" + exp.toLowerCase().replace("sqrt", "t").replace("sqr", "s") + ")";
	}

	public String getExp() {
		return exp;
	}

	public List<String> getPostFix() {
		List<String> result = new ArrayList<>();
		int l = getExp().length();
		String sno = "";
		for (int i = 0; i < l; i++) {
			char ch = getExp().charAt(i);
			if (isOperations(ch)) {
				if (sno != "") {
					result.add(sno);
				}
				String s = getStackOperation().push(ch);
				if (s != "") {
					int len = s.length();
					for (int j = 0; j < len; j++) {
						result.add(String.valueOf(s.charAt(j)));
					}
				}
				sno = "";
			} else if (isDigit(ch)) {
				sno += (ch);
			}
		}
		String s = getStackOperation().popAll();
		if (s != "") {
			int len = s.length();
			for (int j = 0; j < len; j++) {
				result.add(String.valueOf(s.charAt(j)));
			}
		}
		return result;
	}

	public StackOperation getStackOperation() {
		if (stackOperation == null) {
			stackOperation = new StackOperation();
		}
		return stackOperation;
	}

	private String getOprs() {
		String result = "";
		PriorityOperation[] a = PriorityOperation.values();
		for (PriorityOperation o : a) {
			result += o.getOpr1();
			result += o.getOpr2();
			result += o.getOpr3();
		}
		return result;
	}

	public boolean isOperations(char ch) {
		return getOprs().indexOf(ch) != -1;
	}

	public boolean isSingleOperator(char ch) {
		return (getOprs().indexOf(ch) != -1) && ("st%".indexOf(ch) != -1);
	}

	private boolean isDigit(char ch) {
		return Character.isDigit(ch) || ch == '.';
	}
}
