import java.util.LinkedList;
import java.util.Scanner;

public class Restaurante {

    //Atributos especiales
    Scanner sc = new Scanner(System.in);

    //Atributos Restaurantes
    LinkedList<Mesa> mesas = new LinkedList<>();
    LinkedList<Plato> cartaPlatos = new LinkedList<>();
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
    
    private Plato crearPlato() {
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
        return plato;
    }

    public void registrarPlatoCarta() {

        Plato plato = this.crearPlato();
        
        this.cartaPlatos.add(plato);    //Se añade en la LinkedList el objeto plato

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
                for (Plato plato : this.cartaPlatos) {
                    if (codigo.equals(plato.getCodigo())) {
                        listaPlatosPedidos.add(plato);
                        break;
                    }
                }
            }
        }
        System.out.println("Introduce codigo de pedido");

        String codigoPedido = sc.next();

        Pedido pedido = new Pedido(mesaEncontrada, listaPlatosPedidos);
        pedidos.add(pedido);
        System.out.println("Pedido añadido correctamente");

    }

    private Pedido getPedidoNumeroMesa() {
        if(!this.pedidos.isEmpty()) {       
          
            do { 
                System.out.println("Introduce el numero de mesa asociado al pedido");
                int numero = sc.nextInt();
    
                for (Pedido pedido : this.pedidos) {
                    if (numero == pedido.getNumeroMesa()) {
                        return pedido;
                    } 
                }
                System.out.println("Introduce un número valido");
            } while (true);
        }
        return null;
    }

    private Plato platoByCodigo() {
        String codigo;
        if(!this.cartaPlatos.isEmpty()) {
            do { 
                System.out.println("Introduce un código de un plato de la carta: ");
                codigo = sc.nextLine(); 
                sc.next();

                for (Plato plato : this.cartaPlatos) {
                    if (plato.getCodigo().equals(codigo)) {
                        return plato;
                    }
                }
                System.out.println("No se ha encontrado el plato");
            } while (true); //Se ejecut hasta que encuentre un plato con ese código, ya que si se consigue se ejecuta el return y sale del bucle
        }
        return null;
    }
    private Mesa mesaByNumber() {
        int numero;
        if(!this.mesas.isEmpty()) {
            do { 
                System.out.println("Introduce un código de mesa: ");
                numero = sc.nextInt(); 
          
                for (Mesa mesa : this.mesas) {
                    if (mesa.getNumero() == numero) {
                        return mesa;
                    }
                }
                System.out.println("No se ha encontrado la mesa");
            } while (true); //Se ejecut hasta que encuentre un plato con ese código, ya que si se consigue se ejecuta el return y sale del bucle
        }
        return null;
    }
    public void menuModificarPedido() {
        Pedido pedido = this.getPedidoNumeroMesa();
        int opciones;

        do {
			System.out.println("Elige opción");
            System.out.println("Opción 1: Cambiar estado del pedido");
			System.out.println("Opción 2: Añadir plato");
			System.out.println("Opción 3: Eliminar plato");
			System.out.println("Opción 4: Modificar mesa");
			System.out.println("Opción 5: Añadir descuento");
			System.out.println("Opción 6: Borrar pedido");
			System.out.println("Opción 7: Salir");
			
			opciones = sc.nextInt();
			
		}while (opciones != 7);

        switch(opciones) {
            case 1 -> { pedido.cambiarCompletado(); }
            case 2 -> { 
      
                System.out.println("1. Nuevo Plato");
                System.out.println("2. Añadir Plato desde Carta");
                int subopcion = sc.nextInt();

                switch(subopcion) {
                    case 1 -> { pedido.addPlato(this.crearPlato());}
                    case 2 -> { pedido.addPlato(this.platoByCodigo());}
                }
            }
            case 3 -> { 
                String codigo;
                boolean control;
                do { 
                    System.out.println("Introduce un código de un plato: ");
                    codigo = sc.nextLine();
                    sc.next();
                    control = pedido.removePlato(codigo);

                    if ( control) {
                        System.out.println("Se ha borrado el plato");
                    } else {
                        System.out.println("El plato no se ha borrado");
                    }

                } while (!control);
            }
            case 4 -> { pedido.setMesa(this.mesaByNumber()); }
            case 5 -> {}
            case 6 -> {}
                                
            default -> System.out.println("Valor incorrecto, pruebe de nuevo"); 

        }
    }

    
    
}
