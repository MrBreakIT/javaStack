import java.util.HashMap;
import java.util.Set;



public class HashProject {
    public static void main(String[] args) {
        HashMap<String, String> userMap = new HashMap<String, String>();
        userMap.put("Smoke Two Joints", "I smoke two joints in the morning I smoke two joint at night I smoke two joint in the afternoon It makes me feel all right...");
        userMap.put("Rivers of Babylon", "So let the words of our mouth And the meditation of our heart Be acceptable in thy sight Over I.");
        userMap.put("Badfish", "Two pints of booze Tell me are you a badfish, too (are you a badfish, too)? Ain't got no money to spend I hope the night will never end");
        // get the keys by using the keySet method
        Set<String> keys = userMap.keySet();
        System.out.println("Rivers of Babylon: " + userMap.get("Rivers of Babylon"));
        for(String key : keys) {            
            System.out.println(key);
            System.out.println(userMap.get(key));    
        }
        
    }
}
