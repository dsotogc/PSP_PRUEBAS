package ejercicio2;

public class MiHilo extends Thread {
	
	private int sleeptime;
	
	public MiHilo(int ms_sleep, String name)
	{
		this.sleeptime = ms_sleep;
		this.setName(name);
		System.out.printf("Creado hilo con nombre: %s\n", name);
		
	}
	
	public void run()
	{
		try {
			Thread.sleep(sleeptime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("El hilo %s ha estado bloqueado por el método sleep() durante %d ms\n", this.getName(), sleeptime);
	}
	
	public static void main(String[] args) {
		MiHilo h1 = new MiHilo(3000,"Hilo_1");
		MiHilo h2 = new MiHilo(3500, "Hilo_2");
		MiHilo h3 = new MiHilo(1800, "Hilo_3");
		h1.start();
		h2.start();
		h3.start();
	}

}
