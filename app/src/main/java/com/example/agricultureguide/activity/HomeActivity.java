package com.example.agricultureguide.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.androdocs.httprequest.HttpRequest;
import com.example.agricultureguide.R;
import com.example.agricultureguide.adapter.PagerAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class HomeActivity extends AppCompatActivity {

	private String CITY = "Dehradun,India";
	private String API = "6b5680d9f09fa185703b6b171597a157";

	private TextView addressTxt;
	private TextView updated_atTxt;
	private TextView statusTxt;
	private TextView tempTxt;
	private TextView temp_minTxt;
	private TextView temp_maxTxt;
	private TextView sunriseTxt;
	private TextView sunsetTxt;
	private TextView windTxt;
	private TextView pressureTxt;
	private TextView humidityTxt;

	private List<Integer> infoList = new ArrayList<>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bindViews();
	}

	private void bindViews() {
		ViewPager mViewPager = findViewById(R.id.infoViewPager);
		PagerAdapter adapter = new PagerAdapter(this, infoList);
		prepareInfoList();
		mViewPager.setAdapter(adapter);
		addressTxt = findViewById(R.id.address);
		updated_atTxt = findViewById(R.id.updated_at);
		statusTxt = findViewById(R.id.status);
		tempTxt = findViewById(R.id.temp);
		temp_minTxt = findViewById(R.id.temp_min);
		temp_maxTxt = findViewById(R.id.temp_max);
		sunriseTxt = findViewById(R.id.sunrise);
		sunsetTxt = findViewById(R.id.sunset);
		windTxt = findViewById(R.id.wind);
		pressureTxt = findViewById(R.id.pressure);
		humidityTxt = findViewById(R.id.humidity);

		new WeatherTask().execute();
	}

	private void prepareInfoList() {
		infoList.add(R.drawable.img);
		infoList.add(R.drawable.img1);
		infoList.add(R.drawable.img2);
	}

	class WeatherTask extends AsyncTask<String, Void, String> {
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		protected String doInBackground(String... args) {
			String url = "https://api.openweathermap.org/data/2.5/weather?q=" + CITY + "&units=metric&appid=" + API;
			String response = HttpRequest.excuteGet(url);
			Log.e("pancham", "doInBackground: " + url);
			return response;
		}

		@Override
		protected void onPostExecute(String result) {

			try {
				JSONObject jsonObj = new JSONObject(result);
				JSONObject main = jsonObj.getJSONObject("main");
				JSONObject sys = jsonObj.getJSONObject("sys");
				JSONObject wind = jsonObj.getJSONObject("wind");
				JSONObject weather = jsonObj.getJSONArray("weather").getJSONObject(0);

				long updatedAt = jsonObj.getLong("dt");
				String updatedAtText = "Updated at: " + new SimpleDateFormat("dd/MM/yyyy hh:mm a", Locale.ENGLISH).format(new Date(updatedAt * 1000));
				String temp = main.getString("temp") + "°C";
				String tempMin = "Min Temp: " + main.getString("temp_min") + "°C";
				String tempMax = "Max Temp: " + main.getString("temp_max") + "°C";
				String pressure = main.getString("pressure");
				String humidity = main.getString("humidity");

				long sunrise = sys.getLong("sunrise");
				long sunset = sys.getLong("sunset");
				String windSpeed = wind.getString("speed");
				String weatherDescription = weather.getString("description");

				String address = jsonObj.getString("name") + ", " + sys.getString("country");

				addressTxt.setText(address);
				updated_atTxt.setText(updatedAtText);
				statusTxt.setText(weatherDescription.toUpperCase());
				tempTxt.setText(temp);
				temp_minTxt.setText(tempMin);
				temp_maxTxt.setText(tempMax);
				sunriseTxt.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunrise * 1000)));
				sunsetTxt.setText(new SimpleDateFormat("hh:mm a", Locale.ENGLISH).format(new Date(sunset * 1000)));
				windTxt.setText(windSpeed);
				pressureTxt.setText(pressure);
				humidityTxt.setText(humidity);

			} catch (JSONException e) {

			}
		}
	}
}
