package com.naderaria.infinityCenter.view.controllers;

import com.naderaria.infinityCenter.business.service.GeneralService;
import com.naderaria.infinityCenter.business.service.interfaces.IGeneralService;
import com.naderaria.infinityCenter.model.account.*;
import com.naderaria.infinityCenter.util.UiUtil;
import com.naderaria.infinityCenter.view.forms.mainFormPane.RegisteringPane;
import com.naderaria.infinityCenter.view.interfaces.IControllerManager;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;


/**
 * Created by NaderAria on 5/19/2017.
 */
public class AccountController  implements IControllerManager<Account>{

    private IGeneralService generalService = new GeneralService();
    public void registering(RegisteringPane registeringPane){


       /* try{
             Account account = new Account();
             UserNamePassword userNamePassword = new UserNamePassword();
             Address address = new Address();
             CallInfo callInfo = new CallInfo();
             userNamePassword.setUserName( registeringPane.getTxtUserName().getText() );
             userNamePassword.setPassword( registeringPane.getPsfPassword().getText() );

             account.setFirstName( registeringPane.getTxtFirstName().getText() );
             account.setLastName( registeringPane.getTxtLastName().getText() );
             account.setBirthCity( registeringPane.getTxtBirthCity().getText() );

             account.setBirthDate(UiUtil.convertFxDateToCalendar( registeringPane.getDtpBirthDate() ) );
             account.setGender( registeringPane.getCmbGender().getSelectionModel().getSelectedItem() );
             account.setImage( UiUtil.extractToBytes( registeringPane.getImgViewUserImage().getImage() ) );
             address.setTitle( registeringPane.getTxtTitle().getText() );
             address.setCountry( registeringPane.getTxtCountry().getText() );
             address.setCity( registeringPane.getTxtCity().getText() );
             address.setAlley( registeringPane.getTxtAlley().getText() );
             address.setStreet( registeringPane.getTxtStreet().getText() );
             address.setNo(Integer.valueOf( registeringPane.getTxtNo().getText() ) );
             address.setZipCode( registeringPane.getTxtZipCode().getText() );
             callInfo.setPhone( registeringPane.getTxtPhone().getText() );
             callInfo.setCell( registeringPane.getTxtCell().getText() );
             callInfo.setEmail( registeringPane.getTxtEmail().getText() );
             callInfo.setWebSite( registeringPane.getTxtWebSite().getText() );

             account.setAddress( address );
             account.setCallInfo( callInfo );
             Login login = new Login();
             login.setUserNamePassword( userNamePassword );
             login.setAccount( account );
*/
             //generalService.save( login );

       /* }catch (Exception e){
            e.printStackTrace();
        }*/

    }


    @Override
    public void insert() {
        new Alert(Alert.AlertType.CONFIRMATION,"Test Insert" , ButtonType.CLOSE ).show();

    }

    @Override
    public  Account save( Account account ){
        return null;
    }

    @Override
    public void edit() {
        new Alert(Alert.AlertType.CONFIRMATION,"Test Edit" , ButtonType.CLOSE ).show();
    }

    @Override
    public Account update( Account account ){

        try{
            return generalService.update( account );
        }catch ( Exception e ){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void cancel(){
        new Alert(Alert.AlertType.CONFIRMATION,"Test Cancel" , ButtonType.CLOSE ).show();
    }

    public void cancelAndExit(){
        Platform.exit();
    }



}
