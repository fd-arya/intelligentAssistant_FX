package com.naderaria.infinityCenter.view.forms;



import com.naderaria.infinityCenter.business.service.GeneralService;
import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.account.Account;
import com.naderaria.infinityCenter.util.FormStateOnUser;
import com.naderaria.infinityCenter.util.VariablesDefault;
import com.naderaria.infinityCenter.view.controllers.Session;
import com.naderaria.infinityCenter.view.forms.formsItems.menus.BundleLoader;
import com.naderaria.infinityCenter.view.forms.formsItems.menus.MainMenu;
import com.naderaria.infinityCenter.view.forms.mainFormPane.AbstractPane;
import com.naderaria.infinityCenter.view.forms.mainFormPane.AccountPane;
import com.naderaria.infinityCenter.view.forms.mainFormPane.LoginPane;
import com.naderaria.infinityCenter.view.forms.mainFormPane.RegisteringPane;
import com.naderaria.infinityCenter.view.interfaces.IUiManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Locale;

/**
 * Created by NaderAria on 5/4/2017.
 */
public class MainForm  extends Application  {


    private Stage mainStage;
    private String stageTitle;
    private Locale locale;
    private FormStateOnUser formStateOnUser;
    private MainMenu menu;
    private Pane mainPane;
    private Pane content;


    public Stage getMainStage(){

        if( mainStage == null ){
            mainStage = new Stage();
        }
        return mainStage;
    }
    private void setMainStage( Stage mainStage ) throws NullPointerException{

        if( mainStage != null ){
            this.mainStage = mainStage;
        }else{ throw new NullPointerException("mainStage is null"); }
    }

    public final String getStageTitle(){
        if( stageTitle == null || stageTitle.isEmpty() ){
            stageTitle =BundleLoader.getValue( VariablesDefault.INFINITY_CENTER_TITLE , getLocale() ) + "  _   ";
        }
        return stageTitle;
    }
    public final void setStageTitle( String stageTitleKey ){
        this.stageTitle = getStageTitle()+ BundleLoader.getValue( stageTitleKey , getLocale() );
    }

    public Locale getLocale(){

        if( locale == null ){
            locale = new Locale( VariablesDefault.EN , VariablesDefault.US );
        }
        return locale;
    }
    public void setLocale( Locale locale ) throws NullPointerException{

        if( locale != null ){
            this.locale = locale;
        }else { throw new NullPointerException("local is null"); }

    }

    public FormStateOnUser getFormStateOnUser(){ return formStateOnUser; }
    public void setFormStateOnUser( FormStateOnUser formStateOnUser ){ this.formStateOnUser = formStateOnUser; }

    public MainMenu getMenu(){

        if( menu == null ){
            menu = new MainMenu();
        }
        return menu;
    }

    public Pane getMainPane(){ return mainPane; }
    public void setMainPane( Pane mainPane ){ this.mainPane = mainPane; }



    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) throws Exception {
        setMainStage( primaryStage );
        if( checkDbHaveUser()){
            setFormStateOnUser( FormStateOnUser.LOGIN_FORM );
        }else{
            setFormStateOnUser( FormStateOnUser.REGISTERING_FORM );
        }
       // setFormStateOnUser( FormStateOnUser.NORMAL_FORM );
        initializeMainFormUI();
    }

    private boolean checkDbHaveUser() throws Exception {
        return ( new GeneralService().fetchCount( Account.class , IQueryNames.ACCOUNT_SELECT_EXISTS_ACCOUNT_KEY )  ) > 0L ;
    }
    private void initializeMainFormUI() throws Exception {


        getMainStage().setResizable(true);
        getMainStage().setAlwaysOnTop( true );
        getMainStage().setTitle( getStageTitle() );
        getMainStage().setScene( getScene() );
        getMainStage().sizeToScene();
        getMainStage().show();

    }

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

    public static void showWarning( String  message ){

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Look, an Error Dialog");
        alert.setContentText(message);

        alert.showAndWait();
    }

    public static void exit(){

        Platform.exit();
    }

































}
