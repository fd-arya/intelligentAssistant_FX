package com.naderaria.infinityCenter.model.medicine;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import com.naderaria.infinityCenter.model.enums.MedicineTestType;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by NaderAria on 4/27/2017.
 */

@Entity
@Table(name="MEDICINE_TESTES" )
@NamedQueries({
        @NamedQuery( name = IQueryNames.MEDICINE_TEST_SELECT_ALL_KEY , query = IQueryNames.MEDICINE_TEST_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.MEDICINE_TEST_SELECT_BY_MEDICINE_TEST_MANAGER_KEY , query = IQueryNames.MEDICINE_TEST_SELECT_BY_MEDICINE_TEST_MANAGER_VALUE ) ,
        @NamedQuery( name = IQueryNames.MEDICINE_TEST_SELECT_ALL_BY_MEDICINE_TEST_TYPE_KEY , query = IQueryNames.MEDICINE_TEST_SELECT_ALL_BY_MEDICINE_TEST_TYPE_VALUE ) ,
        @NamedQuery( name = IQueryNames.MEDICINE_TEST_SELECT_ALL_BY_DATE_KEY , query = IQueryNames.MEDICINE_TEST_SELECT_ALL_BY_DATE_VALUE ) ,
        @NamedQuery( name = IQueryNames.MEDICINE_TEST_SELECT_ALL_BY_RELATED_DISEASES_KEY , query = IQueryNames.MEDICINE_TEST_SELECT_ALL_BY_RELATED_DISEASES_VALUE )
})
public class MedicineTest  extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch = FetchType.EAGER)
    @JoinColumn(name="MEDICINE_TEST_MANAGER_ID")
    private MedicineTestManager medicineTestManager;

    @Enumerated(EnumType.STRING)
    @Column(name="MEDICINE_TEST_TYPE")
    private MedicineTestType medicineTestType;

    @Column(name="VALUE")
    private String value;

    @Temporal(TemporalType.DATE)
    @Column(name="DATE")
    private Calendar date;

    @Column(name="NORMAL_VALUE")
    private String normalValue;

    @Column(name="RELATED_DISEASES")
    private Boolean relatedDiseases;


    public MedicineTestManager getMedicineTestManager(){ return medicineTestManager; }
    public MedicineTest setMedicineTestManager( MedicineTestManager medicinetestManager ){

        this.medicineTestManager = medicinetestManager;
        return this;
    }


    public MedicineTestType getMedicineTestType(){ return medicineTestType; }
    public MedicineTest setMedicineTestType( MedicineTestType medicineTestType ){

        this.medicineTestType = medicineTestType;
        return this;
    }

    public String getValue(){ return value; }
    public MedicineTest setValue( String value ){

        this.value = value;
        return this;
    }

    public Calendar getDate(){ return date; }
    public MedicineTest setDate( Calendar date ){

        this.date = date;
        return this;
    }

    public String getNormalValue(){ return normalValue; }
    public MedicineTest setNormalValue( String normalValue ){

        this.normalValue = normalValue;
        return this;
    }

    public Boolean isRelatedDiseases(){ return relatedDiseases; }
    public MedicineTest setRelatedDiseases( Boolean relatedDiseases ){

        this.relatedDiseases = relatedDiseases;
        return this;
    }

}
