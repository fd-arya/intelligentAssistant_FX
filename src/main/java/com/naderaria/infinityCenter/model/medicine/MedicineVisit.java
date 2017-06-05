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
@Table(name="MEDICINE_VISITS" )
@NamedQueries({
        @NamedQuery( name = IQueryNames.MEDICINE_VISIT_SELECT_ALL_KEY , query = IQueryNames.MEDICINE_VISIT_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.MEDICINE_VISIT_SELECT_BY_LOGIN_KEY , query = IQueryNames.MEDICINE_VISIT_SELECT_BY_LOGIN_VALUE )
})
public class MedicineVisit extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @OneToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch=FetchType.EAGER)
    @JoinColumn(name="LOGIN_ID")
    private Login login;

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch=FetchType.LAZY,mappedBy="medicineVisit")
    private Set<MedicineInfo> medicineInfoSet;

    public Login getLogin(){ return login; }
    public MedicineVisit setLogin( Login login ){

        this.login = login;
        return this;
    }

    public Set<MedicineInfo> getMedicineInfoSet(){ return medicineInfoSet; }
    public MedicineVisit setMedicineInfoSet( Set<MedicineInfo> medicineInfoSet ){

        this.medicineInfoSet = medicineInfoSet;
        return this;
    }
}
