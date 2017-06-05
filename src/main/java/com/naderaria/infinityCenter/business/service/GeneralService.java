package com.naderaria.infinityCenter.business.service;

import com.naderaria.infinityCenter.business.service.interfaces.IGeneralService;
import com.naderaria.infinityCenter.dao.GeneralDao;
import com.naderaria.infinityCenter.dao.interfaces.IGeneralDao;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by NaderAria on 4/27/2017.
 */
public class GeneralService implements IGeneralService {

    private IGeneralDao generalDao = GeneralDao.getInstance();



    public <T extends BaseEntity> T  save(T t ) throws Exception {
        return generalDao.add( t );
    }


    public <T extends BaseEntity> List<T> save(List<T> ts ) throws Exception {
        return generalDao.add( ts );
    }


    public <T extends BaseEntity> T  update( T t ) throws Exception {
        return  generalDao.update( t );
    }


    public <T extends BaseEntity> List<T> update( List<T> ts ) throws Exception {
        return generalDao.update( ts );
    }


    public <T extends BaseEntity> void delete( T t ) throws Exception {
        generalDao.delete( t );
    }


    public <T extends BaseEntity> void delete( List<T> ts ) throws Exception {
        generalDao.delete( ts );
    }


    public <T extends BaseEntity> void delete( Class<T> t , Long id ) throws Exception {
        generalDao.delete( t , id );
    }


    public <T extends BaseEntity> T findById( Class<T> t ,  Long id ) throws Exception {
        return generalDao.selectById( t ,  id );
    }


    public <T extends BaseEntity> Long fetchCount( Class<T> t , String queryName ) throws Exception {
        return generalDao.fetchCount( t ,  queryName );
    }


    public <T extends BaseEntity> T findByQueryName( Class<T> t , String queryName  ) throws Exception {
        return generalDao.selectByQueryName( t ,  queryName );
    }


    public <T extends BaseEntity> T findByQueryName( Class<T> t , String queryName , Map<String,Object> params ) throws Exception {
        return generalDao.selectByQueryName( t ,  queryName , params );
    }


    public <T extends BaseEntity> List<T> findAllByQueryName( Class<T> t , String queryName ) throws Exception {
        return generalDao.selectAllByQueryName( t ,  queryName );
    }


    public <T extends BaseEntity> List<T> findAllByQueryName( Class<T> t , String queryName , Map<String,Object> params ) throws Exception {
        return generalDao.selectAllByQueryName( t ,  queryName , params );
    }


    public <T extends BaseEntity> T findByCriteriaQuery( Class<T> t , String criteriaQuery ) throws Exception {
        return  generalDao.selectByCriteriaQuery( t ,  criteriaQuery );
    }


    public <T extends BaseEntity> T findByCriteriaQuery( Class<T> t , String criteriaQuery , Map<String,Object> params) throws Exception {
        return generalDao.selectByCriteriaQuery( t ,  criteriaQuery , params );
    }
}
