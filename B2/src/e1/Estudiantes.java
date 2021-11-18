package e1;

public class Estudiantes extends Residentes{


    public Estudiantes(String nombre, String apellido, int edad, int horrocrux, Casa casa) {
        super(nombre, apellido, edad, horrocrux, casa);

    }
    @Override
    public double getRecompensa() {
      int horr = super.getHorrocrux();
      if(this.getCasa()==Casa.Slytherin) return 2*(horr*90);
      else
          return horr*90;
    }

    @Override
    public String recToString() {
        return getNombre() + " " + getApellido() + "(Estudiante de " + getCasa() + " ,"+ getHorrocrux() + " horrocruxes):" + getRecompensa() + " galeones";
    }

}

