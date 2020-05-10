package listasEnlazadasSimples;


import javax.swing.*;

public class Lista {
    Nodo cabeza, cola;
    int size=0;
    public Lista(){
        cabeza=cola=null;
    }
    public int getSize(){ return this.size; }
    //>>>>>>Clase interna Nodo, puede colocarse en otra clase
    //----------------------------------------------------------------------------CLASE NODO----------------------------------------------------------------
    public class Nodo {
        int dato;
        Nodo siguiente;

        public Nodo(int dato){
            this.dato=dato;
        }
        public int getDato(){
            return this.dato;
        }
        public void setDato(int d){
            this.dato=d;
        }
        public Nodo getSiguiente(){
            return this.siguiente;
        }
        public void setSiguiente(Nodo n){ this.siguiente = n; }

    }
    //-----------------------------------------------------------------------------CLASE NODO----------------------------------------------------------------


    //-------------------------------------------------------------Determina si la lista esta vacia---------------------------------------------------------
    public boolean isEmpty(){
        return cabeza==null? true : false;
    }

    //-----------------------------------------------------------------------Visualzacion de dato----------------------------------------------------------
    public void mostrarLista(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"Lista Vacia !!"," Mostrar lista",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            String datos =" ";
            Nodo aux = cabeza;
            while(aux != null){
                //-------------Mostrar en JOptionPane---------------
                datos = datos + "' " +aux.getDato()+" '"+"--->";
                //-------------------------------------------------
                /*------------- Para mostrar en consola-------------
                int data = aux.getDato();
                System.out.print(data + "-->");
                --------------------------------------------------- */
                aux=aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null,datos,"Mostrar lista",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //----------------------------------------------------------------Añade por el principio-----------------------------------------------------------------
    public void insertarPorInicio(int dato){
        if(isEmpty()){
            //Crea los apuntadores simltaneos a cabeza y cola
            cabeza=cola=new Nodo(dato);
        }else{
            Nodo aux = cabeza;
            Nodo nuevoNodo = new Nodo(dato);
            //Ambos tienen la misma funcion
            nuevoNodo.siguiente=cabeza;
            //nuevoNodo.setSiguiente(cabeza);
            //-----------------------------
            cabeza=nuevoNodo;
        }
        size++;
    }

    //--------------------------------------------------------------------Añade por el final------------------------------------------------------------------
    public void insertarPorFinal(int dato){
        if(isEmpty()){
            //Crea los apuntadores simltaneos a cabeza y cola
            cabeza=cola=new Nodo(dato);
        }else{
            Nodo aux = cola;
            Nodo nuevoNodo = new Nodo(dato);
            //-------------Ambos tienen la misma funcion-----------------
            //cola.siguiente=nuevoNodo;
            cola.setSiguiente(nuevoNodo);
            //-----------------------------------------------------------
            cola=nuevoNodo;
        }
        size++;
    }

    //-----------------------------------------------------------------Añadir por indice--------------------------------------------------------------------
    public void insertarPorIndice(int dato, int index){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Insertar por indice",JOptionPane.INFORMATION_MESSAGE);
        }else{
            if(index>=0 && index<size){
                if(index==0){
                    insertarPorInicio(dato);
                }else{
                        Nodo aux= cabeza;
                        int contador = 0;
                        while(contador<index-1){
                            aux=aux.siguiente;
                            contador++;
                        }
                        Nodo nuevoNodo = new Nodo(dato);
                        //----------------Ambos tienen la misma funcion-----------------
                        //nuevoNodo.setSiguiente(aux.getSiguiente());
                        nuevoNodo.siguiente=aux.siguiente;
                        //--------------------------------------------------------------
                        aux.siguiente=nuevoNodo;
                        size++;
                }
            } else{
                JOptionPane.showMessageDialog(null,"Indice fuera de rango", "Insertar por indice",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    //---------------------------------------------------------------Elimiar por el Inicio-------------------------------------------------------------------
    public void eliminarPorInicio(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Eliminar por incio",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            Nodo eliminar = cabeza;
            cabeza=cabeza.siguiente;
            eliminar.siguiente=null;
            size--;
            JOptionPane.showMessageDialog(null,"Se elimino correctamente por el inicio"," ELiminar por el inicio",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //--------------------------------------------------------------Eliminar por Final------------------------------------------------------------------------
    public void eliminarPorFinal(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Eliminar por final",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Nodo aux = cabeza;
            while(aux.siguiente.siguiente != null){
                aux=aux.siguiente;
            }
            cola=aux;
            cola.siguiente=null;
            size--;
            JOptionPane.showMessageDialog(null,"Se elimino correctamente por el final"," ELiminar por el final",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //----------------------------------------------------------Eliminar por Indice----------------------------------------------------------------------------
    public void eliminarPorIndice(int index){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Eliminar por indice",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            if(index>=0 && index<size){
                if(index==0){
                    eliminarPorInicio();
                }else{
                    if(index==size-1){
                        eliminarPorFinal();
                    }else{
                        Nodo aux= cabeza;
                        int contador = 0;
                        while(contador<index-1){
                            aux=aux.siguiente;
                            contador++;
                        }
                        Nodo eliminar = aux.siguiente;
                        aux.siguiente=aux.siguiente.siguiente;
                        eliminar.siguiente=null;
                        size--;
                    }
                }
            } else{
                JOptionPane.showMessageDialog(null,"Indice fuera de rango", "Eliminar por indice",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    //----------------------------------------------------------------Buscar por indice--------------------------------------------------------------------
    public void buscarPorIndice(int index){
        int objBuscado;
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Buscar por indice",JOptionPane.INFORMATION_MESSAGE);
        }else{
            if(index>=0 && index<size){
                Nodo aux = cabeza;
                int contador=0;
                while (contador<index){
                    aux=aux.siguiente;
                    contador++;
                }
                objBuscado=aux.getDato();
                String show="";
                show=show+"Objeto encontrado "+ objBuscado + " en indice "+ contador;
                JOptionPane.showMessageDialog(null,show,"Buscar por valor", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"Indice fuera de rango", "Buscar por indice",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    //--------------------------------------------------------------Buscar por valor----------------------------------------------------------------------
    public void buscarPorValor(int dato){
        int objBuscado;
        boolean flag = false;
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Buscar por valor",JOptionPane.INFORMATION_MESSAGE);
        }else{
                Nodo aux = cabeza;
                int contador=0;
                while (contador<size){
                    if(dato==aux.getDato()){
                        flag=true;
                        break;
                    }
                    aux=aux.siguiente;
                    contador++;
                }

            if (flag == true) {
                String show="";
                show=show+"Objeto "+dato+" encontrado en posicion: " + contador;
                JOptionPane.showMessageDialog(null,show,"Buscar por valor", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("objeto no encontrado");
            }
        }
    }

    //------------------------------------------------------------------Vaciar Lista-------------------------------------------------------------------------------
    public void vaciaLista(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"La lista ya se encuentra vacia", "Vaciar Lista",JOptionPane.INFORMATION_MESSAGE);
        }else{
            Nodo aux=cabeza;
            while(aux.siguiente!=null){
                Nodo eliminar =aux;
                aux=aux.siguiente;
                eliminar.siguiente=null;
                eliminar=null;
            }
            cabeza=null;
            cola=null;
            size=0;
        }
    }
}





