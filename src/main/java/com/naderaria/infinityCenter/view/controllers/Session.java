package com.naderaria.infinityCenter.view.controllers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by NaderAria on 5/8/2017.
 */
public class Session {

    private static Session instance ;
    private static Map<String,Object> list;

    private Session(){}


    public static synchronized  Session getInstance(){

        if( instance == null ){
            instance =  new Session();
        }
        return instance;
    }

    public static Map<String,Object> get(){

        if( list == null ){

            list = new HashMap<>();
        }
        return list;
    }

    public static Object get( String key ) throws Exception{

        if( isNull() ){ throw new Exception("Session is null."); }
        for( Map.Entry<String,Object>  s : get().entrySet() ){
            if( s.getKey().equals( key )){
                return s.getValue();
            }
        }
        throw new Exception("find not found key in Session.");
    }
    public static boolean isNull(){

        return get().size() == 0;
    }


}
