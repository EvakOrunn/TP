package arboleda;
import listase.NodoL;

public class Nodo {
    private int info;
    private Nodo PI;
    private Nodo PD;
    private NodoL dir;
    
    public Nodo(int info){
        this.info = info;
        PI = null;
        PD = null;
    }
  public Nodo(int info, NodoL x){
        this.info = info;
        this.dir=x;
        PI = null;
        PD = null;
    }
    public int getInfo() {
        return info;
    }

    public Nodo getPI() {
        return PI;
    }

    public Nodo getPD() {
        return PD;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public void setPI(Nodo PI) {
        this.PI = PI;
    }

    public void setPD(Nodo PD) {
        this.PD = PD;
    }  

    public NodoL getDir() {
        return dir;
    }

    public void setDir(NodoL dir) {
        this.dir = dir;
    }
    
    
}
