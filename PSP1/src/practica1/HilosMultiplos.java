package practica1;

public class HilosMultiplos extends Thread 
{
	
	private int n;
	private int mult;
	private double resultado;
	private boolean terminado = false;
	
	public HilosMultiplos(int n, int mult)
	{
		this.n = n;
		this.mult = mult;
	}
	
	public double calcular()
	{
		double sum = 0;
		int multiploEncontrado = 0;
		for (int i = 0; multiploEncontrado < this.n; i++)
		{
			if (i % this.mult == 0)
			{
				sum += i;
				multiploEncontrado++;
			}
		}
		return sum;
	}
	
	public void setNum(double resultado)
	{
		this.resultado = resultado;
	}
	
	public double getNum()
	{
		return this.resultado;
	}
	
	public void setTerminado(boolean t)
	{
		this.terminado = true;
	}
	
	public boolean getTerminado()
	{
		return this.terminado;
	}
	
	public void run()
	{
		double resultado = calcular();
		setNum(resultado);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("El resultado de " + Thread.currentThread() + " es " + this.getNum());
		this.setTerminado(true);
	}
}
