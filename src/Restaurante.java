import java.util.LinkedList;
import java.util.Scanner;

public class Restaurante {

    //Atributos especiales
    Scanner sc = new Scanner(System.in);

    //Atributos Restaurantes
    LinkedList<Mesa> mesas = new LinkedList<>();
    
    //Constructor
    public Restaurante() {

    }

    public void registrarMesa() {

        int numeroMesa;
        int capacidad;

        do {
            System.out.println("Introduzca el numero de mesa");
		    numeroMesa = sc.nextInt();
        } while (numeroMesa < 1);

		do {
            System.out.println("Introduzca capacidad de la mesa");
            capacidad = sc.nextInt();
        } while(capacidad < 1);
		
        Mesa mesa = new Mesa(numeroMesa, capacidad);
        mesas.add(mesa);    //Se añade en la LinkedList el objeto mesa

		System.out.println("Mesa creada correctamente");
    }
    
}
