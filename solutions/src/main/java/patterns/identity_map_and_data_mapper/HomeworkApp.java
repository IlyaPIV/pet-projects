package patterns.identity_map_and_data_mapper;

public class HomeworkApp {
    public static void main(String[] args) {

        PersonDBImplementation db = new PersonDBImplementation();
        CacheFindService service = new CacheFindService();
        service.setDb(db);


        initDbValues(db);

        // 1ый поиск без значений в кэше
        System.out.println(service.findPerson(2).toString());
        System.out.println(service.findPerson(4).toString());
        System.out.println(service.findPerson(5).toString());

        updatePersonValuesInDb(db);

        // 2ый поиск: часть значений из БД, часть - из IdentityMap
        System.out.println(service.findPerson(2).toString());
        System.out.println(service.findPerson(3).toString());
        System.out.println(service.findPerson(4).toString());

        /**
         * РЕЗУЛЬТАТ РАБОТЫ В КОНСОЛИ:
         */
//        searching value in DB...
//        add value to cache for key = 2
//        {Id = 2, name = 'Petia', phone = '+375-33-1230055'}
//        searching value in DB...
//        add value to cache for key = 4
//        {Id = 4, name = 'Ania', phone = '+48-500-100-300'}
//        searching value in DB...
//        add value to cache for key = 5
//        {Id = 5, name = 'Olya', phone = '+48-515321123'}
//        return value from cache for key = 2
//        {Id = 2, name = 'Petia', phone = '+375-33-1230055'}
//        searching value in DB...
//        add value to cache for key = 3
//        {Id = 3, name = 'Kolia', phone = '+375-44-9876532'}
//        return value from cache for key = 4
//        {Id = 4, name = 'Galina', phone = '911'}
//
//        Process finished with exit code 0


    }

    private static void updatePersonValuesInDb(PersonDBImplementation db) {
        Person person = db.find(4);
        person.setName("Galina");
        person.setPhone("911");
        db.update(person);
    }

    private static void initDbValues(PersonDBImplementation db) {
        Person person1 = new Person(1, "Vasia", "+375-29-1234567");
        Person person2 = new Person(2, "Petia", "+375-33-1230055");
        Person person3 = new Person(3, "Kolia", "+375-44-9876532");
        Person person4 = new Person(4, "Ania", "+48-500-100-300");
        Person person5 = new Person(5, "Olya", "+48-515321123");
        db.insert(person1);
        db.insert(person2);
        db.insert(person3);
        db.insert(person4);
        db.insert(person5);
    }
}
