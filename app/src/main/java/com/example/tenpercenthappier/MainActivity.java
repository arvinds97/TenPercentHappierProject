package com.example.tenpercenthappier;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.tenpercenthappier.adapters.TopicListener;
import com.example.tenpercenthappier.adapters.TopicRecyclerAdapter;
import com.example.tenpercenthappier.models.TopicImpl;
import com.example.tenpercenthappier.util.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the MainActivity for the Application. The ideal way to develop the
 * application is to use an MVVM architecture, but since the scope of this task is limited, the
 * functions of the repository and the viewmodel have been performed in this class. As this project
 * grows, it will be split into repository and viewmodel as well.
 */
public class MainActivity extends AppCompatActivity implements TopicListener {

    private static final String TAG = "MainActivity";
    private RecyclerView recyclerView;
    private List<TopicImpl> topicList;
    private TopicRecyclerAdapter recyclerViewAdapter;
    RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        topicList = new ArrayList<>();
        getTopicsAndPopulateRecyclerView();
    }

    //private method to populate recycler view
    private void getTopicsAndPopulateRecyclerView() {
        queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,
                Constants.URL, null, response -> {
            try {
                this.topicList = parseResponse(response);
                recyclerViewAdapter = new TopicRecyclerAdapter(topicList, this);
                LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(manager);
                recyclerView.setAdapter(recyclerViewAdapter);
            } catch (JSONException e) {
                Log.d(TAG, "JSONException occurred while parsing JSONObject" + e);
            }
        }, error -> {
            Log.d(TAG, "Error while sending get request" + error.getMessage());
            Toast.makeText(getApplicationContext(), "Network Error",Toast.LENGTH_LONG)
            .show();
        });
        queue.add(jsonObjectRequest);
    }

    //private method to parse the json response
    private List<TopicImpl> parseResponse(JSONObject response) throws JSONException {
        JSONArray list = response.getJSONArray(Constants.TOPICS);
        List<TopicImpl> topicList = new ArrayList<>();
        for (int i = 0; i < list.length(); i++) {
            JSONObject item = (JSONObject) list.get(i);
            JSONArray meditations = (JSONArray) item.get(Constants.MEDITATIONS);
            List<String> meditationsList = new ArrayList<>();
            for (int j = 0; j < meditations.length(); j++) {
                meditationsList.add((String) meditations.get(j));
            }
            TopicImpl topic = new TopicImpl(item.get(Constants.UUID).toString(),
                    item.get(Constants.COLOR).toString(),
                    item.get(Constants.DESCRIPTION).toString(),
                    meditationsList,
                    item.get(Constants.TITLE).toString(),
                    (Integer) item.get(Constants.POSITION),
                    (Boolean) item.get(Constants.FEATURED));
            topicList.add(topic);
        }
        return topicList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onTopicClick(View v, int position) {
        String description = topicList.get(position).getDescriptionShort().equals("null") ?
                "No Description" : topicList.get(position).getDescriptionShort();
        Toast.makeText(MainActivity.this, description, Toast.LENGTH_SHORT)
                .show();
    }
}
