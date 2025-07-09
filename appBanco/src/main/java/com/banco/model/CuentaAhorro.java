import java.util.function.Function;
import java.util.function.DoubleFunction;

public class CuentaAhorro extends Cuenta {
    private double tasaInteres;
    public Function<Double, Boolean> depositarFn;
    public Function<Double, Boolean> retirarFn;
    public DoubleFunction<Double> calcularInteresesFn;

    public CuentaAhorro(String numeroCuenta, double saldoInicial, double tasaInteres) {
        super(numeroCuenta, saldoInicial);
        this.tasaInteres = tasaInteres;
        this.depositarFn = (monto) -> {
            if (monto > 0) {
                saldo += monto;
                System.out.println("Depósito realizado: " + monto);
                return true;
            } else {
                System.out.println("El monto a depositar debe ser mayor que cero.");
                return false;
            }
        };
        this.retirarFn = (monto) -> {
            if (monto > 0 && saldo >= monto) {
                saldo -= monto;
                System.out.println("Retiro realizado: " + monto);
                return true;
            } else {
                System.out.println("Fondos insuficientes o monto inválido.");
                return false;
            }
        };
        this.calcularInteresesFn = (s) -> s * this.tasaInteres;
    }
    // Métodos para compatibilidad con la interfaz abstracta
    @Override
    public boolean depositar(double monto) {
        return depositarFn.apply(monto);
    }
    @Override
    public boolean retirar(double monto) {
        return retirarFn.apply(monto);
    }
    public double calcularIntereses() {
        return calcularInteresesFn.apply(saldo);
    }
}