package io.github.shoma2da.android_youtube_data_api_client.api;

import android.net.Uri;

/**
 * Created by shoma2da on 15/09/06.
 */
public class SearchResultItem {

    private String mId;
    private String mTitle;
    private String mDescription;
    private Uri mThumbnailUrl;

    public SearchResultItem() {}

    public SearchResultItem(String id, String title, String description, Uri thumbnailUri) {
        mId = id;
        mTitle = title;
        mDescription = description;
        mThumbnailUrl = thumbnailUri;
    }

    public String getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public Uri getThumbnailUri() {
        return mThumbnailUrl;
    }

}
