package com.example.come_on;
  
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
  
public class TimerActivity extends Activity { 
  
    private MyCountDownTimer mc; 
    private TextView tv; 
    public static EditText et;
    private Button button;
    private int num;
    public static SQLiteDatabase db;
    public static int total;
    public static int daynum ;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.act_timer); 
        

		db = openOrCreateDatabase("db_burning", SQLiteDatabase.OPEN_READWRITE, null);

		String sql = "create table if not exists exe(_id integer primary key autoincrement, " +
				"running integer, high integer, rope integer, deep integer, " +
					"situp integer, total integer);";		
		db.execSQL(sql);	
		
		int num = MainActivity.getDiffDay();
		System.out.println(num);
			while(num!=0){
				   String sql2 = "insert into exe (running,high,rope,deep,situp,total) values (0,0,0,0,0,0)";
				   db.execSQL(sql2);
				   num--;
		    }		
		
		
		
        tv = (TextView) findViewById(R.id.show); 
        et = (EditText) findViewById(R.id.ed);
        button = (Button) findViewById(R.id.begin);
        button.setOnClickListener(new OnClickListener() {
		    @Override
		    public void onClick(View arg0) {
			    // TODO Auto-generated method stub
			    String str = et.getText().toString();
			    int time = Integer.parseInt(str);
			    mc = new MyCountDownTimer(time*1000, 1000); 
			    mc.start(); 
		   }
	   });
    																									
    } 
  
    public void oncancel(View view) { 
        Toast.makeText(TimerActivity.this, "取消", Toast.LENGTH_LONG).show();// toast有显示时间延迟 
        mc.cancel(); 
    } 
  
    public void restart(View view) { 
        Toast.makeText(TimerActivity.this, "重新开始", Toast.LENGTH_LONG).show();// toast有显示时间延迟 
        mc.start(); 
    } 

  
    class MyCountDownTimer extends CountDownTimer { 
        public MyCountDownTimer(long millisInFuture, long countDownInterval) { 
        super(millisInFuture, countDownInterval); 
    } 
  
    @Override
    public void onFinish() { 
      AlertDialog.Builder builder = new AlertDialog.Builder(TimerActivity.this);
      builder.setTitle("倒计时结束").setMessage("恭喜你！又朝性感的身材迈进了一步！继续努力哦！").show();
      daynum = MainActivity.getCountDay();
      ContentValues values = new ContentValues();
      if(ChoiceActivity.toast == 0){    	 
    	  num = Integer.parseInt(et.getText().toString());
    	  total = total + num;
    	 String sql = "update exe set running="+ num +" where _id=" + daynum;
    	//  String sql = "insert into exe (running) values ("+num+")";
    	  db.execSQL(sql);
    	  String sql1 = "update exe set total="+ total +" where _id=" + daynum;
    	  db.execSQL(sql1);
      }else if(ChoiceActivity.toast == 1){    	 
    	  num = Integer.parseInt(et.getText().toString());
    	  total = total + num;
    	  String sql = "update exe set high="+ num +" where _id=" + daynum;
    	  //String sql = "insert into exe (high) values ("+num+")";
    	  db.execSQL(sql);
    	  String sql1 = "update exe set total="+ total +" where _id=" + daynum;
    	  db.execSQL(sql1);
      }
      else if(ChoiceActivity.toast == 2){    	 
    	  num = Integer.parseInt(et.getText().toString());
    	  total = total + num;
    	  String sql = "update exe set rope="+ num +" where _id=" + daynum;
    	  db.execSQL(sql);
    	  String sql1 = "update exe set total="+ total +" where _id=" + daynum;
    	  db.execSQL(sql1);
      }
      else if(ChoiceActivity.toast == 3){    	 
    	  num = Integer.parseInt(et.getText().toString());
    	  total = total + num;
    	  String sql = "update exe set high="+ num +" where _id=" + daynum;
    	  db.execSQL(sql);
    	  String sql1 = "update exe set deep="+ total +" where _id=" + daynum;
    	  db.execSQL(sql1);
      }
      else if(ChoiceActivity.toast == 4){    	 
    	  num = Integer.parseInt(et.getText().toString());
    	  total = total + num;
    	  String sql = "update exe set situp="+ num +" where _id=" + daynum;
    	  db.execSQL(sql);
    	  String sql1 = "update exe set total="+ total +" where _id=" + daynum;
    	  db.execSQL(sql1);
      }
      db.close();
    } 
  
    @Override
    public void onTick(long millisUntilFinished) { 
        Log.i("MainActivity", millisUntilFinished + ""); 
        tv.setText("倒计时(" + millisUntilFinished / 1000 + ")秒"); 
    } 
  } 
} 