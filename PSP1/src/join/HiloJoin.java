package join;

public class HiloJoin extends Thread
{
	private int c;
	
	public HiloJoin(String n, int c)
	{
		this.setName(n);
		this.c = c;
	}
	
	public void run()
	{
		for (int i = 0; i < c; i++)
		{
			System.out.printf("Hilo: %s, Contador: %d\n", this.getName(), i + 1);
		}
		System.out.printf("Termina hilo %s\n", getName());
	}

}
