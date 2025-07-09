import com.banco.service.BancoService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema bancario.");
        BancoService bancoService = new BancoService();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Abrir cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Salir");
            System.out.print("Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            switch (opcion) {
                case 1:
                    System.out.print("Tipo de cuenta (ahorro/corriente): ");
                    String tipo = scanner.nextLine();
                    System.out.print("Número de cuenta: ");
                    String numeroCuenta = scanner.nextLine();
                    bancoService.abrirCuenta(tipo, numeroCuenta);
                    break;
                case 2:
                    System.out.print("Número de cuenta: ");
                    String numDep = scanner.nextLine();
                    System.out.print("Monto a depositar: ");
                    double montoDep = scanner.nextDouble();
                    bancoService.depositar(numDep, montoDep);
                    break;
                case 3:
                    System.out.print("Número de cuenta: ");
                    String numRet = scanner.nextLine();
                    System.out.print("Monto a retirar: ");
                    double montoRet = scanner.nextDouble();
                    bancoService.retirar(numRet, montoRet);
                    break;
                case 4:
                    salir = true;
                    System.out.println("Gracias por usar el sistema bancario.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
        scanner.close();
    }
}