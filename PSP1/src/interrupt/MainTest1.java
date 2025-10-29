package interrupt;

public class MainTest1 {

	public static void main(String[] args) {
		
		HiloTestInterrupt h1 = new HiloTestInterrupt();
		h1.start();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		h1.interrupt();
		
	}

}
