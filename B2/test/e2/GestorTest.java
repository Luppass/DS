package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorTest {

    private Gestor gestorApp;
    private Apartment a;
    private Apartment b;
    private Apartment c;
    private Apartment d;
    private Apartment e;

    @BeforeEach
    void setUp(){

        gestorApp = new Gestor();

        a = new Apartment("A001", 60000, 350, 15012, 1500, 2000, 2500);
        b = new Apartment("A003", 40000, 250, 15012, 1500);
        c = new Apartment("A002", 50000, 200, 15005, 1500);
        d = new Apartment("A004", 50000, 200, 15005, 1500);
        e = new Apartment("A005", 50000, 200, 15007, 200);

        gestorApp.addApartment(a);
        gestorApp.addApartment(b);
        gestorApp.addApartment(c);
        gestorApp.addApartment(d);
    }

    @Test
    void BasicOperations(){

        // orden previsto: a -> c -> b -> d  por orden natural ref_id

        assertEquals(gestorApp.getApartment(0), a);
        assertEquals(gestorApp.getApartment(1), c);
        assertEquals(gestorApp.getApartment(2), b);
        assertEquals(gestorApp.getApartment(3), d);

        // Basic methods test

        e.setSurface(250);
        e.setPlazas_garaje(new float[]{2400, 2000});
        e.setPrecio_base(55000);
        gestorApp.addApartment(e);

        assertEquals(59400, e.getTotalPrice());
        assertEquals(5, gestorApp.NumberOfApartments());

        // Equals test
        assertEquals(c, d);
        assertNotEquals(c, a);

        // Hashcode test
        assertEquals(c.hashCode(), d.hashCode());
        assertNotEquals(c.hashCode(), a.hashCode());

        // Garage space test
        assertEquals(1, b.getNumPlazas());
        assertEquals(3, a.getNumPlazas());

        assertThrows(IllegalArgumentException.class, () -> a.setPrecio_base(-200));
        assertThrows(IllegalArgumentException.class, () -> a.setPlazas_garaje(new float[]{3000f, -200f}));
        // We will not use this fifth apartment for more simplicity on testing
        gestorApp.deleteApartment(e);
    }

    @Test
    void LocationSortTest(){

        // Ordenar de menor a mayor por localizacion (código postal). Orden previsto: c -> d -> a -> b

        gestorApp.sortBy_Location();
        assertEquals(gestorApp.getApartment(0),c);
        assertEquals(gestorApp.getApartment(1),d);
        assertEquals(gestorApp.getApartment(2),a);
        assertEquals(gestorApp.getApartment(3),b);
    }

    @Test
    void PriceSortTest(){

        // Ordenar de menor a mayor por precio base. Orden previsto: b -> c -> d -> a
        gestorApp.sortBy_basePrice();

        assertEquals(gestorApp.getApartment(0),b);
        assertEquals(gestorApp.getApartment(1),c);
        assertEquals(gestorApp.getApartment(2),d);
        assertEquals(gestorApp.getApartment(3),a);

        // Ordenar de menor a mayor por precio total (base+plazas). Orden previsto: b -> d -> c -> a
        gestorApp.sortBy_totalPrice();

        assertEquals(gestorApp.getApartment(0),b);
        assertEquals(gestorApp.getApartment(1),d);
        assertEquals(gestorApp.getApartment(2),c);
        assertEquals(gestorApp.getApartment(3),a);
    }

    @Test
    void QualitySortTest(){ // ACABAR
        /*
           a -> 188.57
           b -> 166
           c -> 257.5
           d -> 257.5
           c y d desempatan por su orden natural (ref_id)

           Ordenar de menor a mayor por su relacion precio-superficie (precio total / superficie).
           Orden previsto : c -> d -> a -> b
        */
        gestorApp.sortBy_Quality();

        assertEquals(gestorApp.getApartment(0),c);
        assertEquals(gestorApp.getApartment(1),d);
        assertEquals(gestorApp.getApartment(2),a);
        assertEquals(gestorApp.getApartment(3),b);
    }

    @Test
    void NumPlazasTest(){
        /*
           Si un cliente tiene varios vehículos, seguramente quiera obtener apartamentos con varias plazas de garaje
           Orden previsto: c -> b -> d -> a
        */
        gestorApp.sortBy_numPlazas();

        assertEquals(gestorApp.getApartment(0),c);
        assertEquals(gestorApp.getApartment(1),b);
        assertEquals(gestorApp.getApartment(2),d);
        assertEquals(gestorApp.getApartment(3),a);

        // Empty apartment App
        gestorApp.clearList();
        assertEquals(0, gestorApp.NumberOfApartments());
    }
}