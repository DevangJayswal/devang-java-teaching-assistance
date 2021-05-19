package com.example.daoInterfaceImplementation;

import com.example.connection.ConnectionFactory;
//import static connection.ConnectionFactory.getConnection;
import com.example.daoInterface.PersonDAO;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
import com.example.model.Person;

public class PersonDAOImplementation implements PersonDAO {

    Connection connection;

    // Constructor
    public PersonDAOImplementation() throws ClassNotFoundException {
        this.connection = ConnectionFactory.getConnection();

    }

    @Override
    // Create a new Person 
    public void create(Person person) {

        PreparedStatement preparedStatement;
        try {

            preparedStatement = connection.prepareStatement("INSERT INTO person (id, name) VALUES (? , ? ) ");
            preparedStatement.setInt(1, person.getId());
            preparedStatement.setString(2, person.getName());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("One row inserted");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    //  find  All  Persons 
    public List<Person> findAll() {
        List<Person> persons = new ArrayList<>();
        Person person = null;
        ResultSet resultSet;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM person");

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                persons.add(person);
            }
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return persons;
    }

    @Override
    public Person findById(int id) {
        Person person = null;
        ResultSet resultSet = null;

        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM person where id= ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        try {
            resultSet.next();
            person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            resultSet.close();
            preparedStatement.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return person;
    }
}
