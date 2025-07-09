import java.util.function.Function;
import java.util.function.DoubleFunction;

public class CuentaCorriente extends Cuenta {
    private double limiteDescubierto;
    public Function<Double, Boolean> depositarFn;
    public Function<Double, Boolean> retirarFn;
    public DoubleFunction<Double> verificarSaldoFn;

    public CuentaCorriente(String numeroCuenta, double saldoInicial, double limiteDescubierto) {
        super(numeroCuenta, saldoInicial);
        this.limiteDescubierto = limiteDescubierto;
        this.depositarFn = (monto) -> {
            saldo += monto;
            return true;
        };
        this.retirarFn = (monto) -> {
            if (monto <= saldo + limiteDescubierto) {
                saldo -= monto;
                return true;
            } else {
                System.out.println("Fondos insuficientes.");
                return false;
            }
        };
        this.verificarSaldoFn = (s) -> saldo + limiteDescubierto;
    }

    @Override
    public boolean depositar(double monto) {
        return depositarFn.apply(monto);
    }
    @Override
    public boolean retirar(double monto) {
        return retirarFn.apply(monto);
    }

    public double verificarSaldo() {
        return verificarSaldoFn.apply(saldo);
    }
}