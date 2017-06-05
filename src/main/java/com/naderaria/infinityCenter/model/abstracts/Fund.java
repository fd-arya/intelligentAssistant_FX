package com.naderaria.infinityCenter.model.abstracts;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.financial.FundManager;

import javax.persistence.*;

/**
 * Created by NaderAria on 4/26/2017.
 */

@Entity
@Table(name="FUNDS" )
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorColumn(name="FUND_TYPE",discriminatorType=DiscriminatorType.STRING)
@NamedQueries({
        @NamedQuery( name = IQueryNames.FUND_SELECT_ALL_KEY , query = IQueryNames.FUND_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.FUND_SELECT_BY_FUND_MANAGER_KEY , query = IQueryNames.FUND_SELECT_BY_FUND_MANAGER_VALUE ),
        @NamedQuery( name = IQueryNames.FUND_SELECT_ALL_BY_MIN_STOCK_KEY , query = IQueryNames.FUND_SELECT_ALL_BY_MIN_STOCK_VALUE ),
        @NamedQuery( name = IQueryNames.FUND_SELECT_ALL_BY_MAX_STOCK_KEY , query = IQueryNames.FUND_SELECT_ALL_BY_MAX_STOCK_VALUE ),
        @NamedQuery( name = IQueryNames.FUND_SELECT_ALL_BY_CURRENT_STOCK_KEY , query = IQueryNames.FUND_SELECT_ALL_BY_CURRENT_STOCK_VALUE ) ,
        @NamedQuery( name = IQueryNames.FUND_SELECT_ALL_BY_BETWEEN_KEY , query = IQueryNames.FUND_SELECT_ALL_BY_BETWEEN_VALUE )
})
public abstract class Fund extends BaseEntity{

    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade = {CascadeType.ALL} ,fetch = FetchType.EAGER)
    @JoinColumn(name="FUND_MANAGER_ID")
    private FundManager fundManager;

    @Column(name="MIN_STOCK")
    private Long minStock;

    @Column(name="MAX_STOCK")
    private Long maxStock;

    @Column(name="CURRENT_STOCK")
    private Long currentStock;

    public FundManager getFundManager(){ return fundManager; }
    public void setFundManager( FundManager fundManager ){ this.fundManager = fundManager; }

    public Long getMinStock(){ return minStock; }

    public Fund setMinStock( Long minStock ){

        this.minStock = minStock;
        return this;
    }

    public Long getMaxStock(){ return maxStock; }
    public Fund setMaxStock( Long maxStock ){

        this.maxStock = maxStock;
        return this;
    }

    public Long getCurrentStock(){ return currentStock; }
    public Fund setCurrentStock( Long currentStock ){

        this.currentStock = currentStock;
        return this;
    }
}
