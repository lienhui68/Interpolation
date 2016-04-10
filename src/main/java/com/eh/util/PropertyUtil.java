package com.eh.util;

import java.util.ResourceBundle;

/**
 * Created by David on 2016/4/10.
 */
public class PropertyUtil {
    private static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");

    public static String getProperty(String field) {
        return resourceBundle.getString(field);
    }

}
