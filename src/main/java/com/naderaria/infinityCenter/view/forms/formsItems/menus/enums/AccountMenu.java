package com.naderaria.infinityCenter.view.forms.formsItems.menus.enums;

import com.naderaria.infinityCenter.main.InfinityCenter;
import com.naderaria.infinityCenter.util.VariablesDefault;
import com.naderaria.infinityCenter.view.controllers.LoginController;
import com.naderaria.infinityCenter.view.controllers.Session;
import com.naderaria.infinityCenter.view.forms.MainForm;
import com.naderaria.infinityCenter.view.forms.formsItems.menus.BundleLoader;
import com.naderaria.infinityCenter.view.interfaces.IMenuItemManager;
import javafx.application.Platform;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Locale;

/**
 * Created by NaderAria on 5/4/2017.
 */
public enum AccountMenu implements IMenuItemManager {



    /*ACCOUNT_LOGIN(0) {

        @Override
        public MenuItem getItem( Locale l ){

            MenuItem menuItem = new MenuItem(BundleLoader.getValue( VariablesDefault.ACCOUNT_MENU_ITEM_LOGIN , l ));
            menuItem.setOnAction( e -> {
                LoginController loginController = new LoginController();
                loginController.showLoginForm( l );
            });
            return  menuItem;
        }

        @Override
        public boolean isVisible(){
            return Session.getInstance().isNull();
        }
    },*/
    ACCOUNT_LOGOUT(0){

        @Override
        public MenuItem getItem( Locale l ){

            MenuItem menuItem = new MenuItem(BundleLoader.getValue( VariablesDefault.ACCOUNT_MENU_ITEM_LOGOUT , l ));
            menuItem.setOnAction( e -> {
                InfinityCenter.showWarning( "Logout ");
            });
            return  menuItem;
        }

        @Override
        public boolean isVisible(){
            return !Session.getInstance().isNull();
        }
    } ,
    ACCOUNT_PROFILE(1){

        @Override
        public MenuItem getItem( Locale l ){

            MenuItem menuItem = new MenuItem(BundleLoader.getValue( VariablesDefault.ACCOUNT_MENU_ITEM_PROFILE , l ));
            menuItem.setOnAction( e -> {
                InfinityCenter.showWarning( "Profile ");
            });
            return  menuItem;
        }

        @Override
        public boolean isVisible(){
            return !Session.getInstance().isNull();
        }
    } ,
    ACCOUNT_SETTING(2){

        @Override
        public MenuItem getItem( Locale l ){

            MenuItem menuItem = new MenuItem(BundleLoader.getValue( VariablesDefault.ACCOUNT_MENU_ITEM_SETTING , l ));
            menuItem.setOnAction( e -> {
                InfinityCenter.showWarning( "Setting ");
            });
            return  menuItem;
        }

        @Override
        public boolean isVisible(){
            return !Session.getInstance().isNull();
        }
    } ,
    ACCOUNT_EXIT(4){

        @Override
        public MenuItem getItem( Locale l ){

            MenuItem menuItem = new MenuItem(BundleLoader.getValue( VariablesDefault.ACCOUNT_MENU_ITEM_EXIT , l ));
            menuItem.setOnAction( e -> InfinityCenter.exit());
            return  menuItem;
        }

        @Override
        public boolean isVisible(){
            return true;
        }
    } ;


    private Integer no;
    public Integer getNo(){ return no; }
    public void setNo( Integer no ){ this.no = no; }



    private AccountMenu(Integer no ){ this.no = no; }

    public static Menu getMenu( Locale l ){

        Menu menu = new Menu(BundleLoader.getValue( VariablesDefault.ACCOUNT_MAIN_MENU , l ));
        for( AccountMenu a : AccountMenu.values() ){

           if( a.isVisible() ){
               menu.getItems().add( a.getItem( l ) );
           }


        }
        return menu;
    }




}
