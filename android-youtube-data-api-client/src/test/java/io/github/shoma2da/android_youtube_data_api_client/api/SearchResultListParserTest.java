package io.github.shoma2da.android_youtube_data_api_client.api;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import io.github.shoma2da.android_youtube_data_api_client.BuildConfig;

import static junit.framework.Assert.*;

/**
 * Created by shoma2da on 15/09/06.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 18)
public class SearchResultListParserTest {

    @Test
    public void CreateObject() {
        assertNotNull(new SearchResultListParser());
    }

    @Test
    public void Parse() throws JSONException {
        JSONObject json = new JSONObject("{ \"pageInfo\": { \"totalResults\": 3 } }");
        assertNotNull(new SearchResultListParser().parse(json));
    }

    @Test
    public void CannotParse() {
        try {
            JSONObject json = new JSONObject("{}");
            new SearchResultListParser().parse(json);
            fail();
        } catch (JSONException e) {
            assertTrue(true);
        }
    }

}
