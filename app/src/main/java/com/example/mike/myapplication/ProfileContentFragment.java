package com.example.mike.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class ProfileContentFragment extends Fragment {
    private static final String TAG = SecondActivity.class.getSimpleName();
    private TextView textView;
    private Button mainBtn;
    private TextView UsernameTextView;
    private TextView AgeTextView;
    private TextView OccupationTextView;
    private TextView DescriptionTextView;
        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
                                  Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.item_profile, container, false);

                super.onCreate(savedInstanceState);

                UsernameTextView = view.findViewById(R.id.Username);
                AgeTextView = view.findViewById(R.id.Age);
                OccupationTextView = view.findViewById(R.id.Occupation);
                DescriptionTextView = view.findViewById(R.id.description);


                Intent intent = getActivity().getIntent();
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
                return view;}}








