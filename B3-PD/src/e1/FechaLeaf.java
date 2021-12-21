package e1;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Predicate;

public record FechaLeaf(String... dates) implements PredicateConstructor {

    private void checker(String[] conditions) {
        if (conditions.length < 1 || conditions.length > 2) {
            throw new IllegalArgumentException("Cant add more than two conditions to OR sentence");
        }
    }

    @Override
    public Predicate<Billetes> recursiveFiltering() throws ParseException {

        checker(dates);
        Date date1 = new SimpleDateFormat("dd/MM/yy").parse(dates[0]);

        Predicate<Billetes> aux = billetes -> {
            try {
                return billetes.getFecha().equals(date1);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;
        };


        if (dates.length == 1) {
            return aux;
        }
        else {
            Date date2 = new SimpleDateFormat("dd/MM/yy").parse(dates[1]);
            return aux.or(billetes -> {
                try {
                    return billetes.getFecha().equals(date2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return false;
            });
        }
    }
}
