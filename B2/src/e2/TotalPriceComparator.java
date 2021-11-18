package e2;

import java.util.Comparator;

public class TotalPriceComparator implements Comparator<Apartment> {

    @Override
    public int compare(Apartment o1, Apartment o2) {
        if (Float.compare( o1.getTotalPrice(), o2.getTotalPrice())==0){
            return o1.compareTo(o2);
        }
        else return Float.compare(o1.getTotalPrice(), o2.getTotalPrice());
    }
}
