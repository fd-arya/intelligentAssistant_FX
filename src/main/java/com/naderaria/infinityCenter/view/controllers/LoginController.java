package com.naderaria.infinityCenter.view.controllers;


import com.naderaria.infinityCenter.business.service.GeneralService;
import com.naderaria.infinityCenter.business.service.interfaces.IGeneralService;
import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.main.InfinityCenter;
import com.naderaria.infinityCenter.model.account.Login;
import com.naderaria.infinityCenter.model.account.UserNamePassword;
import com.naderaria.infinityCenter.util.FormStateOnUser;
import com.naderaria.infinityCenter.util.VariablesDefault;
import com.naderaria.infinityCenter.view.forms.MainForm;
import com.naderaria.infinityCenter.view.interfaces.IControllerManager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NaderAria on 5/7/2017.
 */
public class LoginController implements IControllerManager<Login>{

    private UserNamePassword userNamePassword;



    public UserNamePassword getUserNamePassword(){
        if( userNamePassword == null ){ userNamePassword = new UserNamePassword(); }
        return userNamePassword;
    }



    public static String login( Login tempLogin , MainForm mainForm ){

        if( tempLogin != null && tempLogin.getUserNamePassword() != null ){
              Map<String,Object> params = new HashMap<>();
              params.put("userName",tempLogin.getUserNamePassword().getUserName() );
              params.put("password",tempLogin.getUserNamePassword().getPassword() );
              try{

                  // IGeneralService generalService = new GeneralService();
                  // Login login =  generalService.findByQueryName( Login.class , IQueryNames.LOGIN_SELECT_BY_USER_NAME_AND_PASSWORD_KEY , params );
                  Login login = new Login();
                   if( login != null  ){

                     Session.getInstance().get().put("login", login);
                     // mainApplication.setUserName( login.getUserNamePassword().getUserName() );
                     //mainApplication.changedScene();
                       mainForm.setFormStateOnUser(FormStateOnUser.NORMAL_FORM);
                       mainForm.getMainPane().getChildren().clear();
                       mainForm.getParent().getMainStage().setScene( mainForm.getScene() );
                     //return VariablesDefault.MSG_SUCCESSFULLY_LOGIN;
                   }
              }catch (Exception e){
                    InfinityCenter.showWarning("sorry can't run command, because connection is lost \n"+e );
              }
        }
        return VariablesDefault.MSG_WRONG_FIND_USER;
    }


    @Override
    public void insert() {

    }

    @Override
    public Login save(Login login) {
        return null;
    }

    @Override
    public void edit() {

    }

    @Override
    public Login update(Login login) {
        return null;
    }

    @Override
    public void cancel() {

    }
}
