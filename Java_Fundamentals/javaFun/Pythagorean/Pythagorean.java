public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        double a= legA*legA;
        double b= legB*legB;
        double c= a+b;
        double squareRoot = Math.sqrt(c);
        return squareRoot;
        // the hypotenuse is the side across from the right angle. 
        // calculate the value of c given legA and legB
    }
}






















