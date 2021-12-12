package ru.sfedu.Lab1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.Lab1.api.DataMongo;
import ru.sfedu.Lab1.api.DataProviderJDBC;
import ru.sfedu.Lab1.model.beans.Producer;

import java.io.IOException;

import static ru.sfedu.Lab1.Constants.CONST2;
import static ru.sfedu.Lab1.utils.ConfigurationUtil.getConfigurationEntry;

public class Main_L1 {


    private static Logger log = LogManager.getLogger(Main_L1.class);

    public static final Producer producer = new Producer(1L, "Maria","Krikovskaya", "Jmaylova 15");
    public static final Producer UpdProducer = new Producer(1L, "Mariam","Krikovskaya", "Jmaylova 15");

    public static void main(String []args) throws IOException {

//        DataMongo dataMongo = new DataProviderJDBC();
//        dataMongo.appendProducer(producer);
//        dataMongo.getProducerById(1L);
//        dataMongo.updProducer(UpdProducer);
//        dataMongo.deleteProducerById(1L);

        log.debug(Constants.CONST);
        log.debug(getConfigurationEntry(CONST2));
        log.debug("Main[0]: starting application.........");
    }

    public void logBasicSystemInfo() {

        log.info("Launching the application...");
        log.info("Operating System: " + System.getProperty("os.name") + " " + System.getProperty("os.version"));
        log.info("JRE: " + System.getProperty("java.version"));
        log.info("Java Launched From: " + System.getProperty("java.home"));
        log.info("Class Path: " + System.getProperty("java.class.path"));
        log.info("Library Path: " + System.getProperty("java.library.path"));
        log.info("User Home Directory: " + System.getProperty("user.home"));
        log.info("User Working Directory: " + System.getProperty("user.dir"));
        log.info("Test INFO logging.");
    }

}
