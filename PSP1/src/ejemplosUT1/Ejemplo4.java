package ejemplosUT1;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Autor: David Soto García
 * Fecha: 09/10/2025
 */
public class Ejemplo4 {

	public static void main(String[] args) {
		
		ProcessBuilder pb=new ProcessBuilder("java", "ejemplosUT1.LecturaPB");
		String linea = "";
		BufferedReader buffer_user = null;
		
		//Redireccionamos la salida por error con la salida correcta
		pb.redirectErrorStream(true);
		
		try {		
			Process p= pb.start();
			
			InputStream salidaComando= p.getInputStream();
			BufferedReader buffer = new BufferedReader(new InputStreamReader (salidaComando));
			linea = buffer.readLine();
			if (linea != null) {
				System.out.println(linea);
			}
			
			
			buffer_user = new BufferedReader(new InputStreamReader(System.in));
			//Nos comunicamos con el proceso para incroducir la entrada
			OutputStream o=p.getOutputStream();
			String text = buffer_user.readLine() + "\n";
			o.write(text.getBytes());
			//Liberamos el buffer de escritura
			o.flush();
			
			//Obtenemos la salida del comando
			salidaComando= p.getInputStream();
			buffer = new BufferedReader(new InputStreamReader (salidaComando));
			linea = buffer.readLine();
			while(linea != null) {
				System.out.println(linea);
				linea = buffer.readLine();
			}
			
			buffer_user.close();
			buffer.close();

			o.close();
			int revisoError = p.waitFor();
			System.out.println("Error igual a: " + revisoError);
			
		}catch (Exception e) {
			System.out.println("Error en: " );
			e.printStackTrace();

		}
	}
}

