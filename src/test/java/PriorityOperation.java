public enum PriorityOperation {
	o1("(", ")", ""), o2("sqr", "^", ""), o3("*", "/", "%"), o4("+", "-", "");

	String opr1;
	String opr2;
	String opr3;

	private PriorityOperation(String opr1, String opr2, String opr3) {
		this.opr1 = opr1;
		this.opr2 = opr2;
		this.opr3 = opr3;
	}

	public String getOpr1() {
		return opr1;
	}

	public String getOpr2() {
		return opr2;
	}

	public String getOpr3() {
		return opr3;
	}

	public static PriorityOperation getOOperation(String opr) {
		PriorityOperation[] a = PriorityOperation.values();
		for (PriorityOperation o : a) {
			if ((o.getOpr1().equals(opr)) || (o.getOpr2().equals(opr)) || (o.getOpr3().equals(opr))) {
				return o;
			}
		}
		return null;
	}
}
