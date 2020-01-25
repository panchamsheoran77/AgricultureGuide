package com.example.agricultureguide.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.agricultureguide.R;
import com.example.agricultureguide.adapter.CropAdapter;
import com.example.agricultureguide.model.Crop;

import java.util.ArrayList;
import java.util.List;

public class CropSuggestionActivity extends AppCompatActivity {

	private static final String TAG = "CropSuggestionActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_crop_suggestion);

		int seasonId = getIntent().getIntExtra("season", -1);

		Toolbar toolbar = findViewById(R.id.toolbar);
		if (seasonId == 1) {
			toolbar.setTitle("Winter Crops");

		} else if (seasonId == 0) {
			toolbar.setTitle("Summer Crops");
		}

		setSupportActionBar(toolbar);

		List<Crop> summerCropList = new ArrayList<>();
		List<Crop> winterCropList = new ArrayList<>();

		winterCropList.add(new Crop("Sept - Oct", "Garlic", R.drawable.garlic));
		winterCropList.add(new Crop("Sept - Nov", "Spinach", R.drawable.spinach));
		winterCropList.add(new Crop("Feb - Mar", "Beans", R.drawable.beans));
		winterCropList.add(new Crop("Aug - Sept - Oct", "Carrots", R.drawable.carrot));
		winterCropList.add(new Crop("Nov - Jan", "Capsicum", R.drawable.capsicum));
		winterCropList.add(new Crop("Aug - Jan", "Radish", R.drawable.radish));
		winterCropList.add(new Crop("Jan-Mar, Sept-Dec", "Pumpkin", R.drawable.pumpkin));

		summerCropList.add(new Crop("Sept - Oct", "Cauliflower", R.drawable.cauliflower));
		summerCropList.add(new Crop("Jun - Jul", "Cucumber", R.drawable.cucumber));
		summerCropList.add(new Crop("May - Jun", "Capsicum", R.drawable.capsicum));
		summerCropList.add(new Crop("Jun - Jul", "Bitter Gourd", R.drawable.bitter_gourd));
		summerCropList.add(new Crop("Jun - Jul", "Bottle Gourd", R.drawable.bottle_gourd));
		summerCropList.add(new Crop("Jun - Aug", "Tomato", R.drawable.tomato));
		summerCropList.add(new Crop("May - Jun", "Pumpkin", R.drawable.pumpkin));

		RecyclerView rvCropSuggestion = findViewById(R.id.rv_crop_suggestion);
		rvCropSuggestion.setLayoutManager(new LinearLayoutManager(this));
		if (seasonId == 1) {
			rvCropSuggestion.setAdapter(new CropAdapter(this, winterCropList));

		} else if (seasonId == 0) {
			rvCropSuggestion.setAdapter(new CropAdapter(this, summerCropList));
		}
	}
}
