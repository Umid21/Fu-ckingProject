package ru.sfedu.Lab1.model.beans;


import org.simpleframework.xml.Root;

@Root(name = "ProductManager")

public class ProductManager extends Manager{

    public ProductManager() {
    }

    public ProductManager(Integer experience, String address) {
        super(experience, address);
    }

    public ProductManager(long id, String firstName, String lastName, Integer experience, String address) {
        super(id, firstName, lastName, experience, address);
    }
}
