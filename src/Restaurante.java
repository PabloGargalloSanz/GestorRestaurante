import java.util.LinkedList;
import java.util.Scanner;

public class Restaurante {

    //Atributos especiales
    Scanner sc = new Scanner(System.in);

    //Atributos Restaurantes
    LinkedList<Mesa> mesas = new LinkedList<>();
    LinkedList<Plato> platos = new LinkedList<>();
    
    //Constructor
    public Restaurante() {

    }

    public void registrarMesa() {

        int numeroMesa;
        int capacidad;

        do {
            System.out.println("Introduzca el numero de mesa: ");
		    numeroMesa = sc.nextInt();
        } while (numeroMesa < 1);

		do {
            System.out.println("Introduzca capacidad de la mesa: ");
            capacidad = sc.nextInt();
        } while(capacidad < 1);
		
        Mesa mesa = new Mesa(numeroMesa, capacidad);
        mesas.add(mesa);    //Se añade en la LinkedList el objeto mesa

		System.out.println("Mesa creada correctamente");
    }
    
    public void registrarPlato() {
        String codigoPlato;
        String nombrePlato;
        double precioPlato;

        System.out.println("Introduzca el código de plato: ");
		codigoPlato = sc.nextLine();
        sc.nextLine();
        
        System.out.println("Introduzca el nombre del plato: ");
        nombrePlato = sc.nextLine();
        sc.nextLine();

        do {
            System.out.println("Introduzca el precio del plato: ");
            precioPlato = sc.nextDouble();
        } while(precioPlato <= 0);
		
        Plato plato = new Plato(codigoPlato, nombrePlato, precioPlato);
        platos.add(plato);    //Se añade en la LinkedList el objeto plato

		System.out.println("Plato creado correctamente");
    }
    


}
