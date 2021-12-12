package ru.sfedu.Lab1;

public class Constants {

    public static final int CONST=25;
    public static final String CONST2 = "AA";
    public static final String PRODUCER_CSV_KEY = "csvProducer";
    public static final String PRODUCT_CSV_KEY = "csvProduct";
    //public static final String MANAGER_CSV_KEY = "csvMANAGER";
    public static final String CLIENT_MANAGER_CSV_KEY = "csvClientManager";
    public static final String PRODUCT_MANAGER_CSV_KEY = "csvProductManager";
    public static final String CUSTOMER_CSV_KEY = "csvCustomer";
    public static final String ORDER_CSV_KEY = "csvOrder";
    public static final String SYS_ENV_KEY = "env";
    public static final String DEFAULT_CONFIG_PATH = "./src/main/resources/enviroment.properties";
    public static final String PRODUCER_XML_KEY = "xmlProducer";



    public static final String RESULT_STATUS = "Status: %s";
    public static final String NPE_EXCEPTION = "%s is not %d";
    public static final String MANAGER_CSV_FORMAT = "%s_%d";
    public static final String JDBC_DRIVER = "jdbcDriver";
    public static final String JDBC_URL = "jdbcUrl";
    public static final String JDBC_USER = "jdbcUser";
    public static final String JDBC_PASSWORD = "jdbcPassword";

    public static final String MONGO_URL = "mongoUrl";
    public static final String MONGO_DB = "mongoDb";
    public static final String MONGO_COLLECTION = "mongoCollection";








    //SQL
    public static final String PRODUCER_DELETE = "delete from producer where id=%d";
    public static final String PRODUCER_INSERT = "insert into producer values (%d, '%s', '%s', '%s');";
    public static final String PRODUCER_SELECT = "select * from producer;";
    public static final String PRODUCER_UPDATE = "update producer set name='%s', lastname='%s', address='%s' where id=%d";
}
