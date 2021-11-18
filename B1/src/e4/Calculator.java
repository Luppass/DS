package e4;

import java.util.ArrayList;
import java.util.Objects;

public class Calculator {
    /**
     * Public constructor of the calculator.
     */
    private final ArrayList<OperationsClass> calculatorList = new ArrayList<>();

    public Calculator() {
    }

    /**
     * Clean the internal state of the calculator
     */
    public void cleanOperations() {
        calculatorList.clear();
    }

    /**
     * Add a new operation to the internal state of the calculator.
     * It is worth mentioning that the calculator behaves in an accumulative way,
     * thus only first operation has two operands.
     * The rest of computations work with the accumulated value and only an extra
     * new operand. Second input value must be ignored if the operation does not
     * correspond to the first one. *
     *
     * @param operation operation to add, as string, "+", "-", "*", "/".
     * @param values    Operands of the new operation (one or two operands).
     *                  Uses the varargs feature.
     *                  }
     *                  <p>
     *                  https://docs.oracle.com/javase/8/docs/technotes/guides/language/varargs.html
     * @throws IllegalArgumentException If the operation does not exist.
     */
    public void addOperation(String operation, float... values) {
        float first, second;
        String op = "+-*/";

        if (!op.contains(operation))
            throw new IllegalArgumentException("The opeation does not exist");

        if (values.length == 1 && calculatorList.isEmpty()) {
            throw new IllegalArgumentException("FIRST OPERATION: Two operands are needed");
        }

            if (values.length == 2 && calculatorList.isEmpty()) {
                first = values[0];
                second = values[1];
                OperationsClass calc = new OperationsClass(operation, first, second);
                calculatorList.add(calc);
            } else if (!calculatorList.isEmpty()) {
                first = values[0];
                OperationsClass calc = new OperationsClass(operation, first);
                calculatorList.add(calc);
            }
    }

    /**
     * Execute the set of operations of the internal state of the calculator.
     * Once execution is finished, internal state (operands and operations)
     * is restored (EVEN if exception occurs).
     * This calculator works with "Batches" of operations.
     *
     * @return result of the execution
     * @throws ArithmeticException If the operation returns an invalid value
     *                             (division by zero)
     */
    public float executeOperations() {
        float result = 0;
        String op;
        float values1, values2;

        for (int i = 0; i < calculatorList.size(); i++) {

            op = calculatorList.get(i).getOperation();
            values1 = calculatorList.get(i).getNumber(0);

            if (i == 0) {
                values2 = calculatorList.get(i).getNumber(1);

                if (Objects.equals(op, Operation.DIVIDE.toString()) && values2 == 0) {
                    calculatorList.clear();
                    throw new ArithmeticException("division by zero");
                } else {
                    if (Objects.equals(op, Operation.TIMES.toString()))
                        result = Operation.TIMES.apply(values1, values2);

                    else if (Objects.equals(op, Operation.DIVIDE.toString()))
                        result = Operation.DIVIDE.apply(values1, values2);

                    else if (Objects.equals(op, Operation.PLUS.toString()))
                        result = Operation.PLUS.apply(values1, values2);

                    else if (Objects.equals(op, Operation.MINUS.toString()))
                        result = Operation.MINUS.apply(values1, values2);
                }
            } else {
                if (Objects.equals(op, Operation.DIVIDE.toString()) && values1 == 0) {
                    calculatorList.clear();
                    throw new ArithmeticException("division by zero");
                }
                else if (Objects.equals(op, Operation.TIMES.toString()))
                    result = Operation.TIMES.apply(result, values1);

                else if (Objects.equals(op, Operation.PLUS.toString()))
                    result = Operation.PLUS.apply(result, values1);

                else if (Objects.equals(op, Operation.MINUS.toString()))
                    result = Operation.MINUS.apply(result, values1);

                else if (Objects.equals(op, Operation.DIVIDE.toString()))
                    result = Operation.DIVIDE.apply(result, values1);

            }
        }
        calculatorList.clear();
        return result;

    }

    /**
     * Current internal state of calculator is printed
     * FORMAT:
     * "[{+/ -/"/"/*}] value1_value2 [{+/ -/"/"/*}] value1 [{+/ -/"/"/*}] value1 {...}"
     * EXAMPLES: JUnit tests
     *
     * @return String of the internal state of the calculator
     */
    @Override
    public String toString() {
        StringBuilder cadena = new StringBuilder();
        if (calculatorList.isEmpty()) {
            return cadena.append("[STATE:]").toString();
        }
        for (int i = 0; i < calculatorList.size(); i++) {
            if (i == 0) {
                cadena.append("[STATE:").append('[').append(calculatorList.get(i).getOperation()).append(']').append(calculatorList.get(i).getNumber(0)).append('_').append(calculatorList.get(i).getNumber(1));
            } else {
                cadena.append('[').append(calculatorList.get(i).getOperation()).append(']').append(calculatorList.get(i).getNumber(0));
            }
        }
        cadena.append(']');
        return cadena.toString();
    }
}


