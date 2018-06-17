package com.ghen61.agabankh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Set;

/**
 * Created by LG on 2018-06-13.
 */

public class SettingActivity extends AppCompatActivity{

    ListView menuList;
    Intent intent = null;
    String[] item ={"계좌생성","계좌삭제","회원탈퇴"};

    ArrayAdapter<String> adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_setting);


        menuList = (ListView)findViewById(R.id.menu);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,item);

        menuList.setAdapter(adapter);

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                switch(i){

                    case 0: intent = new Intent(SettingActivity.this,CreateActivity.class);
                            startActivity(intent);
                            finish();break;
                    case 1:
                        Toast.makeText(SettingActivity.this, "준비중입니다.", Toast.LENGTH_SHORT).show(); break;
                    case 2:
                        Toast.makeText(SettingActivity.this, "준비중입니다.", Toast.LENGTH_SHORT).show(); break;


                }



            }
        });


    }
}
