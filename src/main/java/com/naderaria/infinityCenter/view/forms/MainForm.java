package com.naderaria.infinityCenter.view.forms;



import com.naderaria.infinityCenter.main.InfinityCenter;
import com.naderaria.infinityCenter.util.FormStateOnUser;
import com.naderaria.infinityCenter.view.forms.formsItems.menus.MainMenu;
import com.naderaria.infinityCenter.view.forms.mainFormPane.AbstractPane;
import com.naderaria.infinityCenter.view.forms.mainFormPane.AccountPane;
import com.naderaria.infinityCenter.view.forms.mainFormPane.LoginPane;
import com.naderaria.infinityCenter.view.forms.mainFormPane.RegisteringPane;
import com.naderaria.infinityCenter.view.interfaces.IUiManager;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import java.util.Locale;

/**
 * Created by NaderAria on 5/4/2017.
 */
public class MainForm implements IUiManager {

    private InfinityCenter parent;
    private FormStateOnUser formStateOnUser;
    private Locale locale;
    private MainMenu menu;
    private Pane mainPane;
    private Pane content;

    public MainForm( InfinityCenter parent ){
        this.parent = parent;
    }

    public final InfinityCenter getParent(){ return parent; }

    public FormStateOnUser getFormStateOnUser(){ return formStateOnUser; }
    public void setFormStateOnUser( FormStateOnUser formStateOnUser ){ this.formStateOnUser = formStateOnUser; }

    @Override
    public Locale getLocale(){
        if( locale != null ){ return locale; }
        throw new NullPointerException("locale is null ");
    }
    public void setLocale( Locale locale ){ this.locale = locale; }

    public MainMenu getMenu(){

        if( menu == null ){
            menu = new MainMenu();
        }
        return menu;
    }

    public Pane getMainPane(){ return mainPane; }
    public void setMainPane( Pane mainPane ){ this.mainPane = mainPane; }



    @Override
    public Scene getScene() throws Exception {

        if( getFormStateOnUser().equals( FormStateOnUser.NORMAL_FORM) ){
            setMainPane( getNormalPane() );
        }else{
            setMainPane( getLimitedPane() );
        }
        return new Scene( getMainPane() ,800 , 800  );
    }



    private BorderPane getNormalPane() throws Exception {

        //setContent( new AccountPane( getLocale(),this ).getPane() );
        setContent(null);
        BorderPane borderPane = new BorderPane();
        borderPane.setTop( getMenu().getMenuBar( locale ) );

        borderPane.setCenter( getContent() );
        borderPane.setRight( getSidBarPane() );
        borderPane.setBottom( getStatePane() );
        return borderPane;
    }

    private BorderPane getLimitedPane() throws Exception {

        BorderPane borderPane = new BorderPane();
        if( getFormStateOnUser().equals(FormStateOnUser.LOGIN_FORM)){

            setContent( new LoginPane( getLocale() , this ).getPane() );
            borderPane.setCenter( getContent() );
        }else {
            setContent( new RegisteringPane( getLocale() , this ).getPane() );
            borderPane.setCenter( getContent() );
        }
        return borderPane;
    }

    public Pane getContent(){ return content; }
    public void setContent( Pane content ){ this.content = content; }




    private StackPane getSidBarPane(){

        StackPane pane = new StackPane();

        return pane;
    }

    private StackPane getStatePane(){

        StackPane pane = new StackPane();

        return pane;
    }



}
