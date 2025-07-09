package models;

public class Student {
    private String id;
    private String nombre;
    private long note;

    public Student(String id, String nombre, long note) {
        this.id = id;
        this.nombre = nombre;
        this.note = note;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getNote() {
        return note;
    }

    public void setNote(long note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", note=" + note +
                '}';
    }
}
