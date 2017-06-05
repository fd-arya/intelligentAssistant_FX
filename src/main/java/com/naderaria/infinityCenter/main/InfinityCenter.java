package com.naderaria.infinityCenter.main;


import com.naderaria.infinityCenter.business.service.GeneralService;
import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.account.Account;
import com.naderaria.infinityCenter.util.FormStateOnUser;
import com.naderaria.infinityCenter.util.VariablesDefault;
import com.naderaria.infinityCenter.view.controllers.Session;
import com.naderaria.infinityCenter.view.forms.MainForm;
import com.naderaria.infinityCenter.view.forms.formsItems.menus.BundleLoader;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.Locale;

/**
 * Created by NaderAria on 5/12/2017.
 */
public class InfinityCenter extends Application {


    private Stage mainStage;
    private Locale locale;



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



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        setMainStage( primaryStage );
        initialize();
    }

    public void initialize(){

        try{
            initializeMainFormUI();
           /* if( checkDbHaveUser() ){
                initializeLoginUI();
            }else{
                initializeRegisteringUI();
            }*/

        }catch ( Exception e ){
           e.printStackTrace();
        }
    }

    private boolean checkDbHaveUser() throws Exception {
      return ( new GeneralService().fetchCount( Account.class , IQueryNames.ACCOUNT_SELECT_EXISTS_ACCOUNT_KEY )  ) > 0L ;
    }


   /* private void initializeLoginUI() throws Exception{

        getMainStage().setResizable(false);
        getMainStage().setAlwaysOnTop( false );
        //setMainFormTitle( BundleLoader.getValue( VariablesDefault.LOGIN_FORM_TITLE , getLocale() ) );
       // getMainStage().setTitle( getMainFormTitle() );
        getMainStage().setScene( getLoginForm() );
        getMainStage().sizeToScene();
        getMainStage().show();

    }*/

   /* private Scene getLoginForm() throws Exception{

        LoginForm loginForm = new LoginForm();
        loginForm.setMainApplication( this );
        loginForm.setLocale( getLocale() );
        return loginForm.getScene();
    }
*/
   /* private void initializeRegisteringUI() throws Exception {

        getMainStage().setResizable(false);
        getMainStage().setAlwaysOnTop( false );
       // setMainFormTitle( getWindowTitle( VariablesDefault.REGISTERING_FORM_TITLE ) );
       // getMainStage().setTitle( getMainFormTitle() );
        getMainStage().setScene( getRegisteringForm() );
        getMainStage().sizeToScene();
        getMainStage().show();

    }
*/
   /* private Scene getRegisteringForm() throws Exception {

       // RegisteringPane registeringPane = new RegisteringPane();
        //registeringPane.setMainApplication( this );
        //registeringPane.setLocale( getLocale() );
       // return registeringPane.getScene();
        return null;

    }*/

    private void initializeMainFormUI() throws Exception {

        getMainStage().setResizable(true);
        getMainStage().setAlwaysOnTop( true );
      //  setMainFormTitle( BundleLoader.getValue( VariablesDefault.INFINITY_CENTER_TITLE , getLocale() ) + "  _  " + getUserName() );
       // getMainStage().setTitle( getMainFormTitle() );
        getMainStage().setScene( getMainForm() );
        getMainStage().sizeToScene();
        getMainStage().show();

    }


    private Scene getMainForm() throws Exception {

        MainForm mainForm = new MainForm(this);
        mainForm.setFormStateOnUser( FormStateOnUser.LOGIN_FORM );
       // mainForm.setMainApplication( this );
        mainForm.setLocale( getLocale() );
        return mainForm.getScene();

    }

    public static void showWarning( String  message ){

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Look, an Error Dialog");
        alert.setContentText(message);

        alert.showAndWait();
    }

    public void changedScene() throws Exception{

        if( !Session.isNull() ){
            getMainStage().getScene().getWindow().hide();
            initializeMainFormUI();
        }

    }

    private String getWindowTitle( String titleKey ){

        return BundleLoader.getValue( VariablesDefault.INFINITY_CENTER_TITLE , getLocale() ) + "  _   "  + BundleLoader.getValue( titleKey , getLocale() );

    }

    public static void exit(){

        Platform.exit();
    }
}
