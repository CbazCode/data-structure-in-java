package listasCirculareSimples;

import javax.swing.*;

public class mainListaC {
    public static void main(String[] args) {
        ListaC lc = new ListaC();
        int opcion=0,elemento,dato1,dato2;
        do{
            try{
                opcion= Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar a lista circular\n"
                                +"2. Agregar entre valores\n"
                                +"3. ELiminar en lista circular\n"
                                +"4. Eliminar por valor\n"
                                +"5. Buscar por valor\n"
                                +"6. Vaciar lista\n"
                                +"7. ¿Lista vacia?\n"
                                +"8. Mostrar Lista\n"
                                +"9. Obtener tamaño\n"
                                +"10. Salir ","Lista enlazada circular simple",JOptionPane.INFORMATION_MESSAGE));
                switch (opcion){
                    case 1:
                        elemento=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese numero a añadir","Agregar a lista circular",JOptionPane.INFORMATION_MESSAGE));
                        lc.add(elemento);
                        break;
                    case 2:
                        elemento=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese numero a añadir","Agregar entre valores",JOptionPane.INFORMATION_MESSAGE));
                        dato1= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el dato anterior al dato ingresado","Agregar entre valores",JOptionPane.INFORMATION_MESSAGE));
                        dato2= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el dato posterior al dato ingresado","Agregar entre valores",JOptionPane.INFORMATION_MESSAGE));
                        lc.addForValues(dato1,dato2,elemento);
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null,"Se elimino correctamente "," ELiminar LC",JOptionPane.INFORMATION_MESSAGE);
                        lc.delete();
                        break;
                    case 4:
                        elemento=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese numero a eliminar","Eliminar por valor",JOptionPane.INFORMATION_MESSAGE));
                        lc.deleteForValue(elemento);
                        break;
                    case 5:
                        elemento= Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el numero a buscar","Buscar por valor",JOptionPane.INFORMATION_MESSAGE));
                        lc.searchForValue(elemento);
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null,"Lista eliminada!!","Vaciar Lista", JOptionPane.INFORMATION_MESSAGE);
                        lc.clear();
                        break;
                    case 7:
                        if(lc.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Lista vacia!!","isEmpty", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Lista NO vacia!!","isEmpty", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 8:
                        if(lc.isEmpty()){
                            JOptionPane.showMessageDialog(null,"Lista Vacia !!"," Mostrar lista",JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            lc.show();
                        }
                        break;
                    case 9:
                        String tamaño=String.valueOf(lc.getSize());
                        JOptionPane.showMessageDialog(null,tamaño," Tamaño de lista",JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 10:
                        JOptionPane.showMessageDialog(null,"Aplicacion finalizada", "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null,"Opcion no valida", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error "+ e.getMessage());
            }
        }while (opcion!=10);


    }
}
