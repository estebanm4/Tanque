package ejemplotanque;

import javax.swing.JFrame;

public class EjemploTanque extends JFrame {
    
    public EjemploTanque() {
        initUI();
    }

    private void initUI() {
        add(new Tablero());
        setSize(250, 200);
        setTitle("Ejercicio 1");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) {
        EjemploTanque ex = new EjemploTanque();
        ex.setVisible(true);
       
    }
}