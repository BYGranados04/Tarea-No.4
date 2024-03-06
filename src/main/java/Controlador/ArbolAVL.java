package Controlador;


public class ArbolAVL {
    
    private NodoArbol raiz;
    public ArbolAVL(){
        
        raiz=null;
    }
    public NodoArbol obtenerRaiz(){
        
        return raiz;
    }
    
    public NodoArbol buscar(int a, NodoArbol b){
        
        if(raiz==null){
            return null;
            
        }else if(b.dato==a){
            return b;
            
        }else if(b.dato<a){
            return buscar(a,b.hijoDerecho);
        }else{
            return buscar(a,b.hijoIzquierdo);
        }
    }
    public int obtenerFe(NodoArbol x){
        if(x==null){
            return -1;
        }else{
            return x.fe;
        }
    }
    public NodoArbol rotacionIzquierda(NodoArbol c){
      
        NodoArbol auxiliar = c.hijoIzquierdo;
        c.hijoIzquierdo=auxiliar.hijoDerecho;
        auxiliar.hijoDerecho=c;
        c.fe=Math.max(obtenerFe(c.hijoIzquierdo),obtenerFe(c.hijoDerecho))+1;
        auxiliar.fe=Math.max(obtenerFe(auxiliar.hijoIzquierdo),obtenerFe(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }
    
    public NodoArbol rotacionDerecha(NodoArbol c){
        NodoArbol auxiliar = c.hijoDerecho;
        c.hijoDerecho=auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo=c;
        c.fe=Math.max(obtenerFe(c.hijoIzquierdo),obtenerFe(c.hijoDerecho))+1;
        auxiliar.fe=Math.max(obtenerFe(auxiliar.hijoIzquierdo),obtenerFe(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }
    public NodoArbol rotacionDobleIzquierda(NodoArbol c){
        
        NodoArbol temporal;
        c.hijoIzquierdo=rotacionDerecha(c.hijoIzquierdo);
        temporal=rotacionIzquierda(c);
        return temporal;    
    }
    public NodoArbol rotacionDobleDerecha(NodoArbol c){
        NodoArbol temporal;
        c.hijoDerecho=rotacionIzquierda(c.hijoDerecho);
        temporal=rotacionDerecha(c);
        return temporal;
    }
    public NodoArbol insertarAVL(NodoArbol nuevo, NodoArbol subAr){
        NodoArbol nuevoPadre=subAr;
        if(nuevo.dato<subAr.dato){
            if(subAr.hijoIzquierdo==null){
                subAr.hijoIzquierdo=nuevo;
            }else{
                subAr.hijoIzquierdo=insertarAVL(nuevo,subAr.hijoIzquierdo);
                if(obtenerFe(subAr.hijoIzquierdo) - obtenerFe(subAr.hijoDerecho)==2){
                    if(nuevo.dato<subAr.hijoIzquierdo.dato){
                        nuevoPadre=rotacionIzquierda(subAr);
                    }else{
                        nuevoPadre=rotacionDobleIzquierda(subAr);
                    }
                }
            }
        }else if(nuevo.dato>subAr.dato){
            if(subAr.hijoDerecho==null){
                subAr.hijoDerecho=nuevo;
            }else{
                subAr.hijoDerecho=insertarAVL(nuevo, subAr.hijoDerecho);
                if((obtenerFe(subAr.hijoDerecho) - obtenerFe(subAr.hijoIzquierdo)==2)){
                    if(nuevo.dato>subAr.hijoDerecho.dato){
                      nuevoPadre=rotacionDerecha(subAr);
                    }else{
                        nuevoPadre=rotacionDobleDerecha(subAr);
                    }
                }
            }
        }else{
            System.out.println("Nodo Duplicado");
        }
        if((subAr.hijoIzquierdo==null) && (subAr.hijoDerecho!=null)){
            subAr.fe=subAr.hijoDerecho.fe+1;
        }else if((subAr.hijoDerecho==null) && (subAr.hijoIzquierdo!=null)){
            subAr.fe=subAr.hijoIzquierdo.fe+1;
        }else{
            subAr.fe=Math.max(obtenerFe(subAr.hijoIzquierdo), obtenerFe(subAr.hijoDerecho))+1;
        }
        return nuevoPadre;
    }
    public void insertar(int d){
        NodoArbol nuevo=new NodoArbol(d);
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=insertarAVL(nuevo, raiz);
        }
    }
    public void inOrden(NodoArbol b){
        if(b!=null){
            inOrden(b.hijoIzquierdo);
            System.out.println(b.dato + "");
            inOrden(b.hijoDerecho);
        }
    }
    public void preOrden(NodoArbol b){
        if(b!=null){
            System.out.println(b.dato +", ");
            preOrden(b.hijoIzquierdo);
            preOrden(b.hijoDerecho);
        }
    }
    public void postOrden(NodoArbol b){
        if(b!=null){
            postOrden(b.hijoIzquierdo);
            postOrden(b.hijoDerecho);
            System.out.println(b.dato + ", ");
        }
    }
}
