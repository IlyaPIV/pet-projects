package patterns.identity_map_and_data_mapper;

public interface PersonDataMapper {

    Person find(int id);

    void insert(Person person);

    void update(Person person);

    void delete(int id);
}
