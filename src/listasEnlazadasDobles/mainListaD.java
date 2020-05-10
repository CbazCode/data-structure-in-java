package listasEnlazadasDobles;

import javax.swing.*;

public class mainListaD {
    public static void main(String[] args) {
        ListaD l=new ListaD();
        int opcion=0,elemento,index;
        do{
            try{
                opcion= Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar por el incio\n"
                                +"2. Agregar por el final\n"
                                +"3. Agregar por indice\n"
                                +"4. ELiminar por el inicio\n"
                                +"5. Eliminar por el final\n"
                                +"6. Eliminar por indice\n"
                                +"7. Buscar por indice\n"
                                +"8. Buscar por valor\n"
                                +"9. Vaciar lista\n"
                                +"10. ¿Lista vacia?\n"
                                +"11. Mostrar Lista inicio -> fin\n"
                                +"12. Mostrar Lista fin -> inicio\n"
                                +"13. Obtener tamaño\n"
                                +"14. Salir ","Lista enlazada Doble",JOptionPane.INFORMATION_MESSAGE));
                switch (opcion){
                    case 1:
                        elemento=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese numero a añadir","Agregar por el incio",JOptionPane.INFORMATION_MESSAGE));
                        l.addStart(elemento);
                        break;
                    case 2:
                        elemento=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese numero a añadir","Agregar por el final",JOptionPane.INFORMATION_MESSAGE));
                        l.addEnd(elemento);
                        break;
                    case 3:
                        elemento=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese numero a añadir","Agregar por indice",JOptionPane.INFORMATION_MESSAGE));
                        index= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el indice","Agregar por indice",JOptionPane.INFORMATION_MESSAGE));
                        l.addForIndex(elemento,index);
                        break;
                    case 4:
                        l.deleteStart();
                        break;
                    case 5:
                        l.deleteEnd();
                        break;
                    case 6:
                        index= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el indice","Eliminar por indice",JOptionPane.INFORMATION_MESSAGE));
                        l.deleteForIndex(index);
                        break;
                    case 7:
                        index= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el indice a buscar","Buscar por indice",JOptionPane.INFORMATION_MESSAGE));
                        l.searchForIndex(index);
                        break;
                    case 8:
                        elemento=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese numero a buscar","Buscar por valor",JOptionPane.INFORMATION_MESSAGE));
                        l.searchForValue(elemento);
                        break;
                    case 9:
                        JOptionPane.showMessageDialog(null,"Lista eliminada!!","Vaciar Lista", JOptionPane.INFORMATION_MESSAGE);
                        l.clear();
                        break;
                    case 10:
                        if(l.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Lista vacia!!","isEmpty", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Lista NO vacia!!","isEmpty", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 11:
                        if(l.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Lista Vacia !!"," Mostrar lista inicio -> fin",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            l.showListStartEnd();
                        }
                        break;
                    case 12:
                        if(l.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Lista Vacia !!"," Mostrar lista fin -> inicio",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            l.showListEndStart();
                        }
                        break;
                    case 13:
                        String tamaño=String.valueOf(l.getSize());
                        JOptionPane.showMessageDialog(null,tamaño," Tamaño de lista",JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 14:
                        JOptionPane.showMessageDialog(null,"Aplicacion finalizada", "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Opcion no valida", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error "+ e.getMessage());
            }
        }while (opcion!=14);

    }
}
