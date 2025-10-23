package UT2;

public class UsaHiloEjemplo1{
	
	public static void main(String[] args)
	{
		
		HiloEjemplo1 h=null;
		
		int i = 0;
		while (i <= 5)
		{
			h = new HiloEjemplo1(i);
			h.start();
			i++;
		}
	}
}
