/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package listase;

/**
 *
 * @author Kelly Zarco
 */
public class NodoL {
 
        private int  dni;
        private String ape;
        private int tel;
        private int  cant;
     	private NodoL ps;

    public NodoL(int dni, String ape, int tel, int cant) {
        this.dni = dni;
        this.ape = ape;
        this.tel = tel;
        this.cant = cant;
    }

    public int getDni() {
        return dni;
    }

    public String getApe() {
        return ape;
    }

    public int getTel() {
        return tel;
    }

    public int getCant() {
        return cant;
    }

    public NodoL getPs() {
        return ps;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public void setPs(NodoL ps) {
        this.ps = ps;
    }

   
  

}
   

	 
