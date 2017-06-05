package com.naderaria.infinityCenter.view.forms.formsItems.menus.enums;

import com.naderaria.infinityCenter.view.interfaces.IMenuItemManager;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

import java.util.Locale;

/**
 * Created by NaderAria on 5/5/2017.
 */
public enum ReminderMenu implements IMenuItemManager {



    REMINDER_MANAGER(0) {

        @Override
        public MenuItem getItem(Locale l ){

            return new MenuItem("ReminderManager");
        }

        @Override
        public boolean isVisible(){
            return true;
        }
    };

    private int no;

    public int getNo(){ return no; }
    public void setNo( int no ){ this.no = no; }

    ReminderMenu(int no ){ this.no = no; }

    public static Menu getMenu( Locale l ){

        Menu menu = new Menu("Reminder");
        for( ReminderMenu a : ReminderMenu.values() ){
            menu.getItems().add( a.getItem( l ) );
        }
        return menu;
    }

}
