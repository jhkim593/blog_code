package com.kjh.querydsl.test;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;

public class RequestTextConverter implements AttributeConverter<Request.RequestText, String> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Request.RequestText requestDto) {
        if (requestDto != null) {
            try {
                return objectMapper.writeValueAsString(requestDto);
            } catch (JsonProcessingException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public Request.RequestText convertToEntityAttribute(String str) {
        if (str != null) {
            try {
                return objectMapper.readValue(str, new TypeReference<Request.RequestText>() {});
            } catch (JsonProcessingException jpe) {
                return null;
            }
        } else {
            return null;
        }
    }
}

