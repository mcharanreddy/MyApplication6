package com.example.mchar.myapplication;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.mchar.myapplication.R.attr.title;
import static com.example.mchar.myapplication.R.id.editText5;

public class MainActivity extends AppCompatActivity {
    databasehelper mydb;
    EditText a1,a2,a3,a4;
    Button btn;
    Button btnviewall;
    Button update;
    Button delete,register;
    int i=0;
    int[] c = new int[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb =new databasehelper(this);
        a4 = (EditText) findViewById(editText5);
        a1 = (EditText) findViewById(R.id.editText);
        a2 = (EditText) findViewById(R.id.editText2);
        a3 = (EditText) findViewById(R.id.editText3);
        btn=(Button)findViewById(R.id.button);
        btnviewall=(Button)findViewById(R.id.button3);
        update=(Button)findViewById(R.id.button4);
        delete =(Button)findViewById(R.id.button2);
        register=(Button)findViewById(R.id.button5);
        confirm();
        viewall();
        updatedata();
        deletedata();
        regi();
    }
    public void deletedata(){
        delete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Integer deletedrows=mydb.delete(a4.getText().toString());
                        if (deletedrows >0)
                        {
                            Toast.makeText(MainActivity.this, "data deleted", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(MainActivity.this, "data delete failed", Toast.LENGTH_SHORT).show();

                    }
                }
        );
    }
    public void updatedata(){
        update.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isUpdate =mydb. update(a4.getText().toString(),a1.getText().toString(),a2.getText().toString(),a3.getText().toString());
                        if (isUpdate==true)
                        {
                            Toast.makeText(MainActivity.this, "updated", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(MainActivity.this, "update failed", Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }
    public void confirm()
    {
      btn.setOnClickListener(
                new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                     boolean isInserted= mydb.insertData(a1.getText().toString(),a2.getText().toString(),a3.getText().toString() );
                      if(isInserted==true)
                          Toast.makeText(MainActivity.this, "victory", Toast.LENGTH_SHORT).show();
                      else
                          Toast.makeText(MainActivity.this, "you screwd up", Toast.LENGTH_SHORT).show();



                  }
              }
      );


    }

    public void viewall(){

        btnviewall.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = mydb.gatalldata();
                        if (res.getCount() == 0) {
                            //show message
                            showmessage("Error", "Nothing found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("ID :" + res.getString(0) + "\n");
                            buffer.append("NAME :" + res.getString(1) + "\n");
                            buffer.append("ROLLNO :" + res.getString(2) + "\n");
                            int a= Integer.parseInt(res.getString(2));
                             c[i]=a;
                            i++;
                            buffer.append("ROLLNO2 :" + res.getString(3) + "\n");
                        }
                        //show all data
                        showmessage("Data", buffer.toString());
                    }
                }
        );
    }


        public void showmessage(String title, String Message) {
            AlertDialog.Builder builder = new  AlertDialog.Builder(this);
            builder.setCancelable(true);
            builder.setTitle(title);
            builder.setMessage(Message);
            builder.show();


        }
        public void regi(){
            register.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent intent=new Intent(MainActivity.this, Main2Activity.class);
                            startActivity(intent);

                        }
                    }
            );
        }

}

