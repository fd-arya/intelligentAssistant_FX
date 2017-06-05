import java.util.EmptyStackException;
import java.util.Stack;

public class StackOperation {
	private Stack<String> operations;

	public Stack<String> getOperations() {
		if (operations == null) {
			operations = new Stack<>();
		}
		return operations;
	}

	public String push(char opr) {
		return push(String.valueOf(opr));
	}


	public String push(String opr) {
		if (getOprs().indexOf(opr) == -1 ) {
			return "Malformed experassion";
		}
		String result = "";
		if (getOperations().isEmpty()) {
			getOperations().push(opr);
			return result;
		}
		int priorityOpr = PriorityOperation.getOOperation(opr).ordinal();
		if (priorityOpr == 0) {
			if (opr.equals("(")) {
				getOperations().push(opr);
				return result;
			} else {
				try {
					while (true) {
						String stackOpr = getOperations().pop();
						if (stackOpr.equals("(")) {
							return result;
						}
						result += stackOpr;
					}
				} catch (EmptyStackException e) {
					return "Malformed experssion";
				}
			}
		}
		while (!getOperations().isEmpty()) {
			String stackOpr = getOperations().pop();
			if ("()".indexOf(stackOpr) != -1) {
				getOperations().push(stackOpr);
				getOperations().push(opr);
				return result;
			}
			int priorityStackOpr = PriorityOperation.getOOperation(stackOpr).ordinal();
			if (priorityOpr < priorityStackOpr) {
				getOperations().push(stackOpr);
				getOperations().push(opr);
				return result;
			} else {
				result += stackOpr;
			}
		}
		getOperations().push(opr);
		return result;
	}

	public String pop() {
		return getOperations().pop();
	}

	public String popAll() {
		String result = "";
		while (!getOperations().isEmpty()) {
			result += getOperations().pop();
		}
		return result;
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
}
