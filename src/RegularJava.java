import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegularJava {
    /**
     * Метод проверки IP адреса
     * @param ip
     * @return
     */
    public static boolean validatorIPAddress(String ip){
        String pattern = "^((25[0-5]|2[0-4][0-9]|1?[1-9][0-9]?|0?)\\.){3}(25[0-5]|2[0-4][0-9]|1?[1-9][0-9]?|0?)$";
        return Pattern.matches(pattern, ip);
    }
    /**
     * Метод проверки строки GUID
     * @param string
     * @return
     */
    public static boolean validatorGUID (String string){
        String pattern = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
        return Pattern.matches(pattern, string);
    }

    /**
     * Метод проверки URL адреса
     * @param address
     * @return
     */
    public static boolean validatorURL (String address){
        Pattern ip = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
        Matcher check = ip.matcher(address);
        if(check.find())
            return false;
        else {
            String pattern = "^(https?://)?(www\\.)?((?!www\\b)[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9](\\.[a-zA-Z0-9][a-zA-Z0-9-]*[a-zA-Z0-9]+)+)(:[0-9]+)?(/[^?#]*)?(\\?[^#]*=.*)?(#.*)?$";
            return Pattern.matches(pattern, address);
        }
    }

    /**
     * Метод проверки пароля
     * @param password
     * @return
     */
    public static boolean validatorPassword (String password){
        String pattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9_]{8,}$";
        return Pattern.matches(pattern, password);
    }
}