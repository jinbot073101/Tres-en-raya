import java.util.*;

public class Juego {

    Tablero tablero = new Tablero();
    Jugador jugador1, jugador2;
    Reglas darReglas;

    public void iniciarJuego() {

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        int aux = 1;
        int seleccion = 0;

        do {

            System.out.println();
            System.out.println("===========================");
            System.out.println(" ¡BIENVENIDO A 3 EN RAYA! ");
            System.out.println("===========================");
            System.out.println("    1. Iniciar juego");
            System.out.println("    2. ¿Cómo jugar?");
            seleccion = scanner.nextInt();

            if (seleccion == 2) {
                aux = 2;
                darReglas = new Reglas();
                System.out.println("¿Volver al menú inicial?");
                System.out.println("    1. Si.");
                System.out.println("    2. No. (Terminar juego)");
                int selector = scanner.nextInt();
                if (selector == 1){
                    aux = 1;
                }else{
                    System.out.println("¿Desea terminar el juego?");
                    System.out.println("   1. SI      2. NO");
                    int decision = scanner.nextInt();
                    if(decision == 1){
                        System.out.println();
                        System.out.println("Juego Finalizado.");
                    }else{
                        aux = 1;
                    }
                }

            } else if (seleccion < 1 || seleccion > 2) {
                System.out.println("Opción no encontrada :(");

            } else {
                aux = 2;
                System.out.println();
                scanner.nextLine();
                System.out.println("> Ingrese el nombre del jugador 1: ");
                String nombre = scanner.nextLine();
                System.out.println();
                System.out.println("> Qué figura tendrá " + nombre + ": ");
                System.out.println("    - x");
                System.out.println("    - o");

                char simbolo = scanner.next().charAt(0);
                jugador1 = new Jugador(nombre, simbolo);
                jugador1.setSimbolo(simbolo);
                System.out.println("> Ingrese el nombre del jugador 2: ");
                scanner.nextLine();
                String nombre2 = scanner.nextLine();
                if (jugador1.getSimbolo() == 'x') {
                    jugador2 = new Jugador(nombre2, 'o');
                    jugador2.setSimbolo('o');
                } else {
                    jugador2 = new Jugador(nombre2, 'x');
                    jugador2.setSimbolo('x');
                }
                System.out.println();
                System.out.println("------------------------");
                System.out.println("¡COMIENZA LA PARTIDA!");
                System.out.println("------------------------");
                tablero.mostrarTablero();

                while (!tablero.hayGanador() && !tablero.tableroLleno()) {
                    System.out.println("___________________________");
                    System.out.println(" >> Turno de " + nombre + " <<\n");
                    System.out.println("* Ingrese la fila (0 al 2)");
                    int fila = scanner.nextInt();
                    System.out.println("* Ingrese la columna (0 al 2)");
                    int columna = scanner.nextInt();
                    tablero.marcarCasilla(fila, columna, jugador1);

                    System.out.println();
                    tablero.mostrarTablero(); 

                    if (tablero.hayGanador()) {
                        System.out.println("----------------------");
                        System.out.println("¡FIN DE LA PARTIDA!");
                        System.out.println("----------------------");
                        System.out.println("¡" + nombre + " ha ganado!");
                        break; 
                    }

                    if (tablero.tableroLleno()) {
                        System.out.println();
                        System.out.println("El tablero está lleno.");
                        break; 
                    }

                    System.out.println("_____________________________");
                    System.out.println(" >> Turno de " + nombre2 + " <<\n");
                    System.out.println("* Ingrese la fila (0 al 2)");
                    int fila2 = scanner.nextInt();
                    System.out.println("* Ingrese la columna (0 al 2)");
                    int columna2 = scanner.nextInt();
                    tablero.marcarCasilla(fila2, columna2, jugador2);

                    System.out.println();
                    tablero.mostrarTablero(); 

                    if (tablero.hayGanador()) {
                        System.out.println("----------------------");
                        System.out.println("¡FIN DE LA PARTIDA!");
                        System.out.println("----------------------");
                        System.out.println("¡" + nombre2 + " ha ganado!");
                        break; 
                    }

                    if (tablero.tableroLleno()) {
                        System.out.println();
                        System.out.println("El tablero está lleno.");
                        break; 
                    }
                }
                System.out.println();
                System.out.println("----------------------------");
                System.out.println("¡Gracias por jugar!");
                System.out.println("----------------------------");
            }

        } while (aux == 1);
    }

}
