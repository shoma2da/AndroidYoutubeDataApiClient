package io.github.shoma2da.android_youtube_data_api_client;

import android.support.annotation.VisibleForTesting;
import android.support.annotation.WorkerThread;
import android.util.Log;

import org.json.JSONException;

import java.io.IOException;

import io.github.shoma2da.android_youtube_data_api_client.api.Search;
import io.github.shoma2da.android_youtube_data_api_client.api.SearchResultList;

/**
 * Created by shoma2da on 15/09/09.
 */
public class AndroidYoutubeDataApiClient {

    @VisibleForTesting static String mApiKey;
    @VisibleForTesting static Boolean mDebug = false;

    public static void setApiKey(String apiKey) {
        mApiKey = apiKey;
    }

    public static void setDebug(boolean debug) {
        mDebug = debug;
    }

    @VisibleForTesting
    public static SearchResultList search(String word) throws IOException, JSONException {
        return search(new Search(), word);
    }

    @WorkerThread
    static SearchResultList search(Search search, String word) throws IOException, JSONException {
        if (mApiKey.isEmpty()) {
            throw new RuntimeException("Please set ApiKey with AndroidYoutubeDataApiClient#setApiKey");
        }
        if (mDebug) {
            Log.d(AndroidYoutubeDataApiClient.class.getName(), "[ACCESS] " + search.buildUrl(mApiKey, word));
        }
        return search.search(mApiKey, word);
    }

}
