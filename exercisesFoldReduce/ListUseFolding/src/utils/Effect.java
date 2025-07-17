package utils;

public interface Effect<T> {
    void apply(T t);
}

/*
class EjecutableOk implements Ejecutable{

	@Override
	public void exec(String txt) {
		System.out.println("Correo de verificación enviado a: " + txt);
	}
}
class EjecutableFalla implements Ejecutable{

	@Override
	public void exec(String txt) {
		System.out.println("Error: " + txt);
	}
}*/
