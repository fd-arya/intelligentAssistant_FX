package com.naderaria.infinityCenter.model.financial;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import com.naderaria.infinityCenter.model.account.Login;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by NaderAria on 4/27/2017.
 */

@Entity
@Table(name="DEMAND_MANAGERS")
@NamedQueries({
        @NamedQuery( name = IQueryNames.DEMAND_MANAGER_SELECT_ALL_KEY , query = IQueryNames.DEMAND_MANAGER_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.DEMAND_MANAGER_SELECT_BY_LOGIN_KEY , query = IQueryNames.DEMAND_MANAGER_SELECT_BY_LOGIN_VALUE )
})
public class DemandManager extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @OneToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch=FetchType.EAGER)
    @JoinColumn(name="LOGIN_ID")
    private Login login;

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch=FetchType.LAZY,mappedBy="demandManager")
    private Set<Demand> demands;

    public Login getLogin(){ return login; }
    public DemandManager setLogin( Login  login ){

        this.login = login;
        return this;
    }

    public Set<Demand> getDemands(){ return demands; }
    public DemandManager setDemands( Set<Demand> demands ){

        this.demands = demands;
        return this;
    }
}
