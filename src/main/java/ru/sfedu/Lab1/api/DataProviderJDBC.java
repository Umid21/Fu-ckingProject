package ru.sfedu.Lab1.api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Lab1.model.beans.*;

import java.io.IOException;
import java.sql.*;
import java.util.*;
import java.util.Date;

import static ru.sfedu.Lab1.Constants.*;
import static ru.sfedu.Lab1.model.beans.Status.FAIL;
import static ru.sfedu.Lab1.model.beans.Status.IS_EXISTS;
import static ru.sfedu.Lab1.utils.ConfigurationUtil.getConfigurationEntry;

public class DataProviderJDBC extends IDataprovider {
    private static final Logger loger = LogManager.getLogger(DataProviderJDBC.class);

    @Override
    public Result<Producer> appendProducer(Producer obj) {
        final String method = new Throwable().getStackTrace()[0].getMethodName();
        if (getProducerById(obj.getId()).isPresent()) return new Result<>(obj, IS_EXISTS);
        return new Result<>(obj, execute(String.
                format(PRODUCER_INSERT, obj.getId(), obj.getName(),  obj.getLastname(), obj.getAddress()), method));
    }

    @Override
    public Optional<Producer> getProducerById(Long id) {
        return getAllProducer().stream().filter(o -> o.getId().equals(id)).findFirst();
    }

    @Override
    public Status deleteProducerById(Long id)  {
        final String method = new Throwable().getStackTrace()[0].getMethodName();
        return execute(String.format(PRODUCER_DELETE, id), method);
    }

    @Override
    public Result<Producer> updProducer(Producer obj) {
        final String method = new Throwable().getStackTrace()[0].getMethodName();
        return new Result<>(obj, execute(String.format(PRODUCER_UPDATE, obj.getName(),obj.getLastname(), obj.getAddress(), obj.getId()),method));
    }
    public Result<Product> appendProduct(Product obj) {
        return null;
    }
    @Override
    public Optional<Product> getProductById(Long id) {
        return null;
    }

    @Override
    public Result<ClientManager> createClientManager(ClientManager obj) {
        return null;
    }

    @Override
    public Optional<ClientManager> getClientManagerById(Long id) {
        return null;
    }
    @Override
    public Result<ProductManager> createProductManager(ProductManager obj) {
        return null;
    }

    public Result<Customer> createCustomer(Customer obj) {return null;}

    @Override
    public Optional<Customer> getCustomerById(Long id) {
       return null;
    }
    @Override
    public Result<Order> createOrder(Order obj) {
        return null;
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
       return null;
    }


    private List<Producer> getAllProducer() {
        List<Producer> producers = new ArrayList<>();
        final String method = new Throwable().getStackTrace()[0].getMethodName();
        ResultSet rs = select(PRODUCER_SELECT, method);
        try {
            while (rs != null && rs.next()) {
                producers.add(new Producer(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (Exception exception) {
            loger.error(exception);
        }
        return producers;
    }


    private Status execute(String sql, String method) {
        try {
            Statement statement = init().createStatement();
            statement.executeUpdate(sql);
            init().close();
            saveToLog(new History(new Date(), method, sql));
            return Status.COMPLEATE;
        } catch (Exception exception) {
            loger.error(exception);
            return FAIL;
        }
    }

    private ResultSet select(String sql , String method) {
        try {
            PreparedStatement preparedStatement = init().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            init().close();
            saveToLog(new History(new Date(), method, sql));
            return resultSet;
        } catch (Exception exception) {
            loger.error(exception);
            return null;
        }
    }

    private Connection init() throws IOException, SQLException, ClassNotFoundException {
        Class.forName(getConfigurationEntry(JDBC_DRIVER));
        Connection connection = DriverManager.getConnection(
                getConfigurationEntry(JDBC_URL),
                getConfigurationEntry(JDBC_USER),
                getConfigurationEntry(JDBC_PASSWORD)
        );
        connection.setAutoCommit(true);
        return connection;
    }
}
