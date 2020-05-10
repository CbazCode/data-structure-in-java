package Cola;

import Pila.Pila;
import listasEnlazadasSimples.Lista;

import javax.swing.*;

public class Cola implements OperacionesCola{
    NodoQ start, end;
    int size;
    public Cola(){
        start=end=null;
        size=0;
    }

    //----------------------------------------------------------CLASE NODO-------------------------------------------------------
    public class NodoQ{
        int data;
        NodoQ next;
        public NodoQ(int data){
            this.data=data;
            next=null;
        }
        public int getData(){
            return this.data;
        }
    }
    //----------------------------------------------------------CLASE NODO-------------------------------------------------------
    @Override
    public void add(int data) {
        NodoQ newNodo = new NodoQ(data);
        if(start!=null){
            newNodo.next=end;
        }else{
            start=newNodo;
        }
        end=newNodo;
        size++;
    }
    @Override
    public void quit() {
        if(isEmptyC()){
            JOptionPane.showMessageDialog(null,"Pila vacia","Cola",JOptionPane.INFORMATION_MESSAGE);
        }else{
            NodoQ aux=end;
            if(aux==start){
                JOptionPane.showMessageDialog(null,"Se quito correctamente: "+ start.getData(),"Pila",JOptionPane.INFORMATION_MESSAGE);
                end=start=null;
            }else{
                boolean flag=false;
                while(aux.next!=null){
                    if(aux.next == start){
                        flag=true;
                        JOptionPane.showMessageDialog(null,"Se quito correctamente: "+ start.getData(),"Pila",JOptionPane.INFORMATION_MESSAGE);
                        start=aux;
                    }
                    if(flag==true){
                        aux.next=null;
                    }else{
                        aux=aux.next;
                    }
                }
            }
            size--;
        }
    }

    @Override
    public boolean isEmptyC() {
        return start==null ? true : false;
    }

    public int getEnd(){
        return this.end.getData();
    }

    @Override
    public void clear() {
        if(isEmptyC()){
            JOptionPane.showMessageDialog(null,"Cola vacia","Pila",JOptionPane.INFORMATION_MESSAGE);
        }else{
            NodoQ aux=end;
            while(aux.next!=null){
                NodoQ eliminar=aux;
                end=end.next;
                aux=aux.next;
                eliminar.next=null;
            }
        }
        end=null;
        start=null;
        size=0;
        JOptionPane.showMessageDialog(null,"Pila eliminada","Pila",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public int getSizeC() {
        return this.size;
    }
}
