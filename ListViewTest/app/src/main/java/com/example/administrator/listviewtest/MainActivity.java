package com.example.administrator.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.com.kerwin.listviewtest.adapter.FruitAdapter;
import com.kerwin.listviewtest.model.Fruit;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    //private String[] data = {"apple","banana","orange","pear","apple","banana","orange","pear","apple","banana","orange","pear","apple","banana","orange","pear"};
    private List<Fruit> fruits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);*/
        initFruits();
        FruitAdapter fruitAdapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruits);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(fruitAdapter);

    }



    private void initFruits(){
        for (int i=0;i<2;i++){
            Fruit apple = new Fruit("apple",R.drawable.apple);
            fruits.add(apple);
            Fruit banana = new Fruit("banana",R.drawable.banana);
            fruits.add(banana);
            Fruit orange = new Fruit("orange",R.drawable.orange);
            fruits.add(orange);
        }
    }
}
