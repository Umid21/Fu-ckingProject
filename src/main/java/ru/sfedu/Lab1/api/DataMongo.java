package ru.sfedu.Lab1.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ru.sfedu.Lab1.model.beans.History;
import ru.sfedu.Lab1.model.beans.Producer;
import ru.sfedu.Lab1.model.beans.Result;
import ru.sfedu.Lab1.model.beans.Status;

import java.io.IOException;
import java.util.Optional;

import static ru.sfedu.Lab1.Constants.*;
import static ru.sfedu.Lab1.utils.ConfigurationUtil.getConfigurationEntry;

public abstract class DataMongo {
    public void saveToLog(History object) throws IOException {
        MongoClient client = MongoClients.create(getConfigurationEntry(MONGO_URL));
        MongoDatabase database = client.getDatabase(getConfigurationEntry(MONGO_DB));
        MongoCollection<Document> collection = database.getCollection(getConfigurationEntry(MONGO_COLLECTION));
        Document document = Document.parse(objectToJSON(object));
        collection.insertOne(document);
    }

    public abstract Result<Producer> appendProducer(Producer obj);

    public abstract Optional<Producer> getProducerById(Long id);

    public abstract Status deleteProducerById(Long id);

    public abstract Result<Producer> updProducer(Producer obj);

    private String objectToJSON(History object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }
}
