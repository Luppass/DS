package e2;
import java.util.ArrayList;
import java.util.List;

public class Orden_jerarquico implements OrdenRealizacion {

    List<String> disponibles = new ArrayList<>();
    List<String> tareasEjecutadas = new ArrayList<>();
    List<String> tareasEjecutables = new ArrayList<>();
    StringBuilder solution = new StringBuilder();

    @Override
    public String plan_tasks(List<String> taskX, List<String> taskY) {

        for (String x : taskX) {// Recorre las taskX, y si no hay una dependencia de esa tarea (que este en taskY) la añade a tareasEjecutables
            if (!taskY.contains(x)) {
                if (!tareasEjecutables.contains(x) && !tareasEjecutadas.contains(x)) tareasEjecutables.add(x);
            }
        }
        tareasEjecutables.sort(String::compareTo);
        do {
            if (!disponibles.isEmpty()) {
                disponibles.sort(String::compareTo);
                for (String disp : disponibles) {
                    if (!tareasEjecutables.contains(disp) && !tareasEjecutadas.contains(disp))
                        tareasEjecutables.add(disp);
                }
                disponibles.clear();
            }
            if (tareasEjecutables.size() != 1) {
                tareasEjecutadas.add(tareasEjecutables.get(0));
                solution.append(tareasEjecutables.get(0)).append(" -> ");
            } else {
                tareasEjecutadas.add(tareasEjecutables.get(0));
                solution.append(tareasEjecutables.get(0));
            }

            if (taskX.contains(tareasEjecutables.get(0))) {
                do {
                    disponibles.add(taskY.get(taskX.indexOf(tareasEjecutables.get(0))));
                    taskY.remove(taskX.indexOf(tareasEjecutables.get(0)));
                    taskX.remove(tareasEjecutables.get(0));

                } while (taskX.contains(tareasEjecutables.get(0)));
            }
            tareasEjecutables.remove(0);

        } while (!tareasEjecutables.isEmpty());

        return solution.toString();

    }

}