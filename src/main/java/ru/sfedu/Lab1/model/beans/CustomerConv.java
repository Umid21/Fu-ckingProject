package ru.sfedu.Lab1.model.beans;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import ru.sfedu.Lab1.api.DataProviderCsv;

import static ru.sfedu.Lab1.Constants.NPE_EXCEPTION;

public class CustomerConv extends AbstractBeanField<Customer, String> {
    @Override
    protected Object convert(String s) throws CsvDataTypeMismatchException, CsvConstraintViolationException {
        return new DataProviderCsv().getCustomerById(Long.parseLong(s)).orElseThrow(() -> {
            throw new NullPointerException(String.format(NPE_EXCEPTION, Customer.class.getName(), Long.parseLong(s)));
        });
    }

    @Override
    protected String convertToWrite(Object value) throws CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
        return super.convertToWrite(((Customer) value).getId());
    }
}
