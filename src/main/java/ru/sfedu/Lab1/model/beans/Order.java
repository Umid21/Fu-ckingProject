package ru.sfedu.Lab1.model.beans;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Order")
public class Order {
    @Attribute
    @CsvBindByPosition(position = 0)
    private Long id;
    @Element
    @CsvCustomBindByPosition(position = 1, converter = ProductConv.class)
    private Product product;
    @Element
    @CsvCustomBindByPosition(position = 2, converter = CustomerConv.class)
    private Customer customer;
    @Element
    @CsvCustomBindByPosition(position = 3, converter = ClientManagerConv.class)
    private ClientManager clientmanager;

    public Order () { };

    public Order(Long id) {
        this.id = id;
    }

    public Order(Long id, Product product, Customer customer, ClientManager clientmanager) {
        this.id = id;
        this.product = product;
        this.customer = customer;
        this.clientmanager = clientmanager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ClientManager getClientmanager() {
        return clientmanager;
    }

    public void setClientmanager(ClientManager clientmanager) {
        this.clientmanager = clientmanager;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", product=" + product +
                ", customer=" + customer +
                ", clientmanager=" + clientmanager +
                '}';
    }
}
