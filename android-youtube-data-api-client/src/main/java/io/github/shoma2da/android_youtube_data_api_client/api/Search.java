package io.github.shoma2da.android_youtube_data_api_client.api;

import android.support.annotation.NonNull;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by shoma2da on 15/09/06.
 */
public class Search {

    @NonNull
    public SearchResultList searh() throws IOException {
        //OkHttpClient client = new OkHttpClient();
        //Request request = new Request.Builder().
        //        url("https://www.googleapis.com/youtube/v3/search?key=AIzaSyABfaHO105BgqO9SX73U0pN0rPe3S9Ra2s&q=%E3%81%BE%E3%82%8C&part=snippet&maxResults=50&order=relevance").
        //        build();
        //Response response = client.newCall(request).execute();
        return new SearchResultList();
    }

}
