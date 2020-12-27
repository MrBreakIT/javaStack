public class GreeterTest {
    public static void main(String[] args){
        // Greeter.testGreeting("Kelvin");
        Greeter g = new Greeter();
        String greeting = g.greet();
        String greetingWithName = g.greet("Eduardo", "Baik");
        System.out.println(greetingWithName);

        // if (greeting.equals("Hello World") || greetingWithName.equals("Hello Eduardo")){
        //     System.out.println("Test successful");
        // } else{
        //     System.out.println("Test Fail");
        // }
    }
}