/***El primer ciclo paralelo C, cuenta con 28 estudiantes, de los cuáles al finalizar el 
 * periodo, la Dirección de la carrera de Computación a solicitado las siguientes estadísticas 
 * de la materia INTRODUCCIÓN A LA PROGRAMACIÓN en función a los promedios por estudiante, 
 * dichos promedios se deben calcular (ponderar, ya que el docente ingresa todo sobre 10pts.) 
 * de 3 calificaciones (ACD que representa el 35% de la nota, APE del 35% y la nota del AA con un 
 * peso del 30%). En resumen, los requerimientos son los siguientes:
Registre los nombres de cada estudiante de dicho paralelo.
Genere aleatoriamente las notas ACD, APE, AA, para cada uno de los 28 estudiantes de 0-10 pts.
Calcule el promedio de cada uno de los estudiantes del paralelo dada la siguiente ponderación:
* ACD->35%, APE->35%, y el AA->30%.
Obtenga el promedio del curso, del paralelo C.
Liste los nombres de los estudiantes y su nota, que hayan obtenido un promedio por encima del promedio del curso.
Liste los nombres de los estudiantes y su nota, que hayan obtenido un promedio por debajo del promedio del curso.
Muestre el estudiante con su calificación, si es el del mayor promedio (el más alto de la clase).
Muestre el estudiante con su calificación, si es el del menor promedio (el más bajo de la clase).
Ejercicio 4
 *  @author david
 */
import java.util.*;
public class ejercicio_3 {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        Random random = new Random();

        // Número de estudiantes
        int numEstudiantes = 28;

        // Arrays para almacenar nombres, notas y promedios
        String[] nombres = new String[numEstudiantes];
        double[] acd = new double[numEstudiantes];
        double[] ape = new double[numEstudiantes];
        double[] aa = new double[numEstudiantes];
        double[] promedio = new double[numEstudiantes];

        // Registrar los nombres de los estudiantes
        for (int i = 0; i < numEstudiantes; i++) {
            System.out.print("Ingrese el nombre del estudiante " + (i + 1) + ": ");
            nombres[i] = tcl.nextLine();
        }

        // Generar las notas aleatorias y calcular los promedios
        double sumaPromedios = 0;
        for (int i = 0; i < numEstudiantes; i++) {
            acd[i] = random.nextDouble() * 10; 
            ape[i] = random.nextDouble() * 10;
            aa[i] = random.nextDouble() * 10;
            promedio[i] = acd[i] * 0.35 + ape[i] * 0.35 + aa[i] * 0.30;
            sumaPromedios += promedio[i];
        }

        // Calcular el promedio del curso
        double promedioCurso = sumaPromedios / numEstudiantes;
        System.out.printf("\nPromedio del curso: %.2f\n", promedioCurso);

        // Estudiantes por encima del promedio del curso
        System.out.println("\nEstudiantes con promedio por encima del promedio del curso:");
        for (int i = 0; i < numEstudiantes; i++) {
            if (promedio[i] > promedioCurso) {
                System.out.printf("%s: %.2f\n", nombres[i], promedio[i]);
            }
        }

        // Estudiantes por debajo del promedio del curso
        System.out.println("\nEstudiantes con promedio por debajo del promedio del curso:");
        for (int i = 0; i < numEstudiantes; i++) {
            if (promedio[i] < promedioCurso) {
                System.out.printf("%s: %.2f\n", nombres[i], promedio[i]);
            }
        }

        // Buscar el estudiante con el mayor y menor promedio
        double maxPromedio = promedio[0];
        double minPromedio = promedio[0];
        String estudianteMax = nombres[0];
        String estudianteMin = nombres[0];

        for (int i = 1; i < numEstudiantes; i++) {
            if (promedio[i] > maxPromedio) {
                maxPromedio = promedio[i];
                estudianteMax = nombres[i];
            }
            if (promedio[i] < minPromedio) {
                minPromedio = promedio[i];
                estudianteMin = nombres[i];
            }
        }

        // Mostrar el estudiante con mayor promedio
        System.out.printf("\nEstudiante con el mayor promedio: %s (%.2f)\n", estudianteMax, maxPromedio);

        // Mostrar el estudiante con menor promedio
        System.out.printf("Estudiante con el menor promedio: %s (%.2f)\n", estudianteMin, minPromedio);
    }
}
/***Ingrese el nombre del estudiante 1: david
Ingrese el nombre del estudiante 2: juan
Ingrese el nombre del estudiante 3: daniela
Ingrese el nombre del estudiante 4: valentina
Ingrese el nombre del estudiante 5: cosme
Ingrese el nombre del estudiante 6: alejandra
Ingrese el nombre del estudiante 7: sofia
Ingrese el nombre del estudiante 8: jesus
Ingrese el nombre del estudiante 9: dante
Ingrese el nombre del estudiante 10: maria emilia
Ingrese el nombre del estudiante 11: robert
Ingrese el nombre del estudiante 12: dylan
Ingrese el nombre del estudiante 13: julio
Ingrese el nombre del estudiante 14: marco antonio
Ingrese el nombre del estudiante 15: agusto
Ingrese el nombre del estudiante 16: sara
Ingrese el nombre del estudiante 17: diana
Ingrese el nombre del estudiante 18: julian
Ingrese el nombre del estudiante 19: nataly
Ingrese el nombre del estudiante 20: domenica
Ingrese el nombre del estudiante 21: kevin
Ingrese el nombre del estudiante 22: paula
Ingrese el nombre del estudiante 23: polina
Ingrese el nombre del estudiante 24: alicia
Ingrese el nombre del estudiante 25: sebastian
Ingrese el nombre del estudiante 26: paulo
Ingrese el nombre del estudiante 27: cristian
Ingrese el nombre del estudiante 28: paola

Promedio del curso: 5.18

Estudiantes con promedio por encima del promedio del curso:
valentina: 6.97
alejandra: 6.78
sofia: 5.70
jesus: 6.50
maria emilia: 6.78
robert: 8.19
agusto: 5.72
diana: 6.88
julian: 5.53
kevin: 5.67
polina: 5.64
paulo: 5.92
paola: 7.88

Estudiantes con promedio por debajo del promedio del curso:
david: 3.98
juan: 4.57
daniela: 4.79
cosme: 5.15
dante: 4.60
dylan: 3.79
julio: 4.71
marco antonio: 3.78
sara: 4.45
nataly: 3.39
domenica: 4.60
paula: 3.96
alicia: 2.50
sebastian: 4.28
cristian: 2.23

Estudiante con el mayor promedio: robert (8.19)
Estudiante con el menor promedio: cristian (2.23)
 * 
 */