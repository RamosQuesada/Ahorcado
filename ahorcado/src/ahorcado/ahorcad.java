package ahorcado;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.io.*;

import javax.swing.*;
public class ahorcad extends JFrame implements ActionListener
{

	private pintar panelGrafico;
	private JPanel panelComponentes;
	private JButton botonReIniciar;
	private JButton botonIniciar;
	private JButton botonValidarLetra;
	private JButton botonSalir;
	private JLabel etiqueta;
	private JTextField letra;
	private JTextField palabra;
	private palabras p;
	private int vidas;
	private JTextField visunombre;
	
	public ahorcad()
	{
		super("Juego del ahorcado");
		getContentPane().setLayout(new BorderLayout(1,1));
		setSize(600,600);
		agregarElementos();
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		vidas = 0;
	}

	public void agregarElementos()
	{
		//Panel donde se dibujara 
		panelGrafico = new pintar();
		panelGrafico.setBackground(Color.WHITE);
		getContentPane().add(panelGrafico,BorderLayout.CENTER);

		//Panel donde estaran los elementos
		panelComponentes = new JPanel();
		panelComponentes.setBackground(Color.white);
		panelComponentes.setLayout(null);
		botonReIniciar = new JButton("Reinicar Juego");
		botonIniciar = new JButton("Inicar Juego");
		botonValidarLetra = new JButton("Validar Letra");
		botonSalir = new JButton("SALIR");

		etiqueta = new JLabel("Palabra");

		palabra = new JTextField("");
		letra = new JTextField("");

		//Colocando elementos en el panel
		botonReIniciar.setBounds(30,400,150,30);
		etiqueta.setBounds(250,400,100,30);
		palabra.setBounds(300,400,150,30);
		botonIniciar.setBounds(30,450,150,30);
		botonValidarLetra.setBounds(30,500,150,30);
		letra.setBounds(200,500,50,30);
		botonSalir.setBounds(430,500,150,30);

		botonReIniciar.addActionListener(this);
		botonIniciar.addActionListener(this);
		botonValidarLetra.addActionListener(this);
		botonSalir.addActionListener(this);

		panelComponentes.add(botonReIniciar);
		panelComponentes.add(botonIniciar);
		panelComponentes.add(botonValidarLetra);
		panelComponentes.add(botonSalir);
		panelComponentes.add(letra);
		panelComponentes.add(etiqueta);
		panelComponentes.add(palabra);

		getContentPane().add(panelComponentes,BorderLayout.CENTER);
		
		


	}


	public void actionPerformed(ActionEvent evento) 
	{
		if(evento.getSource() == botonReIniciar)
		{
			panelGrafico.error(0);
			palabra.setText("");
			letra.setText("");
			vidas = 0;
		}
		else if(evento.getSource() == botonIniciar)
		{
			panelGrafico.error(0);
			p = new palabras();
			String aux="";
			int contador =0;
			while(contador < p.getElegida().length())
			{
				aux+="*";
				contador++;
			}
			palabra.setText(aux);
		}
		else 
			
				
			
			if(evento.getSource() == botonValidarLetra)
		{ 
				
			String l="";
			l = letra.getText();
			char c = l.charAt(0);
			if(p.comparar(c).equals(p.getElegida()))
			{
				for (int i = 0; i < botonValidarLetra.BOTTOM; i++) {
					
				
				palabra.setText(p.comparar(c));
				JOptionPane.showMessageDialog(null,"Ganaste");
				jugador.addPunto();
			}
			}
			else if(vidas == 6)
			{
				JOptionPane.showMessageDialog(null,"Has perdido");
			}
			else if(p.getfallos() == 1)
			{
				palabra.setText(p.comparar(c));
			}
			else if(p.getfallos() == 0)
			{
				vidas = vidas + 1;
				panelGrafico.error(vidas);
			}
		}
		else if(evento.getSource() == botonSalir)
		{
			System.exit(0);
		}
	}


	public static void main(String[] args) throws IOException  
	{
		
		 ArduinoTest1 test = new ArduinoTest1();
	        
	        ahorcad a = new ahorcad();
	        palabras p = new palabras();
			int numero=0 ;
	        String nombre1;
			ArrayList<String> nombre = new ArrayList<String>();
			nombre1=JOptionPane.showInputDialog("Introduze un nombre:");
			nombre.add(nombre1);
			jugador j = new jugador(nombre1);
			String ruta;
		    BufferedWriter bw;
		    BufferedReader br;		
		   
		   
		    // Ruta del txt
		    ruta="C:/Users/Vic/Documents/proyectos_eclipse/Comunicacion_Arduino/txt/"+nombre1+".txt"; 
		    File archivo = new File(ruta);
	        if (archivo.exists()) {
	            bw = new BufferedWriter(new FileWriter(ruta,true));       
	           } else {
	            bw = new BufferedWriter(new FileWriter(ruta,false));
	            // Escribimos lo que queremos introducir en el fichero.
	            
	            bw.write("nombre del jugador   "  + nombre1);
	            bw.close();// Cerramos el fichero
	        }
	      // Lee el contenido del fichero txt 
	        	br = new BufferedReader(new FileReader(ruta));
	          	br.close();
	       
	        
	        // Abre el fichero txt
	        try {
	        	File txt = new File (ruta);
	        	Desktop.getDesktop().open(txt);
	        
	        }catch (IOException ex){
	        	System.out.println(ex);
	        }
	        
	        //Arduino
     if ( test.initialize() ) {
     		// Como no consigo tomar el valor de fallos hago un contador para
     		//que se vea el cambio de numeración
     		// while (numero <=7){
     		    // Toma el valor de fallos a traves del metodo getfallos.     	
     		 //   numero = numero+1;
     			numero= p.getfallos();
     		   // Impresion de prueba para asegurar que cambia el valor
    		 //   System.out.println ("fallo"+numero);
     		  //  if (numero==7){break;}
     		    
     		 String data = "";
    	data = String.valueOf(numero);
    	 
    		data= Integer.toString(numero);
    		test.sendData(data);
    	try { Thread.sleep(2000); } catch (InterruptedException ie) {}
    	    
     		 } 
	        
	      // 	}

	    }


	}

