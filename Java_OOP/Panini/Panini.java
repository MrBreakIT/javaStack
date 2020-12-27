import java.util.ArrayList;

public class Panini extends Sandwich {

    public Panini(String name, Double price, Integer calories, String bread, String protein, String cheese, ArrayList<String> toppings) {
        super(name, price, calories, bread, protein, cheese, toppings);
        this.isToasted = true;
    }

    public static void main(String... args) {
        ArrayList<String> toppings = new ArrayList<String>();
        toppings.add("pickles");
        toppings.add("mustard");
        Panini cuban = new Panini("Cuban", 12.75, 500, "baguette", "ham", "swiss cheese", toppings);
        System.out.println(cuban);
        // Panini p1 = new Panini();
    }

}