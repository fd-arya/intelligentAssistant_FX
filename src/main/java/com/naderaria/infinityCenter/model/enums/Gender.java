package com.naderaria.infinityCenter.model.enums;

/**
 * Created by NaderAria on 4/26/2017.
 */
public enum Gender {

    WOMAN(0),
    MAN(1),
    OTHER(2);

    private int selection;

    private Gender( int selection ){

        this.selection = selection;
    }

    public int getSelection(){ return selection; }
}
