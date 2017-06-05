package com.naderaria.infinityCenter.view.forms.mainFormPane;

import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import com.naderaria.infinityCenter.util.VariablesDefault;
import com.naderaria.infinityCenter.view.forms.MainForm;
import com.naderaria.infinityCenter.view.forms.formsItems.menus.BundleLoader;
import com.naderaria.infinityCenter.view.interfaces.IControllerManager;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Locale;

/**
 * Created by NaderAria on 5/26/2017.
 */
public abstract class AbstractPane<T extends IControllerManager , E extends BaseEntity> {


    private MainForm mainForm;
    private T controller;
    private Locale locale;
    private boolean editableMode = false;
    private String paneTitle;
    private Button btnInsert;
    private Button btnSave;
    private Button btnEdit;
    private Button btnUpdate;
    private Button btnCancel;


    public  AbstractPane( Locale locale , MainForm mainForm ){
        this.locale = locale;
        this.mainForm = mainForm;
    }

    public MainForm getMainForm(){ return mainForm; }
    public void setMainForm( MainForm mainForm ){ this.mainForm = mainForm; }

    public T getController(){
        return controller;
    }
    public void setController( T controller ){ this.controller = controller; }

    public Locale getLocale(){ return  locale; }
    public void setLocale( Locale locale ) throws Exception{
        if( locale == null ){
           throw new Exception("locale in null ");
        }
        this.locale = locale;
    }

    public boolean isEditableMode(){ return editableMode; }
    public void setEditableMode( boolean editableMode ){ this.editableMode = editableMode; }

    public String getPaneTitle(){ return paneTitle; }
    public void setPaneTitle( String paneTitle ){ this.paneTitle = paneTitle; }


    public Button getBtnInsert( EventHandler<ActionEvent> eventHandler ) {

        if( btnInsert == null ){
            btnInsert = new Button(BundleLoader.getValue(VariablesDefault.BTN_INSERT,getLocale()));
            btnInsert.setOnAction(eventHandler);
        }
        return btnInsert;
    }

    public Button getBtnSave( EventHandler<ActionEvent> eventHandler ) {

        if( btnSave == null ){
            btnSave = new Button(BundleLoader.getValue(VariablesDefault.BTN_SAVE, getLocale() ));
            btnSave.setOnAction(eventHandler);
        }
        return btnSave;
    }

    public Button getBtnEdit( EventHandler<ActionEvent> eventHandler ) {

        if( btnEdit == null ){
            btnEdit = new Button(BundleLoader.getValue(VariablesDefault.BTN_EDIT, getLocale() ));
            btnEdit.setOnAction(eventHandler);
        }
        return btnEdit;
    }

    public Button getBtnUpdate( EventHandler<ActionEvent> eventHandler ) {

        if( btnUpdate == null ){
            btnUpdate = new Button(BundleLoader.getValue(VariablesDefault.BTN_UPDATE, getLocale() ));
            btnUpdate.setOnAction(eventHandler);
        }
        return btnUpdate;
    }

    public Button getBtnCancel( EventHandler<ActionEvent> eventHandler ) {

        if( btnCancel == null ){
            btnCancel = new Button(BundleLoader.getValue(VariablesDefault.BTN_CANCEL, getLocale() ));
            btnCancel.setOnAction(eventHandler);
        }
        return btnCancel;
    }


    public  Pane getPane() throws Exception{

        BorderPane borderPane = new BorderPane();
        borderPane.setTop( getTitlePane() );
        borderPane.setCenter( getContentPane() );
        borderPane.setBottom( getButtonPane() );
        return borderPane;
    }

    public HBox getTitlePane() throws Exception{

        HBox hBox = new HBox();
        hBox.setAlignment(Pos.BASELINE_CENTER );
        hBox.getChildren().add( getTitleLabel() );
        hBox.setBackground( new Background( new BackgroundFill(Color.BLACK,CornerRadii.EMPTY,Insets.EMPTY ) ) );
        hBox.setPrefHeight(30);
        hBox.autosize();
        return hBox;
    }

    public Label getTitleLabel(){

        Label titleLabel  = new Label( getPaneTitle() );
        titleLabel.setAlignment(Pos.BASELINE_CENTER);
        titleLabel.autosize();
        titleLabel.setPadding( new Insets( 2 ) );
        titleLabel.setStyle("-fx-text-fill: white; -fx-font-size: 16;");
        return titleLabel;
    }

    public abstract Pane getContentPane() throws Exception;
    public abstract HBox getButtonPane( ) throws Exception;
    public abstract E assembleModel() throws Exception;


}
