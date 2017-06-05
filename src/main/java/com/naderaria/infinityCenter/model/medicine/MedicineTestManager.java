package com.naderaria.infinityCenter.model.medicine;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import com.naderaria.infinityCenter.model.account.Login;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by NaderAria on 4/27/2017.
 */

@Entity
@Table(name="MEDICINE_TEST_MANAGERS" )
@NamedQueries({
        @NamedQuery( name = IQueryNames.MEDICINE_TEST_MANAGER_SELECT_ALL_KEY , query = IQueryNames.MEDICINE_TEST_MANAGER_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.MEDICINE_TEST_MANAGER_SELECT_BY_LOGIN_KEY , query = IQueryNames.MEDICINE_TEST_MANAGER_SELECT_BY_LOGIN_VALUE )
})
public class MedicineTestManager extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @OneToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch=FetchType.EAGER)
    @JoinColumn(name="LOGIN_ID")
    private Login login;

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch=FetchType.LAZY,mappedBy="medicineTestManager")
    private Set<MedicineTest> medicineTests;

    public Login getLogin(){ return login; }
    public MedicineTestManager setLogin( Login login ){

        this.login = login;
        return this;
    }

    public Set<MedicineTest> getMedicineTests(){ return medicineTests; }
    public MedicineTestManager setMedicineTests( Set<MedicineTest> medicineTest ){

        this.medicineTests = medicineTest;
        return this;
    }
}

