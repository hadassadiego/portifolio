import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.bootcamp.scanners.string.PasswordInputScanner;
import org.academiadecodigo.bootcamp.scanners.string.StringSetInputScanner;
import java.util.HashMap;


public class Login {

    public static void main(String[] args) {

        Prompt prompt = new Prompt(System.in, System.out);

        System.out.println("Insert your login below");

        HashMap<String, String> hashMap = new HashMap();
        hashMap.put("Bob", "marley");
        hashMap.put("Marley", "bob");
        StringSetInputScanner user = new StringSetInputScanner(hashMap.keySet());
        PasswordInputScanner password = new PasswordInputScanner();

        user.setMessage("Gimme your username dude: ");
        user.setError("Buuhhh");
        password.setMessage("We all have secrets, type yours: ");

        String username = prompt.getUserInput(user);

        while (true) {
            String passwordUser = prompt.getUserInput(password);

            if (passwordUser.equals(hashMap.get(username))) {
                System.out.println("Welcome to Space");
                break;
            }
            else {
                System.out.println("Type again");
            }
        }

    }

}
