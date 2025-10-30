package join;

public class MainJoin {

	public static void main(String[] args) {
		
		HiloJoin h1 = new HiloJoin("h1", 5);
		HiloJoin h2 = new HiloJoin("h2", 3);
		HiloJoin h3 = new HiloJoin("h3", 8);
		
		h1.start();
		h2.start();
		h3.start();
		
		try {
			h1.join();
			h2.join();
			h3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Termina el programa");
	}
}
