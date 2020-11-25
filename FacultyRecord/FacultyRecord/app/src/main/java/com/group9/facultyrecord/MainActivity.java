package com.group9.facultyrecord;

import android.app.AlertDialog;
import android.database.Cursor;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends Activity {

    EditText NAME,ADDRESS,DEGREE,ID;
	DatabaseHelper myDb;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;
	Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        myDb = new DatabaseHelper(this);

        ID = (EditText)findViewById(R.id.idnum);
		NAME = (EditText)findViewById(R.id.empname);
        ADDRESS = (EditText)findViewById(R.id.address);
        DEGREE = (EditText)findViewById(R.id.highdegree);

		//button

        btnAddData = (Button)findViewById(R.id.btnadd);
        btnviewAll = (Button)findViewById(R.id.btnviewall);
        btnUpdate= (Button)findViewById(R.id.btnupdate);
        btnDelete= (Button)findViewById(R.id.btndel);

        AddData();
        ViewData();
        UpdateData();
        DeleteData();
    }



	//DELETE 
    public void DeleteData() {
        btnDelete.setOnClickListener(
			new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Integer deletedRows = myDb.deleteData(ID.getText().toString());
					if(deletedRows > 0)
						Toast.makeText(MainActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
					else
						Toast.makeText(MainActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
				}
			}
        );
    }







	//UPDATE

    public void UpdateData() {
        btnUpdate.setOnClickListener(
			new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					boolean isUpdate = myDb.updateData(ID.getText().toString(),
													   NAME.getText().toString(),
													   ADDRESS.getText().toString(),
													   DEGREE.getText().toString());
					if(isUpdate == true)
						Toast.makeText(MainActivity.this,"Data Update",Toast.LENGTH_LONG).show();
						
					else
						Toast.makeText(MainActivity.this,"Data not Updated",Toast.LENGTH_LONG).show();
				}
			}
        );
    }






	//ADD
	public  void AddData() {
        btnAddData.setOnClickListener(
			new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					boolean isInserted=myDb.insertData(
					ID.getText().toString(),
					NAME.getText().toString(),
					ADDRESS.getText().toString(),
					DEGREE.getText().toString());

					if (isInserted==true){
						Toast.makeText(MainActivity.this,"Data Inserted",Toast.LENGTH_LONG).show();
						ID.setText("");
						NAME.setText("");
						ADDRESS.setText("");
						DEGREE.setText("");
					}
					else
						Toast.makeText(MainActivity.this,"Data Not Inserted",Toast.LENGTH_LONG).show();
				
				}
			}
        );
    }






	//VIEW ALL

    public void ViewData() {
        btnviewAll.setOnClickListener(
			new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Cursor res = myDb.getAllData();
					if(res.getCount() == 0) {

						showMessage("Error","Nothing found");
						return;
					}





					//Step by step Result

					StringBuffer buffer = new StringBuffer();

					while (res.moveToNext()) {
						buffer.append("Id Number :"+ res.getString(0)+"\n");
						buffer.append("Name :"+ res.getString(1)+"\n");
						buffer.append("Address :"+ res.getString(2)+"\n");
						buffer.append("Highest Degree :"+ res.getString(3)+"\n\n\n");
					}
					showMessage("RESULT",buffer.toString());
				}
			}
        );
    }



    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }
}
