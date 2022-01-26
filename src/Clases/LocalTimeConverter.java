package Clases;

import java.sql.Date;
import java.time.*;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalTimeConverter implements AttributeConverter<LocalTime, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalTime localTime) {
        java.util.Date date1 = java.sql.Timestamp.valueOf(localTime.atDate(LocalDate.now()));
        java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
        return sqlDate;
    }

    @Override
    public LocalTime convertToEntityAttribute(Date sqlDate) {
        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
        LocalTime time = LocalDateTime.ofInstant(utilDate.toInstant(), ZoneId.systemDefault()).toLocalTime();
        return time;
    }

}
