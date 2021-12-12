package ru.sfedu.Lab1.api;

import junit.framework.TestCase;

import org.junit.Test;
import ru.sfedu.Lab1.model.beans.ClientManager;
import ru.sfedu.Lab1.model.beans.Producer;
import ru.sfedu.Lab1.model.beans.Status;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static ru.sfedu.Lab1.Entity.*;

public class DataProviderCsvTest extends TestCase {

    IDataprovider provider = new DataProviderCsv();
    @Test
    public void testAppendProducer(){
        assertNotEquals(provider.deleteProducerById(producer.getId()), Status.NOT_FOUND);

        assertFalse(provider.getProducerById(producer.getId()).isPresent());

        assertNotEquals(provider.updProducer(UpdProducer).getStatus(), Status.FAIL);

        assertEquals(provider.appendProducer(producer).getStatus(), Status.COMPLEATE);
        assertNotEquals(provider.appendProducer(producer).getStatus(), Status.COMPLEATE);

        assertTrue(provider.getProducerById(producer.getId()).isPresent());

        assertEquals(provider.updProducer(UpdProducer).getStatus(), Status.COMPLEATE);

        assertEquals(provider.deleteProducerById(producer.getId()), Status.COMPLEATE);





    }
    @Test
    public void testAppendProduct() {
        //assertEquals(provider.appendProducer(producer).getStatus(), Status.COMPLEATE);
        assertEquals(provider.appendProduct(product).getStatus(), Status.COMPLEATE);
    }

    @Test
    public void testAddClientManager() {
        assertEquals(provider.createClientManager(clientmanager).getStatus(), Status.COMPLEATE);
        //assertNotEquals(provider.createClientManager(cm).getStatus(), Status.COMPLEATE);
        //assertEquals(provider.delManagerByTypeAndId(ManagerType.CLIENT, cm.getId()), Status.COMPLETE);
    }

    @Test
    public void testAddProductManager() {
        assertEquals(provider.createProductManager(productmanager).getStatus(), Status.COMPLEATE);

    }

    @Test
    public void testAddCustomer() {
        assertEquals(provider.createCustomer(customer).getStatus(), Status.COMPLEATE);
        //assertNotEquals(provider.createCustomer(customer).getStatus(), Status.COMPLEATE);
        //assertEquals(provider.delCustomerById(customer.getId()), Status.COMPLETE);
    }

    @Test
    public void testCreateOrder() {

        assertEquals(provider.createOrder(order).getStatus(), Status.COMPLEATE);
        //assertNotEquals(provider.createOrder(order).getStatus(), Status.COMPLETE);

    }

    @Test
    public void testDeleteProducer(){

        assertNotEquals(provider.deleteProducerById(producer.getId()), Status.NOT_FOUND);
        assertEquals(provider.deleteProducerById(producer.getId()), Status.COMPLEATE);


    }
    @Test
    public void testGetProducerById(){
        assertFalse(provider.getProducerById(producer.getId()).isPresent());
        assertTrue(provider.getProducerById(producer.getId()).isPresent());


    }
    public void testUpdProducer(){

        assertEquals(provider.updProducer(UpdProducer).getStatus(), Status.COMPLEATE);
        //assertNotEquals(provider.updProducer(UpdProducer).getStatus(), Status.FAIL);


    }




}