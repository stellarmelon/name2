package com.example.mike.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button loginBtn;
    private EditText AgeEditText;
    private EditText UsernameEditText;
    private EditText DOBEditText;
    private EditText EmailEditText;
    private EditText NameEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsernameEditText = (EditText) findViewById(R.id.UsernameEditText);

        loginBtn = findViewById(R.id.button);
        DOBEditText = findViewById(R.id.DOBEditText);
        EmailEditText = findViewById(R.id.EmailEditText);
        NameEditText = findViewById(R.id.nameEditText);
        AgeEditText = findViewById(R.id.AgeEditText);

        Log.i(TAG, "onCreate()");
        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                Integer userAge = Integer.parseInt(AgeEditText.getText().toString());
                    if(userAge < 18){
                    loginBtn.setText("Sorry, cannot create account due to age restriction");
                }
                else{
                intent.putExtra(Constants.KEY_Username, UsernameEditText.getText().toString());
                startActivity(intent);
            }}
                                    }
        );
    }



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
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(TAG, "onRestoreInstanceState()");
        if (savedInstanceState.containsKey(Constants.KEY_NAME)) {
            NameEditText.setText((String)savedInstanceState.get(Constants.KEY_NAME));
        }

        if (savedInstanceState.containsKey(Constants.KEY_Age)) {
            AgeEditText.setText((String) savedInstanceState.get(Constants.KEY_Age));
        }
        if (savedInstanceState.containsKey(Constants.KEY_DOB)) {
            DOBEditText.setText((String) savedInstanceState.get(Constants.KEY_DOB));
        }
        if (savedInstanceState.containsKey(Constants.KEY_EMAIL)) {
            EmailEditText.setText((String) savedInstanceState.get(Constants.KEY_EMAIL));
        }
        if (savedInstanceState.containsKey(Constants.KEY_Username)) {
            UsernameEditText.setText((String) savedInstanceState.get(Constants.KEY_Username));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "onSaveInstanceState()");
        outState.putString(Constants.KEY_NAME, NameEditText.getText().toString());
        outState.putString(Constants.KEY_Age, AgeEditText.getText().toString());
        outState.putString(Constants.KEY_DOB, DOBEditText.getText().toString());
        outState.putString(Constants.KEY_EMAIL, EmailEditText.getText().toString());
        outState.putString(Constants.KEY_Username, UsernameEditText.getText().toString());
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
