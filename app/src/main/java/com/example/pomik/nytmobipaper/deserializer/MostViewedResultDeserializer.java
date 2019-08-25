package com.example.pomik.nytmobipaper.deserializer;

import com.example.pomik.nytmobipaper.model.retrofit.Medium;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewedResult;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MostViewedResultDeserializer implements JsonDeserializer<MostViewedResult> {
    @Override
    public MostViewedResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        final String url = jsonObject.get("url").getAsString();
        final String adxKeywords = jsonObject.get("adx_keywords").getAsString();;
        final String column = jsonObject.get("column").isJsonNull()?null:jsonObject.get("column").toString();
        final String section = jsonObject.get("section").getAsString();
        final String byline = jsonObject.get("byline").getAsString();
        final String type = jsonObject.get("type").getAsString();
        final String title = jsonObject.get("title").getAsString();
        final String _abstract = jsonObject.get("abstract").getAsString();
        final String publishedDate = jsonObject.get("published_date").getAsString();
        final String source = jsonObject.get("source").getAsString();
        final Long id = jsonObject.get("id").getAsLong();
        final Long assetId = jsonObject.get("asset_id").getAsLong();
        final Integer views = jsonObject.get("views").getAsInt();

        JsonArray jsonArray;

        // def_facet
        if(!jsonObject.get("des_facet").isJsonArray())
            jsonArray = new JsonArray();
        else
            jsonArray = jsonObject.get("des_facet").getAsJsonArray();

        final List<String> desFacet = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            final JsonElement jsonTemp = jsonArray.get(i);
            desFacet.add(jsonTemp.getAsString());
        }

        // org_facet
        if(!jsonObject.get("org_facet").isJsonArray())
            jsonArray = new JsonArray();
        else
            jsonArray = jsonObject.get("org_facet").getAsJsonArray();

        final List<String> orgFacet = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            final JsonElement jsonTemp = jsonArray.get(i);
            orgFacet.add(jsonTemp.getAsString());
        }


        // per_facet
        if(!jsonObject.get("per_facet").isJsonArray())
            jsonArray = new JsonArray();
        else
            jsonArray = jsonObject.get("per_facet").getAsJsonArray();

        final List<String> perFacet = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            final JsonElement jsonTemp = jsonArray.get(i);
            perFacet.add(jsonTemp.getAsString());
        }


        // geo_facet
        if(!jsonObject.get("geo_facet").isJsonArray())
            jsonArray = new JsonArray();
        else
            jsonArray = jsonObject.get("geo_facet").getAsJsonArray();

        final List<String> geoFacet = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            final JsonElement jsonTemp = jsonArray.get(i);
            geoFacet.add(jsonTemp.getAsString());
        }

        Medium[] medium = context.deserialize(jsonObject.get("media"),Medium[].class);

        final String uri = jsonObject.get("uri").getAsString();

        final MostViewedResult mostViewedResult = new MostViewedResult();
        mostViewedResult.setUrl(url);
        mostViewedResult.setAdxKeywords(adxKeywords);
        mostViewedResult.setColumn(column);
        mostViewedResult.setSection(section);
        mostViewedResult.setByline(byline);
        mostViewedResult.setType(type);
        mostViewedResult.setTitle(title);
        mostViewedResult.setAbstract(_abstract);
        mostViewedResult.setPublishedDate(publishedDate);
        mostViewedResult.setSource(source);
        mostViewedResult.setId(id);
        mostViewedResult.setAssetId(assetId);
        mostViewedResult.setViews(views);

        mostViewedResult.setDesFacet(desFacet);
        mostViewedResult.setOrgFacet(orgFacet);
        mostViewedResult.setPerFacet(perFacet);
        mostViewedResult.setGeoFacet(geoFacet);

        mostViewedResult.setMedia(new ArrayList<Medium>(Arrays.asList(medium)));
        mostViewedResult.setUri(uri);

        return mostViewedResult;
    }
}
