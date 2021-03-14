import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.*;

public class BasicsTest {
    public static void main(String[] args){
        ArrayList<Integer> testArr = new ArrayList<Integer>();
        testArr.add(10);
        testArr.add(15);
        testArr.add(8);
        testArr.add(-5);
        testArr.add(0);
        testArr.add(-2);

        Basics runFunction = new Basics();
        Integer problem1 = runFunction.printTo255(0);
        Integer problem2 = runFunction.printTo255Odds(0);
        Integer problem3 = runFunction.printTo255Sum(0);
        runFunction.iterate(testArr);
        Integer problem5 = runFunction.findMax(testArr);
        System.out.println(problem5);
        Integer problem6 = runFunction.average(testArr);
        System.out.println(problem6);
        ArrayList<Integer> problem7 = runFunction.arrTo255Odds(0);
        System.out.println(problem7);
        Integer problem8 = runFunction.greaterThanY(testArr, 5);
        System.out.println(problem8);
        ArrayList<Integer> problem9 = runFunction.squareValues(testArr);
        System.out.println(problem9);
        ArrayList<Integer> problem10 = runFunction.noNegatives(testArr);
        System.out.println(problem10);
        runFunction.minMaxAvg(testArr);
        ArrayList<Integer> problem12 = runFunction.shifty(testArr);
        System.out.println(problem12);
    }
}

















