package com.naderaria.infinityCenter.model.enums;

/**
 * Created by NaderAria on 4/26/2017.
 */
public enum TaskType {

    UN_PLANING(0),
    DAILY_SCHEDULE(1),
    SPRINT(2);

    private int selection;

    private TaskType( int selection ){

        this.selection = selection;
    }

    public int getSelection(){ return selection; }
}
