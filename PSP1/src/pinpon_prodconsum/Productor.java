package pinpon_prodconsum;

public class Productor extends Thread{
	private Cola cola;
	
	public Productor(Cola cola) {
		this.cola = cola;
	}

	public void run () {
		for (int i = 0; i < 5; i++) {
			cola.put(i);
		}
		
		try {
			sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}