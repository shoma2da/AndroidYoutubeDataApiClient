package io.github.shoma2da.android_youtube_data_api_client.api;

import android.net.Uri;

import static junit.framework.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import io.github.shoma2da.android_youtube_data_api_client.BuildConfig;

/**
 * Created by shoma2da on 15/09/06.
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 18)
public class SearchResultItemTest {

    @Test
    public void CreateObject() {
        SearchResultItem item = new SearchResultItem();
        assertNotNull(item);
    }

    @Test
    public void GetId() {
        SearchResultItem item = new SearchResultItem("id", null, null, null);
        assertEquals("id", item.getId());
    }

    @Test
    public void GetTitle() {
        SearchResultItem item = new SearchResultItem(null, "title", null, null);
        assertEquals("title", item.getTitle());
    }

    @Test
    public void GetDescription() {
        SearchResultItem item = new SearchResultItem(null, null, "description", null);
        assertEquals("description", item.getDescription());
    }

    @Test
    public void GetThumbnailUri() {
        Uri uri = Uri.parse("http://yahoo.co.jp");
        SearchResultItem item = new SearchResultItem(null, null, null, uri);
        assertEquals("http://yahoo.co.jp", item.getThumbnailUri().toString());
    }

}
