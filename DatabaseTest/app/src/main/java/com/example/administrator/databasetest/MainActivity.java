package com.example.administrator.databasetest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.database.MyDatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private MyDatabaseHelper dbhelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbhelper = new MyDatabaseHelper(this,"BookStore.db",null,1);
        button = (Button)findViewById(R.id.create_database);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbhelper.getWritableDatabase();
            }
        });





    }
}
