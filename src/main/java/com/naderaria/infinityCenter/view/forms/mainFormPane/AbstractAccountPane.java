package com.naderaria.infinityCenter.view.forms.mainFormPane;

import com.naderaria.infinityCenter.model.account.Account;
import com.naderaria.infinityCenter.model.account.Address;
import com.naderaria.infinityCenter.model.account.CallInfo;
import com.naderaria.infinityCenter.model.enums.Gender;
import com.naderaria.infinityCenter.util.UiUtil;
import com.naderaria.infinityCenter.util.VariablesDefault;
import com.naderaria.infinityCenter.view.controllers.AccountController;
import com.naderaria.infinityCenter.view.forms.MainForm;
import com.naderaria.infinityCenter.view.forms.formsItems.menus.BundleLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.time.chrono.HijrahChronology;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * Created by NaderAria on 5/29/2017.
 */
public abstract class AbstractAccountPane extends AbstractPane<AccountController,Account> {

    private Label lblFirstName;
    private TextField txtFirstName;
    private Label lblLastName;
    private TextField txtLastName;
    private Label lblGender;
    private ComboBox<Gender> cmbGender;
    private Label lblBirthCity;
    private TextField txtBirthCity;
    private Label lblBirthDate;
    private DatePicker dtpBirthDate;

    private Label lblUserImage;
    private ImageView imgViewUserImage;


    private Label lblTitle;
    private TextField txtTitle;
    private Label lblCountry;
    private TextField txtCountry;
    private Label lblCity;
    private TextField txtCity;
    private Label lblStreet;
    private TextField txtStreet;
    private Label lblAlley;
    private TextField txtAlley;
    private Label lblZipCode;
    private TextField txtZipCode;
    private Label lblNo;
    private TextField txtNo;

    private Label lblPhone;
    private TextField txtPhone;
    private Label lblCell;
    private TextField txtCell;
    private Label lblEmail;
    private TextField txtEmail;
    private Label lblWebSite;
    private TextField txtWebSite;

    private Label lblUserName;
    private TextField txtUserName;
    private Label lblPassword;
    private PasswordField psfPassword;
    private Label lblRepeatPassword;
    private PasswordField psfRepeatPassword;


    private Button btnUploadImage;

    public AbstractAccountPane(Locale locale , MainForm mainForm ) {
        super(locale , mainForm );
    }

    private Label getLblFirstName(){

        if( lblFirstName == null ){
            lblFirstName = new Label(BundleLoader.getValue(VariablesDefault.LBL_FIRST_NAME, getLocale() ));
            UiUtil.setControlDefaultUi( lblFirstName );
        }
        return lblFirstName;

    }
    public TextField getTxtFirstName(){

        if( txtFirstName == null ){
            txtFirstName = new TextField();
            UiUtil.setControlDefaultUi(txtFirstName, getLblFirstName().getText() , isEditableMode() );

        }
        return txtFirstName;

    }

    private Label getLblLastName(){

        if( lblLastName == null ){
            lblLastName = new Label(BundleLoader.getValue(VariablesDefault.LBL_LAST_NAME, getLocale() ));
            UiUtil.setControlDefaultUi( lblLastName );
        }
        return lblLastName;

    }
    public TextField getTxtLastName(){

        if( txtLastName == null ){
            txtLastName = new TextField();
            UiUtil.setControlDefaultUi(txtLastName, getLblLastName().getText() , isEditableMode() );
        }
        return txtLastName;

    }

    private Label getLblGender(){

        if( lblGender == null ){
            lblGender = new Label(BundleLoader.getValue(VariablesDefault.LBL_GENDER, getLocale() ));
            UiUtil.setControlDefaultUi( lblGender );
        }
        return lblGender;

    }
    public ComboBox<Gender> getCmbGender(){

        if( cmbGender == null ){
            cmbGender = new ComboBox<>();
            cmbGender.getItems().addAll(Gender.values());
            UiUtil.setControlDefaultUi( cmbGender , getLblGender().getText()  , isEditableMode() );
        }
        return cmbGender;

    }

    private Label getLblBirthCity(){

        if( lblBirthCity == null ){
            lblBirthCity = new Label(BundleLoader.getValue(VariablesDefault.LBL_BIRTH_CITY, getLocale() ));
            UiUtil.setControlDefaultUi( lblBirthCity );
        }
        return lblBirthCity;

    }
    public TextField getTxtBirthCity(){

        if( txtBirthCity == null ){
            txtBirthCity = new TextField();
            UiUtil.setControlDefaultUi(txtBirthCity, getLblBirthCity().getText()  , isEditableMode() );
        }
        return txtBirthCity;

    }

    private Label getLblBirthDate(){

        if( lblBirthDate == null ){
            lblBirthDate = new Label(BundleLoader.getValue(VariablesDefault.LBL_BIRTH_DATE, getLocale() ));
            UiUtil.setControlDefaultUi( lblBirthDate );
        }
        return lblBirthDate;

    }
    public DatePicker getDtpBirthDate(){

        if( dtpBirthDate == null ){
            dtpBirthDate = new DatePicker();
            dtpBirthDate.setShowWeekNumbers(true);
            if(  getLocale() .getCountry().equals(VariablesDefault.IR)){
                dtpBirthDate.setChronology(HijrahChronology.INSTANCE);
            }
            UiUtil.setControlDefaultUi( dtpBirthDate , getLblBirthDate().getText()  , isEditableMode() );
        }
        return dtpBirthDate;

    }


    public Label getLblUserImage(){

        if( lblUserImage == null ){
            lblUserImage = new Label(BundleLoader.getValue(VariablesDefault.LBL_USER_IMAGE, getLocale() ));
            UiUtil.setControlDefaultUi( lblUserImage );
        }
        return lblUserImage;

    }
    private ImageView getImgViewUserImage(){

        if( imgViewUserImage == null ){
            imgViewUserImage = new ImageView();

            imgViewUserImage.setImage( new Image( "Images/test2.jpg") );
            imgViewUserImage.setFitWidth(130);
            imgViewUserImage.setFitHeight(130);

        }
        return imgViewUserImage;
    }



    private Label getLblTitle(){

        if( lblTitle == null ){
            lblTitle = new Label(BundleLoader.getValue(VariablesDefault.LBL_TITLE, getLocale() ));
            UiUtil.setControlDefaultUi( lblTitle );
        }
        return lblTitle;

    }
    public TextField getTxtTitle(){

        if( txtTitle == null ){
            txtTitle = new TextField();
            UiUtil.setControlDefaultUi(txtTitle, getLblTitle().getText()  , isEditableMode() );
        }
        return txtTitle;

    }

    private Label getLblCountry(){

        if( lblCountry == null ){
            lblCountry = new Label(BundleLoader.getValue(VariablesDefault.LBL_COUNTRY, getLocale() ));
            UiUtil.setControlDefaultUi( lblCountry );
        }
        return lblCountry;

    }
    public TextField getTxtCountry(){

        if( txtCountry == null ){
            txtCountry = new TextField();
            UiUtil.setControlDefaultUi(txtCountry, getLblCountry().getText()  , isEditableMode() );
        }
        return txtCountry;

    }

    private Label getLblCity(){

        if( lblCity == null ){
            lblCity = new Label(BundleLoader.getValue(VariablesDefault.LBL_CITY, getLocale() ));
            UiUtil.setControlDefaultUi( lblCity );
        }
        return lblCity;

    }
    public TextField getTxtCity(){

        if( txtCity == null ){
            txtCity = new TextField();
            UiUtil.setControlDefaultUi(txtCity, getLblCity().getText()  , isEditableMode() );
        }
        return txtCity;

    }

    private Label getLblStreet(){

        if( lblStreet == null ){
            lblStreet = new Label(BundleLoader.getValue(VariablesDefault.LBL_STREET, getLocale() ));
            UiUtil.setControlDefaultUi( lblStreet );
        }
        return lblStreet;

    }
    public TextField getTxtStreet(){

        if( txtStreet == null ){
            txtStreet = new TextField();
            UiUtil.setControlDefaultUi(txtStreet, getLblStreet().getText()  , isEditableMode() );
        }
        return txtStreet;

    }

    private Label getLblAlley(){

        if( lblAlley == null ){
            lblAlley = new Label(BundleLoader.getValue(VariablesDefault.LBL_ALLEY, getLocale() ));
            UiUtil.setControlDefaultUi( lblAlley );
        }
        return lblAlley;

    }
    public TextField getTxtAlley(){

        if( txtAlley == null ){
            txtAlley = new TextField();
            UiUtil.setControlDefaultUi(txtAlley, getLblAlley().getText()  , isEditableMode() );
        }
        return txtAlley;

    }

    private Label getLblZipCode(){

        if( lblZipCode == null ){
            lblZipCode = new Label(BundleLoader.getValue(VariablesDefault.LBL_ZIP_CODE, getLocale() ));
            UiUtil.setControlDefaultUi( lblZipCode );
        }
        return lblZipCode;

    }
    public TextField getTxtZipCode(){

        if( txtZipCode == null ){
            txtZipCode = new TextField();
            UiUtil.setControlDefaultUi(txtZipCode, getLblZipCode().getText()  , isEditableMode() );
        }
        return txtZipCode;

    }

    private Label getLblNo(){

        if( lblNo == null ){
            lblNo = new Label(BundleLoader.getValue(VariablesDefault.LBL_NO, getLocale() ));
            UiUtil.setControlDefaultUi( lblNo );
        }
        return lblNo;

    }
    public TextField getTxtNo(){

        if( txtNo == null ){
            txtNo = new TextField();
            UiUtil.setControlDefaultUi(txtNo, getLblNo().getText()  , isEditableMode() );
        }
        return txtNo;

    }

    private Label getLblPhone(){

        if( lblPhone == null ){
            lblPhone = new Label(BundleLoader.getValue(VariablesDefault.LBL_PHONE, getLocale() ));
            UiUtil.setControlDefaultUi( lblPhone );
        }
        return lblPhone;

    }
    public TextField getTxtPhone(){

        if( txtPhone == null ){
            txtPhone = new TextField();
            UiUtil.setControlDefaultUi(txtPhone, getLblPhone().getText()  , isEditableMode() );
        }
        return txtPhone;

    }

    private Label getLblCell(){

        if( lblCell == null ){
            lblCell = new Label(BundleLoader.getValue(VariablesDefault.LBL_CELL, getLocale() ));
            UiUtil.setControlDefaultUi( lblCell );
        }
        return lblCell;

    }
    public TextField getTxtCell(){

        if( txtCell == null ){
            txtCell = new TextField();
            UiUtil.setControlDefaultUi(txtCell, getLblCell().getText()  , isEditableMode() );
        }
        return txtCell;

    }

    private Label getLblEmail(){

        if( lblEmail == null ){
            lblEmail = new Label(BundleLoader.getValue(VariablesDefault.LBL_EMAIL, getLocale() ));
            UiUtil.setControlDefaultUi( lblEmail );
        }
        return lblEmail;

    }
    public TextField getTxtEmail(){

        if( txtEmail == null ){
            txtEmail = new TextField();
            UiUtil.setControlDefaultUi(txtEmail, getLblEmail().getText()  , isEditableMode() );
        }
        return txtEmail;

    }

    private Label getLblWebSite(){

        if( lblWebSite == null ){
            lblWebSite = new Label(BundleLoader.getValue(VariablesDefault.LBL_WEB_SITE, getLocale() ));
            UiUtil.setControlDefaultUi( lblWebSite );
        }
        return lblWebSite;

    }
    public TextField getTxtWebSite(){

        if( txtWebSite == null ){
            txtWebSite = new TextField();
            UiUtil.setControlDefaultUi(txtWebSite, getLblWebSite().getText()  , isEditableMode() );
        }
        return txtWebSite;

    }

    private Label getLblUserName(){

        if( lblUserName == null ){
            lblUserName = new Label(BundleLoader.getValue(VariablesDefault.LBL_USER_NAME, getLocale() ));
            UiUtil.setControlDefaultUi( lblUserName );
        }
        return lblUserName;

    }
    public TextField getTxtUserName(){

        if( txtUserName == null ){
            txtUserName = new TextField();
            UiUtil.setControlDefaultUi(txtUserName, getLblUserName().getText()  , isEditableMode() );
        }
        return txtUserName;

    }

    private Label getLblPassword(){

        if( lblPassword == null ){
            lblPassword = new Label(BundleLoader.getValue(VariablesDefault.LBL_PASSWORD, getLocale() ));
            UiUtil.setControlDefaultUi( lblPassword );
        }
        return lblPassword;

    }
    public PasswordField getPsfPassword(){

        if( psfPassword == null ){
            psfPassword = new PasswordField();
            UiUtil.setControlDefaultUi(psfPassword, getLblPassword().getText()  , isEditableMode() );

        }
        return psfPassword;

    }

    private Label getLblRepeatPassword(){

        if( lblRepeatPassword == null ){
            lblRepeatPassword = new Label( BundleLoader.getValue(VariablesDefault.LBL_REPEAT_PASSWORD, getLocale() ));
            UiUtil.setControlDefaultUi( lblRepeatPassword );
        }
        return lblRepeatPassword;
    }
    public PasswordField getPsfRepeatPassword(){

        if( psfRepeatPassword == null ){
            psfRepeatPassword = new PasswordField();
            UiUtil.setControlDefaultUi( psfRepeatPassword , getLblRepeatPassword().getText()  , isEditableMode() );
        }
        return psfRepeatPassword;
    }

    public Button getBtnUploadImage(){

        if( btnUploadImage == null ){
            btnUploadImage = new Button(BundleLoader.getValue(VariablesDefault.BTN_UPLOAD_IMAGE, getLocale() ));
            btnUploadImage.setPadding( new Insets( 2 ) );
            btnUploadImage.setPrefSize(170,30);

            btnUploadImage.setOnAction( e -> {

            });
        }
        return btnUploadImage;
    }






    @Override
    public Pane getContentPane() throws Exception{

        VBox vBox = new VBox();
        vBox.setSpacing( 4 );
        vBox.getChildren().addAll( getPersonalPane() , getPublicInfoPane() );
        return vBox;
    }

    private BorderPane getPersonalPane(){

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft( getPersonalInfoPane() );
        borderPane.setCenter( getSecurityPane() );
        borderPane.setRight( getImageViewerTitledPane() );
        borderPane.setPadding( new Insets(4) );
        return borderPane;

    }

    private TitledPane getPersonalInfoPane(){

        SortedMap<Integer,Map<Node,Node>> elements = new TreeMap<>();
        elements.put( 1 , UiUtil.createNewRecordFromNodes( getLblFirstName() , getTxtFirstName() ) );
        elements.put( 2 , UiUtil.createNewRecordFromNodes( getLblLastName() , getTxtLastName() ) );
        elements.put( 3 , UiUtil.createNewRecordFromNodes( getLblGender() , getCmbGender() ) );
        elements.put( 4 , UiUtil.createNewRecordFromNodes( getLblBirthCity() , getTxtBirthCity() ) );
        elements.put( 5 , UiUtil.createNewRecordFromNodes( getLblBirthDate() , getDtpBirthDate() ) );
        return UiUtil.getTitledPane( BundleLoader.getValue(VariablesDefault.LBL_PERSONAL ,  getLocale()  ) , elements );
    }

    private TitledPane getSecurityPane(){

        SortedMap<Integer,Map<Node,Node>> elements = new TreeMap<>();
        elements.put( 1 , UiUtil.createNewRecordFromNodes( getLblUserName() , getTxtUserName() ));
        elements.put( 2 , UiUtil.createNewRecordFromNodes( getLblPassword() , getPsfPassword() ));
        elements.put( 3 , UiUtil.createNewRecordFromNodes( getLblRepeatPassword() , getPsfRepeatPassword() ));
        return UiUtil.getTitledPane( BundleLoader.getValue( VariablesDefault.LBL_SECURITY ,  getLocale()  ) , elements );

    }

    private TitledPane getImageViewerTitledPane(){

        TitledPane imageViewerTitlePan = new TitledPane();
        VBox vBox = new VBox();
        vBox.setPadding( new Insets(2) );
        vBox.setFillWidth( true );
        vBox.setPrefSize( 110 , 180 );
        vBox.getChildren().addAll( getImgViewUserImage() , getBtnUploadImage() );
        vBox.setSpacing( 10 );
        imageViewerTitlePan.setContent( vBox );
        imageViewerTitlePan.setText( BundleLoader.getValue( VariablesDefault.LBL_USER_IMAGE ,  getLocale()  ));
        imageViewerTitlePan.setAlignment( Pos.BASELINE_LEFT );
        imageViewerTitlePan.setPadding( new Insets(4) );
        imageViewerTitlePan.setCollapsible( false );
        return imageViewerTitlePan;
    }

    private BorderPane getPublicInfoPane(){

        BorderPane borderPane = new BorderPane();
        borderPane.setLeft( getAddressPane() );
        borderPane.setCenter( getCallInfoPane() );
        borderPane.setPadding( new Insets(4) );
        return borderPane;
    }

    private TitledPane getAddressPane(){

        SortedMap<Integer,Map<Node,Node>> elements = new TreeMap<>();
        elements.put( 1 , UiUtil.createNewRecordFromNodes( getLblTitle() , getTxtTitle() ) );
        elements.put( 2 , UiUtil.createNewRecordFromNodes( getLblCountry() , getTxtCountry() ) );
        elements.put( 3 , UiUtil.createNewRecordFromNodes( getLblCity() , getTxtCity() ) );
        elements.put( 4 , UiUtil.createNewRecordFromNodes( getLblStreet() , getTxtStreet() ) );
        elements.put( 5 , UiUtil.createNewRecordFromNodes( getLblAlley() , getTxtAlley() ) );
        elements.put( 6 , UiUtil.createNewRecordFromNodes( getLblZipCode() , getTxtZipCode() ) );
        elements.put( 7 , UiUtil.createNewRecordFromNodes( getLblNo() , getTxtNo() ) );
        return UiUtil.getTitledPane( BundleLoader.getValue( VariablesDefault.LBL_ADDRESS ,  getLocale()  ) , elements );

    }

    private TitledPane getCallInfoPane(){

        SortedMap<Integer,Map<Node,Node>> elements = new TreeMap<>();
        elements.put( 1 , UiUtil.createNewRecordFromNodes(getLblPhone() , getTxtPhone() ) );
        elements.put( 2 , UiUtil.createNewRecordFromNodes(getLblCell() , getTxtCell() ) );
        elements.put( 3 , UiUtil.createNewRecordFromNodes(getLblEmail() , getTxtEmail() ) );
        elements.put( 4 , UiUtil.createNewRecordFromNodes(getLblWebSite() , getTxtWebSite() ) );
        return UiUtil.getTitledPane( BundleLoader.getValue( VariablesDefault.LBL_CALL_INFO ,  getLocale()  ) , elements );
    }

    @Override
    public Account assembleModel() throws Exception {

        Address address = new Address()
                              .setTitle( getTxtTitle().getText() )
                              .setCountry( getTxtCountry().getText() )
                              .setZipCode( getTxtZipCode().getText() )
                              .setCity( getTxtCity().getText() )
                              .setAlley( getTxtAlley().getText() )
                              .setStreet( getTxtStreet().getText() )
                              .setNo( Integer.valueOf( getTxtNo().getText() ) );


        CallInfo callInfo = new CallInfo()
                              .setPhone( getTxtPhone().getText() )
                              .setCell( getTxtCell().getText() )
                              .setEmail( getTxtEmail().getText() )
                              .setWebSite( getTxtWebSite().getText() );

        return new Account()
                              .setFirstName( getTxtFirstName().getText() )
                              .setLastName( getTxtLastName().getText() )
                              .setGender( getCmbGender().getSelectionModel().getSelectedItem() )
                              .setBirthCity( getTxtBirthCity().getText() )
                              .setBirthDate( UiUtil.convertFxDateToCalendar( getDtpBirthDate() ) )
                              .setImage( UiUtil.extractToBytes( getImgViewUserImage().getImage() ) )
                              .setAddress( address )
                              .setCallInfo( callInfo );
    }



}
