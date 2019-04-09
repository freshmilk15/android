package com.kerwin.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.kerwin.recyclerview.adapter.FruitAdapter;
import com.kerwin.recyclerview.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruits = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        /*LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);*/
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        FruitAdapter fruitAdapter = new FruitAdapter(fruits);
        recyclerView.setAdapter(fruitAdapter);


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
