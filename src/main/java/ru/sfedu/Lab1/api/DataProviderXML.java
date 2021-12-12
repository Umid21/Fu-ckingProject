package ru.sfedu.Lab1.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import ru.sfedu.Lab1.model.beans.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.sfedu.Lab1.Constants.*;
import static ru.sfedu.Lab1.model.beans.Status.*;
import static ru.sfedu.Lab1.utils.ConfigurationUtil.getConfigurationEntry;

public class DataProviderXML extends IDataprovider {

    private static final Logger loger = LogManager.getLogger(DataProviderCsv.class);

    @Override
    public Result<Producer> appendProducer(Producer obj) {
        final String method = new Throwable().getStackTrace()[0].getMethodName();
        if (getProducerById(obj.getId()).isPresent())
            return new Result<>(obj, IS_EXISTS);
        return new Result<>(obj, execute(PRODUCER_XML_KEY, join(getAll(Producer.class, PRODUCER_XML_KEY), obj)));
    }

    @Override
    public Optional<Producer> getProducerById(Long id) {
        return getAll(Producer.class, PRODUCER_XML_KEY).
                stream().filter(o -> o.getId().equals(id)).findFirst();
    }

    @Override
    public Status deleteProducerById(Long id) {
        return execute(PRODUCER_XML_KEY, getAll(Producer.class, PRODUCER_XML_KEY).
                stream().filter(o -> !o.getId().equals(id)).collect(Collectors.toList()));
    }

    @Override
    public Result<Producer> updProducer(Producer obj) {
        return new Result<>(obj, execute(PRODUCER_XML_KEY, getAll(Producer.class, PRODUCER_XML_KEY).
                stream().map(o -> o.getId().equals(obj.getId()) ? obj: o).
                collect(Collectors.toList())));
    }

    public Result<Product> appendProduct(Product obj) {
        return null;
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return getAll(Product.class, PRODUCT_CSV_KEY).stream().filter(o -> o.getId().equals(id)).findFirst();
    }

    @Override
    public Result<ClientManager> createClientManager(ClientManager obj) {
        return null;
    }

    @Override
    public Optional<ClientManager> getClientManagerById(Long id) {
        return getAll(ClientManager.class, CLIENT_MANAGER_CSV_KEY).stream().filter(o -> o.getId().equals(id)).findFirst();
    }

    @Override
    public Result<ProductManager> createProductManager(ProductManager obj) {
        return null;
    }

    public Result<Customer> createCustomer(Customer obj) {return null;}

    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return getAll(Customer.class, CUSTOMER_CSV_KEY).stream().filter(o -> o.getId().equals(id)).findFirst();
    }

    @Override
    public Result<Order> createOrder(Order obj) {
        return null;
    }
    @Override
    public Optional<Order> getOrderById(Long id) {
        return getAll(Order.class, ORDER_CSV_KEY).stream().filter(o -> o.getId().equals(id)).findFirst();
    }


    private <T> Status execute(String key, List<T> obj) {
        FileWriter writer;
        Serializer serializer;
        try {
            writer = new FileWriter(getConfigurationEntry(key));
            serializer = new Persister();

            WrapperXML<T> wrapperXML = new WrapperXML<>(obj);
            serializer.write(wrapperXML, writer);

            return COMPLEATE;
        } catch (Exception exception) {
            loger.error(exception);
            return FAIL;
        }
    }
    private <T> List<T> getAll(Class<T> clazz, String key) {
        Reader reader;
        Serializer serializer;
        try {
            reader = new FileReader(getConfigurationEntry(key));
            serializer = new Persister();

            WrapperXML<T> wrapperXML = serializer.read(WrapperXML.class, reader);
            return (List<T>) wrapperXML.getCollection();
        } catch (Exception exception) {
            loger.error(exception);
        }
        return new ArrayList<>();
    }
    private <T> List<T> join(List<T> list, T obj) {
        list.add(obj);
        return list;
    }
}
