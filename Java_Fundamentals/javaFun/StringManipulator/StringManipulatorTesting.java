public class StringManipulatorTesting {
    public static void main(String[] args){
        StringManipulator manipulator = new StringManipulator();

        // String string = manipulator.trimAndConcat("  Hello  ","  World  ");
        // System.out.println(string);

        // char letter = 'o';
        // Integer a = manipulator.getIndexOrNull("COding is So Fun!", letter);
        // Integer b = manipulator.getIndexOrNull("Hello World", letter);
        // Integer c = manipulator.getIndexOrNull("Hi", letter);
        // System.out.println(a); 
        // System.out.println(b); 
        // System.out.println(c); 

        // String word = "Hello";
        // String subString = "llo";
        // String notSubString = "world";
        // Integer a1 = manipulator.getIndexOrNull(word, subString);
        // Integer b1 = manipulator.getIndexOrNull(word, notSubString);
        // System.out.println(a1); // 2
        // System.out.println(b1); // null

        String word1 = manipulator.concatSubstring("Hello", 1, 2, "world");
        System.out.println(word1); // eworld

    }
}