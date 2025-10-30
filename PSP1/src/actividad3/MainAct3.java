package actividad3;

public class MainAct3 {

	public static void main(String[] args) {
		
		Thread hilo1 = new Thread(new MiHilo("Hilo1"));
		Thread hilo2 = new Thread(new MiHilo("Hilo2"));
		
		hilo1.setName("Hilo1Mod");
		hilo1.start();
		hilo2.setName("Hilo2Mod");
		hilo2.start();
		
		try {
			hilo1.join();
			hilo2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Fin de programa." + Thread.currentThread());

	}

}
