public class FizzBuzz {
    String output = "";
    public String fizzBuzz(int number) {
        if(number % 3 == 0 && number % 5==0){
            output += "FizzBuzz";
        }
        else if (number % 3 ==0 ){
            output += "Fizz";
        }
        else if (number %5 ==0){
            output +="Buzz";
        }
        else{
            System.out.println(number);
        }
        return output;
    }
}


// public class FizzBuzz {
//     public String fizzBuzz(int number) {
//         if(number % 3 == 0 && number % 5==0){
//             System.out.println("FizzBuzz");
//         }
//         else if (number % 3 ==0 ){
//             System.out.println("Fizz");
//         }
//         else if (number %5 ==0){
//             System.out.println("Buzz");
//         }
//         else{
//             System.out.println(number);
//         }
//        
//     }
// }
