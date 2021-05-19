package com.example.daoInterface;

import com.example.model.Person;
import java.util.List;

public interface PersonDAO {

    void create(Person p);

    List<Person> findAll();
        Person findById(int id);
}
