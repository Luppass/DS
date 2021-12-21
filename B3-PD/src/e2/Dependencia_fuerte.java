package e2;
import java.util.ArrayList;
import java.util.List;


public class Dependencia_fuerte implements OrdenRealizacion {
    List<String> tareasEjecutables = new ArrayList<>();
    StringBuilder solution = new StringBuilder();

    @Override
    public String plan_tasks(List<String> taskX, List<String> taskY) {

        for (String x : taskX) { // Recorre las taskX, y si no hay una dependencia de esa tarea (que este en taskY) la añade a tareasEjecutables
            if (!taskY.contains(x)) {
                if (!tareasEjecutables.contains(x)) tareasEjecutables.add(x);
            }
        }

        do {
            if (!tareasEjecutables.isEmpty()) {
                tareasEjecutables.sort(String::compareTo);

                for (int i = 0; i < taskX.size(); i++) {
                    if (taskX.get(i).equals(tareasEjecutables.get(0))) {
                        String itemY = taskY.get(i);
                        int count = 0;
                        for (String y : taskY) {
                            if (y.equals(itemY)) count++;
                        }
                        if (count == 1) tareasEjecutables.add(itemY);
                    }
                }
                if(tareasEjecutables.size()!=1)
                solution.append(tareasEjecutables.get(0)).append(" -> ");
                else solution.append(tareasEjecutables.get(0));

                if (taskX.contains(tareasEjecutables.get(0))) {
                    do {
                        taskY.remove(taskX.indexOf(tareasEjecutables.get(0)));
                        taskX.remove(tareasEjecutables.get(0));
                    } while (taskX.contains(tareasEjecutables.get(0)));
                }
                tareasEjecutables.remove(0);
            }
        } while (!tareasEjecutables.isEmpty());
        return solution.toString();
    }

}





