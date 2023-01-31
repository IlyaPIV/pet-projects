package patterns.identity_map_and_data_mapper;

public class CacheFindService {

    private PersonIdentityMap identityMap = new PersonIdentityMap();
    private PersonDBImplementation db = new PersonDBImplementation();

    public void setDb(PersonDBImplementation db) {
        this.db = db;
    }

    public Person findPerson(int key) {
        Person person = identityMap.getPerson(key);
        if (person != null) {
            // Достаём из кэша
            System.out.println("return value from cache for key = " + key);
            return person;
        } else {
            //ищем в БД
            System.out.println("searching value in DB...");
            person = db.find(key);
            if (person != null) {
                // Добавим в кэш
                System.out.println("add value to cache for key = " + key);
                identityMap.addPerson(person);
            } else {
                System.out.println("null value in DB for key = " + key);
            }
            return person;
        }
    }
}
