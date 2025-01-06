/***Crea un juego de tres en raya utilizando una matriz bidimensional 
 * de 3x3. Permita a dos jugadores marcar sus movimientos alternativamente. 
 * El juego debe verificar si alguno de los jugadores ha ganado o si hay un empate. 
 */
import java.util.Scanner;

public class ejercicio_6 {
    public static void main(String[] args) {
        char[][] tablero = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        Scanner tcl = new Scanner(System.in);
        char jugadorActual = 'X';
        boolean juegoTerminado = false;

        System.out.println("\n--- Bienvenido al Tres en Raya ---\n");

        while (!juegoTerminado) {
            imprimirTablero(tablero);
            System.out.println("Turno del jugador " + jugadorActual);

            int fila, columna;
            while (true) {
                System.out.print("Introduce la fila (1-3): ");
                fila = tcl.nextInt() - 1;
                System.out.print("Introduce la columna (1-3): ");
                columna = tcl.nextInt() - 1;

                if (fila >= 0 && fila < 3 && columna >= 0 && columna < 3 && tablero[fila][columna] == ' ') {
                    break;
                } else {
                    System.out.println("Movimiento inválido, intenta de nuevo.");
                }
            }

            tablero[fila][columna] = jugadorActual;

            if (verificarGanador(tablero, jugadorActual)) {
                imprimirTablero(tablero);
                System.out.println("¡El jugador " + jugadorActual + " ha ganado!");
                juegoTerminado = true;
            } else if (esEmpate(tablero)) {
                imprimirTablero(tablero);
                System.out.println("¡Es un empate!");
                juegoTerminado = true;
            } else {
                jugadorActual = (jugadorActual == 'X') ? 'O' : 'X';
            }
        }
    }

    public static void imprimirTablero(char[][] tablero) {
        System.out.println("\nTablero actual:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + tablero[i][j]);
                if (j < 2) System.out.print(" |");
            }
            System.out.println();
            if (i < 2) System.out.println("---|---|---");
        }
        System.out.println();
    }

    public static boolean verificarGanador(char[][] tablero, char jugador) {
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) {
                return true; // Fila completa
            }
            if (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador) {
                return true; // Columna completa
            }
        }

        if (tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) {
            return true; // Diagonal principal
        }

        if (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador) {
            return true; // Diagonal secundaria
        }

        return false;
    }

    public static boolean esEmpate(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
