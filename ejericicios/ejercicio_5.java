/***Crea un programa que gestione el inventario de una tienda, así como la emisión de facturas.
 * Utiliza una matriz bidimensional para almacenar los productos disponibles en la tienda, 
 * con información como nombre, precio y cantidad. El programa debe permitir facturar un
 * producto dado su código, y unidades deseadas. Adicional se debe agregar a la factura 
 * al 15% del IVA, y si la compra superar los $100, se debe aplicar un descuento.
Nota: Considere la alternativa de inexistencias en Stop, para el caso, muestre la alerta respectiva.
 * 
 */
import java.util.Scanner;

public class ejercicio_5 {
    public static void main(String[] args) {
        // Datos de los productos en la tienda
        String[][] productos = {
            {"001", "Manzanas", "50"}, // Código, Nombre, Cantidad
            {"002", "Peras", "30"},
            {"003", "Plátanos", "20"}
        };
        double[] precios = {1.5, 2.0, 1.0}; // Precios de los productos

        // Variables para facturación
        Scanner tcl = new Scanner(System.in);
        String codigoProducto;
        int cantidadDeseada;
        double subtotal = 0.0, total = 0.0, descuento = 0.0, iva = 0.0;

        System.out.println("=== Bienvenido a la tienda ===");
        System.out.print("Ingrese el código del producto: ");
        codigoProducto = tcl.nextLine();

        boolean encontrado = false;

        for (int i = 0; i < productos.length; i++) {
            if (productos[i][0].equals(codigoProducto)) {
                encontrado = true;
                System.out.println("Producto: " + productos[i][1]);
                System.out.println("Cantidad disponible: " + productos[i][2]);

                System.out.print("Ingrese la cantidad deseada: ");
                cantidadDeseada = tcl.nextInt();

                int cantidadDisponible = Integer.parseInt(productos[i][2]);
                if (cantidadDeseada <= cantidadDisponible) {
                    subtotal = cantidadDeseada * precios[i];
                    iva = subtotal * 0.15;
                    total = subtotal + iva;

                    if (total > 100) {
                        descuento = total * 0.10;
                        total -= descuento;
                    }

                    productos[i][2] = String.valueOf(cantidadDisponible - cantidadDeseada);

                    // Mostrar factura
                    System.out.println("\n=== Factura ===");
                    System.out.println("Producto: " + productos[i][1]);
                    System.out.println("Cantidad: " + cantidadDeseada);
                    System.out.printf("Precio unitario: $%.2f%n", precios[i]);
                    System.out.printf("Subtotal: $%.2f%n", subtotal);
                    System.out.printf("IVA (15%%): $%.2f%n", iva);
                    if (descuento > 0) {
                        System.out.printf("Descuento (10%%): -$%.2f%n", descuento);
                    }
                    System.out.printf("Total a pagar: $%.2f%n", total);
                    System.out.println("=====================");
                } else {
                    System.out.println("No hay suficiente stock para la cantidad deseada.");
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }
}
