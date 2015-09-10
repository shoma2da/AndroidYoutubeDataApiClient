package io.github.shoma2da.android_youtube_data_api_client.api;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by shoma2da on 15/09/06.
 */
public class Search {

    public static final String URL_BASE = "https://www.googleapis.com/youtube/v3/search?key=%s&q=%s&part=snippet&maxResults=50&order=relevance";

    @NonNull
    public SearchResultList search(String apiKey, String word) throws IOException, JSONException {
        String url = buildUrl(apiKey, word);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().
                url(url).
                build();
        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            String jsonString = response.body().string();
            JSONObject json = new JSONObject(jsonString);
            return new SearchResultListParser().parse(json);
        } else {
            throw new RuntimeException("Failed to access api. Please confirm your parameter such as api key.");
        }
    }

    @VisibleForTesting
    public String buildUrl(String apiKey, String word) {
        return String.format(Locale.JAPAN, URL_BASE, apiKey, word);
    }

}
