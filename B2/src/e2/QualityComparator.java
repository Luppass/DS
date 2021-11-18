package e2;

import java.util.Comparator;

/*
Esta clase comparará apartamentos por su relación superficie-precio, definiremos
este concepto como la relacion entre precio base, plazas de garaje y su total de
superficie cuadrada. Cuanto menor sea este número, mayor relación superficie-precio
tendrá el apartamento.
*/

public class QualityComparator implements Comparator<Apartment> {

    @Override
    public int compare(Apartment o1, Apartment o2) {
        float quality_o1 = o1.getTotalPrice() / o1.getSurface();
        float quality_o2 = o2.getTotalPrice() / o2.getSurface();

        if (Float.compare(quality_o1, quality_o2) == 0){
            return o1.compareTo(o2);
        }
        else if (Float.compare(quality_o1, quality_o2)<0){
            return 1;
        }
        else return -1;
    }
}