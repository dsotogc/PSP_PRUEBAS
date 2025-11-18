package pinpon_prodconsum;

public class Cola {
	private String v_pinpon;
	private boolean disponible = false;

	public synchronized String getStr() {
		while (!disponible)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		disponible =false;
		notifyAll();
		return v_pinpon;
	}


	public synchronized void put(int valor){
		while (disponible)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		if (valor == 0 || valor % 2 == 0)
			v_pinpon = "pin";
		else
			v_pinpon = "pon";
		notifyAll();
		disponible = true;
	}
}
