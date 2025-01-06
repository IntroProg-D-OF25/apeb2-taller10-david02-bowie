/***Dada una matriz cuadrada (m X m) de valores enteros aleatorios, desarrollar su procesamiento
 * para presentar los elementos:
De la diagonal principal.
De la diagonal segundaria.
Ubicados bajo la diagonal principal.
Ubicados sobre la diagonal principal.
Ubicados bajo la diagonal secundaria.
Ubicados sobre la diagonal secundaria.
 * @author david
 */
import java.util.Random;
public class ejercicio_1 {
    public static void main(String[] args) {
        int m = 5; // Tamaño de la matriz
        int[][] matriz = new int[m][m]; // Crear la matriz
        Random rand = new Random(); // Para generar números aleatorios

        // Llenar la matriz con números aleatorios del 1 al 9
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matriz[i][j] = rand.nextInt(9) + 1; // Números entre 1 y 9
            }
        }

        // Mostrar la matriz
        System.out.println("Matriz:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matriz[i][j] + " "); // Imprimir cada número
            }
            System.out.println(); // Nueva línea al final de cada fila
        }

        // Diagonal principal
        System.out.println("\nDiagonal principal:");
        for (int i = 0; i < m; i++) {
            System.out.print(matriz[i][i] + " "); // Elementos de la diagonal principal
        }

        // Diagonal secundaria
        System.out.println("\nDiagonal secundaria:");
        for (int i = 0; i < m; i++) {
            System.out.print(matriz[i][m - 1 - i] + " "); // Elementos de la diagonal secundaria
        }

        // Elementos bajo la diagonal principal
        System.out.println("\nElementos bajo la diagonal principal:");
        for (int i = 1; i < m; i++) { // Empezar desde 1
            for (int j = 0; j < i; j++) {
                System.out.print(matriz[i][j] + " "); // Elementos debajo
            }
        }

        // Elementos sobre la diagonal principal
        System.out.println("\nElementos sobre la diagonal principal:");
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                System.out.print(matriz[i][j] + " "); // Elementos arriba
            }
        }

        // Elementos bajo la diagonal secundaria
        System.out.println("\nElementos bajo la diagonal secundaria:");
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < m - 1 - i; j++) {
                System.out.print(matriz[i][j] + " "); // Elementos debajo
            }
        }

        // Elementos sobre la diagonal secundaria
        System.out.println("\nElementos sobre la diagonal secundaria:");
        for (int i = 0; i < m; i++) {
            for (int j = m - 1 - i + 1; j < m; j++) {
                System.out.print(matriz[i][j] + " "); // Elementos arriba
            }
        }
    }
}
/***Matriz:
9 2 6 9 8 
1 4 1 7 1 
2 7 9 9 5 
2 7 3 4 3 
1 6 4 7 1 

Diagonal principal:
9 4 9 4 1 
Diagonal secundaria:
8 7 9 7 1 
Elementos bajo la diagonal principal:
1 2 7 2 7 3 1 6 4 7 
Elementos sobre la diagonal principal:
2 6 9 8 1 7 1 9 5 3 
Elementos bajo la diagonal secundaria:
9 2 6 9 1 4 1 2 7 2 
Elementos sobre la diagonal secundaria:
1 9 5 3 4 3 6 4 7 1
 * 
 */