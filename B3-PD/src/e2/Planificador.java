package e2;
import java.util.ArrayList;
import java.util.List;

public class Planificador {

    private OrdenRealizacion algorithm;
    private final List<String> taskX = new ArrayList<>();
    private final List<String> taskY = new ArrayList<>();

    public void addtaskX(String string){
        taskX.add(string);
    }
    public void addtaskY(String string){
        taskY.add(string);
    }

    public OrdenRealizacion getAlgorithm() { return algorithm; }
    public void setAlgorithm(OrdenRealizacion algorithm) {
        this.algorithm = algorithm;}

    public String plan_tasks(){
        return algorithm.plan_tasks(taskX, taskY);
    }
}