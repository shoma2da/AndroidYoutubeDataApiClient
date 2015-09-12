[![Build Status](https://travis-ci.org/shoma2da/AndroidYoutubeDataApiClient.svg)](https://travis-ci.org/shoma2da/AndroidYoutubeDataApiClient)
[![Coverage Status](https://coveralls.io/repos/shoma2da/AndroidYoutubeDataApiClient/badge.svg?branch=master&service=github)](https://coveralls.io/github/shoma2da/AndroidYoutubeDataApiClient?branch=master)

# AndroidYoutubeDataApiClient

Simple client for YouTube Data API (v3) on Android.

# Download

In your `build.gradle` :

```
compile 'com.hatenablog.shoma2da.android:android-youtube-data-api-client:0.0.1'
```

# How to use it

In your `Application` class (or first `Activity`) :

```java
public class ExampleApplication extends Application {
    @Override public void onCreate() {
       super.onCreate();
       AndroidYoutubeDataApiClient.setApiKey(YOUR_GOOGLE_API_KEY);
    }
}
```

## Search

You can search videos by word :

```java
SearchResultList list = AndroidYoutubeDataApiClient.search(SEARCH_WORD); //Caution! Please run it on worker thread.
for (SearchResultItem item : list) {
    //use result items here
}
```
