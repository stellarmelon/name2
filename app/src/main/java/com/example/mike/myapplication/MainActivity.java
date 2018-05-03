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
    public android.widget.DatePicker DatePicker;
    private EditText UsernameEditText;
    private EditText DescriptionEditText;
    private EditText OccupationEditText;
    private EditText NameEditText;
    private String birthString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UsernameEditText = (EditText) findViewById(R.id.UsernameEditText);

        Button loginBtn = (Button)findViewById(R.id.button);
        DescriptionEditText = findViewById(R.id.descriptionEditText);
        OccupationEditText = findViewById(R.id.OccupationEditText);
        DatePicker = findViewById(R.id.set);
        int birthDay = DatePicker.getDayOfMonth();
        int birthMonth = DatePicker.getMonth();
        int birthYear = DatePicker.getYear();
        final String birthString = ""+birthMonth+"/"+birthDay+"/"+birthYear+"";

        Log.i(TAG, "onCreate()");
        loginBtn.setOnClickListener(new View.OnClickListener() {

                                        @Override
                                        public void onClick(View view){
                                            Intent intent = new Intent(MainActivity.this, SecondActivity.class);


                                            intent.putExtra(Constants.KEY_Username, UsernameEditText.getText().toString());
                                            intent.putExtra(Constants.KEY_Age, birthString);
                                            intent.putExtra(Constants.KEY_Description, DescriptionEditText.getText().toString());
                                            intent.putExtra(Constants.KEY_Occupation, OccupationEditText.getText().toString());
                                            startActivity(intent);
                                        }
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
        if (savedInstanceState.containsKey(Constants.KEY_Description)) {
            DescriptionEditText.setText((String)savedInstanceState.get(Constants.KEY_Description));
        }


//        if (savedInstanceState.containsKey(Constants.KEY_DOB)) {
        //          DOBEditText.setText((String) savedInstanceState.get(Constants.KEY_DOB));
        //    }
        if (savedInstanceState.containsKey(Constants.KEY_Occupation)) {
            OccupationEditText.setText((String) savedInstanceState.get(Constants.KEY_Occupation));
        }
        if (savedInstanceState.containsKey(Constants.KEY_Username)) {
            UsernameEditText.setText((String) savedInstanceState.get(Constants.KEY_Username));
        }
    }

/*    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(TAG, "onSaveInstanceState()");
        outState.putString(Constants.KEY_Description, NameEditText.getText().toString());


        outState.putString(Constants.KEY_Occupation, OccupationEditText.getText().toString());
        outState.putString(Constants.KEY_Username, UsernameEditText.getText().toString());
    }*/

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