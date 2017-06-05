package com.naderaria.infinityCenter.model.account;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;

import javax.persistence.*;

/**
 * Created by NaderAria on 4/26/2017.
 */

@Entity
@Table(name="ADDRESSES" )
@NamedQueries({
        @NamedQuery( name = IQueryNames.ADDRESS_SELECT_ALL_KEY , query = IQueryNames.ADDRESS_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.ADDRESS_SELECT_ALL_BY_COUNTRY_KEY , query = IQueryNames.ADDRESS_SELECT_ALL_BY_COUNTRY_VALUE ),
        @NamedQuery( name = IQueryNames.ADDRESS_SELECT_ALL_BY_CITY_KEY , query = IQueryNames.ADDRESS_SELECT_ALL_BY_CITY_VALUE )
})
public class Address extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name="TITLE")
    private String title;

    @Column(name="COUNTRY")
    private String country;

    @Column(name="CITY")
    private String city;

    @Column(name="STREET")
    private String street;

    @Column(name="ALLEY")
    private String alley;

    @Column(name="ZIP_CODE")
    private String zipCode;

    @Column(name="NO")
    private Integer no;

    public String getTitle(){ return title; }
    public Address setTitle( String title ){

        this.title = title;
        return this;
    }

    public String getCountry(){ return country; }
    public Address setCountry( String country ){

        this.country = country;
        return this;
    }

    public String getCity(){ return city; }
    public Address setCity( String city ){

        this.city = city;
        return this;
    }

    public String getStreet(){ return street; }
    public Address setStreet( String street ){

        this.street = street;
        return this;
    }

    public String getAlley(){ return alley; }
    public Address setAlley( String alley ){

        this.alley = alley;
        return this;
    }

    public String getZipCode(){ return zipCode; }
    public Address setZipCode( String zipCode ){

        this.zipCode = zipCode;
        return this;
    }

    public Integer getNo(){ return no; }
    public Address setNo( Integer no ){

        this.no = no;
        return this;
    }
}
