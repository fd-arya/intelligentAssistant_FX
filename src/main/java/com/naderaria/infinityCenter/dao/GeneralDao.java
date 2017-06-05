package com.naderaria.infinityCenter.dao;

import com.naderaria.infinityCenter.dao.interfaces.IGeneralDao;
import com.naderaria.infinityCenter.model.abstracts.BaseEntity;
import javax.persistence.EntityTransaction;
import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by NaderAria on 4/27/2017.
 */
public class GeneralDao implements IGeneralDao {

    private static GeneralDao instance;
    private String persistenceUnitName = "infinityCenter";
    private EntityManager entityManager;

    public  synchronized  static  GeneralDao getInstance(){
        if( instance == null ){
            instance = new GeneralDao();
        }
        return new GeneralDao();
    }

    private GeneralDao(){

    }



    public String getPersistenceUnitName(){ return persistenceUnitName; }
    public void setPersistenceUnitName( String persistenceUnitName ){

        if( persistenceUnitName != null && ! persistenceUnitName.isEmpty() ){

            this.persistenceUnitName = persistenceUnitName;
        }
    }


    private EntityManager getEntityManager(){

        if( entityManager == null ){
            EntityManagerFactory  entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
            entityManager = entityManagerFactory.createEntityManager();
        }

        return entityManager;
    }



    public  <T extends BaseEntity> T  add(  T t ) throws Exception {


        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            getEntityManager().persist(t);
            transaction.commit();

        }catch ( Exception e ){
            if( transaction.isActive() ){
                 transaction.rollback();
            }
            throw new Exception("Entity not Saved.RollBacked Insert" ,e);
        }finally {
            completionProcessesEntityManager();
        }
        return t;
    }


    public  <T extends BaseEntity> List<T> add(List<T> ts ) throws Exception {


        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            for( T t : ts ){
                getEntityManager().persist( t );
            }
            transaction.commit();
        }catch ( Exception e ){
            if( transaction.isActive() ){
                transaction.rollback();
            }
            throw new Exception("Entity not Saved.RollBacked Insert" ,e);
        }finally {
            completionProcessesEntityManager();
        }
        return ts;
    }


    public  <T extends BaseEntity> T  update( T t ) throws Exception {

        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            getEntityManager().merge( t );
            transaction.commit();
        }catch ( Exception e ){
            if( transaction.isActive() ){
                transaction.rollback();
            }
            throw new Exception("Entity not updated.RollBacked Update" ,e);
        }finally {
            completionProcessesEntityManager();
        }
        return t;
    }


    public  <T extends BaseEntity> List<T> update( List<T> ts ) throws Exception {

        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            for( T t : ts ){
                getEntityManager().merge( t );
            }
            transaction.commit();
        }catch ( Exception e ){
            if( transaction.isActive() ){
                transaction.rollback();
            }
            throw new Exception("Entity not updated.RollBacked Update" ,e);
        }finally {
            completionProcessesEntityManager();
        }
        return ts;
    }


    public  <T extends BaseEntity> void delete( T t ) throws Exception {

        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            getEntityManager().remove( getEntityManager().getReference( t.getClass() , t.getId() ));
            transaction.commit();
        }catch ( Exception e ){
            if( transaction.isActive() ){
                transaction.rollback();
            }
            throw new Exception("Entity not deleted.RollBacked Delete" ,e);
        }finally {
            completionProcessesEntityManager();
        }
    }


    public  <T extends BaseEntity> void delete( List<T> ts ) throws Exception {

        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            for( T t :ts ){
                getEntityManager().remove( getEntityManager().getReference( t.getClass() ,  t.getId() ));
            }
            transaction.commit();
        }catch ( Exception e ){
            if( transaction.isActive() ){
                transaction.rollback();
            }
            throw new Exception("Entity not deleted.RollBacked Delete" ,e);
        }finally {
            completionProcessesEntityManager();
        }
    }


    public  <T extends BaseEntity> void delete( Class<T> t, Long id ) throws Exception {

        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            getEntityManager().remove( getEntityManager().getReference( t.getClass() , id ));
            transaction.commit();
        }catch ( Exception e ){
            if( transaction.isActive() ){
                transaction.rollback();
            }
            throw new Exception("Entity not deleted.RollBacked Delete" ,e);
        }finally {
            completionProcessesEntityManager();
        }
    }



    public  <T extends BaseEntity> T selectById( Class<T> t , Long id ) throws Exception {

        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            return getEntityManager().find( t , id );

        }catch ( Exception e ){
            if( transaction.isActive() ){
                transaction.rollback();
            }
            throw new Exception("Entity not find.RollBacked Select" ,e);
        }finally {
            completionProcessesEntityManager();
        }

    }


    public  <T extends BaseEntity> Long fetchCount( Class<T> t, String queryName ) throws Exception {

        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            Object object = getEntityManager().createNamedQuery( queryName ).getSingleResult();
            if( object != null && object instanceof Long ){
                return (Long) object;
            }
            return 0L;
        }catch ( Exception e ){
            if( transaction.isActive() ){
                transaction.rollback();
            }
            throw new Exception("Entity not find.RollBacked Select" ,e);
        }finally {
            completionProcessesEntityManager();
        }
    }

    @SuppressWarnings("unchecked")
    public  <T extends BaseEntity> T selectByQueryName( Class<T> t , String queryName  ) throws Exception {

        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            return (T) getEntityManager().createNamedQuery( queryName ).getSingleResult();
        }catch ( Exception e ){
            if( transaction.isActive() ){
                transaction.rollback();
            }
            throw new Exception("Entity not find.RollBacked Select" ,e);
        }finally {
            completionProcessesEntityManager();
        }
    }

    public  <T extends BaseEntity> T selectByQueryName( Class<T> t , String queryName , Map<String,Object> params ) throws Exception {

        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            Query query = getEntityManager().createNamedQuery( queryName );
            query = fillParametersInNamedQuery( query , params );
            return (T) query.getSingleResult();
        }catch ( Exception e ){
            if( transaction.isActive() ){
                transaction.rollback();
            }
            throw new Exception("Entity not find.RollBacked Select" ,e);
        }finally {
            completionProcessesEntityManager();
        }
    }


    @SuppressWarnings("unchecked")
    public  <T extends BaseEntity> List<T> selectAllByQueryName( Class<T> t , String queryName ) throws Exception {

        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            return (List<T>) getEntityManager().createNamedQuery( queryName ).getResultList();
        }catch ( Exception e ){
            if( transaction.isActive() ){
                transaction.rollback();
            }
            throw new Exception("Entity not find.RollBacked Select" ,e);
        }finally {
            completionProcessesEntityManager();
        }

    }


    public  <T extends BaseEntity> List<T> selectAllByQueryName( Class<T> t , String queryName , Map<String,Object> params ) throws Exception{

        //TODO create query use params;
        return null;
    }


    public  <T extends BaseEntity> T selectByCriteriaQuery( Class<T> t , String criteriaQuery ) throws Exception {

        //TODO create query use params;
        return null;
        //return (T) entityManager.createQuery(criteriaQuery,getClassT().getClass()).getSingleResult();
    }


    public  <T extends BaseEntity> T selectByCriteriaQuery( Class<T> t , String criteriaQuery , Map<String,Object> params ) throws Exception {

        //TODO create query use params;
        return null;
    }

   /* private <T extends BaseEntity> T getClassT( T t) throws Exception{

    	Type type = t.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        t = ( Class<T>) parameterizedType.getActualTypeArguments()[0];
       return  tClass.newInstance();
    }*/

    private Query fillParametersInNamedQuery( Query query , Map<String,Object> params ){

        for( Map.Entry<String,Object> p : params.entrySet() ){
           query.setParameter( p.getKey() , p.getValue() );

        }
        return query;
    }
    private void completionProcessesEntityManager(){


        getEntityManager().clear();
        getEntityManager().close();
    }

}
