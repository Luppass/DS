package e3;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private NetworkManager networkManager;

    public void setNetworkManager(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }

    public NetworkManager getNetworkManager() {
        return networkManager;
    }

    public List<String> usersSameTopic(TopicOfInterest topicOfInterest) {
        if (!networkManager.getInterests().contains(topicOfInterest))
            throw new IllegalArgumentException("No hay ningún usuario interesado en este tópico");
        else {
            ArrayList<String> users = new ArrayList<>();
            for (int i = 0; i < networkManager.getUsers().size(); i++) {
                if (networkManager.getInterestsUser(networkManager.getUsers().get(i)).contains(topicOfInterest)) {
                    users.add(networkManager.getUsers().get(i));
                }
            }
            if (users.isEmpty()) {
                throw new IllegalCallerException("No hay usuarios registrados en la red");
            } else
                return users;
        }
    }

    public List<TopicOfInterest> commonTopic (String user1, String user2) {
        if (!(networkManager.getUsers().contains(user1) || networkManager.getUsers().contains(user2)))
            throw new IllegalArgumentException("No existe ese usuario");
        else {
            List<TopicOfInterest> common = new ArrayList<>();
            for (int i = 0; i < networkManager.getInterestsUser(user1).size(); i++) {
                if (networkManager.getInterestsUser(user2).contains(networkManager.getInterestsUser(user1).get(i))) {
                    common.add(networkManager.getInterestsUser(user1).get(i));
                }
            }
            if (common.isEmpty()) throw new IllegalCallerException("No tienen tópicos en comun");
            else return common;
        }
    }

    public String infoNetwork(){
        StringBuilder cadena = new StringBuilder();
        for(int i =0; i<networkManager.getUsers().size();i++){
            cadena.append(networkManager.getUsers().get(i)).append(": " +
                    "").append(networkManager.getInterestsUser(networkManager.getUsers().get(i))).append("\n");

        }
        if(cadena.isEmpty()) throw new IllegalStateException("No hay usuarios registrados en la red");
        else return cadena.toString();
    }

}