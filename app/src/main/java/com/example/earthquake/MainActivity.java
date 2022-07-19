package com.example.earthquake;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter c;

    public static final String LOG_TAG = MainActivity.class.getName();
    private static final String USGS_REQUEST_URL =
            "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&orderby=time&limit=10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleview);
        EarthquakeAsyncTask earthquakes = new EarthquakeAsyncTask();

//        List<Model> earthquakes = new ArrayList<>();
//        earthquakes.add(new Model("suraj1","nitesh1","vishnu1"));
//        earthquakes.add(new Model("suraj2","nitesh2","vishnu2"));
//        earthquakes.add(new Model("suraj3","nitesh3","vishnu3"));
//        earthquakes.add(new Model("suraj4","nitesh4","vishnu4"));
//        earthquakes.add(new Model("suraj5","nitesh5","vishnu5"));
//        earthquakes.add(new Model("suraj6","nitesh6","vishnu6"));
//        earthquakes.add(new Model("suraj7","nitesh7","vishnu7"));


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        c = new CustomAdapter(this, new ArrayList<Model>());
        recyclerView.setAdapter(c);
        EarthquakeAsyncTask task = new EarthquakeAsyncTask();
        task.execute(USGS_REQUEST_URL);
    }
    private class EarthquakeAsyncTask extends AsyncTask<String, Void, List<Model>> {

        @Override
        protected List<Model> doInBackground(String... urls) {
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            List<Model> result = QueryUtils.fetchEarthquakeData(urls[0]);
            return result;

        }

        @Override
        protected void onPostExecute(List<Model> data) {
            //TODO : Update UI
            recyclerView.setAdapter(new CustomAdapter(MainActivity.this,data));


        }
    }



}