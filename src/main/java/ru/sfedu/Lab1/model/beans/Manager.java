package ru.sfedu.Lab1.model.beans;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;

public class Manager extends Person {

    @Attribute
    @CsvBindByPosition(position = 3)
    protected Integer experience;
    @Attribute
    @CsvBindByPosition(position = 4)
    protected String Address;


    public Manager () { };

    public Manager(Integer experience, String address) {
        this.experience = experience;
        this.Address = address;
    }

    public Manager(long id, String firstName, String lastName, Integer experience, String address) {
        super(id, firstName, lastName);
        this.experience = experience;
        this.Address = address;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "experience=" + experience +
                ", Address='" + Address + '\'' +
                ", id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
}
