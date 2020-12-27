import java.util.ArrayList;

public class Boxing {
	
	public static void main (String[] args) {
		ArrayList<Object> myList = new ArrayList<Object>();
		myList.add("13");
		myList.add(200);
		myList.add("hello world");
		myList.add(48);
		myList.add("Goodbye World");
		Integer sumOfNumbers=0;
		
		
		for(int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
			try {
				Integer castedValue = (Integer) myList.get(i);
				sumOfNumbers += castedValue;
			}
			catch(Exception e) {
				System.out.println("Something went wrong!");
				System.out.println(e);
			}
		}
		System.out.println("The sum of numbers is: " + sumOfNumbers);
	}

}