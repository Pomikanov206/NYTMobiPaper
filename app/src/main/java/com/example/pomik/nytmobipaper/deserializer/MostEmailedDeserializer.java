package com.example.pomik.nytmobipaper.deserializer;

import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailed;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class MostEmailedDeserializer implements JsonDeserializer<MostEmailed> {
    @Override
    public MostEmailed deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return null;
    }
}
