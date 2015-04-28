package com.example.test;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class ChoiceActivity extends Activity{
	private ListView lv;
	public static int toast;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choice);
		
		lv = (ListView) findViewById(R.id.choice_id);
		String[] all = {"�ܲ�","����","��̧��","��������","���"};
		ListAdapter adapter = new ArrayAdapter<String>(ChoiceActivity.this,
				android.R.layout.simple_list_item_1, all);
		lv.setAdapter(adapter);
		
	
		lv.setOnItemClickListener(new OnItemClickListener() {			
			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long id) {
				
				// TODO Auto-generated method stub
				if(position == 0){
					toast = 0;
					Intent intent = new Intent(ChoiceActivity.this, TimerActivity.class);
					startActivity(intent);					
				}else if(position == 1){
					toast = 1;
					Intent intent = new Intent(ChoiceActivity.this, TimerActivity.class);
					startActivity(intent);
				}else if(position == 2){
					toast = 2;
					Intent intent = new Intent(ChoiceActivity.this, TimerActivity.class);
					startActivity(intent);
				}
				else if(position == 3){
					toast = 3;
					Intent intent = new Intent(ChoiceActivity.this, TimerActivity.class);
					startActivity(intent);
				}
				else if(position == 4){
					toast = 4;
					Intent intent = new Intent(ChoiceActivity.this, TimerActivity.class);
					startActivity(intent);
				}
			}
			
		});
				
		
	}
}
