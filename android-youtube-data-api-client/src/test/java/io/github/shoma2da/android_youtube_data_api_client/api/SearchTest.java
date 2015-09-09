package io.github.shoma2da.android_youtube_data_api_client.api;

import android.support.annotation.NonNull;

import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.*;

/**
 * Created by shoma2da on 15/09/06.
 */
public class SearchTest {

    @Test
    public void CreateObject() {
        Search search = new Search();
        assertNotNull(search);
    }

    @Test
    public void searchMethod() throws IOException {
        Search search = new Search();
        assertNotNull(search.searh());
    }

}
