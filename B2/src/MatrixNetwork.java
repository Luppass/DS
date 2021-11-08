import java.util.ArrayList;
import java.util.List;

public class MatrixNetwork implements NetworkManager{

    ArrayList<String> users = new ArrayList<>();
    ArrayList<List<TopicOfInterest>> topics = new ArrayList<>();
    int[][] table;

    @Override
    public void addUser(String user, List<TopicOfInterest> topicOfInterest) {
        if (!users.contains(user)) {
            users.add(user);
            topics.add(topicOfInterest);
            table = new int[users.size()][8];
            fillTable(table);
        }else throw new IllegalArgumentException("Este usuario ya existe");
    }

    private void printTable(){
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(table[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void fillTable(int[][] table){
        if (users.isEmpty() || topics.isEmpty()){
            throw new IllegalArgumentException("Data Error");
        }else{
                for (int j = 0; j < users.size(); j++) {
                    if (topics.get(j).contains(TopicOfInterest.Cryptograhpy))
                        table[users.indexOf(users.get(j))][0] = 1;
                    else table[users.indexOf(users.get(j))][0] = 0;

                    if (topics.get(j).contains(TopicOfInterest.Forensics))
                        table[users.indexOf(users.get(j))][1] = 1;
                    else table[users.indexOf(users.get(j))][1] = 0;

                    if (topics.get(j).contains(TopicOfInterest.Web))
                        table[users.indexOf(users.get(j))][2] = 1;
                    else table[users.indexOf(users.get(j))][2] = 0;

                    if (topics.get(j).contains(TopicOfInterest.Steganography))
                        table[users.indexOf(users.get(j))][3] = 1;
                    else table[users.indexOf(users.get(j))][3] = 0;

                    if (topics.get(j).contains(TopicOfInterest.OSINT))
                        table[users.indexOf(users.get(j))][4] = 1;
                    else table[users.indexOf(users.get(j))][4] = 0;

                    if (topics.get(j).contains(TopicOfInterest.Programming))
                        table[users.indexOf(users.get(j))][5] = 1;
                    else table[users.indexOf(users.get(j))][5] = 0;

                    if (topics.get(j).contains(TopicOfInterest.Pentesting))
                        table[users.indexOf(users.get(j))][6] = 1;
                    else table[users.indexOf(users.get(j))][6] = 0;

                    if (topics.get(j).contains(TopicOfInterest.Reverse_engineering))
                        table[users.indexOf(users.get(j))][7] = 1;
                    else table[users.indexOf(users.get(j))][7] = 0;
                }
        }
    }

    public static void main(String[] args) {
        MatrixNetwork matrix = new MatrixNetwork();
        ArrayList<TopicOfInterest> topic = new ArrayList<>();
        ArrayList<TopicOfInterest> topi2 = new ArrayList<>();
        ArrayList<TopicOfInterest> topi3 = new ArrayList<>();

        matrix.getInterests();
        topi3.add(TopicOfInterest.Reverse_engineering);
        topi2.add(TopicOfInterest.OSINT);
        topic.add(TopicOfInterest.OSINT);
        topic.add(TopicOfInterest.Forensics);

        matrix.addUser("juan", topic);
        matrix.addUser("pedro", topi2);
        matrix.addUser("ana", topi3); // NI DE COÑA PONER MISMA LISTA DE TOPICOS A VARIAS PERSONAS

        System.out.println();
        matrix.printTable();

        matrix.removeInterest("juan", TopicOfInterest.OSINT);
        System.out.println();
        matrix.printTable();

    }

    @Override
    public void removeUser(String user) {
        if (!users.contains(user)) throw new IllegalArgumentException("User dont exist");
        else{
            topics.remove(users.indexOf(user));
            users.remove(user);
            table = new int[users.size()][8];
            fillTable(table);
        }
    }

    private int getIndexInterest(TopicOfInterest topic){
        return switch (topic) {
            case Cryptograhpy -> 0;
            case Forensics -> 1;
            case Web -> 2;
            case Steganography -> 3;
            case OSINT -> 4;
            case Programming -> 5;
            case Pentesting -> 6;
            case Reverse_engineering -> 7;
        };
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {
        if (users.contains(user)) {
            if (table[users.indexOf(user)][getIndexInterest(topicOfInterest)] == 1) {
                throw new IllegalArgumentException("Este usuario ya tiene este interés");
            } else table[users.indexOf(user)][getIndexInterest(topicOfInterest)] = 1;
        }else throw new IllegalArgumentException("No existe este usuario");
    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {
        if (users.contains(user)) {
            if (table[users.indexOf(user)][getIndexInterest(topicOfInterest)] == 0) {
                throw new IllegalArgumentException("Este usuario no posee este interés");
            } else table[users.indexOf(user)][getIndexInterest(topicOfInterest)] = 0;
        }else throw new IllegalArgumentException("No existe este usuario");
    }

    @Override
    public List<String> getUsers() {
        return users;
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> aux = new ArrayList<>();

        for (int i = 0; i < users.size(); i++){
            for (int j = 1; j < 7; j++){
                if (table[i][0] == 1 && !aux.contains(TopicOfInterest.Cryptograhpy)){
                    aux.add(TopicOfInterest.Cryptograhpy);
                }
                if (table[i][1] == 1 && !aux.contains(TopicOfInterest.Forensics)){
                    aux.add(TopicOfInterest.Forensics);
                }
                if (table[i][2] == 1 && !aux.contains(TopicOfInterest.Web)){
                    aux.add(TopicOfInterest.Web);
                }
                if (table[i][3] == 1 && !aux.contains(TopicOfInterest.Steganography)){
                    aux.add(TopicOfInterest.Steganography);
                }
                if (table[i][4] == 1 && !aux.contains(TopicOfInterest.OSINT)){
                    aux.add(TopicOfInterest.OSINT);
                }
                if (table[i][5] == 1 && !aux.contains(TopicOfInterest.Programming)){
                    aux.add(TopicOfInterest.Programming);
                }
                if (table[i][6] == 1 && !aux.contains(TopicOfInterest.Pentesting)){
                    aux.add(TopicOfInterest.Pentesting);
                }
                if (table[i][7] == 1 && !aux.contains(TopicOfInterest.Reverse_engineering)){
                    aux.add(TopicOfInterest.Reverse_engineering);
                }
            }
        }
        return aux;
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String user){
        List<TopicOfInterest> aux = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            if (table[users.indexOf(user)][i] == 1){
                if (i == 0) aux.add(TopicOfInterest.Cryptograhpy);
                if (i == 1) aux.add(TopicOfInterest.Forensics);
                if (i == 2) aux.add(TopicOfInterest.Web);
                if (i == 3) aux.add(TopicOfInterest.Steganography);
                if (i == 4) aux.add(TopicOfInterest.OSINT);
                if (i == 5) aux.add(TopicOfInterest.Programming);
                if (i == 6) aux.add(TopicOfInterest.Pentesting);
                if (i == 7) aux.add(TopicOfInterest.Reverse_engineering);
            }
        }
        return aux;
    }
}
