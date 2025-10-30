package actividad3;

public class MiHilo implements Runnable {

	private String nombre;
	
	public MiHilo(String n)
	{
		this.nombre = n;
	}
	
	public void run() {
		
		int n_rand = (int)(Math.random() * 10) + 1;
		boolean salir = false;
		nombre = Thread.currentThread().getName();
		
		do
		{
			n_rand = (int)(Math.random() * 10) + 1;
			
			if (n_rand == 2)
				salir = true;
			
			System.out.printf("Hilo: %s, Num Aleatorio: %d\n", nombre, n_rand);
			
		}while (!salir);
		
		System.out.printf("Salió el número %d en el hilo %s\n", n_rand, nombre);
	}

}
