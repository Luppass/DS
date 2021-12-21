package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class GestorTest {

    private Gestor gestor;

    private Billetes billetes1;
    private Billetes billetes2;
    private Billetes billetes3;
    private Billetes billetes4;

    private OrigenLeaf origenLeaf;
    private DestinoLeaf destinoLeaf;
    private PrecioLeaf precioLeaf;
    private FechaLeaf fechaLeaf;


    @BeforeEach
    void setUp(){
        gestor = new Gestor();

        billetes1 = new Billetes("Coruña", "Ourense", 10, "01/12/21", 4);
        billetes2 = new Billetes("Coruña", "Ourense", 13, "03/12/21", 16);
        billetes3 = new Billetes("Santiago", "Madrid", 10, "10/12/21", 8);
        billetes4 = new Billetes("Coruña", "Madrid", 100, "10/12/21", 3);

        String[] origenes = {"Coruña", "Santiago"};
        origenLeaf = new OrigenLeaf(origenes);

        String[] destinos = {"Ourense"};
        destinoLeaf = new DestinoLeaf(destinos);

        String[] precio = {"<", "15"};
        precioLeaf = new PrecioLeaf(precio);

        String[] fechas = {"01/12/21", "02/12/21"};
        fechaLeaf = new FechaLeaf(fechas);

        gestor.addBillete(billetes1);
        gestor.addBillete(billetes2);
        gestor.addBillete(billetes3);
        gestor.addBillete(billetes4);
    }

    @Test
    void oneFilterTest() throws ParseException {

        /*
        Empezamos utilizando un único filtro, en este caso, por destino "Ourense",
        para hacer un nivel más bajo de test
        */
        gestor.addPredicate(destinoLeaf);

        // Filtramos...
        gestor.recursiveFiltering();

        //El resultado deben ser los dos primeros billetes, creamos una lista auxiliar con esos billetes para comparar.
        List<Billetes> auxiliar = new ArrayList<>();
        auxiliar.add(billetes1);
        auxiliar.add(billetes2);

        assertEquals(gestor.FilteredList(), auxiliar);
    }

    @Test
    void mainTest() throws ParseException {

        // Aplicaremos todos los filtros disponibles para forzar al gestor que nos devuelva un
        // único billete en específico, vamos a sacar el "billete1".

        gestor.addPredicate(origenLeaf); // Coruña o Santiago
        gestor.addPredicate(destinoLeaf); // Ourense
        gestor.addPredicate(precioLeaf); // < 15
        gestor.addPredicate(fechaLeaf); // 01/12/2021 o 02/12/2021

        gestor.recursiveFiltering();
        List<Billetes> auxiliar = new ArrayList<>();
        auxiliar.add(billetes1);

        assertEquals(gestor.FilteredList(), auxiliar);
    }
}
