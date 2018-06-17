package com.ghen61.agabankh;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by LG on 2018-06-13.
 */

public class SendActivity extends AppCompatActivity {

    Button button1;
    EditText name;
    EditText mEditTextReAcc;
    EditText mEditTextMoney;
    Spinner mEditTextType;
    Intent intent = null;
    private TextView mTextViewResult;
    /*
    * jsp에서의 getParameter와 비슷
    *
    * Intent intent = getIntent();
    *
    *
    * String data = intent.getStringExtra("value");
    * */
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_send);

        button1=(Button)findViewById(R.id.submitB);
        name=(EditText)findViewById(R.id.name);
        mEditTextReAcc=(EditText)findViewById(R.id.acc);
        mEditTextMoney=(EditText)findViewById(R.id.money);
        mEditTextType=(Spinner) findViewById(R.id.spend);
        mTextViewResult=(TextView)findViewById(R.id.textView3);


        Button buttonInsert = (Button)findViewById(R.id.submitB);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String myacc = "1234"; //잠깐 임시 값이 들어왔아
                String reAcc = mEditTextReAcc.getText().toString();
                String money = mEditTextMoney.getText().toString();
                String type = mEditTextType.getSelectedItem().toString();

                //Namego =name;

                InsertData task = new InsertData();
                task.execute(myacc, reAcc, money, type);

            }
        });
    }
    class InsertData extends AsyncTask<String, Void, String> {
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(SendActivity.this,
                    "Please Wait", null, true, true);
        }


        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);

            progressDialog.dismiss();
            mTextViewResult.setText(result);//php에서 echo 해주는 내용 출력해준다
            if (result.equals("ok")) {
                Log.d("od", "dddd");

            }
            //Log.d(TAG, "POST response  - " + result);
        }


        @Override
        protected String doInBackground(String... params) {

            String myacc = (String) params[0];
            String reAcc = (String) params[1];
            String money = (String) params[2];
            String type = (String) params[3];
            String serverURL =  "http://wwhurin0834.dothome.co.kr/sent.php";
            String postParameters = "myAcc=" + myacc + "&receiverAcc=" + reAcc+"&money="+money+"&type="+type;

            try {
                URL url = new URL(serverURL);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();


                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setRequestMethod("POST");
                //httpURLConnection.setRequestProperty("content-type", "application/json");
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();


                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(postParameters.getBytes("UTF-8"));
                outputStream.flush();
                outputStream.close();


                int responseStatusCode = httpURLConnection.getResponseCode();
                //Log.d(TAG, "POST response code - " + responseStatusCode);

                InputStream inputStream;
                if (responseStatusCode == HttpURLConnection.HTTP_OK) {
                    inputStream = httpURLConnection.getInputStream();
                } else {
                    inputStream = httpURLConnection.getErrorStream();
                }


                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                StringBuilder sb = new StringBuilder();
                String line = null;

                while ((line = bufferedReader.readLine()) != null) {
                    sb.append(line);
                }


                bufferedReader.close();


                return sb.toString();


            } catch (Exception e) {

                //Log.d(Tag, "InsertData: Error ", e);

                return new String("Error: " + e.getMessage());
            }

        }
    }
}