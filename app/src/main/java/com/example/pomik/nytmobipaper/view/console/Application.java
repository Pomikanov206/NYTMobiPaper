package com.example.pomik.nytmobipaper.view.console;

import com.example.pomik.nytmobipaper.model.retrofit.MediaMetadatum;
import com.example.pomik.nytmobipaper.model.retrofit.Medium;
import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailed;
import com.example.pomik.nytmobipaper.model.retrofit.mostemailed.MostEmailedResult;
import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostShared;
import com.example.pomik.nytmobipaper.model.retrofit.mostshared.MostSharedResult;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewed;
import com.example.pomik.nytmobipaper.model.retrofit.mostviewed.MostViewedResult;
import com.example.pomik.nytmobipaper.presenter.ConsolePresenter;

public class Application implements ConsoleView{
    public static void main(String[] args) {
        Application application = new Application();
        ConsolePresenter presenter = new ConsolePresenter(application);

        presenter.requestMostEmailed();
        presenter.requestMostShared();
        presenter.requestMostViewed();
    }

    @Override
    public void showMostEmailed(MostEmailed mostEmailed) {
        StringBuilder builder = new StringBuilder();
        builder.append("Copyrigh: ").append(mostEmailed.getCopyright()).append("\n");
        builder.append("num result: ").append(mostEmailed.getNumResults()).append("\n");
        builder.append("status:").append(mostEmailed.getStatus()).append("\n");

        builder.append("-----------------------------------------------------").append('\n');

        for (MostEmailedResult result:
             mostEmailed.getResults()) {
            builder.append("url:").append(result.getUrl()).append("\n");
            builder.append("adx_keywords: ").append(result.getAdxKeywords()).append("\n");
            builder.append("subsection: ").append(result.getSubsection()).append("\n");
            builder.append("email_count: ").append(result.getEmailCount()).append("\n");
            builder.append("count_type: ").append(result.getCountType()).append("\n");
            builder.append("column: ").append(result.getColumn()).append("\n");
            builder.append("eta_id: ").append(result.getEtaId()).append("\n");
            builder.append("section: ").append(result.getSection()).append("\n");
            builder.append("id: ").append(result.getId()).append("\n");
            builder.append("asset_id: ").append(result.getAssetId()).append("\n");
            builder.append("nytdsection: ").append(result.getNytdsection()).append("\n");
            builder.append("byline: ").append(result.getByline()).append("\n");
            builder.append("type: ").append(result.getType()).append("\n");
            builder.append("title: ").append(result.getTitle()).append("\n");
            builder.append("abstract: ").append(result.getAbstract()).append("\n");
            builder.append("published_date: ").append(result.getPublishedDate()).append("\n");
            builder.append("source: ").append(result.getSource()).append("\n");
            builder.append("updated: ").append(result.getUpdated()).append("\n");

            builder.append("des_facet: ").append("\n");
            for (String data:
                 result.getDesFacet()) {
               builder.append('-').append(data).append(',');
            }
            builder.append('\n');

            builder.append("org_facet: ").append("\n");
            for (String data:
                 result.getOrgFacet()) {
               builder.append('-').append(data).append(',');
            }
            builder.append('\n');

            builder.append("per_facet: ").append("\n");
            for (String data:
                 result.getPerFacet()) {
               builder.append('-').append(data).append(',');
            }
            builder.append('\n');

            builder.append("geo_facet: ").append("\n");
            for (String data:
                 result.getGeoFacet()) {
               builder.append('-').append(data).append(',');
            }
            builder.append('\n');

            builder.append("media: ").append("\n");

            for (Medium medium:
                 result.getMedia()) {
                builder.append('\t').append('-').append("type: ").append(medium.getType()).append('\n');
                builder.append('\t').append('-').append("subtype: ").append(medium.getSubtype()).append('\n');
                builder.append('\t').append('-').append("caption: ").append(medium.getCaption()).append('\n');
                builder.append('\t').append('-').append("copyright: ").append(medium.getCopyright()).append('\n');
                builder.append('\t').append('-').append("approved_for_syndication: ").append(medium.getApprovedForSyndication()).append('\n');
                builder.append('\t').append('-').append("media-metadata: ").append('\n');

                for (MediaMetadatum mediaMetadatum:
                     medium.getMediaMetadata()) {
                    builder.append('\t').append("    -").append("url: ").append(mediaMetadatum.getUrl()).append('\n');
                    builder.append('\t').append("    -").append("format: ").append(mediaMetadatum.getFormat()).append('\n');
                    builder.append('\t').append("    -").append("height: ").append(mediaMetadatum.getHeight()).append('\n');
                    builder.append('\t').append("    -").append("width: ").append(mediaMetadatum.getWidth()).append('\n');
                }
            }
        }

        System.out.println(builder.toString());
        System.out.println("END");
    }

    @Override
    public void showMostShared(MostShared mostShared) {
        StringBuilder builder = new StringBuilder();
        builder.append("Copyrigh: ").append(mostShared.getCopyright()).append("\n");
        builder.append("num result: ").append(mostShared.getNumResults()).append("\n");
        builder.append("status:").append(mostShared.getStatus()).append("\n");

        builder.append("-----------------------------------------------------").append('\n');

        for (MostSharedResult result:
                mostShared.getResults()) {
            builder.append("url:").append(result.getUrl()).append("\n");
            builder.append("adx_keywords: ").append(result.getAdxKeywords()).append("\n");
            builder.append("subsection: ").append(result.getSubsection()).append("\n");
            builder.append("count_type: ").append(result.getCountType()).append("\n");
            builder.append("column: ").append(result.getColumn()).append("\n");
            builder.append("eta_id: ").append(result.getEtaId()).append("\n");
            builder.append("section: ").append(result.getSection()).append("\n");
            builder.append("id: ").append(result.getId()).append("\n");
            builder.append("asset_id: ").append(result.getAssetId()).append("\n");
            builder.append("nytdsection: ").append(result.getNytdsection()).append("\n");
            builder.append("byline: ").append(result.getByline()).append("\n");
            builder.append("type: ").append(result.getType()).append("\n");
            builder.append("title: ").append(result.getTitle()).append("\n");
            builder.append("abstract: ").append(result.getAbstract()).append("\n");
            builder.append("published_date: ").append(result.getPublishedDate()).append("\n");
            builder.append("source: ").append(result.getSource()).append("\n");
            builder.append("updated: ").append(result.getUpdated()).append("\n");

            builder.append("des_facet: ").append("\n");
            for (String data:
                    result.getDesFacet()) {
                builder.append('-').append(data).append(',');
            }
            builder.append('\n');

            builder.append("org_facet: ").append("\n");
            for (String data:
                    result.getOrgFacet()) {
                builder.append('-').append(data).append(',');
            }
            builder.append('\n');

            builder.append("per_facet: ").append("\n");
            for (String data:
                    result.getPerFacet()) {
                builder.append('-').append(data).append(',');
            }
            builder.append('\n');

            builder.append("geo_facet: ").append("\n");
            for (String data:
                    result.getGeoFacet()) {
                builder.append('-').append(data).append(',');
            }
            builder.append('\n');

            builder.append("media: ").append("\n");

            for (Medium medium:
                    result.getMedia()) {
                builder.append('\t').append('-').append("type: ").append(medium.getType()).append('\n');
                builder.append('\t').append('-').append("subtype: ").append(medium.getSubtype()).append('\n');
                builder.append('\t').append('-').append("caption: ").append(medium.getCaption()).append('\n');
                builder.append('\t').append('-').append("copyright: ").append(medium.getCopyright()).append('\n');
                builder.append('\t').append('-').append("approved_for_syndication: ").append(medium.getApprovedForSyndication()).append('\n');
                builder.append('\t').append('-').append("media-metadata: ").append('\n');

                for (MediaMetadatum mediaMetadatum:
                        medium.getMediaMetadata()) {
                    builder.append('\t').append("    -").append("url: ").append(mediaMetadatum.getUrl()).append('\n');
                    builder.append('\t').append("    -").append("format: ").append(mediaMetadatum.getFormat()).append('\n');
                    builder.append('\t').append("    -").append("height: ").append(mediaMetadatum.getHeight()).append('\n');
                    builder.append('\t').append("    -").append("width: ").append(mediaMetadatum.getWidth()).append('\n');
                }
            }
        }

        System.out.println(builder.toString());
        System.out.println("END");
    }

    @Override
    public void showMostViewed(MostViewed mostViewed) {
        StringBuilder builder = new StringBuilder();
        builder.append("Copyrigh: ").append(mostViewed.getCopyright()).append("\n");
        builder.append("num result: ").append(mostViewed.getNumResults()).append("\n");
        builder.append("status:").append(mostViewed.getStatus()).append("\n");

        builder.append("-----------------------------------------------------").append('\n');

        for (MostViewedResult result:
                mostViewed.getResults()) {
            builder.append("url:").append(result.getUrl()).append("\n");
            builder.append("adx_keywords: ").append(result.getAdxKeywords()).append("\n");
            builder.append("column: ").append(result.getColumn()).append("\n");
            builder.append("section: ").append(result.getSection()).append("\n");
            builder.append("byline: ").append(result.getByline()).append("\n");
            builder.append("type: ").append(result.getType()).append("\n");
            builder.append("title: ").append(result.getTitle()).append("\n");
            builder.append("abstract: ").append(result.getAbstract()).append("\n");
            builder.append("published_date: ").append(result.getPublishedDate()).append("\n");
            builder.append("source: ").append(result.getSource()).append("\n");
            builder.append("id: ").append(result.getId()).append("\n");
            builder.append("asset_id: ").append(result.getAssetId()).append("\n");
            builder.append("views: ").append(result.getViews()).append("\n");


            builder.append("des_facet: ").append("\n");
            for (String data:
                    result.getDesFacet()) {
                builder.append('-').append(data).append(',');
            }
            builder.append('\n');

            builder.append("org_facet: ").append("\n");
            for (String data:
                    result.getOrgFacet()) {
                builder.append('-').append(data).append(',');
            }
            builder.append('\n');

            builder.append("per_facet: ").append("\n");
            for (String data:
                    result.getPerFacet()) {
                builder.append('-').append(data).append(',');
            }
            builder.append('\n');

            builder.append("geo_facet: ").append("\n");
            for (String data:
                    result.getGeoFacet()) {
                builder.append('-').append(data).append(',');
            }
            builder.append('\n');

            builder.append("media: ").append("\n");

            for (Medium medium:
                    result.getMedia()) {
                builder.append('\t').append('-').append("type: ").append(medium.getType()).append('\n');
                builder.append('\t').append('-').append("subtype: ").append(medium.getSubtype()).append('\n');
                builder.append('\t').append('-').append("caption: ").append(medium.getCaption()).append('\n');
                builder.append('\t').append('-').append("copyright: ").append(medium.getCopyright()).append('\n');
                builder.append('\t').append('-').append("approved_for_syndication: ").append(medium.getApprovedForSyndication()).append('\n');
                builder.append('\t').append('-').append("media-metadata: ").append('\n');

                for (MediaMetadatum mediaMetadatum:
                        medium.getMediaMetadata()) {
                    builder.append('\t').append("    -").append("url: ").append(mediaMetadatum.getUrl()).append('\n');
                    builder.append('\t').append("    -").append("format: ").append(mediaMetadatum.getFormat()).append('\n');
                    builder.append('\t').append("    -").append("height: ").append(mediaMetadatum.getHeight()).append('\n');
                    builder.append('\t').append("    -").append("width: ").append(mediaMetadatum.getWidth()).append('\n');
                }
            }
        }

        System.out.println(builder.toString());
        System.out.println("END");
    }
}
