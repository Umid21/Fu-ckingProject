package ru.sfedu.Lab1.model.beans;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;

import java.io.Serializable;
import java.util.Objects;

public class Producer {

    @Attribute
    @CsvBindByPosition(position = 0)
    private Long id;
    @Attribute
    @CsvBindByPosition(position = 1)
    private String name;
    @Attribute
    @CsvBindByPosition(position = 2)
    private String lastname;
    @Attribute
    @CsvBindByPosition(position = 3)
    private String address;


    public Producer() {
    }

    ;

    public Producer(Long id, String name, String lastname, String address) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producer producer = (Producer) o;
        return Objects.equals(id, producer.id) && Objects.equals(name, producer.name) && Objects.equals(lastname, producer.lastname) && Objects.equals(address, producer.address);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastname, address);
    }

    @Override
    public String toString() {
        return "Producer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
