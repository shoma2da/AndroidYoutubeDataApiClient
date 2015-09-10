package io.github.shoma2da.android_youtube_data_api_client.api;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by shoma2da on 15/09/06.
 */
public class SearchResultListParser {

    public SearchResultList parse(JSONObject json) throws JSONException {
        return parse(json, new SearchResultItemParser());
    }

    public SearchResultList parse(JSONObject json, SearchResultItemParser parser) throws JSONException {
        int totalResults = json.getJSONObject("pageInfo").getInt("totalResults");
        JSONArray items = json.getJSONArray("items");

        ArrayList<SearchResultItem> list = new ArrayList<>();
        for (int i = 0; i < items.length(); i++) {
            SearchResultItem item = parser.parse(items.getJSONObject(i));
            if (item != null) {
                list.add(item);
            }
        }

        return new SearchResultList(totalResults, list);
    }

}
