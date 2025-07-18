package util;

public interface Resultado {
    public class Exito implements Resultado{

    }

    public class Falla implements Resultado{
        private String mns;
        public Falla(String mns){
            this.mns = mns;
        }

        public String getMns() {
            return mns;
        }
    }
}
