package interrupt;

public class HiloTestInterrupt extends Thread {
	
	public void run()
	{
		while(!interrupted())
		{
			try {
				Thread.sleep(5000);
				System.out.printf("%s\nVivo: %s\n", getName(), isAlive());
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.out.println("Se interrumpió el hilo");
			}
		}
	}

}
