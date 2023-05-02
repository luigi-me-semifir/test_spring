package com.example.gestiondatespring.config;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;
/**
 * JacksonConfiguration class to configure the date format for the JSON serialization and deserialization.
 */
@Configuration
public class JacksonConfiguration {
    /**
     * Jackson2ObjectMapperBuilderCustomizer
     * @return
     */
    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {

        return builder -> {
            /**
             * https://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html
             */
            // formatter
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            /**
             * https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-spring-mvc-jackson-custom
             */
            // deserializers
            builder.deserializers(new LocalDateDeserializer(dateFormatter));
            builder.deserializers(new LocalDateTimeDeserializer(dateTimeFormatter));
            /**
             * https://docs.spring.io/spring-boot/docs/current/reference/html/howto.html#howto-spring-mvc-jackson-custom
             */
            // serializers
            builder.serializers(new LocalDateSerializer(dateFormatter));
            builder.serializers(new LocalDateTimeSerializer(dateTimeFormatter));
        };
    }

}
