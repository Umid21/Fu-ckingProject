package ru.sfedu.Lab1;

import ru.sfedu.Lab1.model.beans.*;

public class Entity {
    public static final Producer producer = new Producer(3L, "Maria","Krikovskaya", "Jmaylova 15");
    public static final Producer UpdProducer = new Producer(1L, "Mariam","Krikovskaya", "Jmaylova 15");
    public static final Customer customer = new Customer(1L, "Isakov", "Umid", "Zorge21", "email@mail.ru");
    public static final ClientManager clientmanager = new ClientManager(1L, "Ramz","Ramazanov", 5, "Chust");
    public static final ProductManager productmanager = new ProductManager(1L, "Umid","Isakov", 21, "Eron");
    public static final Product product = new Product(1L, producer, "Milk", 44);
    public static final Order order = new Order(1L, product, customer,clientmanager);
}
