package com.example.griditempass;

import java.util.Vector;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.powerpoint45.griditempass.R;

public class MainActivity extends Activity {
	
	GridView lightGrid;
	GridView darkGrid;
	public static Vector <Item> lightGridData;
	public static Vector <Item> darkGridData;
	int numAnimals = 7;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lightGrid = (GridView) findViewById(R.id.light_grid);
		darkGrid = (GridView) findViewById(R.id.dark_grid);
		
		lightGridData = new Vector<Item>(); 
		darkGridData  = new Vector<Item>();
		
		//Light grid starts out with all the data
		lightGridData.add(new Item(getResources().getDrawable( R.drawable.bird ), "Bird" ));
		lightGridData.add(new Item(getResources().getDrawable( R.drawable.camel ), "Camel" ));
		lightGridData.add(new Item(getResources().getDrawable( R.drawable.elephant ), "Elephant" ));
		lightGridData.add(new Item(getResources().getDrawable( R.drawable.monkey ), "Monkey" ));
		lightGridData.add(new Item(getResources().getDrawable( R.drawable.sheep ), "Sheep" ));
		lightGridData.add(new Item(getResources().getDrawable( R.drawable.turtle ), "Turtle" ));
		lightGridData.add(new Item(getResources().getDrawable( R.drawable.whale ), "Whale" ));
		
		lightGrid.setAdapter(new LightGridAdapter(this));
		darkGrid.setAdapter(new DarkGridAdapter(this));
		
		lightGrid.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int pos, long arg3) {
				//move from light grid to dark grid
				Item tempItem = lightGridData.get(pos);
				lightGridData.remove(pos);
				((BaseAdapter) lightGrid.getAdapter()).notifyDataSetChanged();
				darkGridData.add(tempItem);
				((BaseAdapter) darkGrid.getAdapter()).notifyDataSetChanged();
				return false;
			}
		});
		
		darkGrid.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int pos, long arg3) {
				//move from dark grid to light grid
				Item tempItem = darkGridData.get(pos);
				darkGridData.remove(pos);
				((BaseAdapter) darkGrid.getAdapter()).notifyDataSetChanged();
				lightGridData.add(tempItem);
				((BaseAdapter) lightGrid.getAdapter()).notifyDataSetChanged();
				return false;
			}
		});
		
	}
}
