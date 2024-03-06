package Controlador;


public class NodoArbol {
   
    public int dato, fe;
    public NodoArbol hijoIzquierdo, hijoDerecho;
    
    public NodoArbol(int d){
        this.dato = d;
        this.fe=0;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
}
