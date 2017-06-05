package com.naderaria.infinityCenter.view.forms.mainFormPane;


import com.naderaria.infinityCenter.util.VariablesDefault;
import com.naderaria.infinityCenter.view.controllers.AccountController;
import com.naderaria.infinityCenter.view.forms.MainForm;
import com.naderaria.infinityCenter.view.forms.formsItems.menus.BundleLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.Locale;

/**
 * Created by NaderAria on 5/26/2017.
 */
public class AccountPane extends AbstractAccountPane {

    public AccountPane( Locale locale , MainForm mainForm ) {
        super( locale , mainForm );
        super.setController( new AccountController() );
        super.setPaneTitle( BundleLoader.getValue(VariablesDefault.ACCOUNT_PANE_TITLE,getLocale() ));
    }

    @Override
    public HBox getButtonPane() throws Exception {

        HBox hBox = new HBox();
        hBox.setSpacing(4);
        hBox.setAlignment( Pos.BASELINE_CENTER );
        hBox.getChildren().addAll(
                getBtnEdit( e -> getController().edit()  ),
                getBtnUpdate(e ->{
                    try{ getController().update( assembleModel() ); }catch (Exception ex ){ ex.printStackTrace(); }
                } ),
                getBtnCancel(e -> getController().cancel()));

        return hBox;
    }
}
