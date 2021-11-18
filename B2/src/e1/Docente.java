package e1;

public class Docente extends Personal{
    public enum Asignatura{Historia, Transformaciones, Defensa, Herbologia, Pociones}
    Asignatura asignatura;

    public Docente(String nombre, String apellido, int edad, int horrocrux, Asignatura asignatura) {
        super(nombre, apellido, edad, horrocrux);
        this.asignatura=asignatura;
    }

public Asignatura getAsignatura(){
        return asignatura;
}

    @Override
    public double getRecompensa() {
        int horr= super.getHorrocrux();
        if(asignatura==Asignatura.Defensa)
            return (horr*50) * 0.75;
        else
            return horr*50;
    }

    @Override
    public int getSalario()  {
        int salario = 0;
    if(asignatura==Asignatura.Historia)
        salario= 200;
   else if(asignatura==Asignatura.Herbologia)
        salario= 250;
    else if(asignatura==Asignatura.Pociones)
        salario= 350;
    else if(asignatura==Asignatura.Transformaciones)
        salario= 400;
    else if(asignatura==Asignatura.Defensa)
        salario= 500;

    return salario;

    }

    @Override
    public String recToString() {
        return getNombre() + " " + getApellido() + "(Docente de " + getAsignatura()+ " ,"+ getHorrocrux() + " horrocruxes):" + getRecompensa() + " galeones";
    }

  @Override
    public String salToString(){
        return getNombre() + " " + getApellido() + " (Docente de " + getAsignatura() + "): " + getSalario() + " galeones";
    }

}

