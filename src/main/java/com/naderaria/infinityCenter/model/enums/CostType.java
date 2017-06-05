package com.naderaria.infinityCenter.model.enums;

/**
 * Created by NaderAria on 4/26/2017.
 */
public enum CostType {

    DEBT(0),
    FARE(1),
    BUY(2),
    OTHER(3);

    private int selection;

    private CostType( int selection ){

        this.selection = selection;
    }

    public int getSelection(){ return selection; }
}
