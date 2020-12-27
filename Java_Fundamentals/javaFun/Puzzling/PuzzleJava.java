import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// public class Puzzling {
//     public static void main(String[] args) {
//         ArrayList<Integer> numbers = new ArrayList<Integer>();
//         numbers.add(5);
//         numbers.add(4);
//         numbers.add(3);
//         numbers.add(2);
//         numbers.add(1);
        
//         Collections.shuffle(numbers);
//         System.out.println(numbers); // [1, 5, 2, 4, 3]
//         Collections.sort(numbers);
//         System.out.println(numbers); // [1, 2, 3, 4, 5]
                
//         Random r = new Random();
//         System.out.println(r.nextInt()); // without bounds
//         System.out.println(r.nextInt(5)); // with bounds 0 to 5
//     }
// }

public class PuzzleJava{
    public static void main (String[] args){
        ArrayList<Integer> testArr = new ArrayList<Integer>();
            testArr.add(3);
            testArr.add(5);
            testArr.add(1);
            testArr.add(2);
            testArr.add(7);
            testArr.add(9);
            testArr.add(8);
            testArr.add(13);
            testArr.add(25);
            testArr.add(32);
        ArrayList<String> nameArr = new ArrayList<String>();    
            nameArr.add("Nancy");
            nameArr.add("Jinichi");
            nameArr.add("Fujibayashi");
            nameArr.add("Momochi");
            nameArr.add("Ishikawa");
        ArrayList<Character> aBC = new ArrayList<Character>(); 
            aBC.add('a');
            aBC.add('b');
            aBC.add('c');
            aBC.add('d');
            aBC.add('e');
            aBC.add('f');
            aBC.add('g');
            aBC.add('h');
            aBC.add('i');
            aBC.add('j');
            aBC.add('k');
            aBC.add('l');
            aBC.add('m');
            aBC.add('n');
            aBC.add('o');
            aBC.add('p');
            aBC.add('q');
            aBC.add('r');
            aBC.add('s');
            aBC.add('t');
            aBC.add('u');
            aBC.add('v');
            aBC.add('w');
            aBC.add('x');
            aBC.add('y');
            aBC.add('z');
            
// ************************function calls
        Integer x = Sum (testArr);     
            System.out.println(x);
        ArrayList<Integer> x1 = greaterThan10(testArr);     
            System.out.println(x1);
        Collections.shuffle(nameArr);
            System.out.println(nameArr); 
        ArrayList<String> x2 = greaterThan5 (nameArr);
            System.out.println(x2);
        firstAndLast(aBC);
        ArrayList<Integer> x3 = randomNumbers ();
        ArrayList<String> x4 = randomStrings();

       // *************************function calls
    }
    public static Integer Sum (ArrayList<Integer> arr){
        int sum = 0;
        for (int i=0; i < arr.size(); i++){
            sum += arr.get(i);
        }
        return sum;
    }
    public static ArrayList<Integer> greaterThan10(ArrayList<Integer> arr){
        ArrayList<Integer> x = new ArrayList<Integer>();
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) > 10){
                x.add(arr.get(i));
            }
        }
        return x;
    }
    public static ArrayList<String> greaterThan5(ArrayList<String> arr){
        ArrayList<String> x = new ArrayList<String>();
        for(int i=0; i<arr.size(); i++){
            if(arr.get(i).length() >5){
                x.add(arr.get(i));
            }
        }
        return x;
    }
    public static void firstAndLast(ArrayList<Character> arr){
        Collections.shuffle(arr);
        System.out.println(arr);
        System.out.println("First letter: " + arr.get(0) + " Last letter: " +  arr.get(arr.size()-1));
        if (arr.get(0) == 'a'){
            System.out.println("First letter is the vowel "+ arr.get(0));
        }
        else if (arr.get(0) == 'e'){
            System.out.println("First letter is the vowel "+ arr.get(0));
        }
        else if (arr.get(0) == 'i'){
            System.out.println("First letter is the vowel "+ arr.get(0));
        }
        else if (arr.get(0) == 'o'){
            System.out.println("First letter is the vowel "+ arr.get(0));
        }
        else if (arr.get(0) == 'u'){
            System.out.println("First letter is the vowel "+ arr.get(0));
        }
    }
    public static ArrayList<Integer> randomNumbers (){
        ArrayList<Integer> x = new ArrayList<Integer>(); 
        Random rand = new Random();
        
        for(int i=0; i<10; i++){
            x.add(rand.nextInt(46) + 55);
        }
        int min = x.get(0);
        int max = x.get(0);
        Collections.sort(x);
        for(int i = 0; i< x.size(); i++){
            if (x.get(i)> max){
                max = x.get(i);
            }
            else if (x.get(i)< min){
                min = x.get(i);
            }
        }
        System.out.println("Max: "+ max + " Min: "+ min);
        System.out.println(x);
        return x;
    } 
    public static ArrayList<String> randomStrings (){
        ArrayList<String> x = new ArrayList<String>();
        Random rand = new Random();
        String aBC = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i<10; i++){
            String temp = "";
            for(int j = 0; j<5; j++){
                temp += aBC.charAt(rand.nextInt(26));
            }
            x.add(temp);
        }
        System.out.println(x);
        return x;

    } 


}
