package com.naderaria.infinityCenter.model.enums;

/**
 * Created by NaderAria on 4/26/2017.
 */
public enum PayType {

    CHECK(0),
    PAYMENT(1),
    BILL(2),
    GENERIC(3);

    private int selection;

    private PayType( int selection ){

        this.selection = selection;
    }

    public int getSelection(){ return selection; }
}
