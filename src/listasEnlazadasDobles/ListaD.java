package listasEnlazadasDobles;

import listasEnlazadasSimples.Lista;

import javax.swing.*;

public class ListaD {
    NodoD head, tail;
    int size = 0;
    public ListaD(){ head=tail=null; }
    public int getSize(){ return this.size; }
    //----------------------------------------------------------------------------CLASE NODO----------------------------------------------------------------
    public class NodoD{
        int dato;
        NodoD next;
        NodoD previous;
        public NodoD(int dato){
            this.dato=dato;
            next=null;
            previous=null;
        }
        public int getDato(){
            return this.dato;
        }
    }
    //-----------------------------------------------------------------------------CLASE NODO----------------------------------------------------------------

    //-------------------------------------------------------------Determina si la listaD esta vacia---------------------------------------------------------
    public boolean isEmpty(){
        return head==null? true : false;
    }

    //-----------------------------------------------------------------------Visualzacion de dato----------------------------------------------------------
    public void showListStartEnd(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"ListaD Vacia !!"," Mostrar lista",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            String datos =" ";
            NodoD aux = head;
            while(aux != null){
                //-------------Mostrar en JOptionPane---------------
                datos = datos + "' " +aux.getDato()+" '"+"<--->";
                //-------------------------------------------------

                //------------- Para mostrar en consola-------------
                //int data = aux.getDato();
                //System.out.print(data + "<-->");
                //---------------------------------------------------
                aux=aux.next;
            }
            JOptionPane.showMessageDialog(null,datos,"Mostrar lista",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public void showListEndStart(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"ListaD Vacia !!"," Mostrar lista",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            String datos =" ";
            NodoD aux = tail;
            while(aux != null){
                //-------------Mostrar en JOptionPane---------------
                datos = datos + "' " +aux.getDato()+" '"+"<--->";
                //-------------------------------------------------

                //------------- Para mostrar en consola-------------
                //int data = aux.getDato();
                //System.out.print(data + "<-->");
                //---------------------------------------------------
                aux=aux.previous;
            }
            JOptionPane.showMessageDialog(null,datos,"Mostrar lista",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //----------------------------------------------------------------Añade por el principio-----------------------------------------------------------------
    public void addStart(int dato){
        if(isEmpty()){
            //Crea los apuntadores simultaneos a cabeza y cola
            head=tail=new NodoD(dato);
        }else{
            NodoD nuevoNodo = new NodoD(dato);
            nuevoNodo.next=head;
            head.previous=nuevoNodo;
            head=nuevoNodo;
        }
        size++;
    }

    //--------------------------------------------------------------------Añade por el final------------------------------------------------------------------
    public void addEnd(int dato){
        if(isEmpty()){
            //Crea los apuntadores simltaneos a cabeza y cola
            head=tail=new NodoD(dato);
        }else{
            NodoD aux = tail;
            NodoD nuevoNodo = new NodoD(dato);
            tail.next=nuevoNodo;
            nuevoNodo.previous=tail;
            tail=nuevoNodo;
        }
        size++;
    }
    //-----------------------------------------------------------------Añadir por indice--------------------------------------------------------------------
    public void addForIndex(int dato, int index){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Insertar por indice",JOptionPane.INFORMATION_MESSAGE);
        }else{
            if(index>=0 && index<size){
                if(index==0){
                    addStart(dato);
                }else{
                    NodoD aux= head;
                    int contador = 0;
                    while(contador<index-1){
                        aux=aux.next;
                        contador++;
                    }
                    NodoD nuevoNodo = new NodoD(dato);
                    nuevoNodo.next=aux.next;
                    aux.next.previous=nuevoNodo;
                    aux.next=nuevoNodo;
                    nuevoNodo.previous=aux;
                    size++;
                }
            } else{
                JOptionPane.showMessageDialog(null,"Indice fuera de rango", "Insertar por indice",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    //---------------------------------------------------------------Elimiar por el Inicio-------------------------------------------------------------------
    public void deleteStart(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Eliminar por incio",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            NodoD eliminar = head;
            head=head.next;
            eliminar.next=null;
            head.previous=null;
            size--;
            JOptionPane.showMessageDialog(null,"Se elimino correctamente por el inicio"," ELiminar por el inicio",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //--------------------------------------------------------------Eliminar por Final------------------------------------------------------------------------
    public void deleteEnd(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Eliminar por final",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            NodoD aux = head;
            while(aux.next.next != null){
                aux=aux.next;
            }
            tail=aux;
            aux.next.previous=null;
            tail.next=null;
            size--;
            JOptionPane.showMessageDialog(null,"Se elimino correctamente por el final"," ELiminar por el final",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //----------------------------------------------------------Eliminar por Indice----------------------------------------------------------------------------
    public void deleteForIndex(int index){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Eliminar por indice",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            if(index>=0 && index<size){
                if(index==0){
                    deleteStart();
                }else{
                    if(index==size-1){
                        deleteEnd();
                    }else{
                        NodoD aux= head;
                        int contador = 0;
                        while(contador<index-1){
                            aux=aux.next;
                            contador++;
                        }
                        NodoD eliminar = aux.next;
                        aux.next.next.previous=aux;
                        aux.next=aux.next.next;
                        eliminar.next=null;
                        eliminar.previous=null;
                        size--;
                    }
                }
            } else{
                JOptionPane.showMessageDialog(null,"Indice fuera de rango", "Eliminar por indice",JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    //----------------------------------------------------------------Buscar por indice--------------------------------------------------------------------
    public void searchForIndex(int index){
        int objBuscado;
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Buscar por indice",JOptionPane.INFORMATION_MESSAGE);
        }else{
            if(index>=0 && index<size){
                NodoD aux = head;
                int contador=0;
                while (contador<index){
                    aux=aux.next;
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
    public void searchForValue(int dato){
        boolean flag = false;
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Buscar por valor",JOptionPane.INFORMATION_MESSAGE);
        }else{
            NodoD aux = head;
            int contador=0;
            while (contador<size){
                if(dato==aux.getDato()){
                    flag=true;
                    break;
                }
                aux=aux.next;
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
    public void clear(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"La lista ya se encuentra vacia", "Vaciar Lista",JOptionPane.INFORMATION_MESSAGE);
        }else{
            NodoD aux=head;
            while(aux.next!=null){
                NodoD eliminar =aux;
                aux=aux.next;
                eliminar.next=null;
                eliminar.previous=null;
            }
            head.next=null;
            head=null;
            tail.previous=null;
            tail=null;
            size=0;
        }
    }
}
