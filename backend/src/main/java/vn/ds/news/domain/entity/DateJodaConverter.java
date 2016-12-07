package vn.ds.news.domain.entity;

import java.sql.Timestamp;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.joda.time.DateTime;

@Converter
public class DateJodaConverter implements AttributeConverter<DateTime, Timestamp> {

    @Override
    public Timestamp convertToDatabaseColumn(DateTime attribute) {
        if (attribute == null) {
            return null;
        }
        return new Timestamp(attribute.getMillis());
    }

    @Override
    public DateTime convertToEntityAttribute(Timestamp dbData) {
        if (dbData == null) {
            return null;
        }
        return new DateTime(dbData.getTime());
    }

}
