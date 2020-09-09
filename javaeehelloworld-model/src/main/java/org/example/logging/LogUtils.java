package org.example.logging;

public class LogUtils {

    private LogUtils(){}

    public static String formatToCSVXYZ(String[] args){
        // according to format specs XYZ, we have three columns with a width of 12 characters each.
        return String.format("%12s\t%12s\t%12s\t", args);
    }


}
