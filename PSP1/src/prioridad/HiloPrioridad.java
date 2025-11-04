package prioridad;

public class HiloPrioridad extends Thread {
	
	private int cont = 0;
	private boolean stop = false;
	
	public int getContador()
	{
		return cont;
	}
	
	public boolean getStop()
	{
		return stop;
	}
	
	public void setContador(int cont)
	{
		this.cont = cont;
	}
	
	public void setStop(boolean stop)
	{
		this.stop = stop;
	}
	
	public void pararHilo()
	{
		setStop(true);
	}
	
	public void run()
	{
		while (!this.stop)
		{
			cont++;
		}
		System.out.println("Terminado");
	}
	
}
