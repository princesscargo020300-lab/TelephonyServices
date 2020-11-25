package com.telephonyservices;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity 
{
	Button intent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		
		
		//intent phone1

		intent = (Button)findViewById(R.id.message1);
        //implement Onclick event for Explicit Intent
        intent.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new  Intent(getBaseContext(), Message1Activity.class);
					startActivity(intent);
				}
			});
			
		intent = (Button)findViewById(R.id.message2);
        //implement Onclick event for Explicit Intent
        intent.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new  Intent(getBaseContext(), Message2Activity.class);
					startActivity(intent);
				}
			});
		
		intent = (Button)findViewById(R.id.message3);
        //implement Onclick event for Explicit Intent
        intent.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new  Intent(getBaseContext(), Message3Activity.class);
					startActivity(intent);
				}
			});
		
			
		intent = (Button)findViewById(R.id.message4);
        //implement Onclick event for Explicit Intent
        intent.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new  Intent(getBaseContext(), Message4Activity.class);
					startActivity(intent);
				}
			});
			
			
		intent = (Button)findViewById(R.id.message5);
        //implement Onclick event for Explicit Intent
        intent.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Intent intent = new  Intent(getBaseContext(), Message5Activity.class);
					startActivity(intent);
				}
			});
		
		
		
			
			//5 person calling
	}
	public void call1(View view) {
		int permissionCheck =
			ContextCompat.checkSelfPermission(this, 
											  Manifest.permission.CALL_PHONE);
		if (permissionCheck== 
			PackageManager.PERMISSION_GRANTED){

			Intent callIntent = new 
				Intent(Intent.ACTION_CALL);

			callIntent.setData(Uri.parse("tel:Levi"+"(091234567887)"));

			startActivity(callIntent);
		}
		else {
			ActivityCompat.requestPermissions(this, 
											  new String[]{Manifest.permission.CALL_PHONE}, 
											  							  0);
		}
		}

		
		
	public void call2(View view) {
		int permissionCheck =
			ContextCompat.checkSelfPermission(this, 
											  Manifest.permission.CALL_PHONE);
		if (permissionCheck== 
			PackageManager.PERMISSION_GRANTED){

			Intent callIntent = new 
				Intent(Intent.ACTION_CALL);

			callIntent.setData(Uri.parse("tel:Jicel"+"(098765432101)"));

			startActivity(callIntent);
		}
		else {
			ActivityCompat.requestPermissions(this, 
											  new String[]{Manifest.permission.CALL_PHONE}, 
											  0);
		}
		
	}
	



	public void call3(View view) {
		int permissionCheck =
			ContextCompat.checkSelfPermission(this, 
											  Manifest.permission.CALL_PHONE);
		if (permissionCheck== 
			PackageManager.PERMISSION_GRANTED){

			Intent callIntent = new 
				Intent(Intent.ACTION_CALL);

			callIntent.setData(Uri.parse("tel:Oliver"+"(096788767867)"));

			startActivity(callIntent);
		}
		else {
			ActivityCompat.requestPermissions(this, 
											  new String[]{Manifest.permission.CALL_PHONE}, 
											  0);
		}
		}
		
		
		
	public void call4(View view) {
		int permissionCheck =
			ContextCompat.checkSelfPermission(this, 
											  Manifest.permission.CALL_PHONE);
		if (permissionCheck== 
			PackageManager.PERMISSION_GRANTED){

			Intent callIntent = new 
				Intent(Intent.ACTION_CALL);

			callIntent.setData(Uri.parse("tel:Jenny"+"(094565646546)"));

			startActivity(callIntent);
		}
		else {
			ActivityCompat.requestPermissions(this, 
											  new String[]{Manifest.permission.CALL_PHONE}, 
											  0);
		}
		}
		
		
	public void call5(View view) {
		int permissionCheck =
			ContextCompat.checkSelfPermission(this, 
											  Manifest.permission.CALL_PHONE);
		if (permissionCheck== 
			PackageManager.PERMISSION_GRANTED){

			Intent callIntent = new 
				Intent(Intent.ACTION_CALL);

			callIntent.setData(Uri.parse("tel:Kylie"+"(091233212313)"));

			startActivity(callIntent);
		}
		else {
			ActivityCompat.requestPermissions(this, 
											  new String[]{Manifest.permission.CALL_PHONE}, 
											  0);
		}
		
    }
}
