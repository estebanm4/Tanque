package ejemplotanque;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Estudiante
 * Jpanel dado que voy a pintar en el Canvas
 * ActionListener: Para poder ejecutar el escenario cada ciertos milisegundos
 */
public class Tablero extends JPanel implements ActionListener{
    private Timer timer ;
    private Tanque tanque;
    
    public Tablero(){
        //Lanza un evento de tipo ActionListener cada 25 Milisegundo
        //Se hace referencia a this porque la misma clase (Tablero) procesa el evento
        this.timer = new Timer(25, this);
        this.tanque = new Tanque();
        this.tanque.setX(50);
        this.tanque.setY(50);
        //Registrar evento del Teclado
        setFocusable(true); //Debe estar en modo Focus para que puede detectar el evento
        addKeyListener(new EventosTeclado()); //Inner class que procesa los eventos del teclado
        this.timer.start(); //Inicio con el escenario
    }
        
    //Inner class Que captura los eventos del teclado
     private class EventosTeclado extends KeyAdapter {
        //Cuando se suelta una tecla
         @Override
        public void keyReleased(KeyEvent e) {
           int key = e.getKeyCode();
           if (key == KeyEvent.VK_SPACE) {
            System.out.println("VK_SPACE"); //Se  va usar posteriormente 
           }
           int angle = e.getKeyCode();
           if (angle == KeyEvent.VK_W) {
               tanque.setAngulo(tanque.getAngulo()+1);
           } else if (angle == KeyEvent.VK_S) {
               if (tanque.getAngulo()>= 1){
               tanque.setAngulo(tanque.getAngulo()-1);
               }
           }
        }
        //Cuando se presiona una tecla
        @Override
        public void keyPressed(KeyEvent e) {
           
        }
    }
    //Metodo donde se pintan los objetos 
     @Override
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       g.drawRect(this.tanque.getX(), this.tanque.getY(), 30, 30);
       //do {
       Image imgTanque = LoadImage(tanque.getImagenes()[tanque.getAngulo()]);
       g.drawImage(imgTanque, tanque.getX(), tanque.getY(), this);
       //}
       //while(tanque.getAngulo()< 1 && tanque.getAngulo()>= 18);
       }

    //Metodo que se ejecuta cada vez que se lanza un ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Repaint");
        repaint();
    }
    
    public Image LoadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    } 
}
