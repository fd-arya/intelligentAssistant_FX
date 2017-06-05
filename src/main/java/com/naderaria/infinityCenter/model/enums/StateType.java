package com.naderaria.infinityCenter.model.enums;

/**
 * Created by NaderAria on 4/26/2017.
 */
public enum StateType {

    OPENED(0),
    CLOSED(1),
    REOPENED(2),
    WAITING(3),
    IN_PROGESS(4),
    DONE(5),
    TODO(6),
    UN_PLANING(7),
    PLANED(8);

    private int selection;

    private StateType( int selection ){

        this.selection = selection;
    }

    public int getSelection(){ return selection; }

}
