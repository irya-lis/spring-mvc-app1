package ru.irya_lis.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.irya_lis.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int PEOPLE_COUNT;

    List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Tom", 22, "tom@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Bob", 73, "bob@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Mike", 43, "mike@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Katy", 29, "katy@mail.ru"));
    }


    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
       return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }


    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
