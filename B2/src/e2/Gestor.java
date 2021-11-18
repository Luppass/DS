package e2;

import java.util.ArrayList;
import java.util.Collections;

/*
Nota: Todo filtro de ordenamiento ordena de menor a mayor según el criterio escogido.
*/

public class Gestor{

    private final ArrayList<Apartment> ApartList = new ArrayList<>();

    public void addApartment(Apartment apartment){
        ApartList.add(apartment);
        Collections.sort(ApartList);
    }
    public void deleteApartment(Apartment apartment){
        ApartList.remove(apartment);
    }
    public void clearList(){
        ApartList.clear();
    }
    public Apartment getApartment(int i){
        return ApartList.get(i);
    }
    public int NumberOfApartments(){
        return ApartList.size();
    }


    public void sortBy_Location(){
        ApartList.sort(new LocationComparator());
    }

    public void sortBy_basePrice(){
        ApartList.sort(new PriceComparator());
    }

    public void sortBy_totalPrice(){
        ApartList.sort(new TotalPriceComparator());
    }

    public void sortBy_Quality(){
        ApartList.sort(new QualityComparator());
    }

    public void sortBy_numPlazas(){
        ApartList.sort(new TotalPlazasComparator());
    }
}
