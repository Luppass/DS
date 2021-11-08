
import java.util.*;
import java.util.stream.Collectors;

    public class MapNetwork implements NetworkManager {
        Map<String, List<TopicOfInterest>> linkedHashMap = new LinkedHashMap<>();
        List<TopicOfInterest> totaltopics = new ArrayList<>();

        @Override
        public void addUser(String user, List<TopicOfInterest> topicOfInterest) {
            if (!linkedHashMap.containsKey(user))
                linkedHashMap.put(user, topicOfInterest);
            else
                throw new IllegalArgumentException("Este usuario ya existe");
        }

        @Override
        public void removeUser(String user) {
            if (!linkedHashMap.containsKey(user))
                throw new IllegalArgumentException("El usuario no existe");
            else
                for(int i =0; i< linkedHashMap.get(user).size(); i++)
                    totaltopics.remove(linkedHashMap.get(user).get(i));

            linkedHashMap.remove(user);
        }

        @Override
        public void addInterest(String user, TopicOfInterest topicOfInterest) {
            if (!linkedHashMap.containsKey(user))
                throw new IllegalArgumentException("El usuario no existe");
            else
                for (String key : linkedHashMap.keySet()) {
                    if (Objects.equals(key, user)) {
                        if (linkedHashMap.get(key).contains(topicOfInterest))
                            throw new IllegalArgumentException("El usuario ya posee este interés");
                        else
                            linkedHashMap.get(key).add(topicOfInterest);
                    }
                }
            totaltopics.add(topicOfInterest);
        }

        @Override
        public void removeInterest(String user, TopicOfInterest topicOfInterest) {
            if (!linkedHashMap.containsKey(user))
                throw new IllegalArgumentException("No existe ese usuario");
            else
                for (String key : linkedHashMap.keySet()) {
                    if (Objects.equals(key, user)) {
                        if (!linkedHashMap.get(key).contains(topicOfInterest))
                            throw new IllegalArgumentException("El usuario no posee este Interés");
                        else
                            linkedHashMap.get(key).remove(topicOfInterest);
                    }
                }
            totaltopics.remove(topicOfInterest);
        }

        @Override
        public List<String> getUsers() {
            return new ArrayList<>(linkedHashMap.keySet());
        }

        @Override
        public List<TopicOfInterest> getInterests() {
            return totaltopics.stream().distinct().collect(Collectors.toList());
        }

        @Override
        public List<TopicOfInterest> getInterestsUser(String user) {
            if (!linkedHashMap.containsKey(user))
                throw new IllegalArgumentException("No existe ese usuario");
            else
                return new ArrayList<>(linkedHashMap.get(user));
        }

    }