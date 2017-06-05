package com.naderaria.infinityCenter.model.account;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.UniqueConstraint;

/**
 * Created by NaderAria on 4/26/2017.
 */

@Entity
@Table(name="USERNAME_PASSWORDS" , uniqueConstraints = @UniqueConstraint(columnNames ="USER_NAME" ))
@NamedQueries({
        @NamedQuery( name = IQueryNames.USER_NAME_PASSWORD_SELECT_ALL_KEY , query = IQueryNames.USER_NAME_PASSWORD_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.USER_NAME_PASSWORD_SELECT_BY_NAME_KEY , query = IQueryNames.USER_NAME_PASSWORD_SELECT_BY_NAME_VALUE )

})
public class UserNamePassword extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="PASSWORD")
    private String password;


    public String getUserName(){ return userName; }
    public UserNamePassword setUserName( String userName ){

        this.userName = userName;
        return this;
    }

    public String getPassword(){ return password; }
    public UserNamePassword setPassword( String password ){

        this.password = password;
        return this;
    }
}
