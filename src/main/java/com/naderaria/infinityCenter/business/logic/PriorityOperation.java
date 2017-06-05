package com.naderaria.infinityCenter.business.logic;

/**
 * Created by NaderAria on 5/26/2017.
 */
public enum PriorityOperation implements IPriorityPoeration {

    FIRST("(",")",""){

        @Override
        public String getValues(){

            return  this.getOneOperation()+this.getTwoOperation()+this.getTreeOperation();
        }

    },SECOND("sqr","^",""){

        @Override
        public String getValues(){

            return  this.getOneOperation()+this.getTwoOperation()+this.getTreeOperation();
        }

    },THIRD("*","/","%"){

        @Override
        public String getValues(){

            return  this.getOneOperation()+this.getTwoOperation()+this.getTreeOperation();
        }

    },FOURTH("+","-",""){

        @Override
        public String getValues(){

            return  this.getOneOperation()+this.getTwoOperation()+this.getTreeOperation();
        }

    };

    private String oneOperation;

    private String twoOperation;

    private String treeOperation;

    public String getOneOperation(){ return oneOperation; }

    public String getTwoOperation(){ return twoOperation; }

    public String getTreeOperation(){ return treeOperation; }

    private PriorityOperation( String oneOperation , String twoOperation , String treeOperation ){

        this.oneOperation = oneOperation;
        this.twoOperation = twoOperation;
        this.treeOperation = treeOperation;
    }

    public static int findPriortyOrdinal( String opr ){

       if(  PriorityOperation.FIRST.getValues().contains( opr )  ){

           return PriorityOperation.FIRST.ordinal();

       }else  if (  PriorityOperation.SECOND.getValues().contains( opr ) ){

           return PriorityOperation.SECOND.ordinal();

       }else  if (  PriorityOperation.THIRD.getValues().contains( opr ) ){

           return PriorityOperation.THIRD.ordinal();

       }else  if (  PriorityOperation.FOURTH.getValues().contains( opr ) ){

           return PriorityOperation.FOURTH.ordinal();

       }

        return -1;
    }
}
