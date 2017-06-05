package com.naderaria.infinityCenter.model.financial;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseSalary;

import javax.persistence.*;

/**
 * Created by NaderAria on 4/27/2017.
 */

@Entity
@Table(name="SALARES")
@DiscriminatorValue("SALARY")
@NamedQueries({
        @NamedQuery( name = IQueryNames.SALARY_SELECT_ALL_KEY , query = IQueryNames.SALARY_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.SALARY_SELECT_BY_SALARY_MANGER_KEY , query = IQueryNames.SALARY_SELECT_BY_SALARY_MANAGER_VALUE )
})
public class Salary extends BaseSalary {

    private static final long serialVersionUID = 1L;

    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
            fetch = FetchType.EAGER )
    @JoinColumn(name="SALARY_MANAGER_ID")
    private SalaryManager salaryManager;

    public SalaryManager getSalaryManager(){ return salaryManager; }
    public Salary setSalaryManager( SalaryManager salaryManager ){

        this.salaryManager = salaryManager;
        return this;
    }
}
