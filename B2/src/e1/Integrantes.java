package e1;

public abstract class Integrantes {
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final int horrocrux;

    public Integrantes(String nombre, String apellido, int edad, int horrocrux) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.horrocrux = horrocrux;
    }

    public abstract String recToString();

    public abstract double getRecompensa();

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getHorrocrux() {return horrocrux;}

    public int getEdad() {
        return edad;
    }

}
