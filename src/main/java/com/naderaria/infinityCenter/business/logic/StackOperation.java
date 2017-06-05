package com.naderaria.infinityCenter.business.logic;


import java.util.Stack;

/**
 * Created by NaderAria on 5/26/2017.
 */
public class StackOperation {

    private Stack<String> operations;

    private Stack<String> getOperations(){

        if( operations == null ){
            operations = new Stack<>();
        }
        return operations;
    }

    public void push( String opr ){

        if( getOperations().isEmpty() ){
            getOperations().push( opr );
        }else{
            int newOprOrdinal = PriorityOperation.findPriortyOrdinal( opr );
            String oldOpr = getOperations().peek();
            int oldOprOrdinal = PriorityOperation.findPriortyOrdinal( oldOpr );

            if( newOprOrdinal != -1 || oldOprOrdinal != -1  ){
                if( newOprOrdinal < oldOprOrdinal ){

                    String temp = getOperations().pop();
                    getOperations().push( opr );
                    getOperations().push( temp );

                }else if( newOprOrdinal > oldOprOrdinal ){
                    getOperations().push( opr );
                }else {
                    
                }
            }else{

            }


        }




        //TODO hh
        getOperations().push( opr );

    }

    public String pop(){

        return getOperations().pop();
    }

    public String peek(){

        return getOperations().peek();
    }

    public boolean isEmpty(){

        return getOperations().isEmpty();
    }


}
