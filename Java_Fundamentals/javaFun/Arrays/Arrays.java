import java.util.ArrayList;

public class Arrays{
    public static void main (String[] args){
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(10);
        list.add("Hello");
        list.add(new ArrayList<Integer>());
        list.add(new Double(12.0)); // adding a Double of value 12.0
        list.add(57);
        // list.remove("Hello");

        System.out.println(list); // [10, "Hello", [], 12.0]
}
}

