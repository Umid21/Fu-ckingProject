package ru.sfedu.Lab1.api;

import junit.framework.TestCase;
import org.junit.Test;
import ru.sfedu.Lab1.model.beans.Status;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static ru.sfedu.Lab1.Entity.UpdProducer;
import static ru.sfedu.Lab1.Entity.producer;

public class DataProviderJDBCTest extends TestCase {
    IDataprovider provider = new DataProviderJDBC();
    @Test
    public void testAppendProducer() {
      //assertEquals(provider.appendProducer(producer).getStatus(), Status.COMPLEATE);
        //assertNotEquals(provider.appendProducer(producer).getStatus(), Status.COMPLEATE);
       // assertEquals(provider.deleteProducerById(producer.getId()), Status.COMPLEATE);
       // assertEquals(provider.updProducer(UpdProducer).getStatus(), Status.COMPLEATE);
//      assertNotEquals(provider.updProducer(UpdProducer).getStatus(), Status.FAIL);


        assertNotEquals(provider.deleteProducerById(producer.getId()), Status.NOT_FOUND);

        assertFalse(provider.getProducerById(producer.getId()).isPresent());

        assertNotEquals(provider.updProducer(UpdProducer).getStatus(), Status.FAIL);

        assertEquals(provider.appendProducer(producer).getStatus(), Status.COMPLEATE);
        assertNotEquals(provider.appendProducer(producer).getStatus(), Status.COMPLEATE);

        assertTrue(provider.getProducerById(producer.getId()).isPresent());

        assertEquals(provider.updProducer(UpdProducer).getStatus(), Status.COMPLEATE);

        assertEquals(provider.deleteProducerById(producer.getId()), Status.COMPLEATE);



    }

}