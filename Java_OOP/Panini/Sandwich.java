import java.util.ArrayList;


public class Sandwich {

    public String name;
    public Double price;
    public Integer calories;
    public String bread;
    public String protein;
    public String cheese;
    public ArrayList<String> toppings;
    public Boolean isToasted = false;

    public Sandwich(String name, Double price, Integer calories, String bread, String protein, String cheese, ArrayList<String> toppings) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.bread = bread;
        this.protein = protein;
        this.cheese = cheese;
        this.toppings = toppings;
    }

    // 0 argument constructor
    public Sandwich() {
        this.name = "DEFAULT SANDWICH";
        this.price = 3.50;
        this.calories = 200;
        this.bread = "Thin wheat bread with extra crust";
        this.protein = "peanut butter";
        this.toppings = new ArrayList<String>();
        this.toppings.add("prune jelly");
    }

    public void toastTheSandwich() {
        isToasted = true;
    }

    public String toString() {
        String output = "";
        output += "Name:     " + name + "\n";
        output += "Price:    " + price + "\n";
        output += "Calories: " + calories + "\n";
        output += "Bread:    " + bread + "\n";
        output += "Protein:  " + protein + "\n";
        output += "Cheese:   " + cheese + "\n";
        output += "Toppings: " + toppings + "\n";
        output += "Toasted?: " + (isToasted ? "yes" : "no") + "\n";
        return output;
    }

    public static void main(String... args) {
        System.out.println("Sandwich is operational");
        ArrayList<String> toppings1 = new ArrayList<String>();
        toppings1.add("lettuce");
        toppings1.add("tomato");
        toppings1.add("mayo");

        Sandwich blt = new Sandwich(
            "BLT",
            6.25,
            400,
            "sourdough",
            "bacon",
            null,
            toppings1
        );

        System.out.println(blt);

        Sandwich s1 = new Sandwich();

        System.out.println(s1);

        blt.toastTheSandwich();
        System.out.println(blt);
    }

}