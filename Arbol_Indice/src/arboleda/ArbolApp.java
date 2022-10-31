package arboleda;

import java.io.IOException;
import java.util.Scanner;
import entradaSalida.Consola;
import listase.*;

public class ArbolApp {

    Arbol In;
    Lista Li;
    Scanner ingreso;
    int cont = 0;

    public ArbolApp() {
        Li = new Lista();
        In = new Arbol();
        ingreso = new Scanner(System.in);
    }

    public void mostrarOpciones() {

        System.out.print("\n=========================================");
        System.out.print("\n              Arbol                      ");
        System.out.print("\n|--- (1) generar lista...................");
        System.out.print("\n|--- (2) generar Arbol indice............");
        System.out.print("\n|--- (3) mostrar arbol indice............");
        System.out.print("\n|--- (4) Actualizar lista................");
        System.out.print("\n|--- (5) Mostrar  lista..................");
        System.out.print("\n|--- (0) Salir --------------------------|");
        System.out.print("\n=========================================");
        System.out.print("\n(--->) Ingrese opcion:\t");
    }

    public void menu() {

        int op = 9;
        do {
            switch (op) {
                case 1:
                    generarLista();
                    break;
                case 2:
                    generarArbolIndice();
                    break;
                case 3:
                    mostraArbolIndice(In.obtenerRaiz());
                    break;
                case 4:
                    ActualizarLista();
                    break;
                case 5:
                    mostarListaActualizada();
                    break;
                case 0:
                    break;
            }
            mostrarOpciones();
            op = ingreso.nextInt();
        } while (op != 0);

    }

    public int imprimirEntreorden(Nodo r, int cont) {
        if (r != null) {
            cont = imprimirEntreorden(r.getPI(), cont);

            System.out.println("\t NUMERO  " + r.getInfo() + "  ");
            //if(r.getDir().getEstado()=='1')
            cont = cont + 1;

            cont = imprimirEntreorden(r.getPD(), cont);
        }
        return cont;
    }

    public void imprimir(Nodo r) {
        if (r != null) {
            System.out.println("\t\t  NUMERO : " + r.getInfo());
            System.out.println("----------------------------------------------------------------");
            imprimir(r.getPI());
            imprimir(r.getPD());
        }
    }

    public void generarLista() {
        boolean mas = true;
        String op = "s";
        while (mas) {
            System.out.println("Ingrese documento:");
            int elem = Consola.leerEntero();
            System.out.println("Ingrese Apellido : ");
            String apel = Consola.leerString();
            System.out.println("Ingrese numero de telefono/celular:");
            int num = Consola.leerEntero();
            System.out.println("Ingrese  cantidad de planes :");
            int cant = Consola.leerEntero();
            Li.insertarpri(elem, apel, num, cant);
            System.out.println("Desea continuar s/n");
            op = Consola.leerString();
            op = op.equals("") ? "a" : op;
            char opcion = op.charAt(0);
            mas = opcion != 'n';
        }
    }

    public void ActualizarLista() {
        //metodo  a desarrollar por el alumno
    }

    public NodoL BuscoenArbol(Nodo p, int dato, NodoL q) {
        if (p != null) {
            if (dato == p.getInfo()) {
                q = p.getDir();
            } else if (p.getInfo() < dato) {
                q = BuscoenArbol(p.getPI(), dato, q);
            } else {
                q = BuscoenArbol(p.getPD(), dato, q);
            }
        }
        return q;
    }

    public void generarArbolIndice() {
        NodoL p = Li.Inicio();
        while (p != null) {
            In.insertar(p.getDni(), p);
            p = p.getPs();
        }
    }

    public void mostraArbolIndice(Nodo r) {
        if (r != null) {
            mostraArbolIndice(r.getPI());
            System.out.println("\t\t  documento : " + r.getInfo() + "    " + r.getDir());
            mostraArbolIndice(r.getPD());
        }
    }

    public void mostarListaActualizada() {
        NodoL p = Li.Inicio();
        while (p != null) {
            System.out.println("documento :" + p.getDni() + " Apellido:" + p.getApe() + "cantidad de planes:" + p.getCant());
            p = p.getPs();
        }
    }

    public NodoL BuscoenLista(int ele) {
        NodoL q = null;
        int b = 0;
        NodoL l = Li.Inicio();
        while ((l != null) && (b == 0)) {
            if (ele == l.getDni()) {
                q = l;
                b = 1;
            } else {
                l = l.getPs();
            }
        }
        return q;
    }

    public void ArbolenLista(Nodo r) {
        if (r != null) {
            ArbolenLista(r.getPI());
            NodoL q = BuscoenLista(r.getInfo());
            if (q == null) {
                System.out.println("no existe" + r.getInfo());
            } else {
                System.out.println("existe");
                System.out.println("datos:" + q.getDni());
            }
            ArbolenLista(r.getPD());
        }
    }
}
