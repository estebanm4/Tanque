package ejemplotanque;

public class Tanque {
    private int x;
    private int y;
    private int angulo;
    private String[] imagenes;
    
    public Tanque(){
        this.imagenes = new String [18];
        for(int i = 0; i < 18; i++) {
            this.imagenes[i] = i+ ".png";
        }
        this.angulo = 1;
    }

    public String[] getImagenes() {
        return imagenes;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }
    
    
}
