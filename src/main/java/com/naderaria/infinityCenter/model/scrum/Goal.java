package com.naderaria.infinityCenter.model.scrum;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import com.naderaria.infinityCenter.model.enums.GoalTimeType;
import com.naderaria.infinityCenter.model.enums.GoalType;
import com.naderaria.infinityCenter.model.enums.StateType;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by NaderAria on 4/27/2017.
 */

@Entity
@Table(name="GOALS" , uniqueConstraints = @UniqueConstraint(columnNames = "TITLE"))
@NamedQueries({
        @NamedQuery( name = IQueryNames.GOAL_SELECT_ALL_KEY , query = IQueryNames.GOAL_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.GOAL_SELECT_BY_GOAL_MANAGER_KEY , query = IQueryNames.GOAL_SELECT_BY_GOAL_MANAGER_VALUE ) ,
        @NamedQuery( name = IQueryNames.GOAL_SELECT_BY_TITLE_KEY , query = IQueryNames.GOAL_SELECT_BY_TITLE_VALUE ) ,
        @NamedQuery( name = IQueryNames.GOAL_SELECT_BY_CODE_KEY , query = IQueryNames.GOAL_SELECT_BY_CODE_VALUE ) ,
        @NamedQuery( name = IQueryNames.GOAL_SELECT_ALL_BY_GOAL_TYPE_KEY , query = IQueryNames.GOAL_SELECT_ALL_BY_GOAL_TYPE_VALUE ) ,
        @NamedQuery( name = IQueryNames.GOAL_SELECT_ALL_BY_GOAL_TIME_TYPE_KEY , query = IQueryNames.GOAL_SELECT_ALL_BY_GOAL_TIME_TYPE_VALUE ),
        @NamedQuery( name = IQueryNames.GOAL_SELECT_ALL_BY_STATE_TYPE_KEY , query = IQueryNames.GOAL_SELECT_ALL_BY_STATE_TYPE_VALUE )
})
public class Goal extends BaseEntity {

    private static final long serialVersionUID = 1L;


    @ManyToOne( cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch = FetchType.EAGER)
    @JoinColumn(name="GOAL_MANAGER_ID")
    private GoalManager goalManager;

    @Column(name="TITLE")
    private String title;

    @Column(name="CODE")
    private String code;

    @Column(name="DESCRIPTION")
    private String description;


    @Enumerated(EnumType.STRING)
    @Column(name="GOAL_TYPE")
    private GoalType goalType;

    @Enumerated(EnumType.STRING)
    @Column(name="GOAL_TIME_TYPE")
    private GoalTimeType goalTimeType;

    @Enumerated(EnumType.STRING)
    @Column(name="STATE_TYPE")
    private StateType stateType;

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch=FetchType.LAZY,mappedBy="goal")
    private Set<Sprint> sprints;

    public GoalManager getGoalManager(){ return goalManager; }
    public Goal setGoalManager( GoalManager goalManager ){

        this.goalManager = goalManager;
        return this;
    }

    public String getTitle(){ return title; }
    public Goal setTitle( String title ){

        this.title = title;
        return this;
    }

    public String getCode(){ return code; }
    public Goal setCode( String code ){

        this.code = code;
        return this;
    }

    public String getDescription(){ return description; }
    public Goal setDescription( String description ){

        this.description = description;
        return this;
    }

    public GoalType getGoalType(){ return goalType; }
    public Goal setGoalType( GoalType goalType ){

        this.goalType = goalType;
        return this;
    }

    public GoalTimeType getGoalTimeType(){ return goalTimeType; }
    public Goal setGoalTimeType( GoalTimeType goalTimeType ){

        this.goalTimeType = goalTimeType;
        return this;
    }

    public StateType getStateType(){ return stateType; }
    public Goal setStateType( StateType stateType ){

        this.stateType = stateType;
        return this;
    }

    public Set<Sprint> getSprints(){ return sprints; }
    public Goal setSprints( Set<Sprint> sprints ){

        this.sprints = sprints;
        return this;
    }
}

