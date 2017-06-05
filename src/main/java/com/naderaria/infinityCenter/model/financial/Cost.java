package com.naderaria.infinityCenter.model.financial;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import com.naderaria.infinityCenter.model.enums.CostType;
import com.naderaria.infinityCenter.model.enums.FinanceType;
import com.naderaria.infinityCenter.model.enums.PayType;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

/**
 * Created by NaderAria on 4/27/2017.
 */

@Entity
@Table(name="COSTS")
@NamedQueries({
        @NamedQuery( name = IQueryNames.COST_SELECT_ALL_KEY , query = IQueryNames.COST_SELECT_ALL_VALUE ),
        @NamedQuery( name = IQueryNames.COST_SELECT_ALL_BY_MANAGER_KEY , query = IQueryNames.COST_SELECT_ALL_BY_MANAGER_VALUE ),
        @NamedQuery( name = IQueryNames.COST_SELECT_BY_TITLE_KEY , query = IQueryNames.COST_SELECT_BY_TITLE_VALUE ) ,
        @NamedQuery( name = IQueryNames.COST_SELECT_ALL_BY_PAY_DATE_KEY , query = IQueryNames.COST_SELECT_ALL_BY_PAY_DATE_VALUE ) ,
        @NamedQuery( name = IQueryNames.COST_SELECT_ALL_BY_PAID_KEY , query = IQueryNames.COST_SELECT_ALL_BY_PAID_VALUE ) ,
        @NamedQuery( name = IQueryNames.COST_SELECT_ALL_BY_COST_TYPE_KEY , query = IQueryNames.COST_SELECT_ALL_BY_COST_TYPE_VALUE ) ,
        @NamedQuery( name = IQueryNames.COST_SELECT_ALL_BY_PAY_TYPE_KEY , query = IQueryNames.COST_SELECT_ALL_BY_PAY_TYPE_VALUE ) ,
        @NamedQuery( name = IQueryNames.COST_SELECT_ALL_BY_FINANCE_TYPE_KEY , query = IQueryNames.COST_SELECT_ALL_BY_FINANCE_TYPE_VALUE )
})
public class Cost extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch = FetchType.EAGER)
    @JoinColumn(name="COST_MANAGERS_ID")
    private CostManager costManager;

    @Column(name="TITLE")
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="PAY_DATE")
    private Calendar payDate;

   @Column(name="SELLER")
    private String seller;

    @Column(name="SUM")
    private Double sum;

    @Column(name="PAID")
    private Boolean paid;

    @Enumerated(EnumType.STRING)
    @Column(name="COST_TYPE")
    private CostType costType;

    @Enumerated(EnumType.STRING)
    @Column(name="PAY_TYPE")
    private PayType payType;

    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="cost")
    private Set<FactorDetails> details;

    @Enumerated(EnumType.STRING)
    @Column(name="FINANCE_TYPE")
    private FinanceType financeType;

    @OneToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST}
            ,fetch=FetchType.EAGER)
    @JoinColumn(name="CURRENT_FUND_ID")
    private CurrentFund currentFund;


    public CostManager getCostManager(){ return costManager; }
    public Cost setCostManager( CostManager costManager ){

     this.costManager = costManager;
     return this;
    }


    public String getTitle(){ return title; }
    public Cost setTitle( String title ){

     this.title = title;
     return this;
    }

    public Calendar getPayDate(){ return payDate; }
    public Cost setPayDate( Calendar payDate ){

     this.payDate = payDate;
     return this;
    }

    public String getSeller(){ return seller; }
    public Cost setSeller( String seller ){

     this.seller = seller;
     return this;
    }

    public Double getSum(){ return sum; }
    public Cost setSum( Double sum ){

     this.sum = sum;
     return this;
    }

    public Boolean isPaid(){return paid; }
    public Cost setPaid( Boolean paid ){

     this.paid = paid;
     return this;
    }

    public CostType getCostType(){ return costType; }
    public Cost setCostType( CostType costType ){

     this.costType = costType;
     return this;
    }

    public PayType getPayType(){ return payType; }
    public Cost setPayType( PayType payType ){

     this.payType = payType;
     return this;
    }

    public Set<FactorDetails> getDetails(){ return details; }
    public Cost setDetails( Set<FactorDetails> details ){

     this.details = details;
     return this;
    }

    public FinanceType getFinanceType(){ return financeType; }
    public Cost setFinanceType( FinanceType financeType ){

     this.financeType = financeType;
     return this;
    }

    public CurrentFund getCurrentFund(){ return currentFund; }
    public Cost setCurrentFund( CurrentFund currentFund ){

     this.currentFund = currentFund;
     return this;
    }

}
