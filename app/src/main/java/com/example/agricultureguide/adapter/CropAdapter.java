package com.example.agricultureguide.adapter;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agricultureguide.R;
import com.example.agricultureguide.model.Crop;

import java.util.List;

public class CropAdapter extends RecyclerView.Adapter {

	private Context context;
	private List<Crop> cropList;

	public CropAdapter(Context context, List<Crop> cropList) {
		this.context = context;
		this.cropList = cropList;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(R.layout.row_crop, parent, false);
		return null;
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

	}

	@Override
	public int getItemCount() {
		return 0;
	}

	class CropViewHolder extends RecyclerView.ViewHolder {

		public CropViewHolder(@NonNull View itemView) {
			super(itemView);
		}
	}
}
