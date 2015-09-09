package io.github.shoma2da.android_youtube_data_api_client.api;

import android.support.annotation.NonNull;

/**
 * Created by shoma2da on 15/09/06.
 */
public class SearchResultList {

    @NonNull private int mTotalResults;

    public SearchResultList() {
        this(0);
    }

    public SearchResultList(int totalResults) {
        mTotalResults = totalResults;
    }

    public int getTotalResults() {
        return mTotalResults;
    }

}
