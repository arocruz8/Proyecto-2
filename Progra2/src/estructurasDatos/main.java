package estructurasDatos;

import javax.swing.JOptionPane;

public class main {

    public static void main(String [] args){
        int opcion=0;
        Object dato;
        
        colaPrioridad cola1 =  new colaPrioridad();
        do{
            try{
                opcion=Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Insertar un elemento en la cola\n"+
                        "2. Quitar un elemento de la cola\n"+
                        "3. ¿La cola está vacia?\n"+
                        "4. Primer elemento en la cola\n"+
                        "5. Cantidad de elementos en la cola\n"+
                        "6. Salir","Menú de opciones",
                        JOptionPane.QUESTION_MESSAGE));
                switch(opcion){
                    case 1:
                        dato = JOptionPane.showInputDialog(null, "Ingrese el dato que desea agregar",
                                "Agregando", JOptionPane.QUESTION_MESSAGE);
                        cola1.agregar(dato);
                        break;
                        
                }
            }catch(NumberFormatException n){
                JOptionPane.showMessageDialog(null, "Error"+n.getMessage());
            }
        }while(opcion != 5);
         
    
    }
}
