package e1;

public class Guardabosques extends Personal {
    boolean nocturnidad;
    public Guardabosques(String nombre, String apellido, int edad, int horrocrux, boolean nocturnidad) {
        super(nombre, apellido, edad, horrocrux);
        this.nocturnidad=nocturnidad;
    }

    @Override
    public double getRecompensa() {
        int horr = super.getHorrocrux();
        return horr*75;
    }

    @Override
    public int getSalario() {
        if(nocturnidad) return 180;
        else return 170;
    }

    @Override
    public String recToString() {
        return getNombre() + " " + getApellido() + " (Guardabosques): " + getHorrocrux() + " horrocruxes):" + getRecompensa() + " galeones";
    }

    @Override
    public String salToString(){
        return getNombre() + " " + getApellido() + " (Guardabosques): " + getSalario() + " galeones";
    }

}
