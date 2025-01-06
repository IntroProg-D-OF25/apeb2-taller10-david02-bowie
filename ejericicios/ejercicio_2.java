/***Dadas dos matrices (cuadradas y/o rectangulares) de valores enteros aleatorios, desarrollar 
 * su procesamiento para calcular y presentar:
La suma de las dos matrices (considerar las restricciones matemáticas para ello).
La multiplicación de las dos matrices (considerar las reglas matemáticas para ello).
 * @author david
 */
import java.util.*;

public class ejercicio_2 {

    public static void main(String[] args) {
        Random random = new Random();

        // Generar dimensiones y matrices aleatorias
        int filas1 = 4, columnas1 = 4;
        int filas2 = 4, columnas2 = 4;

        int[][] matriz1 = new int[filas1][columnas1];
        int[][] matriz2 = new int[filas2][columnas2];

        for (int i = 0; i < filas1; i++) {
            for (int j = 0; j < columnas1; j++) {
                matriz1[i][j] = random.nextInt(10); 
            }
        }

        for (int i = 0; i < filas2; i++) {
            for (int j = 0; j < columnas2; j++) {
                matriz2[i][j] = random.nextInt(10); 
            }
        }

        System.out.println("Matriz 1:");
        for (int[] fila : matriz1) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }

        System.out.println("\nMatriz 2:");
        for (int[] fila : matriz2) {
            for (int elemento : fila) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }

        // Intentar sumar matrices
        if (filas1 == filas2 && columnas1 == columnas2) {
            System.out.println("\nSuma de matrices:");
            int[][] suma = new int[filas1][columnas1];
            for (int i = 0; i < filas1; i++) {
                for (int j = 0; j < columnas1; j++) {
                    suma[i][j] = matriz1[i][j] + matriz2[i][j];
                }
            }
            for (int[] fila : suma) {
                for (int elemento : fila) {
                    System.out.print(elemento + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("\nNo se pueden sumar las matrices porque tienen dimensiones diferentes.");
        }

        // Intentar multiplicar matrices
        if (columnas1 == filas2) {
            System.out.println("\nProducto de matrices:");
            int[][] producto = new int[filas1][columnas2];
            for (int i = 0; i < filas1; i++) {
                for (int j = 0; j < columnas2; j++) {
                    for (int k = 0; k < columnas1; k++) {
                        producto[i][j] += matriz1[i][k] * matriz2[k][j];
                    }
                }
            }
            for (int[] fila : producto) {
                for (int elemento : fila) {
                    System.out.print(elemento + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("\nNo se pueden multiplicar las matrices porque sus dimensiones no son compatibles.");
        }
    }
}
/***Matriz 1:
2 0 8 8 
3 9 0 7 
5 8 7 8 
5 7 5 3 

Matriz 2:
8 3 5 9 
9 7 3 7 
3 1 0 6 
1 6 6 5 

Suma de matrices:
10 3 13 17 
12 16 3 14 
8 9 7 14 
6 13 11 8 

Producto de matrices:
48 62 58 106 
112 114 84 125 
141 126 97 183 
121 87 64 139 
 * 
 */