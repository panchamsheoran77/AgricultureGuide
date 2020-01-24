package com.example.agricultureguide.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

public class PagerAdapter extends androidx.viewpager.widget.PagerAdapter {
	private Context context;
	private List<Integer> infoList;

	public PagerAdapter(Context context, List<Integer> infoList) {
		this.context = context;
		this.infoList = infoList;
	}

	@Override
	public int getCount() {
		return infoList.size();
	}

	@NonNull
	@Override
	public Object instantiateItem(@NonNull ViewGroup container, int position) {
		ImageView imageView = new ImageView(context);
		imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
		imageView.setImageResource(infoList.get(position));
		((ViewPager) container).addView(imageView, 0);
		return imageView;
	}

	@Override
	public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
		return view == ((ImageView) object);
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView((ImageView) object);
	}

}

