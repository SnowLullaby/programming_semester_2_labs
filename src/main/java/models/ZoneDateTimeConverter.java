package models;

import com.opencsv.bean.AbstractBeanField;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 *  Converter for open CSV to bean reader
 *  @author Ekaterina Vavilina
 *  @see Person#setCreationDate(ZonedDateTime)
 */
public class ZoneDateTimeConverter extends AbstractBeanField<ZonedDateTime, String> {
    /**
     * Convert ZonedDateTime for bean reader
     * @return Object
     */
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
