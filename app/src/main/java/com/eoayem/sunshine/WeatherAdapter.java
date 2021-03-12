package com.eoayem.sunshine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {

    public static final int VIEW_TYPE_1 = 1;
    public static final int VIEW_TYPE_2 = 2;

    private Callback callback;

    private List<Weather> listWeather;

    public WeatherAdapter(List<Weather> listWeather, Callback callback) {
        this.listWeather = listWeather;
        this.callback = callback;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int itemLayout = viewType == VIEW_TYPE_1 ? R.layout.item_weather_art : R.layout.item_weather;
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        Weather weather = listWeather.get(position);
        if (weather == null) {
            return;
        }

        holder.imgTypeWeather.setImageResource(weather.getImageWeather());
        holder.tvDateTimne.setText(weather.getDateTime());
        holder.tvTypeWeather.setText(weather.getTypeWeather());
        holder.tvMaxTemp.setText(weather.getMaxTemp() + "\u00B0");
        holder.tvMinTemp.setText(weather.getMinTemp() + "\u00B0");
        holder.tvAddress.setText(weather.getAddress());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClickItem(position, weather);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listWeather.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
            return VIEW_TYPE_1;
        else
            return VIEW_TYPE_2;
    }

    static class WeatherViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgTypeWeather;
        private TextView tvDateTimne;
        private TextView tvTypeWeather;
        private TextView tvMaxTemp;
        private TextView tvMinTemp;
        private TextView tvAddress;

        public WeatherViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTypeWeather = itemView.findViewById(R.id.imgTypeWeather);
            tvDateTimne = itemView.findViewById(R.id.tvDateTime);
            tvTypeWeather = itemView.findViewById(R.id.tvTypeWeather);
            tvMaxTemp = itemView.findViewById(R.id.tvMaxTemp);
            tvMinTemp = itemView.findViewById(R.id.tvMinTemp);
            tvAddress = itemView.findViewById(R.id.tvAddress);
        }
    }

    interface Callback{
        void onClickItem(int index, Weather weather);
    }
}
