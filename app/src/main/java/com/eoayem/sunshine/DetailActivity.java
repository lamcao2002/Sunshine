package com.eoayem.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private Weather weather;

    private ImageView imgTypeWeather;
    private TextView tvDateTimne;
    private TextView tvTypeWeather;
    private TextView tvMaxTemp;
    private TextView tvMinTemp;
    private TextView tvAddress;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_weather_art);

        getData();
    }

    private void getData(){
        weather = (Weather) getIntent().getExtras().getSerializable(Weather.WEATHER_TAG);

        imgTypeWeather = findViewById(R.id.imgTypeWeather);
        tvDateTimne = findViewById(R.id.tvDateTime);
        tvTypeWeather = findViewById(R.id.tvTypeWeather);
        tvMaxTemp = findViewById(R.id.tvMaxTemp);
        tvMinTemp = findViewById(R.id.tvMinTemp);
        tvAddress = findViewById(R.id.tvAddress);

        imgTypeWeather.setImageResource(weather.getImageWeather());
        tvDateTimne.setText(weather.getDateTime());
        tvTypeWeather.setText(weather.getTypeWeather());
        tvMaxTemp.setText(weather.getMaxTemp() + "\u00B0");
        tvMinTemp.setText(weather.getMinTemp() + "\u00B0");
        tvAddress.setText(weather.getAddress());
    }
}
