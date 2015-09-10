package io.github.shoma2da.android_youtube_data_api_client.api;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by shoma2da on 15/09/06.
 */
public class SearchResultList implements Iterable<SearchResultItem> {

    @NonNull private int mTotalResults;
    @NonNull private List<SearchResultItem> mItems;

    public SearchResultList() {
        this(0, new ArrayList<SearchResultItem>());
    }

    public SearchResultList(int totalResults, ArrayList<SearchResultItem> searchResultItems) {
        mTotalResults = totalResults;
        mItems = new ArrayList<>(searchResultItems);
    }

    public int getTotalResults() {
        return mTotalResults;
    }

    public int itemSize() {
        return mItems.size();
    }

    @Override
    public Iterator<SearchResultItem> iterator() {
        return mItems.iterator();
    }
}
