package ejemplosUT1;

public class EjemploSaludo {

	public static void main(String[] args) {
		int contador = 1;
		if(args.length == 0) {
			System.out.println("NUMERO DE ARGUMENTOS INVÁLIDO, INSERTE ALGÚN PARÁMETRO");
		}
		else {
			for (int i = 0; i < args.length; i++) {
				System.out.printf("Argumento %d: %s\n", contador, args[i]);
				contador++;
			}
		}	

	}

}
