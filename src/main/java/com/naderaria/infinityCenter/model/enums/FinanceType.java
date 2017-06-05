package com.naderaria.infinityCenter.model.enums;

/**
 * Created by NaderAria on 4/26/2017.
 */
public enum FinanceType {

    PREDICTABLE(0),
    UNPREDICTABLE(1);

    private int selection;

    private FinanceType( int selection ){

        this.selection = selection;
    }

    public int getSelection(){ return selection; }
}
