package practica1;

public class PrincipalMultiplo {
		
	public static double calcularResultado(double h1, double h2, double h3)
	{
		double resultado = 0;
		
		resultado = (h1 - h2) / h3;
		return resultado;
	}

	public static void main(String[] args) {
		
		HilosMultiplos h1 = new HilosMultiplos(100000, 3);
		HilosMultiplos h2 = new HilosMultiplos(10000, 2);
		HilosMultiplos h3 = new HilosMultiplos(50000, 4);
		
		try {
			h1.start();
			h2.start();
			h3.start();
			
			while (!h3.getTerminado() && !h2.getTerminado() && !h1.getTerminado())
			{
				System.out.println("Calculando resultado...");
				Thread.sleep(100);
			}
			h1.join();
			h2.join();
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("El resultado es %f\n", calcularResultado(h1.getNum(), h2.getNum(), h3.getNum()));
		System.out.println("Programa terminado");
	}

}
