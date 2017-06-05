package com.naderaria.infinityCenter.model.enums;

/**
 * Created by NaderAria on 4/26/2017.
 */
public enum RepetitionType {

    MONTHLY(0),
    WEELLY(1),
    EVERYDAY(2),
    SATURDAY(3),
    SUNDAY(4),
    MONDAY(5),
    TUESDAY(6),
    WEDNESDAY(7),
    THURSDAY(8),
    FRIDAY(10);

    private int selection;

    private RepetitionType(int selection ){

        this.selection = selection;
    }

    public int getSelection(){ return selection; }
}
