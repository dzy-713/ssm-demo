package com.rl.mes.util;

import java.util.Locale;
import java.util.MissingResourceException;

/**

 */
public class ResourceBundle {

    public ResourceBundle() {
    }

    public static String getText(String baseName, String name) {
        if(name == null) {
            return "";
        } else {
            String value = null;

            try {
                value = java.util.ResourceBundle.getBundle(baseName, Locale.CHINA).getString(name);
            } catch (MissingResourceException var4) {
                ;
            }

            return value != null && !value.equals("")?value:name;
        }
    }

    public static String getText(String name) {
        return getText("Message", name);
    }

    public static String getText(String baseName, String name, String... params) {
        String msg = getText(baseName, name);
        if(msg == null) {
            return name;
        } else if(params != null && params.length > 0) {
            for(int i = 0; i < params.length; ++i) {
                msg = msg.replace("{" + i + "}", params[i]);
            }

            return msg;
        } else {
            return msg;
        }
    }

    public static String getText(String name, String... params) {
        String msg = getText(name);
        if(msg == null) {
            return name;
        } else if(params != null && params.length > 0) {
            for(int i = 0; i < params.length; ++i) {
                msg = msg.replace("{" + i + "}", params[i]);
            }

            return msg;
        } else {
            return msg;
        }
    }

    public static String getLocalLang() {
        Locale defaultLocale = Locale.CHINA;
        String country = defaultLocale.getCountry();
        String language = defaultLocale.getLanguage();
        return language + "_" + country;
    }
}
