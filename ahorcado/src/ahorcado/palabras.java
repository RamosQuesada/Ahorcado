package ahorcado;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class palabras {
    //Arreglo sirve para guardar las palabras
	 private String[] arreglo;
	 //Elegida es para elegir una palabra 
	    private String elegida;
	    //palabraFormada es para pasar la palabra elegida a *
	    private String[] palabraFormada;
	    private int fallos;
	    
	    
	    public palabras()
	    {
	        arreglo = new String[10];
	        arreglo[0] = "java";
	        arreglo[1] = "ordenador";
	        arreglo[2] = "programacion";
	        arreglo[3] = "eclipse";
	        arreglo[4] = "sublimetext";
	        arreglo[5] = "github";
	        arreglo[6] = "meteor";
	        arreglo[7] = "xammp";
	        arreglo[8] = "joption";
	        arreglo[9] = "jframe";
	        elegida = escogerPalabra();
	        palabraFormada = new String[elegida.length()];
	        llenarPalabraFormada();
	        fallos = 0;
	    }
	    //Metodo escoger palabra aleatoriamente del 0 al 10 
	    public String escogerPalabra()
	    {
	        int aleatorio=(int)((Math.random()*10));
	        return arreglo[aleatorio];
	        
	    }
	    //Este metodo sirve para cuando recoja la palabra seleccionada convierta esa palabra en *
	    public void llenarPalabraFormada()
	    {
	        for(int i = 0; i < palabraFormada.length; i++)
	        {
	            palabraFormada[i] = "*";
	        }
	    }
	    //
	    public String comparar(char letra)
	    {
	        
	        String aux="";
	        String nuevaPalabra ="";
	        int contador = 0;
	        fallos =0;
	        
	        while(contador < elegida.length())
	        {
	            if((letra == elegida.charAt(contador)) && (palabraFormada[contador].equals("*")))
	            {
	                aux += letra;
	                palabraFormada[contador] = aux;
	                aux="";
	                contador++;
	                fallos=1;
	            }
	            else
	            {
	                contador++;
	            }
	            
	        }
	        
	        for(int i = 0; i < palabraFormada.length;i++)
	        {
	            nuevaPalabra += palabraFormada[i];
	            
	        }
	        return nuevaPalabra;
	    }
	    
	    public String getElegida()
	    {
	        return elegida;
	    }
	    
	    public int getfallos()
	    {
	        return fallos;
	    }
	    
}
