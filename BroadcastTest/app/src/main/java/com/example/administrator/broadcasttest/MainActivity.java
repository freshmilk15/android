package com.example.administrator.broadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private IntentFilter filter;
    private NetworkReceiver networkReceiver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        networkReceiver = new NetworkReceiver();
        registerReceiver(networkReceiver,filter);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.kerwin.MY_BROADCAST");
                sendBroadcast(intent);
            }
        });



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(networkReceiver);
    }

    class NetworkReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            //Toast.makeText(context,"network changes",Toast.LENGTH_LONG).show();
            ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo =  connectivityManager.getActiveNetworkInfo();
            if(networkInfo != null && networkInfo.isAvailable()){
                Toast.makeText(context,"network is available",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(context,"network is unavailable",Toast.LENGTH_LONG).show();
            }
        }
    }


}
