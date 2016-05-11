package Utility;

import java.util.ArrayList;

/**
 * Created by ohshi on 5/4/16.
 */
public class ErrorHandling {

    private ErrorHandling() {}

    private static ArrayList<String> errors = new ArrayList<String>();

    public static void Error(String err){
        errors.add(err);
    }

    public static void Error(String err, int line){
        String msg = String.format("Error on line %d: %s",line,err);
    }

    public static void Error(String err, Object o){
        errors.add(err+o.toString());
    }

    public static void printErrors(){
        for(String error : errors){
            System.out.println(error);
        }
    }
}
