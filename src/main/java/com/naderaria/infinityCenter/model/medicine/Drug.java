package com.naderaria.infinityCenter.model.medicine;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by NaderAria on 4/27/2017.
 */

@Entity
@Table(name="DRUGS"  ,uniqueConstraints = @UniqueConstraint(columnNames ={"TITLE"}))
@NamedQueries({
        @NamedQuery( name = IQueryNames.DRUG_SELECT_ALL_KEY , query = IQueryNames.DRUG_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.DRUG_SELECT_BY_DRUG_MANAGER_KEY , query = IQueryNames.DRUG_SELECT_BY_DRUG_MANAGER_VALUE ) ,
        @NamedQuery( name = IQueryNames.DRUG_SELECT_BY_TITLE_KEY , query = IQueryNames.DRUG_SELECT_BY_TITLE_VALUE ) ,
        @NamedQuery( name = IQueryNames.DRUG_SELECT_BY_CONSUMPTION_INSTRUCTION_KEY , query = IQueryNames.DRUG_SELECT_BY_CONSUMPTION_INSTRUCTION_VALUE ) ,
		/*@NamedQuery( name = IQueryNames.DRUG_SELECT_ALL_BY_MEMBER_KEY , query = IQueryNames.DRUG_SELECT_ALL_BY_MEMBER_VALUE ) ,*/
        @NamedQuery( name = IQueryNames.DRUG_SELECT_ALL_BY_ACTIVE_KEY , query = IQueryNames.DRUG_SELECT_ALL_BY_ACTIVE_VALUE )
})
public class Drug extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST} ,fetch = FetchType.EAGER)
    @JoinColumn(name="DRUG_MANAGER_ID")
    private DrugManager drugManager;

    @Column(name="TITLE")
    private String title;

    @Column(name="CONSUMPTION_INSTRUCTION")
    private String consumptionInstruction;

    @Temporal(TemporalType.DATE)
    @Column(name="START_DATE")
    private Calendar startDate;

    @Temporal(TemporalType.DATE)
    @Column(name="END_DATE")
    private Calendar endDate;

    @Temporal(TemporalType.TIME)
    @Column(name="USE_TIME")
    private Date useTime;

    @Column(name="USE_COUNT")
    private Integer useCount;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="COMPLICATIONS")
    private String complications;

    @Column(name="CONSUMED")
    private Boolean consumed;

    @Column(name="ACTIVE")
    private Boolean active;



    public DrugManager getDrugManager(){ return drugManager; }
    public Drug setDrugManager( DrugManager drugManager ){

        this.drugManager = drugManager;
        return this;
    }

    public String getTitle(){ return title; }
    public Drug setTitle( String title ){

        this.title = title;
        return this;
    }

    public String getConsumptionInstruction(){ return consumptionInstruction; }
    public Drug setConsumptionInstruction( String consumptionInstruction ) {

        this.consumptionInstruction = consumptionInstruction;
        return this;
    }

    public Calendar getStartDate(){ return startDate; }
    public Drug setStartDate( Calendar startDate ){

        this.startDate = startDate;
        return this;
    }

    public Calendar getEndDate(){ return endDate; }
    public Drug setEndDate( Calendar endDate ){

        this.endDate = endDate;
        return this;
    }

    public Date getUseTime(){ return useTime; }
    public Drug setUseTime( Date useTime ){

        this.useTime = useTime;
        return this;
    }

    public Integer getUseCount(){ return useCount; }
    public Drug setUseCount( Integer useCount ){

        this.useCount = useCount;
        return this;
    }

    public String getDescription(){ return description; }
    public Drug setDescription( String description ){

        this.description = description;
        return this;
    }

    public String getComplications(){ return complications; }
    public Drug setComplications( String complications ){

        this.complications = complications;
        return this;
    }

    public Boolean isConsumed(){ return consumed; }
    public Drug setConsumed( Boolean consumed ){

        this.consumed =consumed;
        return this;
    }

    public Boolean isActive(){ return active; }
    public Drug setActive( Boolean active ){

        this.active = active;
        return this;
    }
}
