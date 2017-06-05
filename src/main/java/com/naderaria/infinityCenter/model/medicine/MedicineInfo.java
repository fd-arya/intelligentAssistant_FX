package com.naderaria.infinityCenter.model.medicine;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import com.naderaria.infinityCenter.model.account.Address;
import com.naderaria.infinityCenter.model.account.CallInfo;
import com.naderaria.infinityCenter.model.enums.MedicineType;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by NaderAria on 4/27/2017.
 */

@Entity
@Table(name="MEDICINE_INFO"  ,uniqueConstraints = @UniqueConstraint(columnNames = "TITLE"))
@NamedQueries({
        @NamedQuery( name = IQueryNames.MEDICINE_INFO_SELECT_ALL_KEY , query = IQueryNames.MEDICINE_INFO_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.MEDICINE_INFO_SELECT_BY_MEDICINE_VISIT_KEY , query = IQueryNames.MEDICINE_INFO_SELECT_BY_MEDICINE_VISIT_VALUE ) ,
        @NamedQuery( name = IQueryNames.MEDICINE_INFO_SELECT_BY_TITLE_KEY , query = IQueryNames.MEDICINE_INFO_SELECT_BY_TITLE_VALUE ) ,
        @NamedQuery( name = IQueryNames.MEDICINE_INFO_SELECT_BY_ADDRESS_KEY , query = IQueryNames.MEDICINE_INFO_SELECT_BY_ADDRESS_VALUE ) ,
        @NamedQuery( name = IQueryNames.MEDICINE_INFO_SELECT_BY_CALL_INFO_KEY , query = IQueryNames.MEDICINE_INFO_SELECT_BY_CALL_INFO_VALUE ) ,
        @NamedQuery( name = IQueryNames.MEDICINE_INFO_SELECT_All_BY_DATE_KEY , query = IQueryNames.MEDICINE_INFO_SELECT_All_BY_DATE_VALUE ) ,
        @NamedQuery( name = IQueryNames.MEDICINE_INFO_SELECT_ALL_BY_MEDICINE_TYPE_KEY , query = IQueryNames.MEDICINE_INFO_SELECT_ALL_BY_MEDICINE_TYPE_VALUE )
})
public class MedicineInfo extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch = FetchType.EAGER)
    @JoinColumn(name="MEDICINE_VISIT_ID")
    private MedicineVisit medicineVisit;

    @Column(name="TITLE")
    private String title;

    @Column(name="DESCRIPTION")
    private String description;

    @OneToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch=FetchType.EAGER)
    @JoinColumn(name="ADDRESS_ID")
    private Address address;

    @OneToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER,orphanRemoval=true)
    @JoinColumn(name = "CALL_INFO_ID")
    private CallInfo callInfo;

    @Column(name="FEE")
    private Long fee;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE")
    private Calendar date;

    @Enumerated(EnumType.STRING)
    @Column(name="MEDICINE_TYPE")
    private MedicineType medicineType;


    public MedicineVisit getMedicineVisit(){ return medicineVisit; }
    public MedicineInfo setMedicineVisit( MedicineVisit medicineVisit ){

        this.medicineVisit = medicineVisit;
        return this;
    }


    public String getTitle(){ return title; }
    public MedicineInfo setTitle( String title ){

        this.title = title;
        return this;
    }

    public String getDescription(){ return description; }
    public MedicineInfo setDescription( String description ){

        this.description = description;
        return this;
    }

    public Address getAddress(){ return address; }
    public MedicineInfo setAddress( Address address ){

        this.address = address;
        return this;
    }

    public CallInfo getCallInfo(){ return callInfo; }
    public MedicineInfo setCallInfo( CallInfo callInfo ){

        this.callInfo = callInfo;
        return this;
    }

    public Long getFee(){ return fee; }
    public MedicineInfo setFee( Long fee ){

        this.fee = fee;
        return this;
    }

    public Calendar getDate(){ return date; }
    public MedicineInfo setDate( Calendar date ){

        this.date = date;
        return this;
    }

    public MedicineType getMedicineType(){ return medicineType; }
    public MedicineInfo setMedicineType( MedicineType medicineType ){

        this.medicineType = medicineType;
        return this;
    }

}
