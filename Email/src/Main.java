import service.EnviarMail;
import util.Executable;

public class Main {
    public static void main(String[] args) {
        EnviarMail e = new EnviarMail();
        Executable exec = e.validar("prueba@gmail.com@");
        exec.exec();
    }
}