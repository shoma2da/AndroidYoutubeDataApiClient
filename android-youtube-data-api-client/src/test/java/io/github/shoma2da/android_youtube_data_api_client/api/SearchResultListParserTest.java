package io.github.shoma2da.android_youtube_data_api_client.api;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import io.github.shoma2da.android_youtube_data_api_client.BuildConfig;

import static junit.framework.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by shoma2da on 15/09/06.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 18)
public class SearchResultListParserTest {

    private SearchResultItemParser mMockParser;

    @Before
    public void setUp() throws JSONException {
        mMockParser = mock(SearchResultItemParser.class);
    }

    @Test
    public void CreateObject() {
        assertNotNull(new SearchResultListParser());
    }

    @Test
    public void Parse() throws JSONException {
        JSONObject json = new JSONObject("{" +
                    "\"pageInfo\": {" +
                        "\"totalResults\": 3" +
                    "}," +
                    "\"items\": []" +
                "}");
        SearchResultList list = new SearchResultListParser().parse(json, mMockParser);
        assertNotNull(list);
    }

    @Test
    public void ParseAndTestResultCount() throws JSONException {
        JSONObject json = new JSONObject("{" +
                "\"pageInfo\": {" +
                "\"totalResults\": 3" +
                "}," +
                "\"items\": []" +
                "}");
        SearchResultList list = new SearchResultListParser().parse(json, mMockParser);
        assertEquals(3, list.getTotalResults());
    }

    @Test
    public void ParseAndTestItemSize() throws JSONException {
        JSONObject json = new JSONObject("{" +
                "\"pageInfo\": {" +
                "\"totalResults\": 0" +
                "}," +
                "\"items\": [{}, {}, {}]" +
                "}");
        when(mMockParser.parse((JSONObject)anyObject())).thenReturn(new SearchResultItem());
        SearchResultList list = new SearchResultListParser().parse(json, mMockParser);
        assertEquals(3, list.itemSize());
    }

    @Test
    public void CannotParseItem() throws JSONException {
        JSONObject json = new JSONObject("{" +
                "\"pageInfo\": {" +
                "\"totalResults\": 0" +
                "}," +
                "\"items\": [{}, {}, {}]" +
                "}");
        when(mMockParser.parse((JSONObject)anyObject())).thenReturn(null);
        SearchResultList list = new SearchResultListParser().parse(json, mMockParser);
        assertEquals(0, list.itemSize());
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
