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
    private TextView UsernameTextView;
    private TextView AgeTextView;
    private TextView OccupationTextView;
    private TextView DescriptionTextView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        UsernameTextView = findViewById(R.id.Username);
        AgeTextView = findViewById(R.id.Age);
        OccupationTextView = findViewById(R.id.Occupation);
        DescriptionTextView = findViewById(R.id.description);
        mainBtn = findViewById(R.id.Return);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        assert b != null;
        if (b.containsKey(Constants.KEY_Username)) {
            String name = b.getString(Constants.KEY_Username);
            Log.i(TAG, name);
            UsernameTextView.setText(name);
        }

        if (b.containsKey(Constants.KEY_Occupation)) {
            String occupation = b.getString(Constants.KEY_Occupation);
            Log.i(TAG, occupation);
            OccupationTextView.setText(occupation);
        }
        if (b.containsKey(Constants.KEY_Age)) {
            String age = b.getString(Constants.KEY_Age);
            Log.i(TAG, age);
            AgeTextView.setText(age);
        }
        if (b.containsKey(Constants.KEY_Description)) {
            String description = b.getString(Constants.KEY_Description);
            Log.i(TAG, description);
            DescriptionTextView.setText(description);
        }




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

    //@Override
    //protected void onStart() {
      //  super.onStart();
        //Log.i(TAG, "onStart()");
    //}

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