package prioridad;

public class MainPrioridad {

	public static void main(String[] args) {
		
		HiloPrioridad h1 = new HiloPrioridad();
		HiloPrioridad h2 = new HiloPrioridad();
		HiloPrioridad h3 = new HiloPrioridad();
		
		h1.setPriority(Thread.MAX_PRIORITY);
		h3.setPriority(Thread.MIN_PRIORITY);
		
		h1.start();
		h2.start();
		h3.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		h1.pararHilo();
		h2.pararHilo();
		h3.pararHilo();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println(h1.getStop());
		System.out.printf("H1: %d Prio: %d\nH2: %d Prio: %d\nH3: %d Prio: %d", h1.getContador(), h1.getPriority(), h2.getContador(), h2.getPriority(), h3.getContador(), h3.getPriority());

	}

}
