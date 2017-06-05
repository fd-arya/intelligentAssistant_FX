package com.naderaria.infinityCenter.model.account;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import com.naderaria.infinityCenter.model.enums.Language;

import javax.persistence.*;

/**
 * Created by NaderAria on 4/26/2017.
 */

@Entity
@Table(name="LOGINIS" )
@NamedQueries({
        @NamedQuery( name = IQueryNames.LOGIN_SELECT_ALL_kEY , query = IQueryNames.LOGIN_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.LOGIN_SELECT_ALL_BY_LANGUAGE_KEY , query = IQueryNames.LOGIN_SELECT_ALL_BY_LANGUAGE_VALUE ),
        @NamedQuery( name = IQueryNames.LOGIN_SELECT_BY_ACCOUNT_KEY , query = IQueryNames.LOGIN_SELECT_BY_ACCOUNT_VALUE ),
        @NamedQuery( name = IQueryNames.LOGIN_SELECT_BY_USER_NAME_KEY , query = IQueryNames.LOGIN_SELECT_BY_USER_NAME_VALUE ),
        @NamedQuery( name = IQueryNames.LOGIN_SELECT_BY_USER_NAME_AND_PASSWORD_KEY , query = IQueryNames.LOGIN_SELECT_BY_USER_NAME_AND_PASSWORD_VALUE )
})
public class Login extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @OneToOne(cascade={CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE}
            ,fetch=FetchType.EAGER)
    @JoinColumn(name="ACCOUNT_ID")
    private Account account;

    @OneToOne(cascade={CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST,CascadeType.MERGE}
            ,fetch=FetchType.EAGER)
    @JoinColumn(name="USER_NAME_PASSWORD_ID")
    private UserNamePassword userNamePassword;

    @Enumerated(EnumType.STRING)
    @Column(name="LANGUAGE")
    private Language language;


    public Account getAccount(){ return account; }
    public Login setAccount(Account account){

        this.account = account;
        return this;
    }

    public UserNamePassword getUserNamePassword(){ return userNamePassword; }
    public Login setUserNamePassword( UserNamePassword userNamePassword ){

        this.userNamePassword = userNamePassword;
        return this;
    }


    public Language getLanguage(){ return language; }
    public Login setLanguage( Language language ){

        this.language = language;
        return this;
    }
}
