package com.naderaria.infinityCenter.model.financial;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;

import javax.persistence.*;

/**
 * Created by NaderAria on 4/27/2017.
 */

@Entity
@Table(name="FACTOR_DETAILS")
@NamedQueries({
        @NamedQuery( name = IQueryNames.FACTOR_DETAILS_SELECT_ALL_KEY , query = IQueryNames.FACTOR_DETAILS_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.FACTOR_DETAILS_SELECT_ALL_BY_COST_KEY , query = IQueryNames.FACTOR_DETAILS_SELECT_ALL_BY_COST_VALUE ) ,
        @NamedQuery( name = IQueryNames.FACTOR_DETAILS_SELECT_BY_TITLE_KEY , query = IQueryNames.FACTOR_DETAILS_SELECT_BY_TITLE_VALUE )
})
public class FactorDetails extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH},
            fetch = FetchType.EAGER )
    @JoinColumn(name="COST_ID")
    private Cost cost;

    @Column(name="TITLE")
    private String title;

    @Column(name="AMOUNT_OF")
    private Integer amountOf;

    @Column(name="UNIT")
    private String unit;

    @Column(name="PRICE_PER_UNIT")
    private Long pricePerUnit;

    @Column(name="SUM")
    private Long sum;


    public Cost getCost(){ return cost; }
    public FactorDetails setCost( Cost cost ){

        this.cost = cost;
        return this;
    }

    public String getTitle(){ return title; }
    public FactorDetails setTitle( String title ){

        this.title = title;
        return this;
    }

    public Integer getAmountOf(){ return amountOf; }
    public FactorDetails setAmountOf( Integer amountOf ){

        this.amountOf = amountOf;
        return this;
    }
    public String getUnit(){ return unit; }
    public FactorDetails setUnit( String unit ){

        this.unit = unit;
        return this;
    }

    public Long getPricePerUnit(){ return pricePerUnit; }
    public FactorDetails setPricePerUnit( Long pricePerUnit ){

        this.pricePerUnit = pricePerUnit;
        return this;
    }


    public Long getSum(){ return sum; }
    public FactorDetails setSum( Long sum ){

        this.sum = sum;
        return this;
    }
}
