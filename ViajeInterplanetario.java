import java.util.Scanner;

public class ViajeInterplanetario {
    // Atributo privado para lectura de entrada
    private Scanner input;

    //Constructor (inicializa el input --> Entrda de datos)
    public ViajeInterplanetario() {
        this.input = new Scanner(System.in);
    }

    //Metodo principal para el menu
    public void menuSistema() {
        final String SEPARADOR = "=".repeat(50);

        String menu = """
                
                %s
                ¡BIENVENIDO AL SIMULADOR DE VIAJE INTERPLANETARIO!
                Prepárate para una aventura única en el sistema solar
                %s
                
                           \uD83D\uDE80 GALACTIC CODE \uD83D\uDE80
                %s
                
                              MENÚ OPCIONES:
                %s
                \uD83E\uDE90 1. Seleccionar planeta destino
                \uD83D\uDE80 2. Elegir nave espacial
                \uD83C\uDF0C 3. Iniciar simulación de viaje
                \u274C 4. Salir del programa
                %s
                """.formatted(SEPARADOR, SEPARADOR, SEPARADOR, SEPARADOR, SEPARADOR);

        System.out.println(menu);
        System.out.print("\nIngrese su elección: ");
    }

    // Metodo para iniciar el programa
    public void start() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        int option;

        do {
            menuSistema();
            option = obtenerOpcion(input);

            switch (option) {
 //               case 1 -> seleccionarPlaneta(input);
//                case 2 -> seleccionarNave(input);
//                case 3 -> iniciarSimulacion();
                case 4 -> System.out.println("\n🛸 Finalizando el programa... ¡Hasta la próxima aventura! 🌠");
                default -> System.out.println("\n\u26A0\uFE0F Opción inválida. Intente nuevamente.");
            }
        } while (option != 4);

    }
//Metodo para validar  la opcion que escoge el usuario
    private int obtenerOpcion(Scanner input) {
        while (!input.hasNextInt()) {
            System.out.println("\u26A0\uFE0F  Acción no permitida seleccione un número entre 1 y 4.");
            System.out.print("Seleccione una opción: ");
            input.next();
        }
        int option = input.nextInt();
        input.nextLine();
        return option;
    }


    // Metodo para cerrar el scanner
    public void cerrarScanner() {
        if (input != null) {
            input.close();
        }
    }


}
