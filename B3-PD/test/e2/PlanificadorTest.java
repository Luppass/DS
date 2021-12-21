package e2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PlanificadorTest {
    @Test
    public void dependencia_fuerte_test(){
        Planificador planificador = new Planificador();
        planificador.setAlgorithm(new Dependencia_fuerte());

        planificador.addtaskX("C"); planificador.addtaskY("A");
        planificador.addtaskX("C"); planificador.addtaskY("F");
        planificador.addtaskX("A"); planificador.addtaskY("B");
        planificador.addtaskX("A"); planificador.addtaskY("D");
        planificador.addtaskX("B"); planificador.addtaskY("E");
        planificador.addtaskX("D"); planificador.addtaskY("E");
        planificador.addtaskX("F"); planificador.addtaskY("E");
        planificador.addtaskX("G"); planificador.addtaskY("F");
        planificador.addtaskX("G"); planificador.addtaskY("H");
        planificador.addtaskX("F"); planificador.addtaskY("J");
        planificador.addtaskX("H"); planificador.addtaskY("J");

       assertEquals("C -> A -> B -> D -> G -> F -> E -> H -> J" ,planificador.plan_tasks());
      assertEquals("Dependencia_fuerte", planificador.getAlgorithm().getClass().getSimpleName());
    }

@Test
    public void dependencia_debil_test(){
        Planificador planificador = new Planificador();
        planificador.setAlgorithm(new Dependencia_debil());

        planificador.addtaskX("C"); planificador.addtaskY("A");
        planificador.addtaskX("C"); planificador.addtaskY("F");
        planificador.addtaskX("A"); planificador.addtaskY("B");
        planificador.addtaskX("A"); planificador.addtaskY("D");
        planificador.addtaskX("B"); planificador.addtaskY("E");
        planificador.addtaskX("D"); planificador.addtaskY("E");
        planificador.addtaskX("F"); planificador.addtaskY("E");
        planificador.addtaskX("G"); planificador.addtaskY("F");
        planificador.addtaskX("G"); planificador.addtaskY("H");
        planificador.addtaskX("F"); planificador.addtaskY("J");
        planificador.addtaskX("H"); planificador.addtaskY("J");

        assertEquals("C -> A -> B -> D -> E -> F -> G -> H -> J" ,planificador.plan_tasks());
        assertEquals("Dependencia_debil", planificador.getAlgorithm().getClass().getSimpleName());
    }

   @Test
    public void Orden_jerarquico_test(){
        Planificador planificador = new Planificador();
        planificador.setAlgorithm(new Orden_jerarquico());

        planificador.addtaskX("C"); planificador.addtaskY("A");
        planificador.addtaskX("C"); planificador.addtaskY("F");
        planificador.addtaskX("A"); planificador.addtaskY("B");
        planificador.addtaskX("A"); planificador.addtaskY("D");
        planificador.addtaskX("B"); planificador.addtaskY("E");
        planificador.addtaskX("D"); planificador.addtaskY("E");
        planificador.addtaskX("F"); planificador.addtaskY("E");
        planificador.addtaskX("G"); planificador.addtaskY("F");
        planificador.addtaskX("G"); planificador.addtaskY("H");
        planificador.addtaskX("F"); planificador.addtaskY("J");
        planificador.addtaskX("H"); planificador.addtaskY("J");

        assertEquals("C -> G -> A -> F -> H -> B -> D -> E -> J" ,planificador.plan_tasks());
        assertEquals("Orden_jerarquico", planificador.getAlgorithm().getClass().getSimpleName());
    }


}
