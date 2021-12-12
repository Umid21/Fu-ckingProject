package ru.sfedu.Lab1.model.beans;


import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvCustomBindByPosition;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "Product")
public class Product {

    @Attribute
    @CsvBindByPosition(position = 0)
    private Long id;
    @Element
    @CsvCustomBindByPosition(position = 1, converter = ProducerConv.class)
    private Producer producer;
    @Attribute
    @CsvBindByPosition(position = 2)
    private String name;
    @Attribute
    @CsvBindByPosition(position = 3)
    private Integer price;

    public Product () { };

    public Product(Long id, String name, Integer price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product(Long id, Producer producer, String name, Integer price) {
        this.id = id;
        this.producer = producer;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", producer=" + producer +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
