import java.util.LinkedList;
import java.util.Scanner;
public class App {
  
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int opciones;

        Restaurante restaurante = new Restaurante();
		
        do {
		
			System.out.println("Vienvenido a la gestión del restaurante");
			System.out.println("Opción 1: Registrar mesa");
			System.out.println("Opción 2: Registrar plato");
			System.out.println("Opción 3: Regitrar pedido");
			System.out.println("Opción 4: Modificar pedido");
			System.out.println("Opción 5 Modificar o borrar plato");
			System.out.println("Opción 6: Guradar datos");
			System.out.println("Opción 7: Cargar datos");
			System.out.println("Opción 8: Salir");
			
			opciones = sc.nextInt();
			
			switch(opciones) {
			case 1 -> {restaurante.registrarMesa();}
			case 2 -> {restaurante.registrarPlatoCarta();}
			case 3 -> {restaurante.registrarPedido();}
			case 4 -> {restaurante.menuModificarPedido();}
			case 5 -> {restaurante.menuModificarPlato();}
			case 6 -> {
				LinkedList<Object>[] datos = restaurante.getDatos();
				Persistencia.guardarDatos(datos);
	
			}
			case 7 -> {
				LinkedList<?>[] datos = Persistencia.cargarDatos();
				restaurante.setDatos(datos);
			}
			
            default -> System.out.println("Valor incorrecto, pruebe de nuevo"); 

			}
		
		// Se ejecuta siempre que no se introduzca el 8
		}while (opciones != 8);
		
		
	}
}
