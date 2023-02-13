package patterns.identity_map_and_data_mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonDBImplementation implements PersonDataMapper{

    //вместо реальной ДБ использую список
    private List<Person> personList = new ArrayList<>();


    @Override
    public Person find(int id) throws DataMapperException{

        Optional<Person> optionalPerson = personList.stream()
                                                    .filter(p -> p.getPersonalId() == id)
                                                    .findFirst();
        if (optionalPerson.isEmpty()) {
            throw new DataMapperException("Person with ID=" + id + " is not found in DB");
        }

        return optionalPerson.get();
    }

    @Override
    public void insert(Person person) throws DataMapperException{
        // не катит т.к. id может сохраниться, а значения полей измениться. заменил на поиск с уникальным id
        //if (personList.contains(person)) throw new DataMapperException("This person already exists in DB");

        Optional<Person> optionalPerson = personList.stream()
                                                    .filter(p -> p.getPersonalId() == person.getPersonalId())
                                                    .findFirst();
        if (optionalPerson.isPresent()) {
            throw new DataMapperException("Person with ID=" + person.getPersonalId() + " already exists in DB");
        }
        personList.add(person);
    }

    @Override
    public void update(Person person) throws DataMapperException{
        Optional<Person> optionalPerson = personList.stream()
                .filter(p -> p.getPersonalId() == person.getPersonalId())
                .findFirst();
        if (optionalPerson.isEmpty()) {
            throw new DataMapperException("Person with ID=" + person.getPersonalId() + " is not found in DB");
        } else {
            Person elem = optionalPerson.get();
            elem.setName(person.getName());
            elem.setPhone(person.getPhone());
            //тут обычно сохранение в БД
        }

    }

    @Override
    public void delete(int id) {
        Optional<Person> optionalPerson = personList.stream()
                .filter(p -> p.getPersonalId() == id)
                .findFirst();
        if (optionalPerson.isEmpty()) {
            throw new DataMapperException("Person with ID=" + id + " is not found in DB");
        }

        personList.remove(optionalPerson.get());
    }

    public int dbSize() {
        return personList.size();
    }
}
