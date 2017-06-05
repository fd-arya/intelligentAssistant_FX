package com.naderaria.infinityCenter.model.abstracts;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.enums.FinanceType;
import com.naderaria.infinityCenter.model.financial.CurrentFund;
import com.naderaria.infinityCenter.model.financial.ReversFund;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by NaderAria on 4/26/2017.
 */

@Entity
@Table( name= "BASE_SALARYS" )
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name="SALARY_TYPE",discriminatorType=DiscriminatorType.STRING)
@NamedQueries({
        @NamedQuery( name = IQueryNames.BASE_SALARY_SELECT_ALL_KEY , query = IQueryNames.BASE_SALARY_SELECT_ALL_VALUE ),
        @NamedQuery( name = IQueryNames.BASE_SALARY_SELECT_BY_TITLE_KEY ,query = IQueryNames.BASE_SALARY_SELECT_BY_TITLE_VALUE ),
        @NamedQuery( name = IQueryNames.BASE_SALARY_SELECT_ALL_RECEIVED_KEY , query = IQueryNames.BASE_SALARY_SELECT_ALL_RECEIVED_VALUE ),
        @NamedQuery( name = IQueryNames.BASE_SALARY_SELECT_ALL_FINANCE_TYPE_KEY , query = IQueryNames.BASE_SALARY_SELECT_ALL_FINANCE_TYPE_VALUE )

})
public abstract class BaseSalary extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(name="TITLE")
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CALENDAR")
    private Calendar calendar;

    @Column(name="VALUE")
    private Long value;

    @Column(name="RECEIVED")
    private Boolean received;

    @OneToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER,orphanRemoval=true)
    @JoinColumn(name = "REVERS_FUND_ID")
    private ReversFund reversFund;

    @OneToOne(cascade={CascadeType.ALL},fetch=FetchType.EAGER,orphanRemoval=true)
    @JoinColumn(name = "CURRENT_FUND_ID")
    private CurrentFund currentFund;

    @Enumerated(EnumType.STRING)
    @Column(name="FINANCE_TYPE")
    private FinanceType financeType;


    public String getTitle(){ return title; }
    public BaseSalary setTitle( String title ){

        this.title = title;
        return this;
    }

    public Calendar getCalendar(){ return calendar; }
    public BaseSalary setCalendar( Calendar calendar ){

        this.calendar = calendar;
        return this;
    }

    public Long getValue(){ return value; }
    public BaseSalary setValue( Long value ){

        this.value = value;
        return this;
    }

    public Boolean isReceived(){ return received; }
    public BaseSalary setReceived( Boolean received ){

        this.received = received;
        return this;
    }

    public ReversFund getReversFund(){ return reversFund; }
    public BaseSalary setReversFund( ReversFund reversFund ){

        this.reversFund = reversFund;
        return this;
    }

    public CurrentFund getCurrentFund(){ return currentFund; }
    public BaseSalary setCurrentFund( CurrentFund currentFund ){

        this.currentFund = currentFund;
        return this;
    }

    public FinanceType getFinanceType(){ return financeType; }
    public BaseSalary setFinanceType( FinanceType financeType ){

        this.financeType = financeType;
        return this;
    }
}
