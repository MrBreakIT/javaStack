// import java.util.ArrayList;
// import java.util.Collections;
// import java.util.Random;
import java.util.*;


public class Basics {
    public static void main(String[] args){
        ArrayList<Integer> testArr = new ArrayList<Integer>();
            testArr.add(10);
            testArr.add(15);
            testArr.add(8);
            testArr.add(-5);
            testArr.add(0);
            testArr.add(-2);

// ******** Function Calls
        printTo255(0);
        printTo255Odds(0);
        printTo255Sum(0);
        iterate(testArr);
        Integer x= findMax(testArr);
            System.out.println(x);
        Double y= average(testArr);
            System.out.println(y);
        ArrayList<Integer> x1= arrTo255Odds(0);
            System.out.println(x1);
        Integer x2 = greaterThanY(testArr,5);
            System.out.println(x2);
        ArrayList<Integer> x3= squareValues(testArr);
            System.out.println(x3);
        ArrayList<Integer> x4 = noNegatives(testArr);
            System.out.println(x4);
        minMaxAvg(testArr);
        ArrayList<Integer> x5 = shifty(testArr);
            System.out.println(x5);
    }
    public static Integer printTo255(int num){
            while(num<=255){
                System.out.println(num);
                num++;
            }
            return num;
    }
    public static Integer printTo255Odds(int num){
        while(num<=255){
            if(num%2! = 0){
                System.out.println(num);
                num++;
            }
            else{
                num++;
            }
            
        }
        return num;
    }
    public static Integer printTo255Sum(int num){
        int sum = 0;
        while(num<=255){
            sum += num;
            System.out.println("New Number: "+ num + " Sum: " + sum);
            num++;
        }
        return num;
    }
    public static void iterate(ArrayList<Integer> arr){
        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
    }
    public static Integer findMax(ArrayList<Integer> arr){
        int max = 0;
        for(int i = 0; i < arr.size(); i++){
            if( arr.get(i) > max){
                max = arr.get(i);
            }
        }
        return max;
    }
    public static Double average(ArrayList<Integer> arr){
        double sum = 0;
        for(int i = 0; i < arr.size(); i++){
                sum += arr.get(i);
        }
        return sum/arr.size();
    }
    public static ArrayList<Integer> arrTo255Odds(int num){
        ArrayList<Integer> y = new ArrayList<Integer>();
        while(num<=255){
            if(num%2 != 0){
                
                y.add(num);
                num++;
            }
            else{
                num++;
            }
            
        }
        return y;
    }
    public static Integer greaterThanY(ArrayList<Integer> arr, int num){
        int sum = 0;
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) > num){
                sum++;
            }
        }
        return sum;
    }
    public static ArrayList<Integer> squareValues(ArrayList<Integer> arr){
        ArrayList<Integer> y = new ArrayList<Integer>();
            for(int i = 0; i < arr.size(); i++){
            y.add(arr.get(i)*arr.get(i));
        }
        return y;
    }
    public static ArrayList<Integer> noNegatives(ArrayList<Integer> arr){
        ArrayList<Integer> y = new ArrayList<Integer>();
            for(int i = 0; i < arr.size(); i++){
                if(arr.get(i) > 0){
                    y.add(arr.get(i));
                }
                else{
                    y.add(0);
                }
        }
        return y;
    }
    public static void minMaxAvg(ArrayList<Integer> arr){
        int min = 0;
        int max = 0;
        int sum = 0;
        for(int i = 0; i < arr.size(); i++){
            if(arr.get(i) > max){
                max = arr.get(i);
            }
            else if(arr.get(i) < min){
                min = arr.get(i);
            }
            sum += arr.get(i);
        }
        System.out.println("Max: "+ max);
        System.out.println("Min: "+ min);
        System.out.println("Average: "+ sum/arr.size());
    }
    public static ArrayList<Integer> shifty(ArrayList<Integer> arr){
        ArrayList<Integer> y = new ArrayList<Integer>();
            for(int i = 1; i < arr.size(); i++){
                y.add(arr.get(i));
        }
        y.add(0);
        return y;
    }
}










