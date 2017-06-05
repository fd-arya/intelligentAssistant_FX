package com.naderaria.infinityCenter.view.interfaces;

import com.naderaria.infinityCenter.model.abstracts.BaseEntity;

/**
 * Created by NaderAria on 5/7/2017.
 */
public interface IControllerManager<T extends BaseEntity> {

    public void insert();

    public T save( T t );

    public void edit();

    public T update( T t );

    public void cancel();

}
