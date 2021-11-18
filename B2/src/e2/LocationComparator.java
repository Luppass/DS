package e2;

import java.util.Comparator;

public class LocationComparator implements Comparator<Apartment> {

    @Override
    public int compare(Apartment o1, Apartment o2) {
        if (o1.getCodigo_postal() == o2.getCodigo_postal()){
            return o1.compareTo(o2);
        }
        else return Integer.compare(o1.getCodigo_postal(), o2.getCodigo_postal());
    }
}
