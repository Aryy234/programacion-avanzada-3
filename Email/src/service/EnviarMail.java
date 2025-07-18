package service;

import util.Effect;
import util.Executable;
import util.Resultado;

import java.util.function.Function;
import java.util.regex.Pattern;

public class EnviarMail {
    Pattern emailPattern = Pattern.compile("^[a-z0-9._%+-]+@[a-z09.-]+\\.[a-z]{2,4}$");

    Function<String, Resultado> emailChecker =
            email ->{
        if(email == null){
            return new Resultado.Falla("Vacio, coloque un correo valido");
        } else if (email.isEmpty()){
            return new Resultado.Falla("Vacio, coloque un correo valido");
        }
        else if(emailPattern.matcher(email).matches()) {
            return new Resultado.Exito();
        }
        else {
            return new Resultado.Falla("El correo no corresponde al formato deseado");
                }
            };

/*    private void enviarCorrero(String email) {
        System.out.println(" Correo de verificación enviado a: " + email);
    }
    private void deslegarMensajeError(String txt) {
        System.out.printf("ERROR:  %s\n", txt);
    }*/
/*    public void testMail(String email) {
        Resultado resul =  emailChecker.apply(email);
        if(resul instanceof Resultado.Exito) {
            enviarCorrero(email);
        }else {
            Resultado.Falla error = (Resultado.Falla) resul;
            //deslegarMensajeError(String.format("email %s inválido", email));
            deslegarMensajeError(error.getMns());
        }
    }*/

    Effect<String> succes = mns -> System.out.println(" Correo de verificación enviado a: " + mns);
    Effect<String> failure = mns -> System.out.printf("ERROR:  %s\n", mns);

    public Executable validar(String email){
        Resultado resul = emailChecker.apply(email);
      return resul instanceof Resultado.Exito ?
              () -> succes.apply(email):
                () -> failure.apply(((Resultado.Falla) resul).getMns());
    };


}
