import java.util.Arrays;
import java.util.List;

import utilidades.LocalFunctions;
import utilidades.Result;

public class Main {
    public static void main(String[] args) {
        // Crear instancia de LocalFunctions
        LocalFunctions localFunctions = new LocalFunctions();
        
        // Crear listas para el ejemplo
        List<Boolean> conditions = Arrays.asList(false, true, false, true);
        List<String> values = Arrays.asList("Primer valor", "Segundo valor", "Tercer valor", "Cuarto valor");
        
        // Aplicar el método ifElse_ (busca el primer TRUE)
        Result<String> resultTrue = localFunctions.ifElse_(conditions, values);
        
        // Mostrar el resultado del ifElse_
        System.out.println("Resultado con ifElse_ (primer TRUE): " + resultTrue.getValue());

        System.out.println("-----------------------------------");
        
        // Aplicar el nuevo método ifElseFalse_ (busca el primer FALSE)
        Result<String> resultFalse = localFunctions.ifElseFalse_(conditions, values);
        
        // Mostrar el resultado del ifElseFalse_
        System.out.println("Resultado con ifElseFalse_ (primer FALSE): " + resultFalse.getValue());
    }
}