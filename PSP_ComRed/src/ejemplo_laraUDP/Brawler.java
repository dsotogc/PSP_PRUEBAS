package ejemplo_laraUDP;
import java.io.Serializable;

/**
 * No olvidar el Serializable
 *
 */
public class Brawler implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nombre;
    private int nivel;
    private int coronas;

    public Brawler(String nombre, int nivel, int coronas) {
    	super();
        this.nombre = nombre;
        this.nivel = nivel;
        this.coronas = coronas;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel;}
    public int getCoronas() { return coronas;}
    public void setCoronas(int coronas) { this.coronas = coronas;}
}
