package suspender;

public class Hilo06bSuspensionMain {
	
	public static void main(String[] args) throws InterruptedException {
		
		Hilo06bSuspensionHijo hilo = new Hilo06bSuspensionHijo();

		hilo.start();

		Thread.sleep(2000);// duerme la clase principal

		hilo.suspender();

		Thread.sleep(2000);

		//Reanudamos el hilo
		hilo.reanudar();

		Thread.sleep(3000);

		// Interrumpimos el hilo
		hilo.interrupt();

		Thread.sleep(2000);

		System.out.println("¿Se ha interrumpido el hilo? " + hilo.isInterrupted()); 

	}
}
