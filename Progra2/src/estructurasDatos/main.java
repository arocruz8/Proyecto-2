package estructurasDatos;
import java.util.Scanner;

public class main {
    
    public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.println("Registro de paquetes en el heap\n");   

    System.out.println("Digite el tamaño que desea en el arreglo ");
    heap pq = new heap(scan.nextInt() );

    char ch;
    /* menú para trabajar con el heap */
    do    
    {
        System.out.println("\nOperaciones del heap\n");
        System.out.println("1. añadir");
        System.out.println("2. eliminar");
        System.out.println("3. vacia");
        System.out.println("4. llena");
        System.out.println("5. limpiar toda");
        System.out.println("6. tamaño");

        int choice = scan.nextInt();            
        switch (choice) 
        {
        case 1 : 
            System.out.println("Ingrese el tipo de paquete y el #de la prioriddad");
            pq.añadir(scan.next(), scan.nextInt() );                     
            break;                          
        case 2 : 
            System.out.println("\nPaquete elimanado \n\n"+ pq.eliminar()); 
            break;        
        case 3 : 
            System.out.println("\nEstado del heap vacio : "+ pq.vacia() );
            break; 
        case 4 : 
            System.out.println("\nEstado del heap lleno : "+ pq.lleno() );
            break; 
        case 5 : 
            System.out.println("\nPriority Queue Cleared");
            pq.clear();
            break;    
        case 6 : 
            System.out.println("\nTamaño = "+ pq.tamañoArreglo() );
            break;         
        default : 
            System.out.println("Entrada erronea \n ");
            break;   
        }    

        System.out.println("\nDesea seguir registrando paquetes (Type y or n) \n");
        ch = scan.next().charAt(0);                        
    } while (ch == 'Y'|| ch == 'y');            
    }
}

