package com.naderaria.infinityCenter.model.scrum;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import com.naderaria.infinityCenter.model.account.Login;
import javax.persistence.*;
import java.util.Set;

/**
 * Created by NaderAria on 4/27/2017.
 */

@Entity
@Table(name="GOAL_MANAGERS" )
@NamedQueries({
        @NamedQuery( name = IQueryNames.GOAL_MANAGER_SELECT_ALL_KEY , query = IQueryNames.GOAL_MANAGER_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.GOAL_MANAGER_SELECT_BY_LOGIN_KEY , query = IQueryNames.GOAL_MANAGER_SELECT_BY_LOGIN_VALUE )
})
public class GoalManager extends BaseEntity {


    private static final long serialVersionUID = 1L;

    @OneToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch=FetchType.EAGER)
    @JoinColumn(name="LOGIN_ID")
    private Login login;

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch=FetchType.LAZY,mappedBy="goalManager")
    private Set<Goal> goals;

    public Login getLogin(){ return login; }
    public GoalManager setLogin( Login login ){

        this.login = login;
        return this;
    }

    public Set<Goal> getGoals(){ return goals; }
    public GoalManager setGoals( Set<Goal> goals ){

        this.goals = goals;
        return this;
    }
}

