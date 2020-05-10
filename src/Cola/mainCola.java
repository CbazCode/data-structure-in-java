package Cola;

import javax.swing.*;

public class mainCola {
    public static void main(String[] args) {
        Cola miCola = new Cola();
        int opcion=0,elemento,dato1,dato2;
        do{
            try{
                opcion= Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar a Queue\n"
                                +"2. Quitar a Queue\n"
                                +"3. ¿Queue vacio?\n"
                                +"4. Limpiar queue\n"
                                +"5. Obtener ultimo\n"
                                +"6. Obtener tamaño\n"
                                +"7. Salir ","Cola",JOptionPane.INFORMATION_MESSAGE));
                switch (opcion){
                    case 1:
                        elemento=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese numero a añadir","Agregar a Cola",JOptionPane.INFORMATION_MESSAGE));
                        miCola.add(elemento);
                        break;
                    case 2:
                        miCola.quit();
                        break;
                    case 3:
                        if(miCola.isEmptyC()){
                            JOptionPane.showMessageDialog(null,"Cola vacia!!","isEmpty", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Cola NO vacia!!","isEmpty", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4:
                        miCola.clear();
                        break;
                    case 5:
                        elemento=miCola.getEnd();
                        JOptionPane.showMessageDialog(null,"Final de cola: "+elemento,"Obtner final", JOptionPane.INFORMATION_MESSAGE);                        break;
                    case 6:
                        elemento=miCola.getSizeC();
                        JOptionPane.showMessageDialog(null,"Tamaño de cola: "+elemento,"Obtener tamaño", JOptionPane.INFORMATION_MESSAGE);
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
