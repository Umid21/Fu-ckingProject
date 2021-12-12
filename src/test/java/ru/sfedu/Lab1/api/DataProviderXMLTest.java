package ru.sfedu.Lab1.api;

import junit.framework.TestCase;
import org.junit.Test;
import ru.sfedu.Lab1.model.beans.Status;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static ru.sfedu.Lab1.Entity.UpdProducer;
import static ru.sfedu.Lab1.Entity.producer;

public class DataProviderXMLTest extends TestCase {

    IDataprovider provider = new DataProviderXML();

    @Test
    public void  testAppendProducer() {
        assertEquals(provider.appendProducer(producer).getStatus(), Status.COMPLEATE);
        //assertNotEquals(provider.appendProducer(producer).getStatus(), Status.COMPLEATE);

    }
    @Test
    public void testGetProducerById(){
        //assertFalse(provider.getProducerById(producer.getId()).isPresent());
         assertTrue(provider.getProducerById(producer.getId()).isPresent());

    }

    @Test
    public void testDeleteProducer(){

        assertEquals(provider.deleteProducerById(producer.getId()), Status.COMPLEATE);
        //assertNotEquals(provider.deleteProducerById(producer.getId()), Status.NOT_FOUND);
    }

    public void testUpdProducer(){

        assertEquals(provider.updProducer(UpdProducer).getStatus(), Status.COMPLEATE);
        assertNotEquals(provider.updProducer(UpdProducer).getStatus(), Status.FAIL);

    }





}