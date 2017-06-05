package com.naderaria.infinityCenter.model.account;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

/**
 * Created by NaderAria on 4/26/2017.
 */
@Entity
@Table( name = "LOGES" )
@NamedQueries({
        @NamedQuery( name = IQueryNames.LOG_SELECT_ALL_KEY , query = IQueryNames.LOG_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.LOG_SELECT_ALL_BY_LOGIN_KEY , query = IQueryNames.LOG_SELECT_ALL_BY_LOGIN_VALUE ) ,
        @NamedQuery( name = IQueryNames.LOG_SELECT_ALL_BY_SERVICE_NAME_KEY , query = IQueryNames.LOG_SELECT_ALL_BY_SERVICE_NAME_VALUE ) ,
        @NamedQuery( name = IQueryNames.LOG_SELECT_ALL_BY_BETWEEN_CALENDAR_KEY , query = IQueryNames.LOG_SELECT_ALL_BY_BETWEEN_CALENDAR_VALUE )
})
public class Log extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @OneToOne( cascade = CascadeType.REFRESH , fetch = FetchType.EAGER )
    @JoinColumn( name = "LOGIN_ID")
    private Login login;

    @Column( name ="SERVICE_NAME")
    private String serviceName;

    @Column( name ="START_LOG")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar startLog;

    @Column( name ="END_LOG")
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar endLog;

    @Column( name = "EXCEPTIONS" )
    @ElementCollection( fetch = FetchType.LAZY )
    private List<Exception> exceptions;

    public Login getLogin(){ return login; }
    public Log setLogin( Login login ){

        this.login = login;
        return this;
    }

    public String getServiceName(){ return serviceName; }
    public Log setServiceName( String serviceName ){

        this.serviceName = serviceName;
        return this;
    }

    public Calendar getStartLog(){ return startLog; }
    public Log setStartLog( Calendar startLog ){

        this.startLog = startLog;
        return this;
    }

    public Calendar getEndLog(){ return endLog; }
    public Log setEndLog( Calendar endLog ){

        this.endLog = endLog;
        return this;
    }

    public List<Exception> getExceptions(){ return exceptions; }
    public Log setExceptions( List<Exception> exceptions ){

        this.exceptions = exceptions;
        return this;
    }
}