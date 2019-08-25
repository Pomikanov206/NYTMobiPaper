package com.example.pomik.nytmobipaper.deserializer;

import com.example.pomik.nytmobipaper.model.retrofit.Medium;
import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailedResult;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Add method TEST param

public class MostEmailedResultDeserializer implements JsonDeserializer<MostEmailedResult> {
    @Override
    public MostEmailedResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        final JsonObject jsonObject = json.getAsJsonObject();

        final String url = jsonObject.get("url").getAsString();
        final String adxKeywords = jsonObject.get("adx_keywords").getAsString();
        final String subsection = jsonObject.get("subsection").getAsString();
        final Integer emailCount = jsonObject.get("email_count").getAsInt();
        final String countType = jsonObject.get("count_type").getAsString();
        final String column = jsonObject.get("column").isJsonNull()?null:jsonObject.get("column").toString();
        final Integer etaId = jsonObject.get("eta_id").getAsInt();
        final String section = jsonObject.get("section").getAsString();
        final Long id = jsonObject.get("id").getAsLong();
        final Long assetId = jsonObject.get("asset_id").getAsLong();
        final String nytdsection = jsonObject.get("nytdsection").getAsString();
        final String byline = jsonObject.get("byline").getAsString();
        final String type = jsonObject.get("type").getAsString();
        final String title = jsonObject.get("title").getAsString();
        final String _abstract = jsonObject.get("abstract").getAsString();
        final String publishedDate = jsonObject.get("published_date").getAsString();
        final String source = jsonObject.get("source").getAsString();
        final String updated = jsonObject.get("updated").getAsString();

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

        final MostEmailedResult mostEmailedResult = new MostEmailedResult();
        mostEmailedResult.setUrl(url);
        mostEmailedResult.setAdxKeywords(adxKeywords);
        mostEmailedResult.setSubsection(subsection);
        mostEmailedResult.setEmailCount(emailCount);
        mostEmailedResult.setCountType(countType);
        mostEmailedResult.setColumn(column);
        mostEmailedResult.setEtaId(etaId);
        mostEmailedResult.setSection(section);
        mostEmailedResult.setId(id);
        mostEmailedResult.setAssetId(assetId);
        mostEmailedResult.setNytdsection(nytdsection);
        mostEmailedResult.setByline(byline);
        mostEmailedResult.setType(type);
        mostEmailedResult.setTitle(title);
        mostEmailedResult.setAbstract(_abstract);
        mostEmailedResult.setPublishedDate(publishedDate);
        mostEmailedResult.setSource(source);
        mostEmailedResult.setUpdated(updated);

        mostEmailedResult.setDesFacet(desFacet);
        mostEmailedResult.setOrgFacet(orgFacet);
        mostEmailedResult.setPerFacet(perFacet);
        mostEmailedResult.setGeoFacet(geoFacet);

        mostEmailedResult.setMedia(new ArrayList<Medium>(Arrays.asList(medium)));
        mostEmailedResult.setUri(uri);

        return mostEmailedResult;
    }
}
