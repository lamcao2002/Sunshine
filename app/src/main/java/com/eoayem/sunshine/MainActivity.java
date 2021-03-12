package com.eoayem.sunshine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Toolbar toolbar;

    private WeatherAdapter weatherAdapter;
    private List<Weather> listWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generateDummyData();
        setupView();

    }

    private void setupView() {
        recyclerView = findViewById(R.id.rcv_weather);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        weatherAdapter = new WeatherAdapter(this, listWeather, new WeatherAdapter.Callback() {
            @Override
            public void onClickItem(int index, Weather weather) {
                openDetailActivity(weather);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(weatherAdapter);
    }

    private void generateDummyData() {
        Weather weather1 = new Weather("Today, April 20", "18", "4",
                "Clear", R.drawable.art_clear, "London, UK");
        Weather weather2 = new Weather("Tomorrow", "16", "3",
                "Clear", R.drawable.ic_clear, "London, UK");
        Weather weather3 = new Weather("Wednesday", "17", "4",
                "Clear", R.drawable.ic_clear, "London, UK");
        Weather weather4 = new Weather("Thursday", "16", "6",
                "Clear", R.drawable.ic_clear, "London, UK");
        Weather weather5 = new Weather("Friday", "15", "10",
                "Rain", R.drawable.ic_rain, "London, UK");
        Weather weather6 = new Weather("Saturday", "13", "8",
                "Rain", R.drawable.ic_rain, "London, UK");
        Weather weather7 = new Weather("Sunday", "12", "7",
                "Rain", R.drawable.ic_rain, "London, UK");

        listWeather = new ArrayList<>();
        listWeather.add(weather1);
        listWeather.add(weather2);
        listWeather.add(weather3);
        listWeather.add(weather4);
        listWeather.add(weather5);
        listWeather.add(weather6);
        listWeather.add(weather7);
    }

    private void openDetailActivity(Weather weather) {
        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(Weather.WEATHER_TAG, weather);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}