package com.naderaria.infinityCenter.view.forms.mainFormPane;


import com.naderaria.infinityCenter.util.VariablesDefault;
import com.naderaria.infinityCenter.view.controllers.AccountController;
import com.naderaria.infinityCenter.view.forms.MainForm;
import com.naderaria.infinityCenter.view.forms.formsItems.menus.BundleLoader;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.Locale;



/**
 * Created by NaderAria on 5/18/2017.
 */
public class RegisteringPane extends AbstractAccountPane{


    public RegisteringPane(Locale locale , MainForm mainForm ) {
        super( locale , mainForm );
        super.setController( new AccountController() );
        super.setPaneTitle(BundleLoader.getValue(VariablesDefault.REGISTERING_FORM_TITLE,locale));
    }

    @Override
    public HBox getButtonPane() throws Exception {

        HBox hBox = new HBox();
        hBox.setSpacing(4);
        hBox.setAlignment( Pos.BASELINE_CENTER );
        hBox.getChildren().addAll(
                            getBtnCancel( e-> getController().cancelAndExit() ),
                            getBtnSave( e-> { try{ getController().save( assembleModel() ); }catch (Exception ex ){ ex.printStackTrace(); } }));


        return hBox;
    }





}
