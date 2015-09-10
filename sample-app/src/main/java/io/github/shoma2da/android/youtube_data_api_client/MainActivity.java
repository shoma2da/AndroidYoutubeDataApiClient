package io.github.shoma2da.android.youtube_data_api_client;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import io.github.shoma2da.android_youtube_data_api_client.AndroidYoutubeDataApiClient;
import io.github.shoma2da.android_youtube_data_api_client.api.SearchResultItem;
import io.github.shoma2da.android_youtube_data_api_client.api.SearchResultList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AndroidYoutubeDataApiClient.setDebug(true);

        final TextView apiKeyTextView = (TextView)findViewById(R.id.text_api_key);
        final TextView wordTextView = (TextView)findViewById(R.id.text_word);
        final ListView listView = (ListView)findViewById(R.id.list);
        final View searchButton = findViewById(R.id.button_search);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //set api key
                String apiKey = apiKeyTextView.getText().toString();
                AndroidYoutubeDataApiClient.setApiKey(apiKey);

                final String word = wordTextView.getText().toString();
                new AsyncTask<Void, Void, SearchResultList>() {
                    @Override
                    protected SearchResultList doInBackground(Void... params) {
                        try {
                            return AndroidYoutubeDataApiClient.search(word);
                        } catch (JSONException | IOException e) {
                            e.printStackTrace();
                            return null;
                        }
                    }

                    @Override
                    protected void onPostExecute(SearchResultList list) {
                        super.onPostExecute(list);

                        //convert to title string list
                        ArrayList<String> titles = new ArrayList<>();
                        for (SearchResultItem item : list) {
                            titles.add(item.getTitle());
                        }

                        //set to list
                        listView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, titles));
                    }
                }.execute();
            }
        });
    }
}
