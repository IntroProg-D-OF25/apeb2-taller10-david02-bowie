/***Crea un programa que gestione el inventario de una tienda. Utiliza una matriz bidimensional
 * para almacenar los productos disponibles en la tienda, con información como nombre,
 * precio y cantidad. El programa debe permitir agregar nuevos productos, actualizar existencias, 
 * buscar productos y eliminarlos. 
 */
import java.util.Scanner;
public class ejercicio_4 {
    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);

        // Crear una matriz para almacenar productos (nombre, precio, cantidad)
        String[][] inventario = new String[100][3]; // Máximo de 100 productos
        int numProductos = 0; // Contador de productos

        while (true) {
            System.out.println("\n--- Menú de Gestión de Inventario ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Actualizar existencias");
            System.out.println("3. Buscar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("5. Mostrar inventario ");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = tcl.nextInt();
            tcl.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    if (numProductos < inventario.length) {
                        System.out.print("Ingrese el nombre del producto: ");
                        String nombre = tcl.nextLine();
                        System.out.print("Ingrese el precio del producto: ");
                        String precio = tcl.nextLine();
                        System.out.print("Ingrese la cantidad del producto: ");
                        String cantidad = tcl.nextLine();

                        inventario[numProductos][0] = nombre;
                        inventario[numProductos][1] = precio;
                        inventario[numProductos][2] = cantidad;
                        numProductos++;

                        System.out.println("Producto agregado exitosamente.");
                    } else {
                        System.out.println("El inventario está lleno.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del producto a actualizar: ");
                    String nombreActualizar = tcl.nextLine();
                    boolean encontradoActualizar = false;

                    for (int i = 0; i < numProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(nombreActualizar)) {
                            System.out.print("Ingrese la nueva cantidad: ");
                            String nuevaCantidad = tcl.nextLine();
                            inventario[i][2] = nuevaCantidad;
                            System.out.println("Cantidad actualizada exitosamente.");
                            encontradoActualizar = true;
                            break;
                        }
                    }

                    if (!encontradoActualizar) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del producto a buscar: ");
                    String nombreBuscar = tcl.nextLine();
                    boolean encontradoBuscar = false;

                    for (int i = 0; i < numProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(nombreBuscar)) {
                            System.out.println("Producto encontrado:");
                            System.out.println("Nombre: " + inventario[i][0]);
                            System.out.println("Precio: " + inventario[i][1]);
                            System.out.println("Cantidad: " + inventario[i][2]);
                            encontradoBuscar = true;
                            break;
                        }
                    }

                    if (!encontradoBuscar) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el nombre del producto a eliminar: ");
                    String nombreEliminar = tcl.nextLine();
                    boolean encontradoEliminar = false;

                    for (int i = 0; i < numProductos; i++) {
                        if (inventario[i][0].equalsIgnoreCase(nombreEliminar)) {
                            // Mover los elementos hacia atrás para llenar el hueco
                            for (int j = i; j < numProductos - 1; j++) {
                                inventario[j][0] = inventario[j + 1][0];
                                inventario[j][1] = inventario[j + 1][1];
                                inventario[j][2] = inventario[j + 1][2];
                            }
                            numProductos--;
                            System.out.println("Producto eliminado exitosamente.");
                            encontradoEliminar = true;
                            break;
                        }
                    }

                    if (!encontradoEliminar) {
                        System.out.println("Producto no encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("\nInventario actual:");
                    for (int i = 0; i < numProductos; i++) {
                        System.out.println((i + 1) + ". Nombre: " + inventario[i][0] + ", Precio: " + inventario[i][1] + ", Cantidad: " + inventario[i][2]);
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa.");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
/***--- Men� de Gesti�n de Inventario ---
1. Agregar producto
2. Actualizar existencias
3. Buscar producto
4. Eliminar producto
5. Mostrar inventario
6. Salir
Seleccione una opci�n: 1
Ingrese el nombre del producto: fideos
Ingrese el precio del producto: 2.00
Ingrese la cantidad del producto: 5
Producto agregado exitosamente.
 * 
 */