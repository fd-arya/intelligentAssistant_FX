package com.naderaria.infinityCenter.model.enums;

/**
 * Created by NaderAria on 4/26/2017.
 */
public enum PriorityType {

    CRITICAL(0),
    IMMEDIATE(1),
    HIGH(2),
    NORMAL(3),
    LOW(4);

    private int selection;

    private PriorityType( int selection ){

        this.selection = selection;
    }

    public int getSelection(){ return selection; }
}
