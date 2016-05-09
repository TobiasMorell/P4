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

    private static void Error(String err, Object o){
        errors.add(err+o.toString());
    }

    private static void printErrors(){
        for(String error : errors){
            System.out.print(error);
        }
    }
}