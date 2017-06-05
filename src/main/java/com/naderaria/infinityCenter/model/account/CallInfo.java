package com.naderaria.infinityCenter.model.account;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;

import javax.persistence.*;

/**
 * Created by NaderAria on 4/26/2017.
 */

@Entity
@Table(name="CALL_INFOES" , uniqueConstraints = @UniqueConstraint(columnNames = {"PHONE","EMAIL"}))
@NamedQueries({
        @NamedQuery( name = IQueryNames.CALL_INFO_SELECT_ALL_KEY , query = IQueryNames.CALL_INFO_SELECT_ALL_VALUE ),
        @NamedQuery( name = IQueryNames.CALL_INFO_SELECT_BY_PHONE_KEY , query = IQueryNames.CALL_INFO_SELECT_BY_PHONE_VALUE ),
        @NamedQuery( name = IQueryNames.CALL_INFO_SELECT_BY_CELL_KEY , query = IQueryNames.CALL_INFO_SELECT_BY_CELL_VALUE ),
        @NamedQuery( name = IQueryNames.CALL_INFO_SELECT_BY_EMAIL_KEY , query = IQueryNames.CALL_INFO_SELECT_BY_EMAIL_VALUE )
})
public class CallInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name="PHONE")
    private String phone;

    @Column(name="CELL")
    private String cell;

    @Column(name="EMAIL")
    private String email;

    @Column(name="WEB_SITE")
    private String webSite;


    public String getPhone(){ return phone; }
    public CallInfo setPhone( String phone ){

        this.phone = phone;
        return this;
    }

    public String getCell(){ return cell; }
    public CallInfo setCell( String cell ){

        this.cell = cell;
        return this;
    }

    public String getEmail(){ return email; }
    public CallInfo setEmail( String email ){

        this.email = email;
        return this;
    }

    public String getWebSite(){ return webSite; }
    public CallInfo setWebSite( String webSite ){

        this.webSite = webSite;
        return this;
    }
}
