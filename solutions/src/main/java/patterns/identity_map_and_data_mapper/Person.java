package patterns.identity_map_and_data_mapper;

import java.util.Objects;

public class Person {
    private int personalId;
    private String name;
    private String phone;


    /*
    *   CONSTRUCTORS
    */

    public Person() {
    }

    public Person(int personalId, String name, String phone) {
        this.personalId = personalId;
        this.name = name;
        this.phone = phone;
    }

    /*
    * GETTERS AND SETTERS
     */

    public int getPersonalId() {
        return personalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personalId == person.personalId && Objects.equals(name, person.name) && Objects.equals(phone, person.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalId, name, phone);
    }

    @Override
    public String toString() {
        return "{" +
                "Id = " + personalId +
                ", name = '" + name + '\'' +
                ", phone = '" + phone + '\'' +
                '}';
    }
}
