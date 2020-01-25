package com.example.agricultureguide.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.agricultureguide.R;

import java.util.ArrayList;
import java.util.List;

public class CropSuggestionActivity extends AppCompatActivity {

	private List<String> summerCropList;
	private List<String> winterCropList;

	private static final String TAG = "CropSuggestionActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crop_suggestion);

		summerCropList = new ArrayList<>();
		winterCropList = new ArrayList<>();

		winterCropList.add("Garlic");
		winterCropList.add("Spinach");
		winterCropList.add("Beans");
		winterCropList.add("Carrots");
		winterCropList.add("Capsicum");
		winterCropList.add("Radish");
		winterCropList.add("Pumpkin");

		summerCropList.add("Cauliflower");
		summerCropList.add("Cucumber");
		summerCropList.add("Capsicum");
		summerCropList.add("Bitter Gourd");
		summerCropList.add("Bottle Gourd");
		summerCropList.add("Tomato");
		summerCropList.add("Cauliflower");
		summerCropList.add("Pumpkin");
	}
}
