package com.example.agricultureguide.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.agricultureguide.R;
import com.example.agricultureguide.model.Crop;

import java.util.List;

public class CropAdapter extends RecyclerView.Adapter<CropAdapter.CropViewHolder> {

	private Context context;
	private List<Crop> cropList;

	public CropAdapter(Context context, List<Crop> cropList) {
		this.context = context;
		this.cropList = cropList;
	}

	@NonNull
	@Override
	public CropAdapter.CropViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(context).inflate(R.layout.row_crop, parent, false);
		return new CropViewHolder(view);
	}

	@Override
	public void onBindViewHolder(@NonNull CropAdapter.CropViewHolder holder, int position) {
		Crop crop = cropList.get(position);
		holder.setCropName(crop.getName());
		holder.setCropPeriod(crop.getPeriod());
		holder.setImageResource(crop.getImgId());
	}

	@Override
	public int getItemCount() {
		if (cropList == null || cropList.size() == 0) {
			return 0;

		} else {
			return cropList.size();
		}
	}

	class CropViewHolder extends RecyclerView.ViewHolder {

		private ImageView imgCrop;
		private TextView lblCropName;
		private TextView lblCropPeriod;

		CropViewHolder(@NonNull View itemView) {
			super(itemView);

			imgCrop = itemView.findViewById(R.id.img_crop);
			lblCropName = itemView.findViewById(R.id.lbl_crop_name);
			lblCropPeriod = itemView.findViewById(R.id.lbl_crop_period);
		}

		void setImageResource(int id) {
			imgCrop.setImageResource(id);
		}

		void setCropName(String name) {
			lblCropName.setText(name);
		}

		void setCropPeriod(String period) {
			lblCropPeriod.setText(period);
		}
	}
}
