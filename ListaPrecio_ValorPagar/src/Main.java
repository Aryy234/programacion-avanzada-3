import java.util.*;
import models.Producto;
import utils.ProductoUtils;

public class Main {
    public static void main(String[] args) {
        // Crear lista de productos
        List<Producto> productos = Arrays.asList(
                new Producto(1, "Manzana", 1000),
                new Producto(2, "Banano", 800),
                new Producto(3, "Naranja", 1200)
        );

        // Calcular productos con IVA usando la utilidad
        List<Producto> productosConIVA = ProductoUtils.calcularProductosConIVA(productos);

        // Imprimir productos con IVA
        productosConIVA.forEach(System.out::println);
    }
}