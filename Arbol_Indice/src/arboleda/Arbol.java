package arboleda;

import listase.NodoL;

public class Arbol {

    private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public void insertar(int elemento) {
        if (raiz == null) {
            raiz = new Nodo(elemento);
        } else {
            insertarNodo(raiz, elemento);
        }
    }

    public void insertarNodo(Nodo p, int elemento) {
        if (p.getInfo() != elemento) {
            if (elemento > p.getInfo()) {
                if (p.getPD() == null) {
                    p.setPD(new Nodo(elemento));
                } else {
                    insertarNodo(p.getPD(), elemento);
                }
            } else {
                if (p.getPI() == null) {
                    p.setPI(new Nodo(elemento));
                } else {
                    insertarNodo(p.getPI(), elemento);
                }
            }
        } else {
            System.out.println("El Elemento Ya Existe");
        }
    }

    public Nodo obtenerRaiz() {
        return raiz;
    }

    public Nodo eliminar_Busqueda(Nodo p, Nodo ant, int e, Nodo q) {
        if (p != null) {
            if (p.getInfo() == e) {
                q = desengancharNodo(p, ant);
            } else {
                if (p.getInfo() < e) {
                    q = eliminar_Busqueda(p.getPD(), p, e, q);
                } else {
                    q = eliminar_Busqueda(p.getPI(), p, e, q);
                }
            }
        }
        return q;
    }

    public Nodo desengancharNodo(Nodo p, Nodo ant) {
        Nodo q = null;
        if (p.getPI() == null && p.getPD() == null) {
            q = eliminarHoja(p, ant);
        } else {
            if (p.getPI() != null && p.getPD() != null) {
                q = eliminarDosSubArbol(p);
            } else {
                q = eliminarUnSubArbol(p, ant);
            }
        }
        return q;
    }

    public Nodo eliminarHoja(Nodo p, Nodo ant) {
        if (ant == null) {
            raiz = null;
        } else {
            if (ant.getPI() == p) {
                ant.setPI(null);
            } else {
                ant.setPD(null);
            }
        }
        return p;
    }

    public Nodo eliminarUnSubArbol(Nodo p, Nodo ant) {
        if (ant == null) {
            if (p.getPI() == null) {
                raiz = p.getPD();
            } else {
                raiz = p.getPI();
            }
        } else {
            if (ant.getPI() == p) {
                if (p.getPI() == null) {
                    ant.setPI(p.getPD());
                } else {
                    ant.setPI(p.getPI());
                }
            } else {
                if (p.getPD() == null) {
                    ant.setPD(p.getPI());
                } else {
                    ant.setPD(p.getPD());
                }
            }
        }
        return p;
    }

    public Nodo eliminarDosSubArbol(Nodo p) {
        Nodo ant = p;
        Nodo q = p.getPD();
        while (q.getPI() != null) {
            ant = q;
            q = q.getPI();
        }
        int Aux = p.getInfo();
        p.setInfo(q.getInfo());
        q.setInfo(Aux);
        q = desengancharNodo(q, ant);
        return q;
    }

    public void insertar(int elemento, NodoL x) {
        if (raiz == null) {
            raiz = new Nodo(elemento, x);
        } else {
            insertarNodo(raiz, elemento, x);
        }
    }

    public void insertarNodo(Nodo p, int elemento, NodoL x) {
        if (p.getInfo() == elemento) {
            System.out.println("El Elemento Ya Existe");
        } else {
            if (elemento > p.getInfo()) {
                if (p.getPD() == null) {
                    p.setPD(new Nodo(elemento, x));
                } else {
                    insertarNodo(p.getPD(), elemento, x);
                }
            } else {
                if (p.getPI() == null) {
                    p.setPI(new Nodo(elemento, x));
                } else {
                    insertarNodo(p.getPI(), elemento, x);
                }
            }
        }
    }

}
