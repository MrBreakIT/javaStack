import java.util.ArrayList;

// ***************************************************  While Loops example 

// public class Loops{
//     public static void main (String[] args){
// ArrayList<Object> list = new ArrayList<Object>();
// int i = 0;
// while(i < 7)
// {
//     System.out.println("foo-bar"+" "+ i);
//     i++;
// }
//     }
// }


// ***************************************************  For Loops example 
public class Loops{
    public static void main(String[] args){
        ArrayList<String> dynamicArray = new ArrayList<String>();
            dynamicArray.add("hello");
            dynamicArray.add("world");
            dynamicArray.add("etc");
            for (int i = 0; i < dynamicArray.size(); i++){
                System.out.println(dynamicArray.get(i));
            }

                }
            }

// ***************************************************  For Enhanced Loops example 

// public class Loops{
//     public static void main(String[] args){
//         ArrayList<String> dynamicArray = new ArrayList<String>();
// dynamicArray.add("hello");
// dynamicArray.add("world");
// dynamicArray.add("etc");
// for(String name : dynamicArray){
//     System.out.println("hello " + name);
//     // other operations using name
// }
//     }
// }




