package com.asyncapi.example.generateasyncapipojos;


import com.asyncapi.example.generateasyncapipojos.internal.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

//As it is a simple test, no need to use @SpringBootTest
public class GenerateAsyncApiIT {


    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void verifyAsyncAPIGeneratedModels() throws JsonProcessingException {

        //If we want to work with LocalDate + LocalDateTime
        objectMapper.registerModule(new JavaTimeModule());

        //Internal Models
        User user = new User("123", "Username", Boolean.TRUE, LocalDate.now(), null);
        User user2 = new User("1234", "Username2", Boolean.TRUE, LocalDate.now(), null);


        //Verify that they can be parsed into generated Async API Models
        String userJSONFromInternalModel = objectMapper.writeValueAsString(user);
        String user2JSONFromInternalModel = objectMapper.writeValueAsString(user2);

        //Conversion should be OK!
        objectMapper.readValue(userJSONFromInternalModel, com.asyncapi.model.User.class);
        objectMapper.readValue(user2JSONFromInternalModel, com.asyncapi.model.User.class);

    }

}
