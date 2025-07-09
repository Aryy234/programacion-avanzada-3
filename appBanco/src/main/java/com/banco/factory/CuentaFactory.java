import com.banco.model.CuentaAhorro;
import com.banco.model.CuentaCorriente;

public class CuentaFactory {
    public static Cuenta crearCuenta(String tipoCuenta, String numeroCuenta, double saldoInicial, double extra) {
        switch (tipoCuenta.toLowerCase()) {
            case "ahorro":
                return new CuentaAhorro(numeroCuenta, saldoInicial, extra); // extra = tasaInteres
            case "corriente":
                return new CuentaCorriente(numeroCuenta, saldoInicial, extra); // extra = limiteDescubierto
            default:
                throw new IllegalArgumentException("Tipo de cuenta no válido: " + tipoCuenta);
        }
    }
}