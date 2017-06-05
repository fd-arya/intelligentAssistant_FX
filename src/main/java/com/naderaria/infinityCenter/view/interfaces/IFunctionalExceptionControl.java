package com.naderaria.infinityCenter.view.interfaces;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by NaderAria on 6/1/2017.
 */

public interface IFunctionalExceptionControl<E extends Exception,A extends EventHandler<ActionEvent>> {

    public default void accept( E exception ) throws Exception{

        throw new Exception();
    }
}
