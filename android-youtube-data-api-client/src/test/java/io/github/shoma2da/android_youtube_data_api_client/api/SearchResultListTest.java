package io.github.shoma2da.android_youtube_data_api_client.api;

import static junit.framework.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by shoma2da on 15/09/06.
 */
public class SearchResultListTest {

    @Test
    public void CreateObject() {
        SearchResultList list = new SearchResultList();
        assertNotNull(list);
    }

    @Test
    public void GetTotalResults() {
        SearchResultList list = new SearchResultList(3, new ArrayList<SearchResultItem>());
        assertEquals(3, list.getTotalResults());
    }

    @Test
    public void GetItemCount() {
        ArrayList<SearchResultItem> items = new ArrayList<>();
        items.add(new SearchResultItem());
        items.add(new SearchResultItem());
        items.add(new SearchResultItem());

        SearchResultList list = new SearchResultList(0, items);
        assertEquals(3, list.itemSize());
    }

}
