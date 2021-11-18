package e1;

public abstract class Residentes extends Integrantes {

    public Residentes(String nombre, String apellido, int edad, int horrocrux, Casa casa) {
        super(nombre, apellido, edad, horrocrux);
        this.casa = casa;
    }

    public abstract double getRecompensa();

    @Override
    public abstract String recToString();

    public enum Casa {Gryffindor, Slytherin, Hufflepuff, Ravenclaw}

    Casa casa;

    public Casa getCasa() {
        return casa;
    }
}
