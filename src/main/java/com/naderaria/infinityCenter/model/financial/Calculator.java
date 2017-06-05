package com.naderaria.infinityCenter.model.financial;

/**
 * Created by NaderAria on 5/26/2017.
 */
public class Calculator {

    private double numOne;
    private String opr;
    private double numTwo;

    public Calculator(){}

    public Calculator( double numOne , String opr ,double numTwo ){

        this.numOne = numOne;
        this.opr = opr;
        this.numTwo = numTwo;

    }

    public double getNumOne(){ return numOne; }
    public Calculator setNumOne( double numOne ){
        this.numOne = numOne;
        return this;
    }

    public String getOpr(){ return opr; }
    public Calculator setOpr( String opr ){
        this.opr = opr;
        return this;

    }

    public double getNumTwo(){ return numTwo; }
    public Calculator setNumTwo( double numTwo ){
        this.numTwo = numTwo;
        return this;
    }
}
