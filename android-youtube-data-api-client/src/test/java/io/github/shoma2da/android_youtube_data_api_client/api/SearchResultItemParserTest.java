package io.github.shoma2da.android_youtube_data_api_client.api;

import static junit.framework.Assert.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import io.github.shoma2da.android_youtube_data_api_client.BuildConfig;

/**
 * Created by shoma2da on 15/09/09.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 18)
public class SearchResultItemParserTest {
    
    @Test
    public void CreateObject() {
        assertNotNull(new SearchResultItemParser());
    }

    @Test
    public void Parse() throws JSONException {
        JSONObject jsonObject = new JSONObject("{" +
                " 'id' : { 'videoId' : 'hogeid' }, " +
                " 'snippet' : {" +
                    "'title' : 'hogeTitle', " +
                    " 'description' : 'hogeDescription', " +
                    " 'thumbnails' : { 'default' : { 'url' : 'http://www.yahoo.co.jp/' } } " +
                "}" +
            "}");
        SearchResultItemParser parser = new SearchResultItemParser();
        assertNotNull(parser.parse(jsonObject));
    }

    @Test
    public void CannotParse() throws JSONException {
        JSONObject emptyJson = new JSONObject("{}");
        SearchResultItemParser parser = new SearchResultItemParser();
        assertNull(parser.parse(emptyJson));
    }
}
