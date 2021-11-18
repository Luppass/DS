package e4;

public class OperationsClass {
    private final String operation;
    private  final float[] number;


    public OperationsClass(String operation, float... number) {
        this.operation = operation;
        this.number = number;

    }
    public  float getNumber(int index){
            return number[index];
    }

    public String getOperation() {return operation;}
}
