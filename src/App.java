import java.util.Scanner;
public class App {
  
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int opciones;
		
        do {
		
			System.out.println("Vienvenido a la gestión del restaurante");
			System.out.println("Opción 1: Registrar mesa");
			System.out.println("Opción 2: Registrar plato");
			System.out.println("Opción 3: Regitrar pedido");
			System.out.println("Opción 4: Modificar pedido");
			System.out.println("Opción 5: Borrar pedido");
			System.out.println("Opción 6 Modificar o borrar plato");
			System.out.println("Opción 7: Guradar datos");
			System.out.println("Opción 8: Cargar datos");
			System.out.println("Opción 9: Salir");
			
			opciones = sc.nextInt();
			
			switch(opciones) {
			case 1 -> {}
			case 2 -> {}
			case 3 -> {}
			case 4 -> {}
			case 5 -> {}
			case 6 -> {}
			case 7 -> {}
			case 8 -> {}
			}
		
		// Se ejecuta siempre que no se introduzca el 9
		}while (opciones != 9);
		
		
	}
}
