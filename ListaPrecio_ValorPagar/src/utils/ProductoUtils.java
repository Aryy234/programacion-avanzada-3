package utils;

import models.Producto;
import java.util.List;
import java.util.stream.Collectors;

public class ProductoUtils {
    public static List<Producto> calcularProductosConIVA(List<Producto> productos) {
        return productos.stream()
                .map(p -> new Producto(p.getId(), p.getNombre(), p.getPrecio() * 1.15))
                .collect(Collectors.toList());
    }
}
