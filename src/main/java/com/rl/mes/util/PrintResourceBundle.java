package com.rl.mes.util;


/**
 * PrintResourceBundle
 */
public class PrintResourceBundle {

    PrintResourceBundle() {
    }

    public static String getText(String name, String[] args) {
        return ResourceBundle.getText("Print", name, args);
    }

    public static String getText(String name) {
        return getText(name, null);
    }
}
