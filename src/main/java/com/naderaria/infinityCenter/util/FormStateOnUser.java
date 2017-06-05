package com.naderaria.infinityCenter.util;

/**
 * Created by NaderAria on 6/1/2017.
 */
public enum FormStateOnUser {

    NORMAL_FORM(0),LOGIN_FORM(1),REGISTERING_FORM(3);

    private int no;

    public int getNo(){ return no; }

    private FormStateOnUser( int no ){ this.no = no; }
}
