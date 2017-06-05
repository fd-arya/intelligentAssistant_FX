package com.naderaria.infinityCenter.model.enums;

/**
 * Created by NaderAria on 4/26/2017.
 */
public enum Language {

    ENGLISH(0),
    PERSIAN(1);

    private int selection;

    private Language( int selection ){
        this.selection = selection;
    }

    public int getSelection(){
        return selection;
    }
}
