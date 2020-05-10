package Pila;

import javax.swing.*;

public class mainPila {
    public static void main(String[] args) {
        Pila miPila = new Pila();
        int opcion=0,elemento,dato1,dato2;
        do{
            try{
                opcion= Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar a Stack\n"
                                +"2. Quitar a Stack\n"
                                +"3. ¿Stack vacio?\n"
                                +"4. Limpiar pila\n"
                                +"5. Obtener cima\n"
                                +"6. Obtener tamaño\n"
                                +"7. Salir ","Pila",JOptionPane.INFORMATION_MESSAGE));
                switch (opcion){
                    case 1:
                        elemento=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese numero a añadir","Agregar a Pila",JOptionPane.INFORMATION_MESSAGE));
                        miPila.push(elemento);
                        break;
                    case 2:
                        miPila.pop();
                        break;
                    case 3:
                        if(miPila.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Pila vacia!!","isEmpty", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Pila NO vacia!!","isEmpty", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4:
                        miPila.clear();
                        break;
                    case 5:
                        elemento=miPila.peek();
                        JOptionPane.showMessageDialog(null,"Cima de pila: "+elemento,"isEmpty", JOptionPane.INFORMATION_MESSAGE);                        break;
                    case 6:
                        elemento=miPila.getSize();
                        JOptionPane.showMessageDialog(null,"Cima de pila: "+elemento,"isEmpty", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null,"Aplicacion finalizada", "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Opcion no valida", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error "+ e.getMessage());
            }
        }while (opcion!=7);
    }
}
