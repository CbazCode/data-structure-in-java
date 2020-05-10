package listasCirculareSimples;

import listasEnlazadasDobles.ListaD;

import javax.swing.*;

public class ListaC {
    NodoC ultimo;
    int size=0;
    public ListaC(){ ultimo = null; }
    public int getSize(){ return this.size; }

    //--------------------------------------------------------------------CLASE NODO------------------------------------------------------------------------
    public class NodoC{
        private int data;
        NodoC next;
        NodoC(int data){
            this.data=data;
            next=this;
        }
        public int getData(){
            return this.data;
        }
    }
    //----------------------------------------------------------------------CLASE NODO-----------------------------------------------------------------------
    //-------------------------------------------------------------Determina si la listaD esta vacia---------------------------------------------------------
    public boolean isEmpty(){
        return ultimo==null? true : false;
    }

    //-----------------------------------------------------------------------Visualzacion de dato----------------------------------------------------------
    public void show(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"ListaC Vacia !!"," Mostrar lista",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            String datos =" ";
            NodoC aux = ultimo.next;
            do {
                //-------------Mostrar en JOptionPane---------------
                datos = datos + "' " +aux.getData()+" '"+"--->";
                //-------------------------------------------------

                //------------- Para mostrar en consola-------------
                //int data = aux.getData();
                //System.out.print(data + "<-->");
                //---------------------------------------------------
                aux=aux.next;
            }while (aux != ultimo.next );
            JOptionPane.showMessageDialog(null,datos,"Mostrar lista",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //-----------------------------------------------------------------------Añadir--------------------------------------------------------------------------
    public void add(int data){
        NodoC nuevoNodo = new NodoC(data);
        if(ultimo != null){
            nuevoNodo.next=ultimo.next;
            ultimo.next=nuevoNodo;
        }
        ultimo=nuevoNodo;
        size++;
    }
    //-----------------------------------------------------------------Añadir entre valores--------------------------------------------------------------------
    public void addForValues(int dato1, int dato2, int dataToAdd){
        boolean flag = false;
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Insertar por indice",JOptionPane.INFORMATION_MESSAGE);
        }else{
            NodoC aux = ultimo.next;
            do {
                if((aux.getData()==dato1 && aux.next.getData()==dato2) || (aux.next.getData()==dato1 && aux.getData()==dato2)) {
                    if((ultimo.next.getData()==dato1  && ultimo.getData()==dato2) || (ultimo.getData()==dato1  && ultimo.next.getData()==dato2)){
                        NodoC nodoPrevious=aux, nodoNext=aux.next;
                        NodoC nuevoNodo = new NodoC(dataToAdd);
                        nuevoNodo.next=nodoNext;
                        nodoPrevious.next=nuevoNodo;
                        ultimo=nuevoNodo;
                        size++;
                        flag=true;
                    }else {
                        NodoC nodoPrevious=aux, nodoNext=aux.next;
                        NodoC nuevoNodo = new NodoC(dataToAdd);
                        nuevoNodo.next=nodoNext;
                        nodoPrevious.next=nuevoNodo;
                        size++;
                        flag=true;
                    }
                }
                aux=aux.next;
            }while (aux != ultimo.next );
            if(flag==false) {
                JOptionPane.showMessageDialog(null,"Datos invalidos", "Insertar entre valores",JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

    //-------------------------------------------------------------------------Eliminar----------------------------------------------------------------------
    public void delete(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Eliminar",JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            NodoC eliminar = ultimo,aux=ultimo.next;
            do {
                aux=aux.next;
            }while (aux.next.next != ultimo.next );
            ultimo=aux;
            ultimo.next=eliminar.next;
            eliminar.next=null;
            size--;
        }
    }

    //-----------------------------------------------------------------Eliminar por valor-------------------------------------------------------------------
    public void deleteForValue(int datoToDelete){
        boolean flag = false;
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Insertar por indice",JOptionPane.INFORMATION_MESSAGE);
        }else{
            NodoC aux = ultimo.next;
            do {
                if(aux.next.getData()==datoToDelete) {
                    if(ultimo.getData()==datoToDelete){
                        delete();
                        flag=true;
                        JOptionPane.showMessageDialog(null,"Se elimino correctamente por el final"," ELiminar en lista circular",JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        NodoC nodoPrevious=aux, eliminar=aux.next;
                        nodoPrevious.next=eliminar.next;
                        eliminar.next=null;
                        size--;
                        flag=true;
                        JOptionPane.showMessageDialog(null,"Se elimino correctamente por el final"," ELiminar en lista circular",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                aux=aux.next;
            }while (aux != ultimo.next );
            if(flag==false) {
                JOptionPane.showMessageDialog(null,"Dato no se encuentra en lista", "Eliminar por valor",JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }
    //--------------------------------------------------------------Buscar por valor----------------------------------------------------------------------

    public void searchForValue(int dataToSearch){
        boolean flag = false;
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Insertar por indice",JOptionPane.INFORMATION_MESSAGE);
        }else{
            NodoC aux = ultimo.next;
            do {
                if(aux.getData()==dataToSearch) {
                    String show="";
                    show=show+"Objeto "+dataToSearch + " encontrado";
                    JOptionPane.showMessageDialog(null,show,"Buscar por valor", JOptionPane.INFORMATION_MESSAGE);
                    flag=true;
                }
                aux=aux.next;
            }while (aux != ultimo.next );
            if(flag==false) {
                JOptionPane.showMessageDialog(null,"Dato no se encuentra en lista", "Buscar por valor",JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

    //-------------------------------------------------------------Vaciar lista--------------------------------------------------------------------------------
    public void clear(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"La lista ya se encuentra vacia", "Vaciar Lista",JOptionPane.INFORMATION_MESSAGE);
        }else{
            NodoC aux=ultimo.next;
            do {
                NodoC elminar = aux;
                aux=aux.next;
                elminar.next=null;
            }while (aux != ultimo.next );
            ultimo=null;
            size=0;
        }
    }
}

