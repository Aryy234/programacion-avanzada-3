package com.banco.util;

public class FuncionesBancarias {

    public static boolean validarNumeroCuenta(String numeroCuenta) {
        return numeroCuenta != null && numeroCuenta.matches("\\d{10}");
    }

    public static double calcularInteres(double saldo, double tasaInteres, int meses) {
        return saldo * (tasaInteres / 100) * meses;
    }

    public static void imprimirEstadoCuenta(String numeroCuenta, double saldo) {
        System.out.println("Estado de la cuenta: " + numeroCuenta);
        System.out.println("Saldo disponible: " + saldo);
    }
}