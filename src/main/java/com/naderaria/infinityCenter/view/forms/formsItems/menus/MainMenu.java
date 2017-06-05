package com.naderaria.infinityCenter.view.forms.formsItems.menus;

import com.naderaria.infinityCenter.view.forms.formsItems.menus.enums.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by NaderAria on 5/4/2017.
 */
public class MainMenu implements Serializable {

    private static final long serialVersionUID = 1L;


    private MenuBar menuBar;
    private List<Menu> menus;


    public MenuBar getMenuBar( Locale locale ){

        if( menuBar == null ){
            menuBar = new MenuBar();
            menuBar.getMenus().addAll( getMenus(locale) );
        }
        return menuBar;
    }
    private List<Menu> getMenus( Locale locale ){

        if( menus == null ){
            menus = new ArrayList<>();
            menus.add( AccountMenu.getMenu( locale ) );
            menus.add( FinancialMenu.getMenu( locale ) );
            menus.add( DrugMenu.getMenu( locale ) );
            menus.add( MedicineMenu.getMenu( locale ) );
            menus.add( ReminderMenu.getMenu( locale ) );
            menus.add( ScrumMenu.getMenu( locale ) );
        }
        return menus;
    }


}
