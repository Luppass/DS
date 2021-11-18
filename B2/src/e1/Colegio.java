package e1;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Objects;

public class Colegio {
    ArrayList<Integrantes> colegio = new ArrayList<>();

    public Colegio() {}

    public void clear() {
        colegio.clear();
    }

    public void add(Integrantes integrante) {

            for (Integrantes integrantes : colegio) {
                if(Objects.equals(integrantes.getNombre(), integrante.getNombre()) && Objects.equals(integrantes.getApellido(), integrante.getApellido()))
                    throw new IllegalArgumentException("Esta persona ya existe");
                else {
                    if( integrante instanceof Docente && integrantes instanceof Docente) {
                        if (((Docente) integrantes).getAsignatura() == ((Docente) integrante).getAsignatura())
                            throw new IllegalArgumentException("Ya existe un profesor para esa asignatura");
                       }
                    }

        }
            colegio.add(integrante);

    }

    public String imprimirRecompensas() {
        float premio = 0;
        StringBuilder cadena = new StringBuilder();
        for (Integrantes integrantes : colegio) {
            cadena.append(integrantes.recToString());
            cadena.append("\n");
            premio += integrantes.getRecompensa();
        }
        cadena.append("La recompensa total del colegio es de ").append(premio).append(" galeones");
        return cadena.toString();
    }

    public String imprimirSalario() {
        float sal = 0;
        StringBuilder cadena = new StringBuilder();
        for (Integrantes integrantes : colegio) {
            if (integrantes instanceof Personal) {
                sal += ((Personal) integrantes).getSalario();
                cadena.append(((Personal) integrantes).salToString());
                cadena.append("\n");
            }
        }
        cadena.append("El gasto del colegio en personal es de ").append(sal).append(" galeones");
        return cadena.toString();
    }
}

