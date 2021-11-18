package e1;

public class Conserje extends Personal {
    boolean nocturnidad;

    public Conserje(String nombre, String apellido, int edad, int horrocrux, boolean nocturnidad) {
        super(nombre, apellido, edad, horrocrux);
        this.nocturnidad = nocturnidad;
    }

    @Override
    public double getRecompensa() {
        int horr = super.getHorrocrux();
        return horr * 65;
    }

    @Override
    public int getSalario() {
        if (nocturnidad) return 160;
        else return 150;
    }

    @Override
    public String recToString() {
        return getNombre() + " " + getApellido() + " (Conserje): " + getHorrocrux() + " horrocruxes):" + getRecompensa() + " galeones";
    }

    @Override
    public String salToString(){
        return getNombre() + " " + getApellido() + " (Conserje): " + getSalario() + " galeones";
    }
}
