package ejemplosUT1;

import java.io.*;

public class Ejemplo3 {

	public static void main(String[] args) {
		
		//String comando= "java ejemplosUT1.EjemploSaludo hola h1 h2 h3 h4 h5..."
		String linea="";
		ProcessBuilder pb = new ProcessBuilder("java", "ejemplosUT1.EjemploSaludo", "hola", "h1", "h2", "h3");
		Process p= null;
		int exitVal = 0;
		
		try {
			
			if(args.length < 1) {
				System.out.println("Error: El primer parametro es el nombre del fichero");
			
			}else {
			
				System.out.println("Nombre del fichero a crear con la salida del comando "+ args[0]);
				p = pb.start();
				//lee el stream de salida del proceso, lo que genero en consola
				FileOutputStream ficheroSalida = new FileOutputStream(args[0]);
				PrintWriter escFicheroSalida =new PrintWriter(ficheroSalida);
				
				InputStream salidaComando= p.getInputStream();
				BufferedReader buffer = new BufferedReader(new InputStreamReader (salidaComando));
				linea = buffer.readLine();
				while(linea != null) {
					escFicheroSalida.println(linea);
					linea = buffer.readLine();
				}
				buffer.close();
				
				//Caso de error en el comando
				InputStream errorComando  = p.getErrorStream();
				buffer = new BufferedReader(new InputStreamReader (errorComando));
				linea = buffer.readLine();
				while(linea != null) {
					escFicheroSalida.println(linea);
					linea = buffer.readLine();
				}
				buffer.close();
				escFicheroSalida.close();
				
				exitVal = p.waitFor(); //El proceso espera hasta que el subproceso termiene
				System.out.println("Valor de salida: " + exitVal);
			}
			
		}catch (Exception e) {
			System.out.println("Error en: " + "java ejemplosUT1.EjemploSaludo hola h1 h2 h3");
			e.printStackTrace();
		}	
		
	}

}

