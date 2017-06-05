package com.naderaria.infinityCenter.model.financial;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseSalary;
import com.naderaria.infinityCenter.model.enums.PayType;

import javax.persistence.*;

/**
 * Created by NaderAria on 4/27/2017.
 */

@Entity
@Table(name="DEMANDS")
@DiscriminatorValue("DEMAND")
@NamedQueries({
        @NamedQuery( name = IQueryNames.DEMAND_SELECT_ALL_KEY , query = IQueryNames.DEMAND_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.DEMAND_SELECT_ALL_BY_DEMAND_MANAGER_KEY , query = IQueryNames.DEMAND_SELECT_ALL_BY_DEMAND_MANAGER_VALUE ) ,
        @NamedQuery( name = IQueryNames.DEMAND_SELECT_ALL_BY_DEMAND_TYPE_KEY , query = IQueryNames.DEMAND_SELECT_ALL_BY_PAY_TYPE_VALUE )
})
public class Demand extends BaseSalary {

    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch = FetchType.EAGER )
    @JoinColumn(name="DEMAND_MANAGER_ID")
    private DemandManager demandManager;

    @Enumerated(EnumType.STRING)
    @Column(name="PAY_TYPE")
    private PayType payType;

    public DemandManager getDemandManager(){ return demandManager; }
    public Demand setDemandManager( DemandManager demandManager ){

        this.demandManager = demandManager;
        return this;
    }


    public PayType getPayType(){ return payType; }
    public Demand setPayType( PayType payType ){

        this.payType = payType;
        return this;
    }
}
