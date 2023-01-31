package patterns.identity_map_and_data_mapper;

import java.util.HashMap;
import java.util.Map;

public class PersonIdentityMap {
    private Map<Integer, Person> personMap = new HashMap<>();

    public void addPerson(Person person) {
        if (!personMap.containsKey(person.getPersonalId())) {
            personMap.put(person.getPersonalId(), person);
        }
    }

    public Person getPerson(int id) {

        return personMap.get(id);
    }

    public int mapSize(){
        return personMap.size();
    }
}
