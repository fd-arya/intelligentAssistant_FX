package com.naderaria.infinityCenter.model.abstracts;


import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by NaderAria on 4/26/2017.
 */

@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ID",unique=true, nullable = false)
    private Long id;

    public Long getId(){ return id; }
    public BaseEntity setId( Long id ){

        this.id = id;
        return this;
    }
}
