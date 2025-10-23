package UT2;

public class HiloEjemplo1 extends Thread {
	
	private int hilo;
	
	public HiloEjemplo1(int hilo)
	{
		this.hilo = hilo;
		System.out.printf("Creado hilo: %d \n", hilo);
	}
	
	public void run()
	{
		int cont = 0;
		while (cont <= 5)
		{
			System.out.printf("Ejecutando hilo: %d %d\n", hilo, cont);
			cont++;
		}
	}

}
