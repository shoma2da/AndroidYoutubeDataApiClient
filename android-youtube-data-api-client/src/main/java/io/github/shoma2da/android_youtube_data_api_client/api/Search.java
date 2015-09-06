package io.github.shoma2da.android_youtube_data_api_client.api;

import android.support.annotation.NonNull;

/**
 * Created by shoma2da on 15/09/06.
 */
public class Search {

    public void searh(Callback callback) {
        callback.onFinish(new SearchResultList());
    }

    public interface Callback {
        void onFinish(@NonNull SearchResultList list);
    }

}
