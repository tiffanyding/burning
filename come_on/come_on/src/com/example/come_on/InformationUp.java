package com.example.come_on;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class InformationUp extends Activity {
    private EditText username,Editheight,Editweight;
    private ImageButton imageButton;
    private SharedPreferences sp;
    private String userNameValue;
    private CheckBox remember;
	
    public InformationUp() {
    	   
       }
   
       
       @Override
    protected void onCreate(Bundle savedInstanceState) {
    	// TODO Auto-generated method stub
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.information_update);
    	username= (EditText)this.findViewById(R.id.name);
    	Editheight= (EditText)this.findViewById(R.id.height);
    	Editweight= (EditText)this.findViewById(R.id.weight);
    	remember = (CheckBox)this.findViewById(R.id.nameChecked);
    	imageButton = (ImageButton)this.findViewById(R.id.imageButton2);
    	
    	sp = getSharedPreferences("userInfo", 0);
    	String name = sp.getString("USER_NAME", "");
    	
    	boolean choseRemember = sp.getBoolean("remember", false);
    	if(choseRemember){
            username.setText(name);
            remember.setChecked(true);
        }
    	imageButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences.Editor editor = sp.edit();
				String value = username.getText().toString().trim();
				if(value == null || value.equals("")) {
					username.setError("�������û���");
					return;
				}
				editor.putString("USER_NAME", value);
				if(remember.isChecked()){                        
                    editor.putBoolean("remember", true);                        
                }else{
                    editor.putBoolean("remember", false);                
                }
				editor.commit();
				String height = Editheight.getText().toString().trim();
				String weight = Editweight.getText().toString().trim();
				editor.putString("WEIGHT", weight);
				editor.putString("HEIGHT", height);
				Intent intent =new Intent(InformationUp.this,MainActivity.class);
				startActivity(intent);
			}
		});
    	
    	
    }
}
       
 