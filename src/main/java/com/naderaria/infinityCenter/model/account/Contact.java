package com.naderaria.infinityCenter.model.account;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import javax.persistence.*;

/**
 * Created by NaderAria on 5/15/2017.
 */
@Entity
@Table(name="CONTACTS" )
@NamedQueries({
        @NamedQuery( name = IQueryNames.CONTACT_SELECT_ALL_KEY, query = IQueryNames.CONTACT_SELECT_ALL_VALUE ),
        @NamedQuery( name = IQueryNames.CONTACT_SELECT_ALL_BY_FIRST_NAME_KEY , query = IQueryNames.CONTACT_SELECT_ALL_BY_FIRST_NAME_VALUE ),
        @NamedQuery( name = IQueryNames.CONTACT_SELECT_ALL_BY_LAST_NAME_KEY , query = IQueryNames.CONTACT_SELECT_ALL_BY_LAST_NAME_VALUE ),
        @NamedQuery( name = IQueryNames.CONTACT_SELECT_ALL_BY_FIRST_NAME_AND_LAST_NAME_KEY , query = IQueryNames.CONTACT_SELECT_ALL_BY_FIRST_NAME_AND_LAST_NAME_VALUE ),
        @NamedQuery( name = IQueryNames.CONTACT_SELECT_ALL_BY_ADDRESS_KEY , query = IQueryNames.CONTACT_SELECT_ALL_BY_ADDRESS_VALUE ),
        @NamedQuery( name = IQueryNames.CONTACT_SELECT_ALL_BY_CALL_INFO_KEY , query = IQueryNames.CONTACT_SELECT_ALL_BY_CALL_INFO_VALUE ),
        @NamedQuery( name = IQueryNames.CONTACT_SELECT_EXISTS_CONTACT_KEY , query = IQueryNames.CONTACT_SELECT_EXISTS_CONTACT_VALUE )
})
public class Contact extends BaseEntity {

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch = FetchType.EAGER)
    @JoinColumn(name="ACCOUNT_ID")
    private Account account;

    @Column(name="FIRST_NAME",length=25)
    private String firstName;

    @Column(name="LAST_NAME",length=25)
    private String lastName;

    @OneToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER,orphanRemoval=true)
    @JoinColumn(name = "CALL_INFO_ID")
    private CallInfo callInfo;

    @OneToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER,orphanRemoval=true)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;


    public String getFirstName(){ return firstName; }
    public Contact setFirstName( String firstName ){

        this.firstName = firstName;
        return this;
    }

    public String getLastName(){ return lastName; }
    public Contact setLastName( String lastName ){

        this.lastName = lastName;
        return this;
    }

    public CallInfo getCallInfo(){ return callInfo; }
    public Contact setCallInfo( CallInfo callInfo ){

        this.callInfo = callInfo;
        return this;
    }

    public Address getAddress(){ return address; }
    public Contact setAddress( Address address ){

        this.address = address;
        return this;
    }

    public Account getAccount(){ return account; }
    public Contact setAccount(Account account){

        this.account = account;
        return this;
    }

}
