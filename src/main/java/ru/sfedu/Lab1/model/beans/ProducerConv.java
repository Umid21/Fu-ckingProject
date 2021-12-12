package ru.sfedu.Lab1.model.beans;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import ru.sfedu.Lab1.api.DataProviderCsv;


import static ru.sfedu.Lab1.Constants.NPE_EXCEPTION;

public class ProducerConv extends AbstractBeanField<Producer, Long> {

    @Override
    protected Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        return new DataProviderCsv().getProducerById(Long.parseLong(s)).orElseThrow(() -> {
            throw new NullPointerException(String.format(NPE_EXCEPTION, Producer.class.getName(), Long.parseLong(s)));
        });
    }

    @Override
    protected String convertToWrite(Object value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        return super.convertToWrite(((Producer) value).getName());
    }
}

