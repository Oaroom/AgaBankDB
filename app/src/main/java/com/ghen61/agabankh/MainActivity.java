package com.ghen61.agabankh;

import android.Manifest;
import android.app.LauncherActivity;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ListAdapter.ListBtnClickListener{



    Intent intent = null;

    ImageButton setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        setting = (ImageButton)findViewById(R.id.setting);


       ArrayList<ListViewItem> items = new ArrayList<ListViewItem>();

        ListView listView;
        ListAdapter listAdapter;

        loadItemsFrom(items);


        listAdapter = new ListAdapter(this,R.layout.layout_item,items,this);


        listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(listAdapter);

        listAdapter.addItem("1111111111","50,000","1,000","50,000");
        listAdapter.addItem("2222222222","40,000","1,400","20,000");



        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                intent = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });



        /*
        *
        * intent.putExtra("value","문자열");
        *
        * */

        listView.setAdapter(listAdapter);




        }

    private  boolean loadItemsFrom(ArrayList<ListViewItem> list) {

        ListViewItem item;

        int i;

        if (list == null) {

            list = new ArrayList<ListViewItem>();

            i = 1;

            item = new ListViewItem();
            item.setAccount("21111-11111");
            item.setMoney("1");
            item.setOnetime("5");
            item.setMonth("4");
            i++;



        }
        return true;
    }


    @Override
    public void onListBtnClick(String type){

            switch (type){

                case "show": intent = new Intent(MainActivity.this, ShowActivity.class);
                             startActivity(intent); break;

                case "send": intent = new Intent(MainActivity.this, SendActivity.class);
                    startActivity(intent); break;


            }
    }
}

