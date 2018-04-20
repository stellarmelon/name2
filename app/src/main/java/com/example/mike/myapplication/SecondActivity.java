package com.example.mike.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = SecondActivity.class.getSimpleName();
    private TextView textView;
    private Button mainBtn;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        textView = findViewById(R.id.textView);
        mainBtn = findViewById(R.id.button2);
        StringBuilder msg = new StringBuilder("Hello \n");
        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        assert b != null;
        if (b.containsKey(Constants.KEY_Username)) {
            String name = b.getString(Constants.KEY_Username);
            msg.append(name).append("\n");
            Log.i(TAG, "Welcome! Thanks for signing up " + name +"!");
        }





        textView.setText(msg);

        Log.i(TAG, "onCreate()");

        mainBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);

                startActivity(intent);
            }
    });}

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }
}