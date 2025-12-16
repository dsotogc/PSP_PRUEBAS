package ejemplo_OBJ_Socket;

import java.io.Serializable;

public class Persona implements Serializable{
	
	private String nombre = "";
	private int edad;
	
	public Persona(String nombre, int edad) 
	{
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public String toString()
	{
		return "La persona se llama " + this.nombre + " y tiene " + this.edad + " años.\n";
	}
}
