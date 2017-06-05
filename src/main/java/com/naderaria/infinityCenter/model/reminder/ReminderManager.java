package com.naderaria.infinityCenter.model.reminder;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import com.naderaria.infinityCenter.model.account.Login;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by NaderAria on 4/27/2017.
 */

@Entity
@Table(name="REMINDER_MANAGERS")
@NamedQueries({
        @NamedQuery( name = IQueryNames.REMINDER_MANAGER_SELECT_ALL_KEY , query = IQueryNames.REMINDER_MANAGER_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.REMINDER_MANAGER_SELECT_BY_LOGIN_KEY , query = IQueryNames.REMINDER_MANAGER_SELECT_BY_LOGIN_VALUE )
})
public class ReminderManager extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @OneToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},fetch=FetchType.EAGER)
    @JoinColumn(name="LOGIN_ID")
    private Login login;

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},fetch=FetchType.LAZY,mappedBy="reminderManager")
    private Set<Reminder> reminders;


    public Login getLogin(){ return login; }
    public ReminderManager setLogin( Login login ){

        this.login = login;
        return this;
    }

    public Set<Reminder> getReminders(){ return reminders; }
    public ReminderManager setReminders( Set<Reminder> reminders ){

        this.reminders = reminders;
        return this;
    }
}
