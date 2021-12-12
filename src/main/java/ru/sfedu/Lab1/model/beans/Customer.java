package ru.sfedu.Lab1.model.beans;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

@Root(name = "Customer")
public class Customer extends Person {

    @Attribute
    @CsvBindByPosition(position = 3)
    private String address;
    @Attribute
    @CsvBindByPosition(position = 4)
    private String email;

    public Customer () { };

    public Customer(String address, String email) {
        this.address = address;
        this.email = email;
    }

    public Customer(long id, String firstName, String lastName, String address, String email) {
        super(id, firstName, lastName);
        this.address = address;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                '}';
    }
}
