package suspender;

public class Hilo06bSuspensionHijo extends Thread {
	private boolean suspendido=false;

	public Hilo06bSuspensionHijo() {
		
	}
	
	public synchronized void suspender() {
		System.out.println("Suspendemos el hilo");
		suspendido = true;
	}
	
	public synchronized void reanudar() {
		System.out.println("Reanudamos el hilo");
		suspendido = false;
		notifyAll(); // Notificará este cambio
	}
	
	public synchronized void enSuspension() {
		while (suspendido) {			
			try {
				System.out.println("Hilo en espera ZzzzzzzzZZzzzzzzzZZZzzzzZZZ");
				wait();
			}catch(InterruptedException ie){
				interrupt();
			}
		}
	}
	
	public synchronized void eliminarEspera() {
		notify();
	}

	public void run() {
		try {
			while (!interrupted()) {
				enSuspension();
				System.out.println("Soy un hilo activo");
				Thread.sleep(500);
			}
		}catch (InterruptedException ie){
			
			System.out.println("Excepcion interrupccion de: " + Thread.currentThread());
			this.interrupt();
			
		} finally {
			System.out.println("El hilo ha muerto");
		}
		
	}//run
}
