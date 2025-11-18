package pinpon_prodconsum;

public class Consumidor extends Thread{
	private Cola cola;
	
	public Consumidor(Cola cola) {
		this.cola = cola;
	}

	public void run () {
		String valor = "";
		for (int i = 0; i < 5; i++) {
			valor=cola.getStr();
			System.out.println(valor);
		}
	}
}
