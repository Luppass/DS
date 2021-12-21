package e1;
import java.util.Objects;
import java.util.function.Predicate;

public record OrigenLeaf(String... conditions) implements PredicateConstructor {

    private void checker(String[] conditions) {
        if (conditions.length < 1 || conditions.length > 2) {
            throw new IllegalArgumentException("Invalid values");
        }
    }

    @Override
    public Predicate<Billetes> recursiveFiltering() {
        checker(conditions);
        if (conditions.length == 1) {
            return billetes -> Objects.equals(billetes.getOrigen(), conditions[0]);
        } else {
            Predicate<Billetes> aux = billetes -> billetes.getOrigen().equals(conditions[0]);
            return aux.or(billetes -> billetes.getOrigen().equals(conditions[1]));
        }
    }
}
