package com.example;

import com.example.daoInterfaceImplementation.PersonDAOImplementation;
import com.example.model.Person;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

    public static void main(String[] args) throws ClassNotFoundException {

        PersonDAOImplementation personDAOImplementation = new PersonDAOImplementation();
        List<Person> personList = new ArrayList<Person>();

        //  1. insert person
//        Person person = new Person();
//        person.setId(1);
//        person.setName("Devang");
//        personDAOImplementation.create(person);

        // 2. find all person
//        personList = personDAOImplementation.findAll();
//        System.out.println(personList);
        // using loop to iterate person list
//        for (int i = 0; i < personList.size(); i++) {
//            System.out.println(personList.get(i));
//        }

        // 3. find person By id
        Person personById =  personDAOImplementation.findById(3);
        System.out.println(personById.getId());
        System.out.println(personById.getName());

    }

}
