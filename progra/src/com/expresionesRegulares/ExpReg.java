package com.expresionesRegulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpReg {

    public static void main(String[] args) {
        // Una expresion regular permiten buscar patrones en cadenas de texto, como validar formatos de email, números de teléfono, etc.
        Pattern correoPat = Pattern.compile("uce");
        Matcher match = correoPat.matcher("unouce");
        if (match.find()) {
            System.out.println("Se encontró una coincidencia");
        } else {
            System.out.println("No se encontró ninguna coincidencia");
        }

        // Ejemplo de una expresión regular para validar un correo electrónico
        String email = "ejemplo@dominio.com";
        Pattern emailPat = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
        // Explicación de la expresión regular:
        // ^: Indica el inicio de la cadena.
        // \\: Escapa el carácter especial para que sea interpretado literalmente.
        // ^[\\w-\\.]+: Comienza con uno o más caracteres alfanuméricos, guiones bajos, guiones o puntos. (combinacion)
        // @: Debe contener un símbolo de arroba.
        // ([\\w-]+\\.): Debe contener uno o más caracteres alfanuméricos o guiones seguidos de un punto.
        // [\\w-]{2,4}$: Debe terminar con dos a cuatro caracteres alfanuméricos o guiones.
        // $: Indica el final de la cadena.
        // {vI, Vf} es un minimo y maximo de numero de caracteres
        // Nota: Esta expresión regular es una simplificación y puede no cubrir todos los casos válidos de correos electrónicos.
        // Sin embargo, es un buen punto de partida para validar correos electrónicos comunes.
        Matcher emailMatch = emailPat.matcher(email);
        if (emailMatch.find()) {
            System.out.println("El correo electrónico es válido");
        } else {
            System.out.println("El correo electrónico no es válido");
        }

        // Actividad en clases realizar 3 expresiones regulares diferentes para validar:

        // Ejemplo de una expresión regular para validar un número de teléfono que sea ecuatoriano e inicie con +593
        String telefono = "+593123456789";
        Pattern telefonoPat = Pattern.compile("^\\+593[0-9]{9}$");
        // Explicación de la expresión regular:
        // ^\\+593: Comienza con el prefijo +593, que es el código de país de Ecuador.
        // [0-9]{9}$: Debe contener exactamente 9 dígitos numéricos después del prefijo.
        // $: Indica el final de la cadena.
        Matcher telefonoMatch = telefonoPat.matcher(telefono);
        if (telefonoMatch.find()) {
            System.out.println("El número de teléfono es válido");
        } else {
            System.out.println("El número de teléfono no es válido");
        }

        //Validacion de una contrasenia que empieza con cualquier caracter, su tamanio sea de 7 tenga mayusculas, minusculas, caracteres especiales y minimo 2 numeros
        String contrasenia = "Abc123!";
        Pattern contraseniaPat = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d.*\\d)(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{7,}$");
        // Explicación de la expresión regular:
        // ^: Indica el inicio de la cadena.
        // (?=.*[a-z]): Debe contener al menos una letra minúscula.
        // (?=.*[A-Z]): Debe contener al menos una letra mayúscula.
        // (?=.*\\d.*\\d): Debe contener al menos dos dígitos numéricos.
        // (?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]): Debe contener al menos un carácter especial.
        // .{7,}: Debe tener una longitud mínima de 7 caracteres.
        // $: Indica el final de la cadena.
        // Nota: Esta expresión regular es un ejemplo y puede ajustarse según los requisitos específicos de seguridad.
        Matcher contraseniaMatch = contraseniaPat.matcher(contrasenia);
        if (contraseniaMatch.find()) {
            System.out.println("La contraseña es válida");
        } else {
            System.out.println("La contraseña no es válida");
        }

        //Validacion de correos solo con dominio .uce.edu.ec
        String emailUce = "ejemplo@uce.edu.ec";
        Pattern emailUcePat = Pattern.compile("^[\\w-\\.]+@uce\\.edu\\.ec$");
        // Explicación de la expresión regular:
        // ^[\\w-\\.]+: Comienza con uno o más caracteres alfanuméricos, guiones bajos, guiones o puntos.
        // @uce\\.edu\\.ec: Debe contener el dominio específico uce.edu.ec
        // $: Indica el final de la cadena.


        Matcher emailUceMatch = emailUcePat.matcher(emailUce);
        if (emailUceMatch.find()) {
            System.out.println("El correo electrónico es válido");
        } else {
            System.out.println("El correo electrónico no es válido");
        }

        // Validación de una URL que comience con http:// o https:// y tenga un dominio válido
        String url = "https://www.ejemplo.com";
        Pattern urlPat = Pattern.compile("^(https?://)?([\\w-]+\\.)+[\\w-]+(/[\\w- ./?%&=]*)?$");
        // Explicación de la expresión regular:
        // ^(https?://)?: Puede comenzar con http:// o https:// (el ? indica que la s es opcional).
        // ([\\w-]+\\.)+: Debe contener uno o más caracteres alfanuméricos o guiones seguidos de un punto.
        // [\\w-]+: Debe contener un dominio válido.
        // (/[\\w- ./?%&=]*)?: Puede contener una ruta opcional que incluya caracteres alfanuméricos, guiones, espacios, puntos, barras diagonales, signos de interrogación, porcentajes y signos de igual.
        // $: Indica el final de la cadena.

        
        Matcher urlMatch = urlPat.matcher(url);
        if (urlMatch.find()) {
            System.out.println("La URL es válida");
        } else {
            System.out.println("La URL no es válida");
        }

    }
    
}
