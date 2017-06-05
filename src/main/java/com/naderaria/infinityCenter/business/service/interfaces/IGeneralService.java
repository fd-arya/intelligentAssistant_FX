package com.naderaria.infinityCenter.business.service.interfaces;

import com.naderaria.infinityCenter.model.abstracts.BaseEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by NaderAria on 4/27/2017.
 */
public interface IGeneralService {

    public <T extends BaseEntity> T  save(T t ) throws Exception;
    public <T extends BaseEntity> List<T> save(List<T> ts ) throws Exception;
    public <T extends BaseEntity> T  update( T t ) throws Exception;
    public <T extends BaseEntity> List<T> update( List<T> ts ) throws Exception;
    public <T extends BaseEntity> void delete( T t ) throws Exception;
    public <T extends BaseEntity> void delete( List<T> ts ) throws Exception;
    public <T extends BaseEntity> void delete( Class<T> t , Long id ) throws Exception;
    public <T extends BaseEntity> T findById( Class<T> t ,  Long id ) throws Exception;
    public <T extends BaseEntity> Long fetchCount( Class<T> t , String queryName ) throws Exception;
    public <T extends BaseEntity> T findByQueryName( Class<T> t , String queryName  ) throws Exception;
    public <T extends BaseEntity> T findByQueryName( Class<T> t , String queryName , Map<String,Object> params ) throws Exception;
    public <T extends BaseEntity> List<T> findAllByQueryName( Class<T> t , String queryName ) throws Exception;
    public <T extends BaseEntity> List<T> findAllByQueryName( Class<T> t , String queryName , Map<String,Object> params ) throws Exception;
    public <T extends BaseEntity> T findByCriteriaQuery( Class<T> t , String criteriaQuery ) throws Exception;
    public <T extends BaseEntity> T findByCriteriaQuery( Class<T> t , String criteriaQuery , Map<String,Object> params) throws Exception;

}
