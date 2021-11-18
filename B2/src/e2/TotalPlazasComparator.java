package e2;

import java.util.Comparator;

public class TotalPlazasComparator implements Comparator<Apartment> {
    @Override
    public int compare(Apartment o1, Apartment o2) {

        if (o1.getNumPlazas() == o2.getNumPlazas()){
            return o1.compareTo(o2);
        }
        else return Integer.compare(o1.getNumPlazas(), o2.getNumPlazas());
    }
}
