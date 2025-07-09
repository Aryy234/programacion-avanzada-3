# Mini Sistema de Banco en Java

Este proyecto implementa un mini sistema de banco utilizando programación funcional en Java. El sistema permite la creación y gestión de cuentas de tipo ahorro y corriente, y está diseñado siguiendo buenas prácticas de programación, incluyendo el uso del patrón Factory.

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

```
appBanco
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── banco
│   │               ├── Main.java
│   │               ├── factory
│   │               │   └── CuentaFactory.java
│   │               ├── model
│   │               │   ├── Cuenta.java
│   │               │   ├── CuentaAhorro.java
│   │               │   └── CuentaCorriente.java
│   │               ├── service
│   │               │   └── BancoService.java
│   │               └── util
│   │                   └── FuncionesBancarias.java
│   └── test
│       └── java
│           └── com
│               └── banco
│                   └── BancoTest.java
├── pom.xml
└── README.md
```

## Funcionalidades

- **Cuentas de Ahorro**: Permite realizar depósitos, retiros y calcular intereses.
- **Cuentas Corrientes**: Permite realizar depósitos, retiros y verificar el saldo disponible.
- **BancoService**: Contiene la lógica de negocio para abrir cuentas y realizar operaciones bancarias.
- **Funciones Utilitarias**: Incluye funciones para validaciones y cálculos financieros.

## Instrucciones para Compilar y Ejecutar

1. Asegúrate de tener instalado Java y Maven en tu sistema.
2. Clona el repositorio o descarga el código fuente.
3. Navega a la carpeta del proyecto en la terminal.
4. Ejecuta el siguiente comando para compilar el proyecto:
   ```
   mvn clean install
   ```
5. Para ejecutar la aplicación, utiliza el siguiente comando:
   ```
   mvn exec:java -Dexec.mainClass="com.banco.Main"
   ```

## Pruebas

Las pruebas unitarias están implementadas en `BancoTest.java` y se pueden ejecutar utilizando Maven con el siguiente comando:
```
mvn test
```

## Contribuciones

Las contribuciones son bienvenidas. Si deseas mejorar el proyecto, por favor abre un issue o envía un pull request.