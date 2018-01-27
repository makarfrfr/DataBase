package wrapper.model.person;

import wrapper.model.enums.PersonType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Person {
    PersonType personType;

    String name;

    String middleName;

    String lastName;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Person(PersonType personType, String name, String midName, String lastName){
        this.personType = personType;
        this.name = name;
        this.middleName = midName;
        this.lastName = lastName;
    }

    public PersonType getPersonType() {
        return personType;
    }
}
