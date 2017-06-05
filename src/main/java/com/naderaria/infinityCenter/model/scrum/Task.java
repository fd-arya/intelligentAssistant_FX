package com.naderaria.infinityCenter.model.scrum;

import com.naderaria.infinityCenter.dao.interfaces.IQueryNames;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import com.naderaria.infinityCenter.model.enums.PriorityType;
import com.naderaria.infinityCenter.model.enums.StateType;
import com.naderaria.infinityCenter.model.enums.TaskType;

import javax.persistence.*;

/**
 * Created by NaderAria on 4/27/2017.
 */

@Entity
@Table(name="TASKS" ,uniqueConstraints = @UniqueConstraint(columnNames = "TITLE"))
@NamedQueries({
        @NamedQuery( name = IQueryNames.TASK_SELECT_ALL_KEY , query = IQueryNames.TASK_SELECT_ALL_VALUE ) ,
        @NamedQuery( name = IQueryNames.TASK_SELECT_BY_SPRINT_KEY , query = IQueryNames.TASK_SELECT_BY_SPRINT_VALUE ) ,
        @NamedQuery( name = IQueryNames.TASK_SELECT_BY_TITLE_KEY , query = IQueryNames.TASK_SELECT_BY_TITLE_VALUE ) ,
        @NamedQuery( name = IQueryNames.TASK_SELECT_BY_CODE_KEY , query = IQueryNames.TASK_SELECT_BY_CODE_VALUE ) ,
        @NamedQuery( name = IQueryNames.TASK_SELECT_ALL_BY_PRIORITY_TYPE_KEY , query = IQueryNames.TASK_SELECT_ALL_BY_PRIORITY_TYPE_VALUE ) ,
        @NamedQuery( name = IQueryNames.TASK_SELECT_ALL_BY_TASK_TYPE_KEY , query = IQueryNames.TASK_SELECT_ALL_BY_TASK_TYPE_VALUE ) ,
        @NamedQuery( name = IQueryNames.TASK_SELECT_ALL_BY_STATE_TYPE_KEY , query = IQueryNames.TASK_SELECT_ALL_BY_STATE_TYPE_VALUE )
})
public class Task extends BaseEntity {

        private static final long serialVersionUID = 1L;

        @ManyToOne( cascade = {CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.PERSIST},
                 fetch = FetchType.EAGER)
        @JoinColumn(name="SPRINT_ID")
        private Sprint sprint;

        @Column(name="TITLE")
        private String title;

        @Column(name="CODE")
        private String code;

        @Column(name="DESCRIPTION")
        private String description;

        @Enumerated(EnumType.STRING)
        @Column(name="TASK_PRIORITY_TYPE")
        private PriorityType taskPriorityType;

        @Enumerated(EnumType.STRING)
        @Column(name="TASK_TYPE")
        private TaskType taskType;

        @Enumerated(EnumType.STRING)
        @Column(name="STATE_TYPE")
        private StateType stateType;

        public Sprint getSprint(){ return sprint; }
        public Task setSprint( Sprint sprint ){

           this.sprint = sprint;
           return this;
        }

        public String getTitle(){ return title;}
        public Task setTitle( String title ){

           this.title = title;
           return this;
        }

        public String getCode(){ return code; }
        public Task setNo( String code ){

          this.code = code;
          return this;
        }

        public String getDescription(){ return description; }
        public Task setDescription( String description ){

          this.description = description;
          return this;
        }

        public PriorityType getTaskPriorityType(){ return taskPriorityType; }
        public Task setTaskPriorityType( PriorityType taskPriorityType ){

           this.taskPriorityType = taskPriorityType;
           return this;
        }

        public TaskType getTaskType(){ return taskType; }
        public Task setTaskType( TaskType taskType ){

           this.taskType = taskType;
           return this;
        }

        public StateType getStateType(){ return stateType; }
        public Task setStateType( StateType stateType ){

            this.stateType = stateType;
            return this;
        }
}
