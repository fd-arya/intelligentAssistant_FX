package com.naderaria.infinityCenter.view.forms.mainFormPane;

import com.naderaria.infinityCenter.model.account.Login;
import com.naderaria.infinityCenter.model.account.UserNamePassword;
import com.naderaria.infinityCenter.util.UiUtil;
import com.naderaria.infinityCenter.util.VariablesDefault;
import com.naderaria.infinityCenter.view.controllers.LoginController;
import com.naderaria.infinityCenter.view.forms.MainForm;
import com.naderaria.infinityCenter.view.forms.formsItems.menus.BundleLoader;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Locale;

/**
 * Created by NaderAria on 6/1/2017.
 */
public class LoginPane extends AbstractPane<LoginController,Login> {

    public LoginPane(Locale locale , MainForm mainForm ) {
        super( locale , mainForm );
        super.setController( new LoginController() );
        super.setPaneTitle( BundleLoader.getValue(VariablesDefault.LOGIN_FORM_TITLE,locale));
    }


    private Label lblUserName;
    private Label lblPassword;
    private Label lblMessage;
    private TextField txtUserName;
    private PasswordField txtPassword;
    private Button btnLogin;
    private Button btnCancel;





    private Label getLblUserName(){

        if( lblUserName == null ){
            lblUserName = new Label(BundleLoader.getValue(VariablesDefault.LBL_USER_NAME,getLocale()));
            UiUtil.setControlDefaultUi( lblUserName );
        }
        return lblUserName;
    }
    private TextField getTxtUserName(){

        if( txtUserName == null ){
            txtUserName = new TextField();
            UiUtil.setControlDefaultUi( txtUserName , getLblUserName().getText() );
        }
        return txtUserName;
    }

    private Label getLblPassword(){

        if( lblPassword == null ){
            lblPassword = new Label(BundleLoader.getValue(VariablesDefault.LBL_PASSWORD,getLocale()));
            UiUtil.setControlDefaultUi( lblPassword );
        }
        return lblPassword;
    }
    private PasswordField getTxtPassword(){

        if( txtPassword == null ){
            txtPassword = new PasswordField();
            UiUtil.setControlDefaultUi( txtPassword , getLblPassword().getText() );
        }
        return txtPassword;
    }

    private Label getLblMessage(){

        if( lblMessage == null ){
            lblMessage = new Label();
            UiUtil.setControlDefaultUi( lblMessage );
        }
        return lblMessage;
    }

    private Button getBtnLogin(){

        if( btnLogin == null ){
            btnLogin = new Button( BundleLoader.getValue( VariablesDefault.BTN_LOGIN , getLocale() ) );
            UiUtil.setControlDefaultUi( btnLogin , BundleLoader.getValue(VariablesDefault.BTN_LOGIN , getLocale() ));
            btnLogin.setOnAction( e -> {
                String msg = "";
                try{
                     msg = LoginController.login( assembleModel() , getMainForm() );

                }catch ( Exception ex ){
                    ex.printStackTrace();
                }
                getLblMessage().setText( msg );
            });

        }
        return btnLogin;
    }

    private Button getBtnCancel(){

        if( btnCancel == null ){

            btnCancel = new Button( BundleLoader.getValue( VariablesDefault.BTN_CANCEL_AND_EXIT , getLocale() ) );
            UiUtil.setControlDefaultUi( btnCancel , BundleLoader.getValue(VariablesDefault.BTN_CANCEL_AND_EXIT , getLocale() ));
            btnCancel.setOnAction( e -> Platform.exit() );
        }
        return btnCancel;
    }


    @Override
    public HBox getButtonPane() throws Exception {

        HBox buttonHBox = new HBox();
        buttonHBox.setAlignment( Pos.BASELINE_CENTER );
        buttonHBox.setSpacing( 5 );
        buttonHBox.setPadding( new Insets(2,2,2,30) );
        buttonHBox.getChildren().addAll( getBtnCancel() , getBtnLogin() );
        return buttonHBox;
    }


    @Override
    public Pane getContentPane() throws Exception {

        HBox userNameHBox = new HBox();
        userNameHBox.setAlignment( Pos.BASELINE_CENTER );
        userNameHBox.setPadding( new Insets(2,2,2,30) );
        userNameHBox.setSpacing( 5 );
        userNameHBox.getChildren().addAll( getLblUserName() , getTxtUserName() );

        HBox passwordHBox = new HBox();
        passwordHBox.setAlignment( Pos.BASELINE_CENTER );
        passwordHBox.setSpacing( 5 );
        passwordHBox.setPadding( new Insets(2,2,2,30) );
        passwordHBox.getChildren().addAll( getLblPassword() , getTxtPassword() );


        VBox arrangedVBox = new VBox();
        arrangedVBox.setAlignment( Pos.BASELINE_CENTER );
        arrangedVBox.setSpacing( 10 );
        arrangedVBox.setPadding( new Insets(4,30,20,2) );
        arrangedVBox.getChildren().addAll( userNameHBox , passwordHBox , getLblMessage()  );

        BorderPane pane = new BorderPane();
        pane.setPadding( new Insets(2) );

        Reflection r = new Reflection();
        r.setFraction(0.7f);
        //gridPane.setEffect(r);
        arrangedVBox.setEffect( r );

        HBox hBox = new HBox();
        hBox.setPadding( new Insets(20,20,20,30) );
        hBox.setAlignment(Pos.CENTER);
        //hBox.backgroundProperty().set( new Background( new BackgroundFill(Color.BLUE,CornerRadii.EMPTY,Insets.EMPTY)));
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(5);
        Text text = new Text(BundleLoader.getValue( VariablesDefault.LOGIN_FORM_HEADER , getLocale() ));
        text.setFont(Font.font("Courier New", FontWeight.NORMAL, 18));
        text.setEffect( dropShadow );
        hBox.getChildren().add(text);

        pane.setTop(hBox);
        pane.setCenter( arrangedVBox );
        return pane;

    }


    @Override
    public Login assembleModel() throws Exception {

        UserNamePassword userNamePassword = new UserNamePassword()
                                                .setUserName( getTxtUserName().getText() )
                                                .setPassword( getTxtPassword().getText() );
        return  new Login().setUserNamePassword( userNamePassword );
    }






    //pane.backgroundProperty().set( new Background( new BackgroundFill(Color.RED,CornerRadii.EMPTY,Insets.EMPTY)));




        /*GridPane gridPane = new GridPane();
        gridPane.gridLinesVisibleProperty().setValue(true);
        gridPane.setPadding(new Insets(20,20,20,20));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.backgroundProperty().set( new Background( new BackgroundFill(Color.YELLOW,CornerRadii.EMPTY,Insets.EMPTY)));
        gridPane.add(getLblUserName(), 0, 0);
        gridPane.add(getTxtUserName(), 1, 0);
        gridPane.add(getLblPassword(), 0, 1);
        gridPane.add(getTxtPassword(), 1, 1);
        gridPane.add(getBtnLogin(), 2, 1);
        gridPane.add(getLblMessage(), 1, 2);
        gridPane.add(getBtnCancel(),1,3);
*/

    // pane.setCenter(gridPane);




}
