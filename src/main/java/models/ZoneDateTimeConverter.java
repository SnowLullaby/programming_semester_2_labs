package models;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;


import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ZoneDateTimeConverter extends AbstractBeanField<ZonedDateTime, String> {
    @Override
    protected Object convert(String value) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss X");
            return ZonedDateTime.parse(value, formatter);
        } catch (RuntimeException e) {
            return "";
        }
    }

}
