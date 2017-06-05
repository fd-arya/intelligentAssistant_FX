/**
 * Created by NaderAria on 5/26/2017.
 */
public class Calculator {


        private double no1;
        private String opr;
        private double no2;

        public Calculator() {

        }

        public Calculator(double no1, String opr, double no2) {
            super();
            this.no1 = no1;
            this.opr = opr;
            this.no2 = no2;
        }

        public double getNo1() {
            return no1;
        }

        public void setNo1(double no1) {
            this.no1 = no1;
        }

        public String getOpr() {
            return opr;
        }

        public void setOpr(String opr) {
            this.opr = opr;
        }

        public double getNo2() {
            return no2;
        }

        public void setNo2(double no2) {
            this.no2 = no2;
        }



}
