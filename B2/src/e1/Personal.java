package e1;

public abstract class Personal extends Integrantes {

    public Personal(String nombre, String apellido, int edad, int horrocrux) {
        super(nombre, apellido, edad, horrocrux);
    }

    public abstract String recToString();
    public abstract String salToString();
    public abstract double getRecompensa();
    public abstract int getSalario();
}