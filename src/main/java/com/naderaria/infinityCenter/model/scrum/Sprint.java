package com.naderaria.infinityCenter.model.scrum;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import com.naderaria.infinityCenter.model.enums.StateType;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

/**
 * Created by NaderAria on 4/27/2017.
 */

@Entity
@Table(name="SPRINTS"  , uniqueConstraints = @UniqueConstraint(columnNames ="TITLE" ))
@NamedQueries({
        @NamedQuery( name = IQueryNames.SPRINT_SELECT_ALL_KEY , query = IQueryNames.SPRINT_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.SPRINT_SELECT_BY_GOAL_KEY , query = IQueryNames.SPRINT_SELECT_BY_GOAL_VALUE ) ,
        @NamedQuery( name = IQueryNames.SPRINT_SELECT_BY_TITLE_KEY , query = IQueryNames.SPRINT_SELECT_BY_TITLE_VALUE ) ,
        @NamedQuery( name = IQueryNames.SPRINT_SELECT_BY_CODE_KEY , query = IQueryNames.SPRINT_SELECT_BY_CODE_VALUE ) ,
        @NamedQuery( name = IQueryNames.SPRINT_SELECT_ALL_BY_START_DATE_KEY , query = IQueryNames.SPRINT_SELECT_ALL_BY_START_DATE_VALUE ) ,
        @NamedQuery( name = IQueryNames.SPRINT_SELECT_ALL_BY_END_DATE_KEY , query = IQueryNames.SPRINT_SELECT_ALL_BY_END_DATE_VALUE ) ,
        @NamedQuery( name = IQueryNames.SPRINT_SELECT_ALL_BY_BETWEEN_CALENDAR_KEY , query = IQueryNames.SPRINT_SELECT_ALL_BY_BETWEEN_CALENDAR_VALUE ) ,
        @NamedQuery( name = IQueryNames.SPRINT_SELECT_ALL_STATE_TYPE_KEY , query = IQueryNames.SPRINT_SELECT_ALL_STATE_TYPE_VALUE )
})
public class Sprint extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne( cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch = FetchType.EAGER)
    @JoinColumn(name="GOAL_ID")
    private Goal goal;

    @Column(name="TITLE")
    private String title;

    @Column(name="CODE")
    private String code;


    @Temporal(TemporalType.DATE)
    @Column(name="START_DATE")
    private Calendar startDate;


    @Temporal(TemporalType.DATE)
    @Column(name="END_DATE")
    private Calendar endDate;


    @Enumerated(EnumType.STRING)
    @Column(name="STATE_TYPE")
    private StateType stateType;

    @OneToMany(cascade={CascadeType.ALL},fetch=FetchType.LAZY,mappedBy="sprint")
    private Set<Task> tasks;


    public Goal getGoal(){ return goal; }
    public Sprint setGoal( Goal goal ){

        this.goal = goal;
        return this;
    }

    public String getTitle(){ return title; }
    public Sprint setTitle( String title ){

        this.title = title;
        return this;
    }

    public String getCode(){ return code; }
    public Sprint setCode( String code ){

        this.code = code;
        return this;
    }

    public Calendar getStartDate(){ return startDate; }
    public Sprint setStartDate( Calendar startDate ){

        this.startDate = startDate;
        return this;
    }

    public Calendar getEndDate(){ return endDate; }
    public Sprint setEndDate( Calendar endDate ){

        this.endDate = endDate;
        return this;
    }

    public StateType getStateType(){ return stateType; }
    public Sprint setStateType( StateType stateType ){

        this.stateType = stateType;
        return this;
    }

    public Set<Task> getTasks(){ return tasks; }
    public Sprint setTasks( Set<Task> tasks ){

        this.tasks = tasks;
        return this;
    }

}
