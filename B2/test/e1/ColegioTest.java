package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.Guard;

import static org.junit.jupiter.api.Assertions.*;

public class ColegioTest {

    private Colegio Hogwarts;

    @BeforeEach
    void setUp() {
        Hogwarts = new Colegio();
        Estudiantes e1 = new Estudiantes("Hermione", "Granger", 19, 3, Residentes.Casa.Gryffindor);
        Fantasmas f1 = new Fantasmas("Baron", "Sanguinario", 400, 1, Residentes.Casa.Slytherin);
        Guardabosques g1 = new Guardabosques("Rubeus", "Hagrid", 67, 2, true);
        Docente d1 = new Docente("Minerva", "McGonagall", 60, 1, Docente.Asignatura.Transformaciones);
        Docente d2 = new Docente("Severus", "Snape", 45, 1, Docente.Asignatura.Pociones);
        Conserje c1 = new Conserje("Argus", "Filch", 80, 0, false);
        Hogwarts.add(e1);
        Hogwarts.add(f1);
        Hogwarts.add(g1);
        Hogwarts.add(d1);
        Hogwarts.add(d2);
        Hogwarts.add(c1);
    }

    @Test
    void testRecompensaToString() {
        assertEquals("""
                Hermione Granger(Estudiante de Gryffindor ,3 horrocruxes):270.0 galeones
                Baron Sanguinario(Fantasma de Slytherin ,1 horrocruxes):160.0 galeones
                Rubeus Hagrid (Guardabosques): 2 horrocruxes):150.0 galeones
                Minerva McGonagall(Docente de Transformaciones ,1 horrocruxes):50.0 galeones
                Severus Snape(Docente de Pociones ,1 horrocruxes):50.0 galeones
                Argus Filch (Conserje): 0 horrocruxes):0.0 galeones
                La recompensa total del colegio es de 680.0 galeones""", Hogwarts.imprimirRecompensas());
    }

    @Test
    void testSalarioToString() {

        assertEquals("""
                Rubeus Hagrid (Guardabosques): 180 galeones
                Minerva McGonagall (Docente de Transformaciones): 400 galeones
                Severus Snape (Docente de Pociones): 350 galeones
                Argus Filch (Conserje): 150 galeones
                El gasto del colegio en personal es de 1080.0 galeones""", Hogwarts.imprimirSalario());
    }

    @Test
        //Comprueba que solo haya un unico profesor para cada aignatura
    void unProfesor(){

        Docente d3 = new Docente("Tom", "Riddle", 50, 2, Docente.Asignatura.Pociones);

        assertThrows(IllegalArgumentException.class ,()-> Hogwarts.add(d3));
    }

    @Test
        //por simplicidad asumimos que no puede haber dos personas con el mismo nombre
    void personaYaExiste(){
        Estudiantes e2 = new Estudiantes("Hermione", "Granger", 19, 3, Residentes.Casa.Gryffindor);

        assertThrows(IllegalArgumentException.class ,()-> Hogwarts.add(e2));
    }
    @Test
    void getRecompensa() {
        Hogwarts.clear();
        Fantasmas f1 = new Fantasmas("Rowena", "Ravenclaw", 600, 2, Residentes.Casa.Ravenclaw);
        assertEquals(160, f1.getRecompensa());

        //Profesor de Defensa Contra Artes Oscuras, se reduce un 25%
        Docente d1 = new Docente("OjoLoco", "Moodey", 60, 2, Docente.Asignatura.Defensa);
        assertEquals(75.0, d1.getRecompensa());

        //Pertenece a Slythering, recompensa se duplica
        Fantasmas f2 = new Fantasmas("Baron", "Sanguinario", 400, 3, Residentes.Casa.Slytherin);
        assertEquals(480, f2.getRecompensa());

        Guardabosques g1 = new Guardabosques("Rubeus", "Hagrid", 67, 2, true);
        assertEquals(150, g1.getRecompensa());

        Conserje c1 = new Conserje("Sra", "Norris",10,0,true);
        assertEquals(0,c1.getRecompensa());
    }

    @Test
    void getSalario() {
        Docente d1 = new Docente("Romena", "Sproud", 78, 2, Docente.Asignatura.Herbologia);
        assertEquals(250, d1.getSalario());

        Docente d2 = new Docente("Ojoloco", "Moodey", 80, 3, Docente.Asignatura.Defensa);
        assertEquals(500, d2.getSalario());

        Docente d3 = new Docente("Cuthbert", "Binns", 780, 1, Docente.Asignatura.Historia);
        assertEquals(200, d3.getSalario());

        Guardabosques g1= new Guardabosques("Rubeus", "Hagrid",60,2,false);
        assertEquals(170,g1.getSalario());


    }

    @Test
    void getEdades(){
        Estudiantes e1= new Estudiantes("Cedric", "Diggory",16,1, Residentes.Casa.Hufflepuff);
        assertEquals(16, e1.getEdad());
    }

}
