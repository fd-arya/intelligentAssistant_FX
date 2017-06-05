package com.naderaria.infinityCenter.model.reminder;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import com.naderaria.infinityCenter.model.enums.PriorityType;
import com.naderaria.infinityCenter.model.enums.RepetitionType;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by NaderAria on 4/27/2017.
 */

@Entity
@Table(name="REMINDERS")
@NamedQueries({
        @NamedQuery( name = IQueryNames.REMINDER_SELECT_ALL_KEY , query = IQueryNames.REMINDER_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.REMINDER_SELECT_BY_REMINDER_MANAGER_KEY , query = IQueryNames.REMINDER_SELECT_BY_REMINDER_MANAGER_VALUE ) ,
        @NamedQuery( name = IQueryNames.REMINDER_SELECT_BY_TITLE_KEY , query = IQueryNames.REMINDER_SELECT_BY_TITLE_VALUE ) ,
        @NamedQuery( name = IQueryNames.REMINDER_SELECT_ALL_BY_CALENDAR_KEY , query = IQueryNames.REMINDER_SELECT_ALL_BY_CALENDAR_VALUE ),
        @NamedQuery( name = IQueryNames.REMINDER_SELECT_ALL_BY_ACTIVE_KEY , query = IQueryNames.REMINDER_SELECT_ALL_BY_ACTIVE_VALUE ) ,
        @NamedQuery( name = IQueryNames.REMINDER_SELECT_ALL_BY_REPETITION_TYPE_KEY , query = IQueryNames.REMINDER_SELECT_ALL_BY_REPETITION_TYPE_VALUE ) ,
        @NamedQuery( name = IQueryNames.REMINDER_SELECT_ALL_BY_PRIORITY_TYPE_KEY , query = IQueryNames.REMINDER_SELECT_ALL_BY_PRIORITY_TYPE_VALUE )
})
public class Reminder extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade ={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},fetch = FetchType.EAGER)
    @JoinColumn(name="REMINDER_MANAGER_ID")
    private ReminderManager reminderManager;

    @Column(name="TITLE")
    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CALENDAR")
    private Calendar calendar;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="WARNING_MESSAGE")
    private String warningMessage;

    @Column(name="ERROR_MESSAGE")
    private String errorMessage;

    @Lob
    @Column(name="IMAGE_MESSAGE")
    private Byte[] imageMessage;

    @Column(name="ACTIVE")
    private Boolean active;

    @Column(name="REPETITION")
    private Boolean repetition;

    @Enumerated(EnumType.STRING)
    @Column(name="REPETITION_TYPE")
    private RepetitionType repetitionType;

    @Enumerated(EnumType.STRING)
    @Column(name="PRIORITY_TYPE")
    private PriorityType priorityType;

    public ReminderManager getReminderManager(){ return reminderManager; }
    public Reminder setReminderManager( ReminderManager reminderManager ){

        this.reminderManager = reminderManager;
        return this;
    }

    public String getTitle(){ return title; }
    public Reminder setTitle( String title ){

        this.title = title;
        return this;
    }

    public Calendar getCalendar(){ return calendar; }
    public Reminder setCalendar( Calendar calendar ){

        this.calendar = calendar;
        return this;
    }

    public String getDescription(){ return description; }
    public Reminder setDescription( String description ){

        this.description = description;
        return this;
    }

    public String getWarningMessage(){ return warningMessage; }
    public Reminder setWarningMessage( String warningMessage ){

        this.warningMessage = warningMessage;
        return this;
    }

    public String getErrorMessage(){ return errorMessage; }
    public Reminder setErrorMessage( String errorMessage ){

        this.errorMessage = errorMessage;
        return this;
    }

    public Byte[] getImageMessage(){ return imageMessage; }
    public Reminder setImageMessage( Byte[] imageMessage ){

        this.imageMessage = imageMessage;
        return this;
    }

    public Boolean isActive(){ return active; }
    public Reminder setActive( Boolean active ){

        this.active = active;
        return this;
    }

    public Boolean isRepetition(){ return repetition; }
    public Reminder setRepetition( Boolean repetition ){

        this.repetition = repetition;
        return this;
    }

    public RepetitionType getRepetitionType(){ return repetitionType; }
    public Reminder setRepetitionType( RepetitionType repetitionType ){

        this.repetitionType = repetitionType;
        return this;
    }

    public PriorityType getPriorityType(){ return priorityType; }
    public Reminder setPriorityType( PriorityType priorityType ){

        this.priorityType = priorityType;
        return this;
    }


}
