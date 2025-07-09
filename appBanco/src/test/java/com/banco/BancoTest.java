import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.banco.factory.CuentaFactory;
import com.banco.model.Cuenta;
import com.banco.model.CuentaAhorro;
import com.banco.model.CuentaCorriente;

public class BancoTest {
    private Cuenta cuentaAhorro;
    private Cuenta cuentaCorriente;

    @BeforeEach
    public void setUp() {
        cuentaAhorro = CuentaFactory.crearCuenta("ahorro", "12345", 1000.0);
        cuentaCorriente = CuentaFactory.crearCuenta("corriente", "67890", 2000.0);
    }

    @Test
    public void testDepositarCuentaAhorro() {
        cuentaAhorro.depositar(500.0);
        assertEquals(1500.0, cuentaAhorro.getSaldo());
    }

    @Test
    public void testRetirarCuentaCorriente() {
        cuentaCorriente.retirar(1000.0);
        assertEquals(1000.0, cuentaCorriente.getSaldo());
    }

    @Test
    public void testCalcularInteresesCuentaAhorro() {
        double intereses = cuentaAhorro.calcularIntereses();
        assertTrue(intereses > 0);
    }

    @Test
    public void testVerificarSaldoCuentaCorriente() {
        double saldo = cuentaCorriente.verificarSaldo();
        assertEquals(2000.0, saldo);
    }
}