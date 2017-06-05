package com.naderaria.infinityCenter.view.forms.formsItems.menus;



import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by NaderAria on 5/5/2017.
 */
public class BundleLoader {

    public static String getValue(String key , Locale locale ){


        ResourceBundle bundle = ResourceBundle.getBundle("Language",locale);
        if( bundle.containsKey( key ) ){
            return bundle.getString( key );
        }else{
            return "sorry,Find not Found Key";
        }

    }
}
