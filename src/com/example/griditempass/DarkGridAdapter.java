package com.example.griditempass;

import com.powerpoint45.griditempass.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DarkGridAdapter extends BaseAdapter {

	LayoutInflater inflater;
	
	public DarkGridAdapter(Context context) {
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		return MainActivity.darkGridData.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout item = (LinearLayout) inflater.inflate(R.layout.drawer_item, null);
		((ImageView)item.findViewById(R.id.icon_image)).setImageDrawable(MainActivity.darkGridData.get(position).icon);
		((TextView)item.findViewById(R.id.icon_text)).setText(MainActivity.darkGridData.get(position).label);
		return item;
	}

}
