package com.banco.service;

import com.banco.model.Cuenta;
import com.banco.factory.CuentaFactory;

import java.util.HashMap;
import java.util.Map;

public class BancoService {
    private Map<String, Cuenta> cuentas;

    public BancoService() {
        cuentas = new HashMap<>();
    }

    public void abrirCuenta(String tipo, String numeroCuenta) {
        Cuenta cuenta = CuentaFactory.crearCuenta(tipo, numeroCuenta);
        if (cuenta != null) {
            cuentas.put(numeroCuenta, cuenta);
            System.out.println("Cuenta " + tipo + " abierta con éxito: " + numeroCuenta);
        } else {
            System.out.println("Tipo de cuenta no válido.");
        }
    }

    public void depositar(String numeroCuenta, double monto) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null) {
            if (cuenta.depositar(monto)) {
                System.out.println("Depósito de " + monto + " realizado en la cuenta: " + numeroCuenta);
            }
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    public void retirar(String numeroCuenta, double monto) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null) {
            if (cuenta.retirar(monto)) {
                System.out.println("Retiro de " + monto + " realizado en la cuenta: " + numeroCuenta);
            } else {
                System.out.println("Fondos insuficientes en la cuenta: " + numeroCuenta);
            }
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }
}