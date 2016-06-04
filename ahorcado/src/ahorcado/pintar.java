package ahorcado;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class pintar extends JPanel
{
    private int fallos = 0;
    
    public pintar()
    {
        setSize(600,300);
    }
    
    public void paintComponent(Graphics g)
    {
    	 ArduinoTest1 test = new ArduinoTest1();
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        g.fillRect(0, 250, 300, 50);
        g.fillRect(0, 10, 10, 350);
        g.fillRect(10, 10, 150, 10);
        g.drawLine(150, 10, 150, 50);
      
        if ( test.initialize() ) {
        //Utilizo los fallos para utilizar casos
        if(fallos == 0)
        {
        	test.sendData("0");
        }
        if(fallos == 1)
        {
            //cabeza
            g.drawOval(125, 50, 50, 50);
            test.sendData("1");
        }
        else if(fallos == 2)
        {
            //cabeza
            g.drawOval(125, 50, 50, 50);
            //tronco
            g.drawLine(150, 100, 150, 160);
            test.sendData("2");
        }
        else if(fallos == 3)
        {
            //cabeza
            g.drawOval(125, 50, 50, 50);
            //tronco
            g.drawLine(150, 100, 150, 160);
            //brazo derecho
            g.drawLine(150, 100, 100, 130);
            test.sendData("3");
        }
        else if(fallos == 4)
        {
            //cabeza
            g.drawOval(125, 50, 50, 50);
            //tronco
            g.drawLine(150, 100, 150, 160);
            //brazo derecho
            g.drawLine(150, 100, 100, 130);
            //brazo izq
            g.drawLine(150, 100, 200, 130);
            test.sendData("4");
        }
        else if(fallos == 5)
        {
            //cabeza
            g.drawOval(125, 50, 50, 50);
            //tronco
            g.drawLine(150, 100, 150, 160);
            //brazo derecho
            g.drawLine(150, 100, 100, 130);
            //brazo izq
            g.drawLine(150, 100, 200, 130);
            //pierna derecha
            g.drawLine(150, 160, 100, 200);
            test.sendData("5");
        }
        else if(fallos == 6)
        {
             //cabeza
            g.drawOval(125, 50, 50, 50);
            //tronco
            g.drawLine(150, 100, 150, 160);
            //brazo derecho
            g.drawLine(150, 100, 100, 130);
            //brazo izq
            g.drawLine(150, 100, 200, 130);
            //pierna derecha
            g.drawLine(150, 160, 100, 200);
            //pierna izq
            g.drawLine(150, 160, 200, 200);
            
            test.sendData("6");
        }
        }
        try { Thread.sleep(2000); } catch (InterruptedException ie) {}
        }
    
    //Este metodo es para volver a repintar
    public void error(int error)
    {
    	fallos= error;
        this.repaint();
    }

	
  
}
