package e1;
import java.text.ParseException;
import java.util.function.Predicate;

public interface PredicateConstructor{
    Predicate<Billetes> recursiveFiltering() throws ParseException;
}
