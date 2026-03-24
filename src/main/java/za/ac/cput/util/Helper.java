package za.ac.cput.util;

import org.apache.commons.validator.routines.EmailValidator;

public class Helper {

    public static boolean isNullOrEmpty(String str) {
        if(str == null || str.isEmpty()){
            return true;   //the logic here between true and false is confusing
        }                   // but if not false it's true and the return below is false
        return false;        //otherwise the other way around
    }                       // will check that during testing


    public static boolean isValidEmail(String email){
        EmailValidator validator = EmailValidator.getInstance();
        return  validator.isValid(email);
    }


    public static boolean isValidNumber(float number){
        if(number < 0){
            return false;
        }
        return true;
    }
}
