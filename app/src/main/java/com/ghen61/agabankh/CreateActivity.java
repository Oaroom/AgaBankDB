package com.ghen61.agabankh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by LG on 2018-06-13.
 */

public class CreateActivity extends AppCompatActivity {


    Button createB;
    Intent intent =null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_create);


        createB = (Button) findViewById(R.id.createB);


        createB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                finish();

            }
        });

    }

}
