package ru.sfedu.Lab1.model.beans;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;

public class Person {
    @Attribute
    @CsvBindByPosition(position = 0)
    protected long id;
    @Attribute
    @CsvBindByPosition(position = 1)
    protected String FirstName;
    @Attribute
    @CsvBindByPosition(position = 2)
    protected String LastName;


    public Person () { };

    public Person(long id, String firstName, String lastName) {
        this.id = id;
        FirstName = firstName;
        LastName = lastName;

    }

    /**
     * Set the value of id
     * @param newVar the new value of id
     */
    public void setId (Long newVar) {
        id = newVar;
    }

    /**
     * Get the value of id
     * @return the value of id
     */
    public Long getId () {
        return id;
    }

    /**
     * Set the value of firstName
     * @param newVar the new value of firstName
     */
    public void setFirstName (String newVar) {
        FirstName = newVar;
    }

    /**
     * Get the value of firstName
     * @return the value of firstName
     */
    public String getFirstName () {
        return FirstName;
    }

    /**
     * Set the value of lastName
     * @param newVar the new value of lastName
     */
    public void setLastName (String newVar) {
        LastName = newVar;
    }

    /**
     * Get the value of lastName
     * @return the value of lastName
     */
    public String getLastName () {
        return LastName;
    }

}
