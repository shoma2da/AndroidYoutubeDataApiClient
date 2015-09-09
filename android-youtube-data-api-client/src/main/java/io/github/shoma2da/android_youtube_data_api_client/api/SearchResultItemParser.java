package io.github.shoma2da.android_youtube_data_api_client.api;

import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by shoma2da on 15/09/09.
 */
public class SearchResultItemParser {

    public SearchResultItem parse(JSONObject json) throws JSONException {
        String id = json.getJSONObject("id").getString("videoId");

        JSONObject snippetJson = json.getJSONObject("snippet");
        String title = snippetJson.getString("title");
        String description = snippetJson.getString("description");
        Uri thumbnailUri = Uri.parse(snippetJson.getJSONObject("thumbnails").getJSONObject("default").getString("url"));

        return new SearchResultItem(id, title, description, thumbnailUri);
    }

}
