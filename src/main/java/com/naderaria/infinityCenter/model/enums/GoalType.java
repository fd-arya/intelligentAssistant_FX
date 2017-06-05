package com.naderaria.infinityCenter.model.enums;

/**
 * Created by NaderAria on 4/26/2017.
 */
public enum GoalType {

    ACADEMIC(0),
    EDUCATIONAL(1),
    FINANCIAL(2),
    WORK(3),
    PHYSICAL(4),
    SPIRITUAL(5),
    GENERIC(6),
    OTHER(7);

    private int selection;

    private GoalType( int selection ){

        this.selection = selection;
    }

    public int getSelection(){ return selection; }
}
