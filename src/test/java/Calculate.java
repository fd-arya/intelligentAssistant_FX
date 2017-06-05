import java.util.List;

/**
 * Created by NaderAria on 5/26/2017.
 */
public class Calculate {


        private Expression expression;
        private CalculatorLogic calculatorLogic;
        private Calculator calculator;

        public Calculate(String exp) {
            expression = new Expression(exp);
        }

        public Expression getExpression() {
            if (expression == null) {
                expression = new Expression();
            }
            return expression;
        }

        public Calculator getCalculator() {
            if (calculator == null) {
                calculator = new Calculator();
            }
            return calculator;
        }

        public CalculatorLogic getCalculatorLogic(Calculator calculator) {
            if (calculatorLogic == null) {
                calculatorLogic = new CalculatorLogic(calculator);
            }
            return calculatorLogic;
        }

        public void setCalculatorLogic(CalculatorLogic calculatorLogic) {
            this.calculatorLogic = calculatorLogic;
        }

        public String getResult() {
            List<String> pf = getExpression().getPostFix();
            try{
                for (int i = 0 ; pf.size() !=1 ; i++) {
                    String a = pf.get(i);
                    if (getExpression().isOperations(a.charAt(0))) {
                        if (getExpression().isSingleOperator(a.charAt(0))) {
                            getCalculator().setNo1(Double.parseDouble(pf.get(i - 1)));
                            getCalculator().setOpr(pf.get(i));
                            pf.remove(i - 1);
                            pf.remove(i - 1);
                            String result = String.valueOf(getCalculatorLogic(getCalculator()).getResult());
                            pf.add(i - 1 , result);
                            i = -1;
                        } else {
                            getCalculator().setNo1(Double.parseDouble(pf.get(i - 2)));
                            getCalculator().setNo2(Double.parseDouble(pf.get(i -1)));
                            getCalculator().setOpr(pf.get(i));
                            pf.remove(i - 2);
                            pf.remove(i - 2);
                            pf.remove(i - 2);
                            String result = String.valueOf(getCalculatorLogic(getCalculator()).getResult());
                            pf.add(i - 2 , result);
                            i = -1;

                        }
                    }
                }
            }catch (Exception e){
                return "Malformed expression";

            }
            return pf.get(0);
        }



}
