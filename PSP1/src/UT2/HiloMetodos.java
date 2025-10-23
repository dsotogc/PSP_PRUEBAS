package UT2;

public class HiloMetodos extends Thread {

	public void run()
	{
		System.out.printf("Hilo ejecutándose: %s\nPrioridad: %d\n",this.getName(), this.getPriority());
	}
	
	public static void main(String[] args) {
		
		HiloMetodos h = null;
		
		for (int i=1; i < 4; i++)
		{
			h = new HiloMetodos();
			h.setName("hilo"+i);
			h.setPriority(i);
			h.start();
			
			System.out.printf("Información del %s : %s\n", h.getName(), h.toString());
		}
		
		System.out.println("3 HILOS CREADOS...");

	}

}
