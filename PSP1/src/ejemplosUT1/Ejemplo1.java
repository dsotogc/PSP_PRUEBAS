package ejemplosUT1;

public class Ejemplo1 {

	public static void main(String[] args) {

		String comando= "notepad";
		Process p = null;
		ProcessBuilder pb = new ProcessBuilder(comando);

		try {

			p = pb.start();
		}catch (Exception e) {
			System.out.println("Error en: " + comando);
			e.printStackTrace();
		}			
	}
}

