package e1;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Gestor implements PredicateConstructor {

    private final List<PredicateConstructor> recursiveConditions;
    private final List<Billetes> billetesList;
    private List<Billetes> filteredList;

    public Gestor(){
        this.recursiveConditions = new ArrayList<>();
        this.billetesList = new ArrayList<>();
        this.filteredList = new ArrayList<>();
    }

    public void addBillete(Billetes billete){
        billetesList.add(billete);
    }

    public void addPredicate(PredicateConstructor predicate_constructor){
        recursiveConditions.add(predicate_constructor);
    }

    public List<Billetes> FilteredList(){
        return filteredList;
    }

    private void filterList(PredicateConstructor child) throws ParseException {
        filteredList = billetesList.stream().filter(child.recursiveFiltering()).toList();
    }

    @Override
    public Predicate<Billetes> recursiveFiltering() throws ParseException {
        for (PredicateConstructor x : recursiveConditions){
            filterList(x);
        }
        return null;
    }
}