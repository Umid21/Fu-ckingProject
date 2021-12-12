package ru.sfedu.Lab1.model.beans;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.ArrayList;
import java.util.List;

@Root(name = "Container")
public class WrapperXML<T> {
    @ElementList(inline = true, required = false)
    private List<T> collection;

    public WrapperXML() {
    }

    public WrapperXML(List<T> collection) {
        this.collection = collection;
    }

    public List<T> getCollection() {
        if (collection == null) return new ArrayList<>();
        return collection;
    }
}
