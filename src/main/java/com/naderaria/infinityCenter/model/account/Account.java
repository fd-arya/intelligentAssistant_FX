package com.naderaria.infinityCenter.model.account;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import com.naderaria.infinityCenter.model.enums.Gender;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

/**
 * Created by NaderAria on 4/26/2017.
 */

@Entity
@Table(name="ACCOUNTS")
@NamedQueries({
        @NamedQuery( name = IQueryNames.ACCOUNT_SELECT_ALL_KEY, query = IQueryNames.ACCOUNT_SELECT_ALL_VALUE ),
        @NamedQuery( name = IQueryNames.ACCOUNT_SELECT_ALL_BY_GENDER_KEY , query = IQueryNames.ACCOUNT_SELECT_ALL_BY_GENDER_VALUE ),
        @NamedQuery( name = IQueryNames.ACCOUNT_SELECT_ALL_BY_BIRTH_CITY_KEY , query = IQueryNames.ACCOUNT_SELECT_ALL_BY_BIRTH_CITY_VALUE ),
        @NamedQuery( name = IQueryNames.ACCOUNT_SELECT_ALL_BY_BIRTH_DATE_KEY , query = IQueryNames.ACCOUNT_SELECT_ALL_BY_BIRTH_DATE_VALUE ),
        @NamedQuery( name = IQueryNames.ACCOUNT_SELECT_ALL_BY_ADDRESS_KEY , query = IQueryNames.ACCOUNT_SELECT_ALL_BY_ADDRESS_VALUE ),
        @NamedQuery( name = IQueryNames.ACCOUNT_SELECT_ALL_BY_CALL_INFO_KEY , query = IQueryNames.ACCOUNT_SELECT_ALL_BY_CALL_INFO_VALUE ),
        @NamedQuery( name = IQueryNames.ACCOUNT_SELECT_EXISTS_ACCOUNT_KEY , query = IQueryNames.ACCOUNT_SELECT_EXISTS_ACCOUNT_VALUE )
})
public class Account extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name="FIRST_NAME",length=25)
    private String firstName;

    @Column(name="LAST_NAME",length=25)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name="GENDER")
    private Gender gender;

    @Column(name="BIRTH_CITY",length=20)
    private String birthCity;

    @Temporal(TemporalType.DATE)
    @Column(name="BIRTH_DATE")
    private Calendar birthDate;

    @Lob
    @Column(name="IMAGE")
    private byte[] image;

    @OneToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER,orphanRemoval=true)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @OneToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER,orphanRemoval=true)
    @JoinColumn(name = "CALL_INFO_ID")
    private CallInfo callInfo;

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch=FetchType.LAZY,mappedBy="account")
    private Set<Contact> contacts;


    public String getFirstName(){ return firstName; }
    public Account setFirstName(String firstName ){

        this.firstName = firstName;
        return this;
    }

    public String getLastName(){ return lastName; }
    public Account setLastName(String lastName ){

        this.lastName = lastName;
        return this;
    }

    public Gender getGender(){ return gender; }
    public Account setGender(Gender gender ){

        this.gender = gender;
        return this;
    }

    public String getBirthCity(){ return birthCity; }
    public Account setBirthCity(String birthCity ){

        this.birthCity = birthCity;
        return this;
    }

    public Calendar getBirthDate(){ return birthDate; }
    public Account setBirthDate(Calendar birthDate ){

        this.birthDate = birthDate;
        return this;
    }

    public byte[] getImage(){ return image; }
    public Account setImage(byte[] image ){

        this.image = image;
        return this;
    }

    public Address getAddress(){ return address; }
    public Account setAddress(Address address ){

        this.address = address;
        return this;
    }

    public CallInfo getCallInfo(){ return callInfo; }
    public Account setCallInfo(CallInfo callInfo ){

        this.callInfo = callInfo;
        return this;
    }

    public Set<Contact> getContacts(){ return contacts; }
    public Account setContacts(Set<Contact> contacts ){

        this.contacts = contacts;
        return this;
    }
}
