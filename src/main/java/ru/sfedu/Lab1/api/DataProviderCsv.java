package ru.sfedu.Lab1.api;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Lab1.model.beans.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static ru.sfedu.Lab1.Constants.*;
import static ru.sfedu.Lab1.model.beans.Status.COMPLEATE;
import static ru.sfedu.Lab1.model.beans.Status.FAIL;
import static ru.sfedu.Lab1.model.beans.Status.IS_EXISTS;
import static ru.sfedu.Lab1.model.beans.Status.NOT_FOUND;
import static ru.sfedu.Lab1.utils.ConfigurationUtil.getConfigurationEntry;

public class DataProviderCsv extends IDataprovider {


    private static final Logger loger = LogManager.getLogger(DataProviderCsv.class);

    @Override
    public Result<Producer> appendProducer(Producer obj) {
        if (getProducerById(obj.getId()).isPresent()) {
            return new Result<>(obj, IS_EXISTS);
        }
        return new Result<>(obj, execute(PRODUCER_CSV_KEY, Collections.singletonList(obj), true));
    }


    @Override
    public Optional<Producer> getProducerById(Long id) {
        return getAll(Producer.class, PRODUCER_CSV_KEY).stream().filter(o -> o.getId().equals(id)).findFirst();
    }

    @Override
    public Status deleteProducerById(Long id) {
        return execute(PRODUCER_CSV_KEY, getAll(Producer.class, PRODUCER_CSV_KEY).stream().
                filter(o -> !o.getId().equals(id)).collect(Collectors.toList()), false);
    }

    @Override
    public Result<Producer> updProducer(Producer obj) {
        return new Result<>(obj, execute(PRODUCER_CSV_KEY, getAll(Producer.class, PRODUCER_CSV_KEY).stream()
                .map(o -> o.getId().equals(obj.getId()) ? obj : o)
                .collect(Collectors.toList()), false));
    }

    @Override
    public Result<Product> appendProduct(Product obj) {
        //if (getProductById(obj.getId()).isPresent()) return new Result<>(obj, IS_EXISTS);
        return new Result<>(obj, execute(PRODUCT_CSV_KEY, Collections.singletonList(obj), true));
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return getAll(Product.class, PRODUCT_CSV_KEY).stream().filter(o -> o.getId().equals(id)).findFirst();
    }


    @Override
    public Result<ClientManager> createClientManager(ClientManager obj) {
        return new Result<>(obj, execute(CLIENT_MANAGER_CSV_KEY, Collections.singletonList(obj), true));
    }

    @Override
    public Optional<ClientManager> getClientManagerById(Long id) {
        return getAll(ClientManager.class, CLIENT_MANAGER_CSV_KEY).stream().filter(o -> o.getId().equals(id)).findFirst();
    }


    @Override
    public Result<ProductManager> createProductManager(ProductManager obj) {
        //if (getManagerByTypeAndId(PRODUCT, obj.getId()).isPresent()) return new Result<>(obj, IS_EXISTS);
        return new Result<>(obj, execute(PRODUCT_MANAGER_CSV_KEY, Collections.singletonList(obj), true));
    }

    @Override
    public Result<Customer> createCustomer(Customer obj) {
        //if (getCustomerById(obj.getId()).isPresent()) return new Result<>(obj, IS_EXISTS);
        return new Result<>(obj, execute(CUSTOMER_CSV_KEY, Collections.singletonList(obj), true));
    }
    @Override
    public Optional<Customer> getCustomerById(Long id) {
        return getAll(Customer.class, CUSTOMER_CSV_KEY).stream().filter(o -> o.getId().equals(id)).findFirst();
    }

    @Override
    public Result<Order> createOrder(Order obj) {
        return new Result<>(obj, execute(ORDER_CSV_KEY, Collections.singletonList(obj), true));
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return getAll(Order.class, ORDER_CSV_KEY).stream().filter(o -> o.getId().equals(id)).findFirst();
    }


    public <T> Status execute(String key, List<T> obj, Boolean append) {
        FileWriter fileWriter;
        CSVWriter csvWriter;
        try {
            fileWriter = new FileWriter(getConfigurationEntry(key), append);
            csvWriter = new CSVWriter(fileWriter);

            new StatefulBeanToCsvBuilder<T>(csvWriter).build().write(obj);
            csvWriter.close();
            fileWriter.close();

            return COMPLEATE;
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
            loger.error(e);
            return FAIL;
        } catch (IOException e) {
            loger.error(e);
            return NOT_FOUND;
        }
    }


    public <T> List<T> getAll(Class<T> clazz, String key) {
        List<T> result = new ArrayList<>();
        CSVReader csvReader;
        FileReader fileReader;
        try {
            fileReader = new FileReader(getConfigurationEntry(key));
            csvReader = new CSVReader(fileReader);

            CsvToBean<T> csvToBean = new CsvToBeanBuilder<T>(csvReader)
                    .withType(clazz)
                    .build();
            result = csvToBean.parse();

            csvReader.close();
            fileReader.close();
        } catch (Exception e) {
            loger.error(e);
        }
        return result;
    }
}
