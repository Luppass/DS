package e1;

public class Fantasmas extends Residentes {

    public Fantasmas(String nombre, String apellido, int edad, int horrocrux, Casa casa) {
        super(nombre, apellido, edad, horrocrux, casa);
    }
        @Override
        public double getRecompensa() {
        int horr = super.getHorrocrux();
            if(this.getCasa() == Casa.Slytherin)
            return 2*(horr*80);
                else
                    return horr*80;
        }

    @Override
    public String recToString() {
        return getNombre() + " " + getApellido() + "(Fantasma de " + getCasa() + " ,"+ getHorrocrux() + " horrocruxes):" + getRecompensa() + " galeones";
    }
}

