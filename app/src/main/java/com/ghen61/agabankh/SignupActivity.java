package com.ghen61.agabankh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by LG on 2018-06-13.
 */

public class SignupActivity extends AppCompatActivity {

    EditText nameEdit;
    EditText idEdit;
    EditText pwEdit;

    Button submit;

    Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_signup);


        nameEdit = (EditText)findViewById(R.id.name);
        idEdit = (EditText)findViewById(R.id.id);
        pwEdit = (EditText)findViewById(R.id.pw);

        submit = (Button)findViewById(R.id.signupB);




    }
}
