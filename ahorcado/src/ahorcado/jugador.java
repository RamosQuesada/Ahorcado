package ahorcado;

public class jugador {
	 private static String nombre;
	 private static int puntuacion;

	    public jugador(String nombre)     {
	puntuacion = 0; 
	this.nombre = nombre;
	   }

	    public static void addPunto() {
	        puntuacion = puntuacion + 1;
	        System.out.println ("Jugador " + nombre + " puntuó, ahora la puntuación es " + puntuacion);
	    }
	    
	}