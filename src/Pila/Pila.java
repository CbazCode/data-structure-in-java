package Pila;

import javax.swing.*;

public class Pila implements OperacionesPila {
    NodoP cima;
    int size;
    public Pila(){
        cima=null;
        size=0;
    }
    //---------------------------------------------CLASE NODO---------------------------------------------------------
    public class NodoP{
        int data;
        NodoP next;
        public NodoP(int data){
            this.data=data;
            next=null;
        }
        public int getData(){
            return this.data;
        }
    }
    //---------------------------------------------CLASE NODO---------------------------------------------------------
    @Override
    public void push(int data) {
        NodoP newNodo = new NodoP(data);
        if(cima!=null){
            newNodo.next=cima;
        }
        cima=newNodo;
        size++;
    }

    @Override
    public void pop() {
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"Pila vacia","Pila",JOptionPane.INFORMATION_MESSAGE);
        }else{
            NodoP aux=cima;
            JOptionPane.showMessageDialog(null,"Se quito correctamente: "+ cima.getData(),"Pila",JOptionPane.INFORMATION_MESSAGE);
            cima=cima.next;
            aux.next=null;
            size--;
        }
    }

    @Override
    public int peek() {
        return cima.getData();
    }

    @Override
    public boolean isEmpty() {
        return cima==null ? true : false;
    }

    @Override
    public void clear() {
        if(isEmpty()){
            JOptionPane.showMessageDialog(null,"Pila vacia","Pila",JOptionPane.INFORMATION_MESSAGE);
        }else{
            NodoP aux=cima;
            while(aux.next!=null){
                NodoP eliminar=aux;
                cima=cima.next;
                aux=aux.next;
                eliminar.next=null;
            }
        }
        cima=null;
        size=0;
        JOptionPane.showMessageDialog(null,"Pila eliminada","Pila",JOptionPane.INFORMATION_MESSAGE);

    }

    @Override
    public int getSize() {
        return size;
    }
}
