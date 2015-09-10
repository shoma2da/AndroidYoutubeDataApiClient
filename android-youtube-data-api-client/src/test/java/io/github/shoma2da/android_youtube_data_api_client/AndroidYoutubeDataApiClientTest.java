package io.github.shoma2da.android_youtube_data_api_client;

import org.json.JSONException;

import java.io.IOException;

import io.github.shoma2da.android_youtube_data_api_client.api.Search;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by shoma2da on 15/09/09.
 */
public class AndroidYoutubeDataApiClientTest {

    public void SetApiKey() {
        AndroidYoutubeDataApiClient.setApiKey("hoge");
        assertEquals("hoge", AndroidYoutubeDataApiClient.mApiKey);
    }

    public void InitialDebugIsFalse() {
        assertFalse(AndroidYoutubeDataApiClient.mDebug);
    }

    public void ChangeDebugMode() {
        AndroidYoutubeDataApiClient.setDebug(true);
        assertTrue(AndroidYoutubeDataApiClient.mDebug);
    }
    public void Search() throws IOException, JSONException {
        AndroidYoutubeDataApiClient.setApiKey("hoge");
        AndroidYoutubeDataApiClient.search(mock(Search.class), "");
    }

    public void SearchWithNoApiKey() throws IOException, JSONException {
        try {
            AndroidYoutubeDataApiClient.search(mock(Search.class), "");
            fail();
        } catch (RuntimeException e) {
            assertTrue(true);
        }
    }

}
