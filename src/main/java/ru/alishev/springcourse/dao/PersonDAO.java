package ru.alishev.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;
@Component
public class PersonDAO {
private static int people_count;
    private List<Person>people;

    {
        people=new ArrayList<>();

        people.add(new Person(++people_count,"Tom"));
        people.add(new Person(++people_count,"Bob"));
        people.add(new Person(++people_count,"Mike"));
        people.add(new Person(++people_count,"John"));

    }

    public List<Person> index(){

        return people;
    }
    public Person show (int id){

        return people.stream().filter(person->person.getId()==id)
                .findAny().orElse(null);
    }

    public void save (Person person){
        person.setId(++people_count);
        people.add(person);
    }

    public void update (int id, Person updatePerson){

        Person personToBeUpdated=show(id);
        personToBeUpdated.setName(updatePerson.getName());


    }
    public void delete (int id){

        people.removeIf(p->p.getId()==id);
    }
}
