package ru.sfedu.Lab1.model.beans;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import ru.sfedu.Lab1.api.DataProviderCsv;

import static ru.sfedu.Lab1.Constants.NPE_EXCEPTION;
//import static ru.sfedu.Lab1.Constants.*;

public class ClientManagerConv extends AbstractBeanField<ClientManager, String> {
    @Override
    protected Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        return new DataProviderCsv().getClientManagerById(Long.parseLong(s)).orElseThrow(() -> {
            throw new NullPointerException(String.format(NPE_EXCEPTION, ClientManager.class.getName(), Long.parseLong(s)));
        });
    }

    @Override
    protected String convertToWrite(Object value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        return super.convertToWrite(((ClientManager) value).getId());
    }
}