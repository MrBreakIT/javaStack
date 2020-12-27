package Zoo;


public class MammalTest {
	public static void main(String[] args) {
		Gorilla g = new Gorilla("Harambe", "Gorilla", 100);
		Bat b = new Bat("Bad-Ass Bobby", "Bat", 300);
		g.toString();		
		g.allDay();
		System.out.println(g);
		System.out.println("***************************");
		System.out.println("***************************");

		b.toString();
		b.allDay();
		System.out.println(b);
		System.out.println("***************************");
		System.out.println("***************************");
	}
	
}
