package e3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class NetworkTest {

    private Network MatrixNetwork;
    private Network MapNetwork;
    private List<TopicOfInterest> topic1;
    private List<TopicOfInterest> topic2;
    private List<TopicOfInterest> topic3;

    @BeforeEach
    void setUpMatrix(){

        MatrixNetwork = new Network();
        MatrixNetwork.setNetworkManager(new MatrixNetwork());

        MapNetwork = new Network();
        MapNetwork.setNetworkManager(new MapNetwork());

        //First exceptions, empty list
        assertThrows(IllegalStateException.class, () -> MatrixNetwork.infoNetwork());
        assertThrows(IllegalStateException.class, () -> MapNetwork.infoNetwork());

        topic1 = new ArrayList<>();
        topic2 = new ArrayList<>();
        topic3 = new ArrayList<>();

        MatrixNetwork.getNetworkManager().addUser("Clara", topic1);
        MatrixNetwork.getNetworkManager().addUser("Yago", topic2);
        MatrixNetwork.getNetworkManager().addUser("Ana", topic3);

        MapNetwork.getNetworkManager().addUser("Clara", topic1);
        MapNetwork.getNetworkManager().addUser("Yago", topic2);
        MapNetwork.getNetworkManager().addUser("Ana", topic3);

        //Exceptions for general methods
        assertThrows(IllegalCallerException.class, () -> MatrixNetwork.commonTopic("Clara", "Yago"));
        assertThrows(IllegalArgumentException.class, () -> MatrixNetwork.usersSameTopic(TopicOfInterest.Cryptograhpy));
        assertThrows(IllegalCallerException.class, () -> MapNetwork.commonTopic("Clara", "Yago"));
        assertThrows(IllegalArgumentException.class, () -> MapNetwork.usersSameTopic(TopicOfInterest.Cryptograhpy));


        MatrixNetwork.getNetworkManager().addInterest("Clara", TopicOfInterest.Cryptograhpy);
        MatrixNetwork.getNetworkManager().addInterest("Yago", TopicOfInterest.Forensics);

        MapNetwork.getNetworkManager().addInterest("Clara", TopicOfInterest.Cryptograhpy);
        MapNetwork.getNetworkManager().addInterest("Yago", TopicOfInterest.Forensics);



    }

    @Test
    void ExceptionsTest(){
        /*  Exceptions on both Implementations
         Same user
         same topic
         remove not existing user
         removing a non-existent topic from a user
         */
        assertThrows(IllegalArgumentException.class, () -> MatrixNetwork.getNetworkManager().addUser("Clara", topic1));
        assertThrows(IllegalArgumentException.class, () -> MatrixNetwork.getNetworkManager().addInterest("Clara", TopicOfInterest.Cryptograhpy));
        assertThrows(IllegalArgumentException.class, () -> MatrixNetwork.getNetworkManager().removeUser("Carmen"));
        assertThrows(IllegalArgumentException.class, () -> MatrixNetwork.getNetworkManager().removeInterest("Clara", TopicOfInterest.Reverse_engineering));

        assertThrows(IllegalArgumentException.class, () -> MapNetwork.getNetworkManager().addUser("Clara", topic1));
        assertThrows(IllegalArgumentException.class, () -> MapNetwork.getNetworkManager().addInterest("Clara", TopicOfInterest.Cryptograhpy));
        assertThrows(IllegalArgumentException.class, () -> MapNetwork.getNetworkManager().removeUser("Carmen"));
        assertThrows(IllegalArgumentException.class, () -> MapNetwork.getNetworkManager().removeInterest("Clara", TopicOfInterest.Reverse_engineering));
    }

    @Test
    void InterestTest(){

        //Testing the interest getters of an user:
        List<TopicOfInterest> forensic = new ArrayList<>(); forensic.add(TopicOfInterest.Forensics);

        MatrixNetwork.getNetworkManager().addInterest("Clara", TopicOfInterest.Forensics);
        MatrixNetwork.getNetworkManager().removeInterest("Clara", TopicOfInterest.Cryptograhpy);
        assertEquals(MatrixNetwork.getNetworkManager().getInterestsUser("Clara"), forensic);

        MapNetwork.getNetworkManager().addInterest("Clara", TopicOfInterest.Forensics);
        MapNetwork.getNetworkManager().removeInterest("Clara", TopicOfInterest.Cryptograhpy);
        assertEquals(MapNetwork.getNetworkManager().getInterestsUser("Clara"), forensic);


        //Adding more interests to test functionality of getters
        MatrixNetwork.getNetworkManager().addInterest("Yago", TopicOfInterest.Reverse_engineering);
        MatrixNetwork.getNetworkManager().addInterest("Ana", TopicOfInterest.Web);
        MatrixNetwork.getNetworkManager().addInterest("Ana", TopicOfInterest.OSINT);
        MapNetwork.getNetworkManager().addInterest("Yago", TopicOfInterest.Reverse_engineering);
        MapNetwork.getNetworkManager().addInterest("Ana", TopicOfInterest.Web);
        MapNetwork.getNetworkManager().addInterest("Ana", TopicOfInterest.OSINT);


        //testing the getter of all interests of the network, Expected: [Forensics, Reverse_engineering, Web, OSINT]
        List<TopicOfInterest> interestsNetwork = new ArrayList<>();
        interestsNetwork.add(TopicOfInterest.Forensics);
        interestsNetwork.add(TopicOfInterest.Reverse_engineering);  // Expected list return
        interestsNetwork.add(TopicOfInterest.Web);
        interestsNetwork.add(TopicOfInterest.OSINT);

        assertEquals(MatrixNetwork.getNetworkManager().getInterests(), interestsNetwork);
        assertEquals(MapNetwork.getNetworkManager().getInterests(), interestsNetwork);
    }

    @Test
    void UsersTest(){

        /*
         Borramos un elemento del medio, para probar el funcionamiento correcto de la implementacion por tablas
         */
        MapNetwork.getNetworkManager().addUser("Jaime", topic1);
        MapNetwork.getNetworkManager().addUser("Luis", topic3);

        MatrixNetwork.getNetworkManager().addUser("Jaime", topic1);
        MatrixNetwork.getNetworkManager().addUser("Luis", topic3);

        MapNetwork.getNetworkManager().removeUser("Yago");
        MatrixNetwork.getNetworkManager().removeUser("Yago");

        List<String> users = new ArrayList<>();
        users.add("Clara");
        users.add("Ana");
        users.add("Jaime");
        users.add("Luis");

        assertEquals(MapNetwork.getNetworkManager().getUsers(), users);
        assertEquals(MatrixNetwork.getNetworkManager().getUsers(), users);
    }

    @Test
    void NetworkDataTest(){

        //Info of all network:

        MatrixNetwork.getNetworkManager().addInterest("Clara", TopicOfInterest.Forensics);
        MatrixNetwork.getNetworkManager().addInterest("Ana", TopicOfInterest.Forensics);

        MapNetwork.getNetworkManager().addInterest("Clara", TopicOfInterest.Forensics);
        MapNetwork.getNetworkManager().addInterest("Ana", TopicOfInterest.Forensics);


        assertEquals(MapNetwork.infoNetwork(), """
                Clara: [Cryptograhpy, Forensics]
                Yago: [Forensics]
                Ana: [Forensics]
                """);
        assertEquals(MatrixNetwork.infoNetwork(), """
                Clara: [Cryptograhpy, Forensics]
                Yago: [Forensics]
                Ana: [Forensics]
                """);


        //List with users of same topic
        List<String> auxTest = new ArrayList<>();
        auxTest.add("Clara"); auxTest.add("Yago"); auxTest.add("Ana");

        assertEquals(MapNetwork.usersSameTopic(TopicOfInterest.Forensics), auxTest);
        assertEquals(MatrixNetwork.usersSameTopic(TopicOfInterest.Forensics), auxTest);


        //topics in common of two users:
        MapNetwork.getNetworkManager().addInterest("Ana", TopicOfInterest.Cryptograhpy);
        MatrixNetwork.getNetworkManager().addInterest("Ana", TopicOfInterest.Cryptograhpy);


        List<TopicOfInterest> auxTest2 = new ArrayList<>();
        auxTest2.add(TopicOfInterest.Cryptograhpy); auxTest2.add(TopicOfInterest.Forensics);

        assertEquals(MapNetwork.commonTopic("Clara", "Ana"), auxTest2);


    }

}