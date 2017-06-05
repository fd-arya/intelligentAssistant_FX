package com.naderaria.infinityCenter.model.enums;

/**
 * Created by NaderAria on 4/26/2017.
 */
public enum GoalTimeType {

    SHORT_TERM(0),
    MIDTERM(1),
    LONGTIME(2),
    IMMEDIATE(3);

    private int selection;

    private GoalTimeType( int selection ){

        this.selection = selection;
    }

    public int getSelection(){ return selection; }

}
