package listasCircularesDobles;

import listasCirculareSimples.ListaC;

import javax.swing.*;

public class ListasCD {
    NodoCD ultimo;
    int size=0;
    public ListasCD(){ ultimo=null; }
    public int getSize(){ return this.size; }
    //------------------------------------------------------------------------CLASE NODO------------------------------------------------------------------
    public class NodoCD{
        int data;
        NodoCD next,previous;
        public NodoCD(int data){
            this.data=data;
            next=this;
            previous=this;
        }
        public int getData(){ return this.data; }
    }
    //-------------------------------------------------------------------------CLASE NODO-------------------------------------------------------------------

    //-------------------------------------------------------------Determina si la listaCD esta vacia---------------------------------------------------------
    public boolean isEmpty(){
        return ultimo==null? true : false;
    }

    //-----------------------------------------------------------------------Añadir---------------------------------------------------------------------
    public void add(int data){
        NodoCD nuevoNodo = new NodoCD(data);
        if(ultimo != null){
            nuevoNodo.next=ultimo.next;
            ultimo.next.previous=nuevoNodo;
            ultimo.next=nuevoNodo;
            nuevoNodo.previous=ultimo;
        }
        ultimo=nuevoNodo;
        size++;
    }

    //---------------------------------------------------------Visualizacion en sentido horario--------------------------------------------------------
    public void showClockwise(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"ListaCD Vacia !!"," Mostrar lista horaria",JOptionPane.INFORMATION_MESSAGE);
        }else {
            String datos =" ";
            NodoCD aux = ultimo.next;
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

    //---------------------------------------------------------Visualizacion en sentido antihorario--------------------------------------------------------
    public void showCounterClockwise(){
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"ListaCD Vacia !!"," Mostrar lista antihoraria",JOptionPane.INFORMATION_MESSAGE);
        }else {
            String datos =" ";
            NodoCD aux = ultimo;
            do {
                //-------------Mostrar en JOptionPane---------------
                datos = datos + "' " +aux.getData()+" '"+"--->";
                //-------------------------------------------------

                //------------- Para mostrar en consola-------------
                //int data = aux.getData();
                //System.out.print(data + "<-->");
                //---------------------------------------------------
                aux=aux.previous;
            }while (aux != ultimo );
            JOptionPane.showMessageDialog(null,datos,"Mostrar lista",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    //--------------------------------------------------Funcion soporte para enlazar nuevo Nodo----Añadir entre valores-------------------------------------------
    public boolean funcionSoporte(NodoCD aux, NodoCD nuevoNodo,int dataToAdd){
        NodoCD nodoPrevious=aux, nodoNext=aux.next;
        nuevoNodo.next=nodoNext;
        nodoPrevious.next=nuevoNodo;
        nodoNext.previous=nuevoNodo;
        nuevoNodo.previous=nodoPrevious;
        size++;
        return true;
    }
    //-----------------------------------------------------------------Añadir entre valores--------------------------------------------------------------------
    public void addForValues(int dato1, int dato2, int dataToAdd){
        boolean flag = false;
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Insertar por indice",JOptionPane.INFORMATION_MESSAGE);
        }else{
            NodoCD aux = ultimo.next;
            do {
                if((aux.getData()==dato1 && aux.next.getData()==dato2) || (aux.next.getData()==dato1 && aux.getData()==dato2)) {
                    NodoCD nuevoNodo = new NodoCD(dataToAdd);
                    if((ultimo.next.getData()==dato1  && ultimo.getData()==dato2) || (ultimo.getData()==dato1  && ultimo.next.getData()==dato2)){
                        flag=funcionSoporte(aux,nuevoNodo,dataToAdd);
                        ultimo=nuevoNodo;
                    }else {
                        flag=funcionSoporte(aux,nuevoNodo,dataToAdd);
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
            NodoCD eliminar = ultimo,aux=ultimo.next;
            do {
                aux=aux.next;
            }while (aux.next.next != ultimo.next );
            ultimo=aux;
            ultimo.next=eliminar.next;
            ultimo.next.previous=ultimo;
            eliminar.next=null;
            eliminar.previous=null;
            size--;
        }
    }

    //-----------------------------------------------------------------Eliminar por valor-------------------------------------------------------------------
    public void deleteForValue(int datoToDelete){
        boolean flag = false;
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Insertar por indice",JOptionPane.INFORMATION_MESSAGE);
        }else{
            NodoCD aux = ultimo.next;
            do {
                if(aux.next.getData()==datoToDelete) {
                    if(ultimo.getData()==datoToDelete){
                        delete();
                        flag=true;
                        JOptionPane.showMessageDialog(null,"Se elimino correctamente por el final"," ELiminar en lista circular",JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        NodoCD nodoPrevious=aux, eliminar=aux.next;
                        nodoPrevious.next=eliminar.next;
                        nodoPrevious.next.previous=nodoPrevious;
                        eliminar.next=null;
                        eliminar.previous=null;
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

    public void searchForValue(int dataToSearch){
        boolean flag = false;
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"No procede, lista vacia", "Insertar por indice",JOptionPane.INFORMATION_MESSAGE);
        }else{
            NodoCD aux = ultimo.next;
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
            NodoCD aux=ultimo.next;
            do {
                NodoCD elminar = aux;
                aux=aux.next;
                elminar.next=null;
                elminar.previous=null;
            }while (aux != ultimo.next );
            ultimo=null;
            size=0;
        }
    }
}
