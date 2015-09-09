package io.github.shoma2da.android_youtube_data_api_client.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by shoma2da on 15/09/06.
 */
public class SearchResultListParser {

    public SearchResultList parse(JSONObject json) throws JSONException {
        int totalResults = json.getJSONObject("pageInfo").getInt("totalResults");
        return new SearchResultList(totalResults);
    }

}
