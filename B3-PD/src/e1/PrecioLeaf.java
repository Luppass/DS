package e1;
import java.text.ParseException;
import java.util.Objects;
import java.util.function.Predicate;

public record PrecioLeaf(String... conditions) implements PredicateConstructor {

    private Predicate<Billetes> checker(String[] conditions) {
        if (conditions.length != 2) {
            throw new IllegalArgumentException("Cant add more than two conditions to OR sentence");
        }else{
            try {

                float precio = Float.parseFloat(conditions[1]);

                if (Objects.equals(conditions[0], ">")) {
                    return billetes -> billetes.getPrecio() > precio;
                }
                if (Objects.equals(conditions[0], ">=")) {
                    return billetes -> billetes.getPrecio() >= precio;
                }
                if (Objects.equals(conditions[0], "<")) {
                    return billetes -> billetes.getPrecio() < precio;
                }
                if (Objects.equals(conditions[0], "<=")) {
                    return billetes -> billetes.getPrecio() <= precio;
                }
                if (Objects.equals(conditions[0], "==")) {
                    return billetes -> billetes.getPrecio() == precio;
                }
                throw new IllegalStateException("Error");
            } catch (NumberFormatException nfe) {
                throw new IllegalArgumentException("Invalid values");
            }
        }
    }

    @Override
    public Predicate<Billetes> recursiveFiltering() {
        return checker(conditions);
    }
}