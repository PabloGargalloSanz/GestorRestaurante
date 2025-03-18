import java.util.LinkedList;
import java.util.Scanner;

public class Restaurante {

    //Atributos especiales
    Scanner sc = new Scanner(System.in);

    //Atributos Restaurantes
    LinkedList<Mesa> mesas = new LinkedList<>();
    LinkedList<Plato> platos = new LinkedList<>();
    LinkedList<Pedido> pedidos = new LinkedList<>();
    
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
        sc.next();
        
        System.out.println("Introduzca el nombre del plato: ");
        nombrePlato = sc.nextLine();
        sc.next();

        do {
            System.out.println("Introduzca el precio del plato: ");
            precioPlato = sc.nextDouble();
        } while(precioPlato <= 0);
		
        Plato plato = new Plato(codigoPlato, nombrePlato, precioPlato);
        platos.add(plato);    //Se añade en la LinkedList el objeto plato

		System.out.println("Plato creado correctamente");
    }
    
    public void registrarPedido() {

        Mesa mesaEncontrada = null;
        int numeroMesa;

        do { 
            System.out.println("Introduce el número de una mesa existente");

            numeroMesa = sc.nextInt();

            for(Mesa mesa : this.mesas) {
                if(numeroMesa == mesa.getNumero()){
                    mesaEncontrada = mesa;
                    break;                      //Si esncuentra la mesa se sale del bucle y no recorre la totalidad
                }
            }
            if (mesaEncontrada == null) {
                System.out.println("No se ha encontrado la mesa");
            }
            
        } while (mesaEncontrada == null);

        LinkedList<Plato> listaPlatosPedidos = new LinkedList<Plato>();

        boolean terminar = false;
        String codigo;
        

        while (!terminar) {
            System.out.println("Introduce el código de plato");
            System.out.println("Si se introduce un 0, parará de preguntar");

            codigo = sc.next();

            if(codigo.equals("0")){
                terminar = true;
                
            } else {
                for (Plato plato : this.platos) {
                    if (codigo.equals(plato.getCodigo())) {
                        listaPlatosPedidos.add(plato);
                        break;
                    }
                }
            }
        }

        Pedido pedido = new Pedido(mesaEncontrada, listaPlatosPedidos);
        pedidos.add(pedido);
        System.out.println("Pedido añadido correctamente");

    }

}
