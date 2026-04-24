package za.ac.cput.util;



import org.apache.commons.validator.routines.EmailValidator;

public class Helper {


public static boolean isNullOrEmpty(String str) {
        // Returns true if the string is actually null or empty
        if (str == null || str.isEmpty()) {
            return true;
        }
        // Returns false if the string has content
        return false;
    }

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
