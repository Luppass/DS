import java.util.ArrayList;
import java.util.List;

public class Network{

    private NetworkManager networkManager;

    public void setNetworkManager(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }

    public NetworkManager getNetworkManager() {
        return networkManager;
    }

    public static void main(String[] args) {
        Network network = new Network();
        network.setNetworkManager(new MapNetwork());
        List<TopicOfInterest> topic1 = new ArrayList<>();
        List<TopicOfInterest> topic2 = new ArrayList<>();
        List<TopicOfInterest> topic3 = new ArrayList<>();
        topic1.add(TopicOfInterest.Cryptograhpy);
        topic2.add(TopicOfInterest.Forensics);
        topic3.add(TopicOfInterest.Forensics);
        topic1.add(TopicOfInterest.OSINT);
        network.networkManager.addUser("Pablo", topic1);
        network.networkManager.addUser("KEVIN", topic2);
        network.networkManager.addUser("juan", topic3);
        System.out.println(network.networkManager.getInterestsUser("Pablo"));
        network.networkManager.addInterest("Pablo", TopicOfInterest.Web);
        System.out.println(network.networkManager.getInterestsUser("Pablo"));


    }
}

