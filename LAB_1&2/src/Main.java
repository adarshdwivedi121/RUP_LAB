import java.util.HashMap;

public class Main {

    private static HashMap<String, String> loginDetails = new HashMap<>();
    static {
        loginDetails.put("admin", "hello");
        loginDetails.put("adarsh", "password");
    }

    public static void main(String[] args) {
        new Log_In();
    }

    public static boolean checkDetails(String text, String password) {
        return (loginDetails.containsKey(text) &&
                loginDetails.get(text).compareTo(password) == 0);
    }

    public static boolean SignUp(String username,String password){
        if(loginDetails.containsKey(username)) {
            return false;
        }
        else{
            loginDetails.put(username, password);
            return true;
        }
    }
}
