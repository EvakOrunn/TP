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
public class Lista {

    private NodoL inicio;

//	************************************* CONSTRUCTOR ******************************************************
    public Lista() {
        inicio = null;
    }

//	***************************************** INICIO *******************************************************
    public NodoL Inicio() {
        return inicio;
    }

//	********************************** INSERTAR AL PRINCIPIO ***********************************************
    public void insertarpri(int elem, String apel, int tel, int canti) {
        NodoL x = new NodoL(elem, apel, tel, canti);
        if (inicio == null) {
            inicio = x;
        } else {
            x.setPs(inicio);
            inicio = x;
        }
    }

    public void insertarpri(NodoL x) {
        if (inicio == null) {
            inicio = x;
        } else {
            x.setPs(inicio);
            inicio = x;
        }
    }

    public void insertarFin(int elem, String apel, int tel, int canti) {
        NodoL x = new NodoL(elem, apel, tel, canti);
        NodoL p = Inicio();
        if (Inicio() == null) {
            inicio = x;
        } else {
            while (p.getPs() != null) {
                p = p.getPs();
            }
            p.setPs(x);
        }
    }
//	******************************************** QUITAR ****************************************************

    public NodoL quitar(NodoL p, NodoL q) {
        NodoL x = p;

        if (p == inicio) {
            inicio = p.getPs();
        } else {
            q.setPs(p.getPs());

        }
        return x;
    }

}
