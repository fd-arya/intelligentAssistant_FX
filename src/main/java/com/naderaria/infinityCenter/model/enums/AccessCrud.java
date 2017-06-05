package com.naderaria.infinityCenter.model.enums;

/**
 * Created by NaderAria on 4/26/2017.
 */
public enum AccessCrud {

    CREATE(0),
    READ(1),
    UPDATE(2),
    DELETE(3);

    private int selection;

    private AccessCrud( int selection ){

        this.selection = selection;
    }

    public int getSelection(){ return selection; }
}
