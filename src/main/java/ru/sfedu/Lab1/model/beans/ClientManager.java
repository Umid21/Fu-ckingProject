package ru.sfedu.Lab1.model.beans;

import org.simpleframework.xml.Root;

@Root(name = "ClientManager")
public class ClientManager extends Manager {

    public ClientManager () { }

    public ClientManager(Integer experience, String address) {
        super(experience, address);
    }

    public ClientManager(long id, String firstName, String lastName, Integer experience, String address) {
        super(id, firstName, lastName, experience, address);
    }



}
