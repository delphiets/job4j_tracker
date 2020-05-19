package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public  ArrayList<Person> find(String key) {
        Predicate<Person> combineName = person ->  person.getName().equals(key);
        Predicate<Person> combineSurname = person -> person.getSurname().equals(key);
        Predicate<Person> combinePhone = person -> person.getPhone().equals(key);
        Predicate<Person> combineAddress = person -> person.getAddress().equals(key);
        Predicate<Person> combine =  combineName.or(combineSurname).or(combinePhone).or(combineAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
