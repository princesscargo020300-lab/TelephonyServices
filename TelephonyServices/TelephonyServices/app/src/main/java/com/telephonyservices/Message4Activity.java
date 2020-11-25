package com.telephonyservices;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class Message4Activity extends Activity {

	EditText Phone, Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message4);

		Phone= findViewById(R.id.sent4);
		Message= findViewById(R.id.editMessage);
		Phone.setText("Jenny(094565646546)");

	}
	public void btnSend(View view) {
		int permissionCheck = 
			ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
		if (permissionCheck== 
			PackageManager.PERMISSION_GRANTED){
			sendMessage();
		}else {
			ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 0);
		}
	}
	private void sendMessage() {

		String phone, message;
		phone= Phone.getText().toString().trim();
		message= Message.getText().toString().trim();
		SmsManager smsManager= 
			SmsManager.getDefault();

		smsManager.sendTextMessage(phone, null, 
								   message, null, null);
		Toast.makeText(this, "Message Sent", 
					   Toast.LENGTH_SHORT).show();
	}
}


