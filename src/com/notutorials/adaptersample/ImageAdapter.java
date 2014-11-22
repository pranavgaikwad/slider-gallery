package com.notutorials.adaptersample;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.notutorials.gallerysample.R;

public class ImageAdapter extends PagerAdapter {
	Context context;
	private int[] GalImages = new int[] { R.drawable.sun, R.drawable.moon,
			R.drawable.clock,R.drawable.justin };
	private String[] ImageInfo = new String[]{"This is sun","This is moon","This is a clock","OOPS!\n He looks like Justin Bieber"};
	LayoutInflater myInflater;
	
	public ImageAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return GalImages.length;
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((LinearLayout) object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		
		myInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View myView = myInflater.inflate(R.layout.container, container,false);
		
		TextView txtView = (TextView)myView.findViewById(R.id.image_description);
		ImageView imgView = (ImageView)myView.findViewById(R.id.image);
		
		txtView.setText(ImageInfo[position]);
		imgView.setImageResource(GalImages[position]);
		((ViewPager)container).addView(myView);
		return myView;
	}

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView((LinearLayout) object);
	}
}